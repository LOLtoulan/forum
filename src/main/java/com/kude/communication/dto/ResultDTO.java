package com.kude.communication.dto;

import com.kude.communication.Exception.CustomizeErrorCode;
import com.kude.communication.Exception.CustomizeException;
import lombok.Data;

import java.util.List;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/10/9 14:59
 * @Message
 */
@Data
public class ResultDTO<T> {
    private Integer code;
    private String message;
    private T data;


    public static ResultDTO errorOf(Integer code, String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static Object errorOf(CustomizeErrorCode errorCode) {
        return errorOf(errorCode.getCode(),errorCode.getMessage());
    }

    public static ResultDTO errorOf(CustomizeException e) {
        return  errorOf(e.getCode(),e.getMessage());
    }

    public static ResultDTO okOf() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;
    }

    public static ResultDTO okOf(Object t) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        resultDTO.setData(t);
        return resultDTO;
    }

}
