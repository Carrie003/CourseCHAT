package com.example.course_chat;

import java.util.ArrayList;

public class VocabCheck {
    private String language, dateCreated, description;
    private ArrayList<String> vocabList, meaningList;
    private Integer thumbUp, thumbDown;

    public VocabCheck(String language, String description, ArrayList<String> vocabList, ArrayList<String> meaningList,  Integer thumbUp, Integer thumbDown,String dateCreated){
        this.language = language;
        this.description = description;
        this.vocabList = vocabList;
        this.meaningList = meaningList;
        this.dateCreated = dateCreated;
        this.thumbUp = thumbUp;
        this.thumbDown = thumbDown;

    }

    public String getLanguage(){
        return language;
    }

    public ArrayList<String> getVocabList() {
        return vocabList;
    }

    public ArrayList<String> getMeaningList() {
        return meaningList;
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
}
