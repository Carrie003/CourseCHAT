package com.example.course_chat.videotutorial;

public class Comment {
    private String user;
    private String commentsOfComment;
    private Integer thumbUp, thumbDown;
    private Integer dateCommented;

    public Comment(String user, String commentsOfComment, Integer thumbUp, Integer thumbDown, Integer dateCommented){

        this.user = user;
        this.commentsOfComment = commentsOfComment;
        this.thumbUp = thumbUp;
        this.thumbDown = thumbDown;
    }

    public String getUser() {
        return user;
    }

    public String getCommentsOfComment() {
        return commentsOfComment;
    }

    public Integer getThumbUp() {
        return thumbUp;
    }

    public Integer getThumbDown() {
        return thumbDown;
    }

    public Integer getDateCommented() {
        return dateCommented;
    }
}


