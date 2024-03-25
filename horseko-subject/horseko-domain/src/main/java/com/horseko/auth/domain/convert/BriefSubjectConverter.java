package com.horseko.auth.domain.convert;

import com.horseko.auth.domain.entity.SubjectInfoBO;
import com.horseko.infra.basic.entity.SubjectBrief;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BriefSubjectConverter {

    BriefSubjectConverter INSTANCE = Mappers.getMapper(BriefSubjectConverter.class);

    SubjectBrief convertBoTOEntity(SubjectInfoBO subjectInfoBO);
}
