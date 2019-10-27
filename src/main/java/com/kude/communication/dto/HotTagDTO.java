package com.kude.communication.dto;

import lombok.Data;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/10/27 14:57
 * @Message
 */
@Data
public class HotTagDTO implements Comparable {
    private String name;
    private Integer priority;

    @Override
    public int compareTo(Object o) {
        return this.getPriority() - ((HotTagDTO) o).getPriority();
    }
}
