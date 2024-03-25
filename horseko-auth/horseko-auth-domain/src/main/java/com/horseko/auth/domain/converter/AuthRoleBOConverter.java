package com.horseko.auth.domain.converter;


import com.horseko.auth.domain.entity.AuthRoleBO;
import com.horseko.auth.infra.basic.entity.AuthRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户dto转化器
 */
@Mapper
public interface AuthRoleBOConverter {

    AuthRoleBOConverter INSTANCE = Mappers.getMapper(AuthRoleBOConverter.class);

    AuthRole convertBoToEntity(AuthRoleBO authRoleBO);

}
