package com.horseko.auth.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (AuthRole)实体类
 *
 * @author makejava
 * @since 2024-03-25 20:03:08
 */
@Data
public class AuthRoleDTO implements Serializable {
    private static final long serialVersionUID = 254651710316013080L;
    
    private Long id;
    
    private String roleName;
    
    private String roleKey;

}

