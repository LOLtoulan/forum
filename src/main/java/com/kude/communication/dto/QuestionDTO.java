package com.kude.communication.dto;

import com.kude.communication.model.User;
import lombok.Data;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/9/14 10:31
 * @Message
 */

@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Long viewCount;
    private Long commentCount;
    private Long likeCount;
    private User user;
}
