package com.example.course_chat.videolesson;

public class Comment {
    private String content;
    private String user;
    private String commentsOfComment;
    private Integer thumbUp, thumbDown;
    private String dateCommented;
//    private Integer commentId;

    public Comment(String content, String user, String commentsOfComment, Integer thumbUp, Integer thumbDown, String dateCommented){


        this.content = content;
        this.user = user;
        this.commentsOfComment = commentsOfComment;
        this.thumbUp = thumbUp;
        this.thumbDown = thumbDown;
    }



    public String getContent() {
        return content;
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

    public String getDateCommented() {
        return dateCommented;
    }

    public void setThumbUp(Integer newThumbUp) {
        this.thumbUp = newThumbUp;
    }

    public void setThumbDown(Integer newThumbDown) {
        this.thumbDown = newThumbDown;
    }
}


