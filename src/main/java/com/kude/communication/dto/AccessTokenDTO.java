package com.kude.communication.dto;

/**
 * @Author liyage LOL_toulan
 * @Time 2019/8/18 18:55
 * @Message
 */
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

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
