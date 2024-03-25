package com.horseko.auth.application.converter;


import com.horseko.auth.application.dto.AuthRoleDTO;
import com.horseko.auth.application.dto.AuthUserDTO;
import com.horseko.auth.domain.entity.AuthRoleBO;
import com.horseko.auth.domain.entity.AuthUserBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户dto转化器
 */
@Mapper
public interface AuthRoleDTOConverter {

    AuthRoleDTOConverter INSTANCE = Mappers.getMapper(AuthRoleDTOConverter.class);

    AuthRoleBO convertDTOToBO(AuthRoleDTO authRoleDTO);

}
