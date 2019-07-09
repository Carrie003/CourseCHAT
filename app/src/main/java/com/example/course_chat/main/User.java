package com.example.course_chat.main;


import android.net.Uri;

public class User {

    private Integer userId;
    private Uri userImageUri;
    private String userName;
    private String password;
    //TODO add more user features
    public User(Integer userId, Uri userImageUri, String userName, String password){
        this.userId = userId;
        this.userImageUri = userImageUri;
        this.userName = userName;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public Uri getUserIamgeUri() {
        return userImageUri;
    }

    public String getUserName() {
        return userName;
    }




}
