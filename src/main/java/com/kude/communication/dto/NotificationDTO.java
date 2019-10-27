package com.kude.communication.dto;

import com.kude.communication.model.User;
import lombok.Data;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/10/24 21:18
 * @Message
 */
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;
}
