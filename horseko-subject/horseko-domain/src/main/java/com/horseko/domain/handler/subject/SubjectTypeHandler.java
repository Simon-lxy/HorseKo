package com.horseko.domain.handler.subject;

import com.horseko.domain.entity.SubjectInfoBO;
import com.horseko.domain.entity.SubjectOptionBO;
import com.horseko.subject.common.enums.SubjectInfoTypeEnum;

public interface SubjectTypeHandler {

    /**
     * 枚举身份的识别
     * @return
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 实际的题目的插入
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 实体题目查询
     * @param subjectId
     * @return
     */
    SubjectOptionBO query(int subjectId);
}
