package com.horseko.auth.infra.basic.service.impl;

import com.horseko.auth.infra.basic.mapper.AuthUserDao;
import com.horseko.auth.infra.basic.entity.AuthUser;
import com.horseko.auth.infra.basic.service.AuthUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * (AuthUser)表服务实现类
 *
 * @author makejava
 * @since 2024-03-24 21:18:34
 */
@Service("authUserService")
public class AuthUserServiceImpl implements AuthUserService {

    @Resource
    private AuthUserDao authUserDao;

    @Override
    public Integer register(AuthUser authUser) {
        return this.authUserDao.insert(authUser);
    }

    @Override
    public Integer update(AuthUser authUser) {
        return this.authUserDao.update(authUser);
    }

    @Override
    public AuthUser queryByUserName(AuthUser authUser) {
        return this.authUserDao.queryAllByLimit(authUser);
    }
}
