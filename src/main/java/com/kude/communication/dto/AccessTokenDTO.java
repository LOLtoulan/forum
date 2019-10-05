package com.kude.communication.dto;

import lombok.Data;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/8/18 18:55
 * @Message
 */
@Data
public class AccessTokenDTO {

    //您从GitHub收到的GitHub应用程序的客户端ID
    private String client_id;

    //The client secret you received from GitHub for your GitHub App.
    private String client_secret;

    //The code you received as a response to Step 1
    private String code;

    //callback地址
    private String redirect_uri;

    //随机数
    private String state;



}
