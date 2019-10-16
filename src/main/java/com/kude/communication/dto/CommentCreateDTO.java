package com.kude.communication.dto;

import lombok.Data;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/10/8 13:30
 * @Message
 */
@Data
public class CommentCreateDTO {

    private Long parentId;
    private String content;
    private int type;


}
