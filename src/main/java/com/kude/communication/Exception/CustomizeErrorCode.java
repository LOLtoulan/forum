package com.kude.communication.Exception;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/10/6 16:42
 * @Message
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001, "您要找的问题不在了,要不换个试试？"),
    TARGET_PARAM_NOT_FOUNT(2002, "您要找的问题不在了,要不换个试试？"),
    NO_LOGIN(2003, "用户未登录，请登陆后评论"),
    SYS_ERROR(2004, "服务冒烟了，要不稍后再试试!!"),
    TYPE_PARAM_WRONG(2005, "回复类型错误，或为空"),
    COMMENT_NOT_FOUNT(2006, "抱歉,你要回复的评论不存在了"),


    ;


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }}

