package com.example.course_chat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.*;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.text.*;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    int i = 1;

Spinner spinner, difficultyCategorySppinner;
Button addQbtn;
int newID;
private TextView textView2, textView3;
private int questionIndex;
private String nextQuestion;
public static int ID;
private QuizListViewAdapter quizListViewAdapter;
private QuizQuestionListViewAdapter quizQuestionListViewAdapter;

public ArrayList<String> quizQuestionStorage, quizAnswerStorage;
public List<Quiz> quizList;
private ArrayList<Integer> quizIDCollection;
private ArrayList<Quiz> quizCollection;
private Map<Integer, Quiz> IDQuizMap;

Quiz newQuiz;

private ListView list,quizlist;
public int p;
    // Declare Variables

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quizQuestionStorage = new ArrayList<>();
        quizIDCollection = new ArrayList<>();
        spinner = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adaptor = ArrayAdapter.createFromResource(this, R.array.subjects, android.R.layout.simple_spinner_item);
       adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinner.setAdapter(adaptor);
       spinner.setOnItemSelectedListener(this);


       difficultyCategorySppinner = findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> difficultyListAdapter = ArrayAdapter.createFromResource(this, R.array.difficulties, android.R.layout.simple_spinner_item);
        difficultyListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultyCategorySppinner.setAdapter(difficultyListAdapter);
        difficultyCategorySppinner.setOnItemSelectedListener(this);

//        list =  findViewById(R.id.listview);
//        List<QuizQuestion> arrayList = new ArrayList<>();
//        arrayList.add(new QuizQuestion(0,"","","",null));
//        quizQuestionListViewAdapter = new QuizQuestionListViewAdapter(this, arrayList);
//        list.setAdapter(quizQuestionListViewAdapter);
//





        quizlist  = findViewById(R.id.quizlist);
        quizList= new ArrayList<>();
//        ArrayList<String> qL=  new ArrayList<>();
//        qL.add("blala");
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String currentDate = simpleDateFormat.format(new Date());
        quizList.add( new Quiz("", QuizQuestionListViewAdapter.quizQuestionStorage, QuizQuestionListViewAdapter.quizAnswerStorage, 0,"hhh",0, 0,currentDate));
        quizListViewAdapter = new QuizListViewAdapter(this,quizList);
        quizlist.setAdapter(quizListViewAdapter);







//        quizlist.setOnItemClickListener(new AdapterView. OnItemClickListener()
//        {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View v, int position,
//                                    long arg3)
//            {
//                Log.i("hi", "cliked");
//
//            }
//        });



        quizlist.setOnItemClickListener(new AdapterView. OnItemClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position,
                                    long arg3)
            {
                Log.i("hi", "cliked");
                parent.getChildAt(position).setBackgroundColor(				Color.argb((float) 0.5, 100, 100, 100));

                for(int i =0; i<parent.getCount(); i++) {
                    if (i != position) {
                        parent.getChildAt(position).setBackgroundColor(255 - 255 - 255);
                    }
                }
                p = position;

                Toast.makeText(MainActivity.this,"A new quiz selected", Toast.LENGTH_SHORT).show();
            }
        });

//        addQbtn = findViewById(R.id.addQbtn);
//        textView2  = findViewById(R.id.textView2);
//        textView3  = findViewById(R.id.textView3);
//        questionIndex = 0;



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String text = parent.getItemAtPosition(position).toString();


        if(i<0){
            if(parent == difficultyCategorySppinner){
                Toast.makeText(this, "Difficulty "+text+" selected",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Subject "+text+" selected",Toast.LENGTH_SHORT).show();
            }

        }
       i--;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void addQbtnClicked(View view){


//        String pattern = "yyyy-MM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String currentDate = simpleDateFormat.format(new Date());
//
//        newQuiz = new Quiz("", QuizQuestionListViewAdapter.quizQuestionStorage, QuizQuestionListViewAdapter.quizAnswerStorage, 0,"",0, 0,currentDate);//TODO add, description, difficulty
//
//        quizList.add(newQuiz);
////        IDQuizMap.put(newID,newQuiz);
//        quizCollection.add(newQuiz);
//
//        QuizQuestionListViewAdapter.quizQuestionStorage.clear();
//        QuizQuestionListViewAdapter.quizAnswerStorage.clear();
//
//        Log.i( "question storage", QuizQuestionListViewAdapter.quizQuestionStorage.get(0));
//        Log.i( "question storage", QuizQuestionListViewAdapter.quizQuestionStorage.get(0));

    }


//        Random rand = new Random();
//        newID  = rand.nextInt();
//        while(quizIDCollection.contains(newID)){
//            newID = rand.nextInt();
//
//        }
//        quizIDCollection.add(newID);
//        Date currentDate =  simpleDateFormat.format(new Date());

//
//
    public void doQuizBtnOnClick(View view){

        Intent intent = new Intent(getApplicationContext(),DoQuiz.class);
        startActivity(intent);
    }



//    public ArrayList<Quiz> getQuizList(){
//        return quizList;
//    }


//
//    public void next(View view){
//       //TODO get newID from QuizBank
//
////        ID = Integer.valueOf();
//        questionIndex+=1;
////        nextQuestion = IDQuizMap.get(ID).getQuestionList().get(questionIndex); //TODO set newQuiz to the quiz that mapped to newID
//
//        textView2.setText(nextQuestion);
//    }


    public void gotovocab(View view){
        Intent intent = new Intent(getApplicationContext(), BuildVocabCheckMain.class);
        startActivity(intent);
    }


    public void goToFun(View view) {
        Intent intent = new Intent(getApplicationContext(), DoVocabCheckFunMode.class);
        startActivity(intent);


    }

    }
