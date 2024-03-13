package com.horseko.domain.entity;

import lombok.Data;

/**
 * @author Wayne
 * @data 2024/03/13 20:13:52
 **/

@Data
public class SubjectAnswerBO {
    /**
     * 答案选项标识
     */
    private Integer optionType;

    /**
     * 答案
     */
    private String optionContent;

    /**
     * 是否正确
     */
    private Integer isCorrect;
}
