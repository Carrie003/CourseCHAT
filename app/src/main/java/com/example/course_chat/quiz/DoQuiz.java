package com.example.course_chat.quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.course_chat.main.MainActivity;
import com.example.course_chat.R;

import java.util.ArrayList;

public class DoQuiz extends AppCompatActivity {


    TextView questionText;
    Button nextQuestionButton;
    ProgressBar quizProgressBar;
    MainActivity main = new MainActivity();
    public ArrayList<String> q = new ArrayList();
    private int questionIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_quiz);

        initializeText();
        questionIndex = 0;
        nextQuestionButton = findViewById(R.id.nextQuestionBtn);
        quizProgressBar = findViewById(R.id.quizProgressBar);




    }

    public void initializeText(){
        questionText = findViewById(R.id.questionText);

        q.clear();
        q.add("p");
        q.add("j");
        q.add("l");
        for(String l:q){
            Log.i("hi", l);
        }
        questionText.setText("Question" +(questionIndex+1)+ " "+q.get(main.p)); //TODO set q to quizList of this class
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void nextQuestion(View view){
        if(questionIndex < q.size()-2){
            nextQuestionButton.setText("next question");
            questionIndex +=1;
            questionText.setText("Question" +(questionIndex+1)+ " "+q.get(questionIndex));
            quizProgressBar.setProgress(quizProgressBar.getMax()/q.size()); //TODO move to the method that checks right or wrong
            quizProgressBar.getProgressDrawable().setColorFilter(
                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        }
       else if(questionIndex == q.size()-2){
            questionIndex +=1;
            questionText.setText("Question" +(questionIndex+1)+ " "+q.get(questionIndex));
            nextQuestionButton.setText("finish quiz");
        }
       else{
            Intent intent = new Intent(getApplicationContext(), QuizAccomplished.class);
            startActivity(intent);
        }



////        LayoutInflater inflater = getLayoutInflater();
////        View v = inflater.inflate(R.layout.activity_correct_and_wrong_toast,
////                (ViewGroup)findViewById(R.id.relativeLayout1));
////
////        Toast toast = new Toast(this);
////        toast.setView(v);
////        toast.show();
//
    }

    public void previousQuestion(View view){
        if(questionIndex>0){
            questionIndex -=1;
            questionText.setText("Question" +(questionIndex+1)+ " "+q.get(questionIndex));
        }

        else{
            Toast.makeText(this,"This is already the first question", Toast.LENGTH_SHORT).show();
        }

    }


//    public String  getAnswerText() {
//        return answerText.getText().toString();
//    }

    //



}
