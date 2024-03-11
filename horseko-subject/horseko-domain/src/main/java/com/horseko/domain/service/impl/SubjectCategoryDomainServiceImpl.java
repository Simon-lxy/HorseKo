package com.horseko.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.horseko.domain.convert.SubjectCategoryConverter;
import com.horseko.domain.entity.SubjectCategoryBO;
import com.horseko.domain.service.SubjectCategoryDomainService;
import com.horseko.infra.basic.entity.SubjectCategory;
import com.horseko.infra.basic.service.SubjectCategoryService;
import com.horseko.subject.common.enums.IsDeletedFlagEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Wayne
 * @data 2024/03/09 23:10:17
 **/
@Service("subjectCategoryDomainService")
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    /**
     * 新增分类
     */
    public void add(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.add.bo:{}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectCategoryService.insert(subjectCategory);
    }
}
