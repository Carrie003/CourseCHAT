package com.example.course_chat.vocabquiz;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.course_chat.videolesson.Lesson;

import java.util.ArrayList;
import java.util.Comparator;

public class VocabCheck {
    private String language, title, dateCreated, description;
    private ArrayList<String> vocabList, meaningList;
    private Integer thumbUp, thumbDown;

    public VocabCheck(String title, String language, String description, ArrayList<String> vocabList, ArrayList<String> meaningList,  Integer thumbUp, Integer thumbDown,String dateCreated){

        this.title = title;
        this.language = language;
        this.description = description;
        this.vocabList = vocabList;
        this.meaningList = meaningList;
        this.dateCreated = dateCreated;
        this.thumbUp = thumbUp;
        this.thumbDown = thumbDown;

    }





    public String getTitle() {
        return title;
    }

    public String getLanguage(){
        return language;
    }
    public String getDescription() {
        return description;
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


    public static Comparator<VocabCheck> voteComparator = new Comparator<VocabCheck>() {
        @Override
        public int compare(VocabCheck v1, VocabCheck  v2) {
            return (v1.getThumbUp().compareTo(v2.getThumbUp()));
        }
    };


}
