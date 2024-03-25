package com.horseko.auth.domain.convert;


import com.horseko.auth.domain.entity.SubjectLabelBO;
import com.horseko.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectLabelConverter {

    SubjectLabelConverter INSTANCE = Mappers.getMapper(SubjectLabelConverter.class);

    SubjectLabel convertBoTOLabel(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> convertLabelListTOLabelBOList(List<SubjectLabel> subjectLabels);
}
