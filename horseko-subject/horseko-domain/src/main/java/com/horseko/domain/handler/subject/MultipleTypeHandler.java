package com.horseko.domain.handler.subject;

import com.horseko.domain.convert.MultipleSubjectConverter;
import com.horseko.domain.convert.RadioSubjectConverter;
import com.horseko.domain.entity.SubjectInfoBO;
import com.horseko.infra.basic.entity.SubjectMultiple;
import com.horseko.infra.basic.entity.SubjectRadio;
import com.horseko.infra.basic.service.SubjectMultipleService;
import com.horseko.infra.basic.service.SubjectRadioService;
import com.horseko.subject.common.enums.IsDeletedFlagEnum;
import com.horseko.subject.common.enums.SubjectInfoTypeEnum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 多选题目的策略类
 *
 * @author: Wayne
 * @date: 2024/3/14
 */
@Component
public class MultipleTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectMultipleService subjectMultipleService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        List<SubjectMultiple> subjectMultipleList = new LinkedList();
        subjectInfoBO.getOptionList().forEach(option -> {

        });
        //单选题目的插入
        List<SubjectMultiple> subjectMultiples = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectMultiple subjectMultiple = MultipleSubjectConverter.INSTANCE.convertBoTOEntity(option);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultiple.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectMultiples.add(subjectMultiple);
        });
        subjectMultipleService.batchInsert(subjectMultiples);
    }

}