package com.kude.communication.mapper;

import com.kude.communication.dto.QuestionQueryDTO;
import com.kude.communication.model.Question;

import java.util.List;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/10/7 23:06
 * @Message
 */
public interface QuestionExtMapper {

    int incView(Question record);

    int incCommentCount(Question record);

    List<Question> selectRelated(Question question);

    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}
