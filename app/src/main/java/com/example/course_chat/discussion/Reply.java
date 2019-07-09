package com.example.course_chat.discussion;

import java.util.ArrayList;

public class Reply {
    private Integer userId;
    private String userName;
    private String content;
    private Integer thumbUp;
    private Integer thumbDown;
    private String dateReplied;
    private ArrayList<String> repliesOfReply;


    public Reply(Integer userId, String userName, String content, Integer thumbUp, Integer thumbDown, String dateReplied, ArrayList<String> repliesOfReply){
        this.userId = userId;
        this.userName = userName;
        this.content = content;
        this.thumbUp = thumbUp;
        this.thumbDown = thumbDown;
        this.dateReplied = dateReplied;

        this.repliesOfReply = repliesOfReply;

    }


}
