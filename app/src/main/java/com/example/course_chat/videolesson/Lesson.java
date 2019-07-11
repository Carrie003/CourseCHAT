package com.example.course_chat.videolesson;


import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.course_chat.discussion.Discussion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class Lesson  {

    private Uri lessonUri;
    private String title, description, dateCreated;
    private Integer thumbUp, thumbDown;
//    private ArrayList<Comment> comments;
    private Map<String, Comment> idCommentMap;

    public Lesson(Uri lessonUri, String title, String description, Integer thumbUp, Integer thumbDown, String dateCreated,Map<String, Comment> idCommentMap ){
        this.lessonUri = lessonUri;
        this.title = title;
        this.description = description;
        this.thumbUp = thumbUp;
        this.thumbDown = thumbDown;
        this.dateCreated = dateCreated;
        this.idCommentMap = idCommentMap;
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

    public Map<String, Comment> getIdCommentMap() {
        return idCommentMap;
    }

    public static Comparator<Lesson> voteComparator = new Comparator<Lesson>() {
        @Override
        public int compare(Lesson l1, Lesson  l2) {
            return (l1.getThumbUp().compareTo(l2.getThumbUp()));
        }
    };


    public static Comparator<Lesson> commentComparator = new Comparator<Lesson>() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public int compare(Lesson l1, Lesson l2) {
            return  (Integer.compare(l1.getIdCommentMap().keySet().size(), l2.getIdCommentMap().keySet().size()));
        }
    };
}

