package com.example.course_chat.discussion;


import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.course_chat.main.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class Discussion {

//    private Integer id;


   private User  user;

    private String topic;
    private String content;
    private Integer thumbUp;
    private Integer thumbDown;
    private String dateCreated;
    private Map<Integer, Reply> idReplyMap;



    public Discussion(User user, String topic, String content, Integer thumbUp, Integer thumbDown, String dateCreated,  Map<Integer, Reply> idReplyMap){


      this.user = user;
        this.topic = topic;
        this.content = content;
        this.thumbUp = thumbUp;
        this.thumbDown = thumbDown;
        this.dateCreated = dateCreated;
        this.idReplyMap = idReplyMap;

    }

    public User  getUserId() {
        return user;
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

    public String getDateCreated() {
        return dateCreated;
    }

    public Map<Integer, Reply> getIdReplyMap() {
        return idReplyMap;
    }

    public void setThumbUp(Integer thumbUp) {
        this.thumbUp = thumbUp;
    }

    public void setThumbDown(Integer thumbDown) {
        this.thumbDown = thumbDown;
    }


    public static Comparator<Discussion> voteComparator = new Comparator<Discussion>() {
        @Override
        public int compare(Discussion d1, Discussion d2) {
            return (d1.getThumbUp().compareTo(d2.getThumbUp()));
        }
    };


    public static Comparator<Discussion> ReplyComparator = new Comparator<Discussion>() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public int compare(Discussion d1, Discussion d2) {
            return  (Integer.compare(d1.getIdReplyMap().keySet().size(), d2.getIdReplyMap().keySet().size()));
        }
    };
}

