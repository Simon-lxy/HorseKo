package com.horseko.auth.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Wayne
 * @data 2024/03/13 09:47:37
 **/
@Data
public class SubjectLabelBO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 标签分类
     */
    private String labelName;
    /**
     * 排序
     */
    private Integer sortNum;

    private Long categoryId;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;

    private Integer isDeleted;
}
