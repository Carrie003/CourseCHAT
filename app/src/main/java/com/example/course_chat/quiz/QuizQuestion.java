package com.example.course_chat.quiz;

import java.util.ArrayList;

public class QuizQuestion {

    private Integer id;
    private String question, answer,type;
    private ArrayList<String> choices;
   public  QuizQuestion(Integer id, String type, String question, String answer, ArrayList<String> choices){
        this.id = id;
        this.type = type;
        this.question = question;
        this.answer = answer;
        this.choices = choices;

    }


    public Integer getId() {
        return id;
    }

    public String getType(){
        return type;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }


    public ArrayList<String> getChoices() {
        return choices;
    }

}
