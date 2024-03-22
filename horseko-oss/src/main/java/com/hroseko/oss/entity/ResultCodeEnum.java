package com.hroseko.oss.entity;
import lombok.Getter;
/**
 * @author Wayne
 * 2024/03/20 16:26:14
 **/

@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(500,"失败");

    /**
     * 状态码
     */
    public int code;

    /**
     * 描述信息
     */
    public String desc;

    ResultCodeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static ResultCodeEnum getByCode(int codeVal){
        for(ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
