package com.horseko.auth.infra.basic.service.impl;

import com.horseko.auth.infra.basic.entity.AuthRole;
import com.horseko.auth.infra.basic.mapper.AuthRoleDao;
import com.horseko.auth.infra.basic.service.AuthRoleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (AuthRole)表服务实现类
 *
 * @author makejava
 * @since 2024-03-25 20:03:08
 */
@Service("authRoleService")
public class AuthRoleServiceImpl implements AuthRoleService {
    @Resource
    private AuthRoleDao authRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthRole queryById(Long id) {
        return this.authRoleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param authRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<AuthRole> queryByPage(AuthRole authRole, PageRequest pageRequest) {
        long total = this.authRoleDao.count(authRole);
        return new PageImpl<>(this.authRoleDao.queryAllByLimit(authRole, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    @Override
    public AuthRole insert(AuthRole authRole) {
        this.authRoleDao.insert(authRole);
        return authRole;
    }

    /**
     * 修改数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(AuthRole authRole) {
        return this.authRoleDao.update(authRole);
    }


    @Override
    public Integer add(AuthRole authRole) {
        return this.authRoleDao.insert(authRole);
    }

}
