package com.example.course_chat.videotutorial;


import android.net.Uri;

import java.util.ArrayList;

public class Lesson {

    private Uri lessonUri;
    private String name, description, dateCreated;
    private Integer thumbUp, thumbDown;
    private ArrayList<Comment> comments;

    public Lesson(Uri lessonUri, String name, String description, Integer thumbUp, Integer thumbDown, String dateCreated, ArrayList<Comment> comments){
        this.lessonUri = lessonUri;
        this.name = name;
        this.description = description;
        this.thumbUp = thumbUp;
        this.thumbDown = thumbDown;
        this.dateCreated = dateCreated;
        this.comments = comments;
    }

//    public Integer getLessonID() {
//        return lessonID;
//    }

    public Uri getLessonUri() {
        return lessonUri;
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

