package com.kude.communication.mapper;

import com.kude.communication.model.Question;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/10/7 23:06
 * @Message
 */
public interface QuestionExtMapper {
    int incView(Question record);
    int incCOmmentCount(Question record);
}
