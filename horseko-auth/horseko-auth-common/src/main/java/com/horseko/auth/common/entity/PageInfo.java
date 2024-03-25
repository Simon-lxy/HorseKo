package com.horseko.auth.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 请求分页实体
 *
 * @author Wayne
 * @data 2024/03/14 16:45:41
 **/
@Data
public class PageInfo implements Serializable {

    private Integer pageNo = 1;

    private Integer pageSize = 20;

    public Integer getPageNo() {
        if (pageNo == null || pageNo < 1) {
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE) {
            return 20;
        }
        return pageSize;
    }


}
