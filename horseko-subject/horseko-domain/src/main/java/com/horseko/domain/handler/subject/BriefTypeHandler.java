package com.horseko.domain.handler.subject;

import com.horseko.domain.convert.BriefSubjectConverter;
import com.horseko.domain.convert.JudgeSubjectConverter;
import com.horseko.domain.entity.SubjectInfoBO;
import com.horseko.infra.basic.entity.SubjectBrief;
import com.horseko.infra.basic.entity.SubjectJudge;
import com.horseko.infra.basic.service.SubjectBriefService;
import com.horseko.infra.basic.service.SubjectJudgeService;
import com.horseko.subject.common.enums.IsDeletedFlagEnum;
import com.horseko.subject.common.enums.SubjectInfoTypeEnum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 判断题目的策略类
 *
 * @author: Wayne
 * @date: 2024/3/14
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectBriefService subjectBriefService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        SubjectBrief subjectBrief = BriefSubjectConverter.INSTANCE.convertBoTOEntity(subjectInfoBO);
        subjectBrief.setSubjectId(subjectInfoBO.getId().intValue());
        subjectBrief.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectBriefService.insert(subjectBrief);
    }

}
