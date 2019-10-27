package com.kude.communication.Exception;

import com.kude.communication.dto.ResultDTO;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/10/6 14:39
 * @Message
 */
public class CustomizeException extends RuntimeException {
    private String message;
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }


}
