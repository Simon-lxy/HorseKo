package com.horseko.auth.domain.convert;


import com.horseko.auth.domain.entity.SubjectCategoryBO;
import com.horseko.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryConverter {

    SubjectCategoryConverter INSTANCE = Mappers.getMapper(SubjectCategoryConverter.class);

    SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> convertCategoryListToCategoryBOList(List<SubjectCategory> categoryList);

}
