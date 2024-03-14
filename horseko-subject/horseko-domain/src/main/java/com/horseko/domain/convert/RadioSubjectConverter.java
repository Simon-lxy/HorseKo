package com.horseko.domain.convert;

import com.horseko.domain.entity.SubjectAnswerBO;
import com.horseko.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RadioSubjectConverter {

    RadioSubjectConverter INSTANCE = Mappers.getMapper(RadioSubjectConverter.class);

    SubjectRadio convertBoTOEntity(SubjectAnswerBO subjectAnswerBO);
}
