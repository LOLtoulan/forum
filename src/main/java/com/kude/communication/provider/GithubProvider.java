package com.kude.communication.provider;

import com.alibaba.fastjson.JSON;
import com.kude.communication.dto.AccessTokenDTO;
import com.kude.communication.dto.GithubUser;
import okhttp3.*;
import okhttp3.Request.Builder;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author liyage LOL_tOulan
 * @Time 2019/8/18 18:51
 * @Message
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

//        RequestBody body = RequestBody.create(JSON, json);
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            System.out.println(token);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
//            log.error("getAccessToken error,{}", accessTokenDTO, e);
        }
        return null;
    }


    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        String url;
        Request request = new Request.Builder().url("https://api.github.com/user?access_token="+accessToken).build();


        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string,GithubUser.class);
            return githubUser;
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return null;

    }
}
