package com.kude.communication.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/10/20 21:31
 * @Message
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
