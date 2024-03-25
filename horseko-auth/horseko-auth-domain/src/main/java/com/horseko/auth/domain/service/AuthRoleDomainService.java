package com.horseko.auth.domain.service;


import com.horseko.auth.domain.entity.AuthRoleBO;

/**
 * @author Wayne
 * @Since 2024-3-25
 */
public interface AuthRoleDomainService {

    /**
     * 新增用户角色
     * @param authRoleBO
     * @return
     */
    Boolean add(AuthRoleBO authRoleBO);

    Boolean update(AuthRoleBO authRoleBO);

    Boolean delete(AuthRoleBO authRoleBO);
}
