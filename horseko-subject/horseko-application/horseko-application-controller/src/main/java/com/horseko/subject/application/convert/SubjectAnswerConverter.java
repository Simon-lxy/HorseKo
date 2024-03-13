package com.horseko.subject.application.convert;

import com.horseko.domain.entity.SubjectAnswerBO;
import com.horseko.subject.application.dto.SubjectAnswerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectAnswerConverter {

    SubjectAnswerConverter INSTANCE = Mappers.getMapper(SubjectAnswerConverter.class);

    SubjectAnswerBO convertDtoToBo(SubjectAnswerDTO subjectAnswerDTO);

    List<SubjectAnswerBO> convertListDtoTOBo(List<SubjectAnswerDTO> answerDtoList);
}
