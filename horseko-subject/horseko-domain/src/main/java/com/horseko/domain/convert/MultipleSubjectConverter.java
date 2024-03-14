package com.horseko.domain.convert;

import com.horseko.domain.entity.SubjectAnswerBO;
import com.horseko.infra.basic.entity.SubjectMultiple;
import com.horseko.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MultipleSubjectConverter {

    MultipleSubjectConverter INSTANCE = Mappers.getMapper(MultipleSubjectConverter.class);

    SubjectMultiple convertBoTOEntity(SubjectAnswerBO subjectAnswerBO);
}
