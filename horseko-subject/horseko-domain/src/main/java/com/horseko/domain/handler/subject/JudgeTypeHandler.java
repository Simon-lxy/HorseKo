package com.horseko.domain.handler.subject;

import com.horseko.domain.convert.JudgeSubjectConverter;
import com.horseko.domain.convert.RadioSubjectConverter;
import com.horseko.domain.entity.SubjectAnswerBO;
import com.horseko.domain.entity.SubjectInfoBO;
import com.horseko.infra.basic.entity.SubjectJudge;
import com.horseko.infra.basic.entity.SubjectRadio;
import com.horseko.infra.basic.service.SubjectJudgeService;
import com.horseko.infra.basic.service.SubjectRadioService;
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
public class JudgeTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectJudgeService subjectJudgeService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //判断题目的插入
        SubjectJudge subjectJudge = new SubjectJudge();
        SubjectAnswerBO subjectAnswerBO = subjectInfoBO.getOptionList().get(0);
        subjectJudge.setSubjectId(subjectInfoBO.getId());
        subjectJudge.setIsCorrect(subjectAnswerBO.getIsCorrect());
        subjectJudge.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectJudgeService.insert(subjectJudge);
    }

}
