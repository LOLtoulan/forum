package com.kude.communication.dto;

import lombok.Data;

/**
 * @Author liyage LOL_tOulan
 * @Time 2019/8/19 16:27
 * @Message
 */

@Data
public class GithubUser {

    //name
    private  String name;

    //用户id
    private Long id;

    //用户简介
    private String bio;

    private String avatar_url;
}
