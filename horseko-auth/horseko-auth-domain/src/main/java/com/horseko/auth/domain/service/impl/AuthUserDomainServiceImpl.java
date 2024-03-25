package com.horseko.auth.domain.service.impl;

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
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBoTEntity(authUserBO);
        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        //建立一个初步的角色的关联
        //要把当前用户的角色和权限都刷新我们的redis里
        return authUserService.register(authUser) > 0;
    }
}
