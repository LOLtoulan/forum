package com.kude.communication.dto;

import com.kude.communication.model.User;
import lombok.Data;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/10/15 15:59
 * @Message
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private Long commentCount;
    private User user;
}
