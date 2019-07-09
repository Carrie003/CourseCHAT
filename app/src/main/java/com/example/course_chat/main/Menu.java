package com.example.course_chat.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.course_chat.R;
import com.example.course_chat.discussion.CreateDiscussion;
import com.example.course_chat.discussion.SearchDiscussion;
import com.example.course_chat.discussion.ViewDiscussion;
import com.example.course_chat.quiz.BuildQuiz;
import com.example.course_chat.quiz.DoQuiz;
import com.example.course_chat.quiz.DoQuizMain;
import com.example.course_chat.videolesson.CreateLessons;
import com.example.course_chat.videolesson.WatchLesson;
import com.example.course_chat.vocabquiz.BuildVocabCheck;
import com.example.course_chat.vocabquiz.BuildVocabCheckMain;

import java.util.ArrayList;

public class Menu extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<String> activityList;
    private ActivityMenuListViewAdapter activityListViewAdapter;
    private ListView activityListView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public Menu(){
        activityList = new ArrayList<>();
        activityListView = findViewById(R.id.menuListView);
        activityList.add("build quiz");
        activityList.add("do quiz");
        activityList.add("build vocab quiz");
        activityList.add("do vocab quiz");
        activityList.add("create discussion");
        activityList.add("reply discussion");
        activityList.add("create video lesson");
        activityList.add("watch video lesson");
        activityListViewAdapter = new ActivityMenuListViewAdapter(this, activityList);
        activityListView.setAdapter(activityListViewAdapter);
        activityListView.setOnItemClickListener(this);
    }





    public void goToCreateDiscussion(View view){

        Intent createIntent = new Intent(getApplicationContext(), CreateDiscussion.class);
        startActivity(createIntent);
    }
    public void goToViewDiscussion(View view){
        Intent viewIntent = new Intent(getApplicationContext(), ViewDiscussion.class);
        startActivity(viewIntent);
    }


//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            language= parent.getItemAtPosition(position).toString();
////        languageList.add(language);
//            if(j<=0){
//                Toast.makeText(this, "Language "+language+" selected",Toast.LENGTH_SHORT).show();
//            }
//            j--;
//        }
//
//    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        if(position == 0){

            intent = new Intent(getApplicationContext(), BuildQuiz.class);
            startActivity(intent);



        }
        else if(position == 1){

            intent = new Intent(getApplicationContext(), DoQuizMain.class);
            startActivity(intent);
        }
        else if(position == 2){

            intent = new Intent(getApplicationContext(), BuildVocabCheckMain.class);
            startActivity(intent);
        }

        else if(position == 3){

            intent = new Intent(getApplicationContext(), BuildVocabCheck.class);
            startActivity(intent);
        }
        else if(position == 4){

            intent = new Intent(getApplicationContext(), CreateDiscussion.class);
            startActivity(intent);
        }

        else if(position == 5){

             intent = new Intent(getApplicationContext(), SearchDiscussion.class);
            startActivity(intent);
        }
        else if(position == 6){

            intent = new Intent(getApplicationContext(), CreateLessons.class);
            startActivity(intent);
        }
        else if(position == 7){

            intent = new Intent(getApplicationContext(), WatchLesson.class);
            startActivity(intent);
        }



    }




}
