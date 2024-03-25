package com.horseko.auth.domain.service;


import cn.dev33.satoken.stp.SaTokenInfo;
import com.horseko.auth.domain.entity.AuthUserBO;

/**
 * (AuthUser)表服务接口
 *
 * @author makejava
 * @since 2024-03-24 21:18:33
 */
public interface AuthUserDomainService {


    SaTokenInfo doLogin(String validCode);

    Boolean register(AuthUserBO authUserBO);
}
