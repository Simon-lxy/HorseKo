package com.horseko.domain.convert;

import com.horseko.domain.entity.SubjectAnswerBO;
import com.horseko.domain.entity.SubjectInfoBO;
import com.horseko.infra.basic.entity.SubjectBrief;
import com.horseko.infra.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BriefSubjectConverter {

    BriefSubjectConverter INSTANCE = Mappers.getMapper(BriefSubjectConverter.class);

    SubjectBrief convertBoTOEntity(SubjectInfoBO subjectInfoBO);
}
