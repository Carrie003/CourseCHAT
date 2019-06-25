package com.example.course_chat;
import java.util.ArrayList;
import java.util.Date;
public class Quiz {
    String user, description, dateCreated;
    Integer difficulty, thumbUp, thumbDown;
    ArrayList<String> questionList, answerList;

    public Quiz(String user, ArrayList<String>  questionList, ArrayList<String> answerList, Integer difficulty, String description,  Integer thumbUp, Integer thumbDown, String dateCreated){
        this.user = user;
        this.description = description;
//        this.quizID = quizID;
        this.questionList = questionList;
        this.answerList = answerList;
        this.difficulty = difficulty;
        this.thumbUp = thumbUp;
        this.thumbDown = thumbDown;
        this.dateCreated = dateCreated;


    }
    public String getUser(){
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


