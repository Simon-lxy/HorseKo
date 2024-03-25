package com.horseko.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.horseko.auth.common.enums.AuthUserStatusEnum;
import com.horseko.auth.common.enums.IsDeletedFlagEnum;
import com.horseko.auth.domain.converter.AuthUserBOConverter;
import com.horseko.auth.domain.entity.AuthUserBO;
import com.horseko.auth.domain.redis.RedisUtil;
import com.horseko.auth.domain.service.AuthUserDomainService;
import com.horseko.auth.infra.basic.entity.AuthUser;
import com.horseko.auth.infra.basic.service.AuthUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (AuthUserDomain)表服务实现类
 *
 * @author makejava
 * @since 2024-03-24 21:18:34
 */
@Service("authUserDomainService")
public class AuthUserDomainServiceImpl implements AuthUserDomainService {

    @Resource
    private AuthUserService authUserService;

    @Resource
    private RedisUtil redisUtil;

    private static final String LOGIN_PREFIX = "loginCode";

    @Override
    public SaTokenInfo doLogin(String validCode) {
        String loginKey = redisUtil.buildKey(LOGIN_PREFIX, validCode);
        String openId = redisUtil.get(loginKey);
        if (StringUtils.isBlank(openId)) {
            return null;
        }
        AuthUserBO authUserBO = new AuthUserBO();
        authUserBO.setUserName(openId);
//        this.register(authUserBO);
        StpUtil.login(openId);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return tokenInfo;
    }

    /**
     * 用户注册
     * @param authUserBO
     * @return
     */
    @Override
    public Boolean register(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToEntity(authUserBO);
        authUser.setPassword(SaSecureUtil.md5(authUser.getPassword()));
        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        Integer count = authUserService.register(authUser);
        //建立一个初步的角色的关联
        //要把当前用户的角色和权限都刷新我们的redis里
        return count > 0;
    }

    /**
     * 更新用户信息
     * @param authUserBO
     * @return
     */
    @Override
    public Boolean update(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToEntity(authUserBO);
        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        Integer count = authUserService.update(authUser);
        //有任何的更新，都要与缓存进行同步的修改
        return count > 0;
    }

    @Override
    public Boolean delete(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToEntity(authUserBO);
        authUser.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        Integer count = authUserService.update(authUser);
        return count > 0;
    }

    @Override
    public Boolean changeStatus(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToEntity(authUserBO);
        if (authUser.getStatus() == AuthUserStatusEnum.OPEN.getCode()) {
            authUser.setStatus(AuthUserStatusEnum.CLOSE.getCode());
        } else {
            authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        }
        Integer count = authUserService.update(authUser);
        return count > 0;
    }

    @Override
    public AuthUserBO getUserInfo(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoToEntity(authUserBO);
        AuthUser authUserResult = authUserService.queryByUserName(authUser);
        AuthUserBO userBO = AuthUserBOConverter.INSTANCE.convertEntityToBo(authUserResult);
        return userBO;
    }
}
