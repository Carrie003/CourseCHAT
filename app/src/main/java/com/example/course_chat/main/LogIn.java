package com.example.course_chat.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.course_chat.R;
import com.example.course_chat.vocabquiz.BuildVocabCheckMain;

import java.util.HashMap;
import java.util.Map;

public class LogIn extends AppCompatActivity {

    public static  Map<String, User> applicationUserMap;


    public LogIn(){
        applicationUserMap = new HashMap<>();

    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void logIn(View view){
        Intent intent = new Intent(getApplicationContext(),Menu.class);
        startActivity(intent);
    }
}
