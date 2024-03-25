package com.horseko.auth.domain.service;

import com.horseko.auth.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * 题目标签表(SubjectLabel)表服务接口
 *
 * @author makejava
 * @since 2024-03-13 09:23:13
 */
public interface SubjectLabelDomainService {

    /**
     * 通过分类id查询标签
     *
     * @param subjectLabelBO 主键
     * @return 实例对象
     */
    List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO);

    /**
     * 新增数据
     *
     * @param
     * @param
     * @return 实例对象
     */
    Boolean add(SubjectLabelBO subjectLabelBO);

    /**
     * 修改数据
     *
     * @param subjectLabelBO 实例对象
     * @return 实例对象
     */
    Boolean update(SubjectLabelBO subjectLabelBO);

    /**
     * 通过主键删除数据
     *
     * @param subjectLabelBO
     * @return 是否成功
     */
    Boolean delete(SubjectLabelBO subjectLabelBO);

}
