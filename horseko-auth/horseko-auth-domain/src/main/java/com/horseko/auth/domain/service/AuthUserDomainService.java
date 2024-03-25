package com.horseko.auth.domain.service;


import cn.dev33.satoken.stp.SaTokenInfo;
import com.horseko.auth.domain.entity.AuthUserBO;

/**
 *
 * @author makejava
 * @since 2024-03-24 21:18:33
 */
public interface AuthUserDomainService {


    SaTokenInfo doLogin(String validCode);

    Boolean register(AuthUserBO authUserBO);

    Boolean update(AuthUserBO authUserBO);

    Boolean delete(AuthUserBO authUserBO);

    Boolean changeStatus(AuthUserBO authUserBO);

    AuthUserBO getUserInfo(AuthUserBO authUserBO);
}
