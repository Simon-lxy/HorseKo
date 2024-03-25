package com.horseko.auth.domain.service;

import com.horseko.auth.domain.entity.SubjectCategoryBO;

import java.util.List;


public interface SubjectCategoryDomainService {

    /**
     * 新增分类
     */
    Boolean add(SubjectCategoryBO subjectCategoryBO);

    /**
     * 更新分类
     * @param subjectCategoryBO
     */
    Boolean update(SubjectCategoryBO subjectCategoryBO);

    /**
     * 查询分类
     * @param subjectCategoryBO
     * @return
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * 删除分类
     * @param subjectCategoryBO
     */
    Boolean delete(SubjectCategoryBO subjectCategoryBO);
}
