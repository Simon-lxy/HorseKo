package com.horseko.auth.domain.converter;


import com.horseko.auth.domain.entity.AuthUserBO;
import com.horseko.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户bo转化器
 */
@Mapper
public interface AuthUserBOConverter {

    AuthUserBOConverter INSTANCE = Mappers.getMapper(AuthUserBOConverter.class);

    AuthUser convertBoToEntity(AuthUserBO authUserBO);

    AuthUserBO convertEntityToBo(AuthUser authUser);
}
