package com.kude.communication.enums;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/10/24 9:56
 * @Message
 */
public enum NotificationStatusEnum {
    UNREAD(0),
    READ(1)
    ;
    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }}
