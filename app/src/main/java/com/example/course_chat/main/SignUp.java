package com.example.course_chat.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.course_chat.R;
import com.example.course_chat.vocabquiz.BuildVocabCheckMain;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {

    public static HashMap<Integer, User> idUserMap;

    public SignUp(){
        idUserMap = new HashMap<>();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void signUp(View view){
        Intent intent = new Intent(getApplicationContext(), Menu.class);
        startActivity(intent);
    }
}
