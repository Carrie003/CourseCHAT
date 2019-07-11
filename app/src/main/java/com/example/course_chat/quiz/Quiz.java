package com.example.course_chat.quiz;
import com.example.course_chat.main.User;

import java.util.ArrayList;

public class Quiz {
    private User user;
    private String title;
    private String subject;
    private String  description;
    private String  dateCreated;
    private Integer difficulty, thumbUp, thumbDown;
    private ArrayList<String> questionList, answerList;

    public Quiz(User user, String title, String subject, Integer difficulty, ArrayList<String>  questionList, ArrayList<String> answerList , String description,  Integer thumbUp, Integer thumbDown, String dateCreated){
        this.user = user;
        this.title = title;
        this.subject = subject;
        this.difficulty = difficulty;
        this.description = description;
        this.questionList = questionList;
        this.answerList = answerList;
        this.thumbUp = thumbUp;
        this.thumbDown = thumbDown;
        this.dateCreated = dateCreated;


    }
    public User getUser(){
        return user;
    }
//    public Integer getQuizID(){
//        return quizID;
//    }
    public ArrayList<String> getQuestionList(){
        return questionList;

    }

    public int getDifficulty(){
        return difficulty;
    }
    public String getDescription(){
        return description;
    }


    public ArrayList<String> getAnswerList(){
        return answerList;
    }
    public Integer getThumbUp(){
        return thumbUp;
    }
    public Integer getThumbDown(){
        return thumbDown;
    }
    public String getDateCreated(){
        return dateCreated;
    }

    public void setThumbUp(int newThumbUp){
        thumbUp = newThumbUp;
    }
    public void setThumbDown(int newThumbDown){
        thumbDown = newThumbDown;
    }
}


