package com.example.course_chat.vocabquiz;

public class Vocabulary {

    private String vocabName,meaning;
    public Vocabulary(String name, String meaning){
        this.meaning = meaning;
    }

    public String getName() {
        return vocabName;
    }

    public String getMeaning() {
        return meaning;
    }
}
