package com.example.course_chat.discussion;


import java.util.ArrayList;

public class Discussion {

//    private Integer id;

    private String topic;
    private String content;
    private Integer thumbUp;
    private Integer thumbDown;
    private String dateCreated;
    private ArrayList<String> dialog;



    public Discussion( String topic, String content, Integer thumbUp, Integer thumbDown, String dateCreated, ArrayList<String> dialog){


        this.topic = topic;
        this.content = content;
        this.thumbUp = thumbUp;
        this.thumbDown = thumbDown;
        this.dateCreated = dateCreated;
        this.dialog = dialog;

    }

    public String getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }

    public Integer getThumbUp() {
        return thumbUp;
    }

    public Integer getThumbDown() {
        return thumbDown;
    }

    public void setThumbUp(Integer thumbUp) {
        this.thumbUp = thumbUp;
    }

    public void setThumbDown(Integer thumbDown) {
        this.thumbDown = thumbDown;
    }
}
