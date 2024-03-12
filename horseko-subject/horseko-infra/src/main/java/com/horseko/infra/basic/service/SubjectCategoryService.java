package com.horseko.infra.basic.service;

import com.horseko.infra.basic.entity.SubjectCategory;

import java.util.List;

/**
 * 题目分类(SubjectCategory)表服务接口
 *
 * @author Wayne
 * @since 2024-03-09 22:38:16
 */
public interface SubjectCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectCategory queryById(Long id);

    /**
     * 新增题目分类
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory insert(SubjectCategory subjectCategory);

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory update(SubjectCategory subjectCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 查询分类
     * @param subjectCategory
     * @return
     */
    List<SubjectCategory> queryCategory(SubjectCategory subjectCategory);

    /**
     *
     * @param id
     * @return
     */
    Integer querySubjectCount(Long id);
}
