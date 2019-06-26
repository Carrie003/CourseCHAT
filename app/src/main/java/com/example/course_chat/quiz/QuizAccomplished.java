package com.example.course_chat.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.course_chat.R;

public class QuizAccomplished extends AppCompatActivity {


    TextView scoreText;
    DoQuiz doQuiz;
    public Integer score =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_accomplished);
        scoreText = findViewById(R.id.scoreText);

        doQuiz = new DoQuiz();
//        scoreText.setText(doQuiz.getAnswerText());

    }



}
