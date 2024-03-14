package com.horseko.domain.convert;

import com.horseko.domain.entity.SubjectAnswerBO;
import com.horseko.infra.basic.entity.SubjectJudge;
import com.horseko.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JudgeSubjectConverter {

    JudgeSubjectConverter INSTANCE = Mappers.getMapper(JudgeSubjectConverter.class);

    SubjectJudge convertBoTOEntity(SubjectAnswerBO subjectAnswerBO);
}