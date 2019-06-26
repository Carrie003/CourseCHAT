package com.example.course_chat.videotutorial;


import java.util.ArrayList;
import java.util.Map;

public class Lesson {

    private String videoPath, name, description, dateCreated;
    private Integer thumbUp, thumbDown;
    private ArrayList<Comment> comments;

    public Lesson(String videoPath, String name, String description, Integer thumbUp, Integer thumbDown, String dateCreated, ArrayList<Comment> comments){
        this.videoPath = videoPath;
        this.name = name;
        this.description = description;
        this.thumbUp = thumbUp;
        this.thumbDown = thumbDown;
        this.dateCreated = dateCreated;
        this.comments = comments;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public Integer getThumbUp() {
        return thumbUp;
    }

    public Integer getThumbDown() {
        return thumbDown;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }
}

