package com.horseko.auth.infra.basic.service;


import com.horseko.auth.infra.basic.entity.AuthUser;

/**
 * (AuthUser)表服务接口
 *
 * @author makejava
 * @since 2024-03-24 21:18:33
 */
public interface AuthUserService {


    Integer register(AuthUser authUser);

    Integer update(AuthUser authUser);

    AuthUser queryByUserName(AuthUser authUser);
}
