package com.horseko.domain.convert;


import com.horseko.domain.entity.SubjectLabelBO;
import com.horseko.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectLabelConverter {

    SubjectLabelConverter INSTANCE = Mappers.getMapper(SubjectLabelConverter.class);

    SubjectLabel convertBoTOLabel(SubjectLabelBO subjectLabelBO);
}
