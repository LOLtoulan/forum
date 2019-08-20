package com.kude.communication.dto;

/**
 * @Author liyage LOL_tOulan
 * @Time 2019/8/19 16:27
 * @Message
 */
public class GithubUser {

    //name
    private  String name;

    //用户id
    private Long id;

    //用户简介
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
