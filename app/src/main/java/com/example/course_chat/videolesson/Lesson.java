package com.example.course_chat.videolesson;


import android.net.Uri;

import java.util.ArrayList;

public class Lesson {

    private Uri lessonUri;
    private String title, description, dateCreated;
    private Integer thumbUp, thumbDown;
    private ArrayList<Comment> comments;

    public Lesson(Uri lessonUri, String title, String description, Integer thumbUp, Integer thumbDown, String dateCreated, ArrayList<Comment> comments){
        this.lessonUri = lessonUri;
        this.title = title;
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

    public String getTitle() {
        return title;
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

