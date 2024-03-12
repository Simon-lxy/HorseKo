package com.horseko.domain.service;

import com.horseko.domain.entity.SubjectCategoryBO;

import java.util.List;


public interface SubjectCategoryDomainService {

    /**
     * 新增分类
     */
    void add(SubjectCategoryBO subjectCategoryBO);

    /**
     * 更新分类
     * @param subjectCategoryBO
     */
    void update(SubjectCategoryBO subjectCategoryBO);

    /**
     * 查询分类
     * @param subjectCategoryBO
     * @return
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

}
