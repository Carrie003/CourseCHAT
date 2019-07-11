package com.example.course_chat.main;


import android.net.Uri;

public class User {

//    private Integer userId;

    private String userName;
    private String password;
    private Uri userImageUri;
    private String dateSignedUp;
    //TODO add more user features
    public User( String userName, String password, Uri userImageUri, String dateSignedUp){
//        this.userId = userId;

        this.userName = userName;
        this.password = password;
        this.userImageUri = userImageUri;
        this.dateSignedUp = dateSignedUp;
    }

//    public Integer getUserId() {
//        return userId;
//    }

    public Uri getUserIamgeUri() {
        return userImageUri;
    }

    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }
}
