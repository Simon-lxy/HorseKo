package com.horseko.auth.common.enums;

import lombok.Getter;

/**
 * 删除状态枚举
 * 
 * @author: Wayne
 */
@Getter
public enum AuthUserStatusEnum {

    OPEN(0,"启用"),
    CLOSE(1,"禁用");

    public int code;

    public String desc;

    AuthUserStatusEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

}
