package com.kude.communication.dto;

import lombok.Data;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/10/27 13:58
 * @Message
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private String tag;
    private Integer page;
    private Integer size;
}
