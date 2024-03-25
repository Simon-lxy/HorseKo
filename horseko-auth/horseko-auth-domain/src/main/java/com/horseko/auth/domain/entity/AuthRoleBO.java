package com.horseko.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (AuthRole)实体类
 *
 * @author makejava
 * @since 2024-03-25 20:03:08
 */
@Data
public class AuthRoleBO implements Serializable {
    
    private Long id;
    
    private String roleName;
    
    private String roleKey;

}

