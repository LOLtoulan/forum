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
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
