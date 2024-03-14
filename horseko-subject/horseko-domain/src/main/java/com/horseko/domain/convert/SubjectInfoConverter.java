package com.horseko.domain.convert;


import com.horseko.domain.entity.SubjectCategoryBO;
import com.horseko.domain.entity.SubjectInfoBO;
import com.horseko.infra.basic.entity.SubjectCategory;
import com.horseko.infra.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectInfoConverter {

    SubjectInfoConverter INSTANCE = Mappers.getMapper(SubjectInfoConverter.class);

    SubjectInfo convertBoToInfo(SubjectInfoBO subjectCategoryBO);

    List<SubjectCategoryBO> convertCategoryListToCategoryBOList(List<SubjectCategory> categoryList);

    List<SubjectInfoBO> covertListInfoToBO(List<SubjectInfo> subjectInfoList);
}
