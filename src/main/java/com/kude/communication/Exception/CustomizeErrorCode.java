package com.kude.communication.Exception;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/10/6 16:42
 * @Message
 */
public enum  CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND("您要找的问题不在了,要不换个试试？");


    @Override
    public String getMessage() {
        return message;
    }

    private  String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }
}

