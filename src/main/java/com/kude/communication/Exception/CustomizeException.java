package com.kude.communication.Exception;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/10/6 14:39
 * @Message
 */
public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(CustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String  message) {

        this.message =message;
    }


    @Override
    public String getMessage() {
        return message;
    }


}
