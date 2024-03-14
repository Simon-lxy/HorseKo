package com.horseko.subject.application.convert;

import com.horseko.domain.entity.SubjectInfoBO;
import com.horseko.subject.application.dto.SubjectInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectInfoConverter {

    SubjectInfoConverter INSTANCE = Mappers.getMapper(SubjectInfoConverter.class);

    SubjectInfoBO convertDtoTOBo(SubjectInfoDTO subjectInfoDTO);

}
