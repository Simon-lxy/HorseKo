package com.horseko.auth.domain.service.impl;

import com.horseko.auth.common.enums.IsDeletedFlagEnum;
import com.horseko.auth.domain.converter.AuthRoleBOConverter;
import com.horseko.auth.domain.entity.AuthRoleBO;
import com.horseko.auth.domain.service.AuthRoleDomainService;
import com.horseko.auth.infra.basic.entity.AuthRole;
import com.horseko.auth.infra.basic.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Wayne
 * @data 2024/03/25 20:16:46
 **/
@Service("authRoleDomainService")
public class AuthRoleDomainServiceImpl implements AuthRoleDomainService {

    @Resource
    private AuthRoleService authRoleService;

    /**
     * 新增用户角色
     * @param authRoleBO
     * @return
     */
    @Override
    public Boolean add(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBoToEntity(authRoleBO);
        authRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        Integer count = authRoleService.add(authRole);
        return count > 0;
    }


    /**
     * 修改用户角色
     * @param authRoleBO
     * @return
     */
    @Override
    public Boolean update(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBoToEntity(authRoleBO);
        Integer count = authRoleService.update(authRole);
        return count > 0;
    }


    /**
     * 删除用户角色
     * @param authRoleBO
     * @return
     */
    @Override
    public Boolean delete(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBoToEntity(authRoleBO);
        authRole.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        Integer count = authRoleService.update(authRole);
        return count > 0;
    }
}
