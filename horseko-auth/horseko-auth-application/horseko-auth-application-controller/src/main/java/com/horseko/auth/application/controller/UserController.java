package com.horseko.auth.application.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.horseko.auth.api.entity.Result;
import com.horseko.auth.application.converter.AuthUserDTOConverter;
import com.horseko.auth.application.dto.AuthUserDTO;
import com.horseko.auth.domain.entity.AuthUserBO;
import com.horseko.auth.domain.service.AuthUserDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {

    @Resource
    private AuthUserDomainService authUserDomainService;

    /**
     * 用户注册
     */
    @PostMapping("register")
    public Result<Boolean> register(@RequestBody AuthUserDTO authUserDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.register.dto:{}", JSON.toJSONString(authUserDTO));
            }
            checkUserInfo(authUserDTO);
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);
            return Result.ok(authUserDomainService.register(authUserBO));
        } catch (Exception e) {
            log.error("UserController.register.error:{}", e.getMessage(), e);
            return Result.fail("注册用户失败");
        }
    }

    private void checkUserInfo(@RequestBody AuthUserDTO authUserDTO) {
        Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getUserName()), "用户名不能为空");
        Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getEmail()), "用户邮件地址不能为空");
        Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getPassword()), "用户密码不能为空");
    }


    /**
     * 修改用户信息
     */
    @PostMapping("update")
    public Result<Boolean> update(@RequestBody AuthUserDTO authUserDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.update.dto:{}", JSON.toJSONString(authUserDTO));
            }
            checkUserInfo(authUserDTO);
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);
            return Result.ok(authUserDomainService.update(authUserBO));
        } catch (Exception e) {
            log.error("UserController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新用户信息失败");
        }
    }

    /**
     * 删除用户信息
     */
    @PostMapping("delete")
    public Result<Boolean> delete(@RequestBody AuthUserDTO authUserDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.delete.dto:{}", JSON.toJSONString(authUserDTO));
            }
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);
            return Result.ok(authUserDomainService.delete(authUserBO));
        } catch (Exception e) {
            log.error("UserController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除用户信息失败");
        }
    }

    /**
     * 用户启用/禁用
     */
    @PostMapping("changeStatus")
    public Result<Boolean> changeStatus(@RequestBody AuthUserDTO authUserDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.changeStatus.dto:{}", JSON.toJSONString(authUserDTO));
            }
            Preconditions.checkNotNull(authUserDTO.getStatus(), "用户状态不能为空");
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);
            return Result.ok(authUserDomainService.changeStatus(authUserBO));
        } catch (Exception e) {
            log.error("UserController.delete.error:{}", e.getMessage(), e);
            return Result.fail("用户状态修改失败");
        }
    }

    /**
     * 查询用户信息
     */
    @GetMapping("getUserInfo")
    public Result<AuthUserDTO> getUserInfo(@RequestBody AuthUserDTO authUserDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.getUserInfo.dto:{}", JSON.toJSONString(authUserDTO));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getUserName()), "用户名称不能为空");
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);
            AuthUserBO userBO = authUserDomainService.getUserInfo(authUserBO);
            return Result.ok(AuthUserDTOConverter.INSTANCE.convertBOToDTO(userBO));
        } catch (Exception e) {
            log.error("UserController.getUserInfo.error:{}", e.getMessage(), e);
            return Result.fail("用户状态修改失败");
        }
    }


    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456
    @RequestMapping("doLogin")
    public Result<SaTokenInfo> doLogin(@RequestParam("validCode") String validCode) {
        try {
            Preconditions.checkArgument(StringUtils.isBlank(validCode), "验证码不能为空");
            return Result.ok(authUserDomainService.doLogin(validCode));
        } catch (Exception e) {
            log.error("UserController.doLogin.error:{}", e.getMessage(), e);
            return Result.fail("用户登录失败");
        }
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

}
