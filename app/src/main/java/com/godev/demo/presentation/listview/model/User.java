package com.godev.demo.presentation.listview.model;

/**
 * Created by truongnguyen on 11/24/17.
 */

public class User {
    private String username;
    private String avatar;

    public User(String username, String avatar) {
        this.username = username;
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }


}
