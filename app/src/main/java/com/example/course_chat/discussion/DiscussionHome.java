package com.example.course_chat.discussion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.course_chat.R;
import com.example.course_chat.vocabquiz.BuildVocabCheckMain;

public class DiscussionHome extends AppCompatActivity {

    private Button createDiscussionButton;
    private Button viewDiscussionButton;



    public DiscussionHome(){
        createDiscussionButton = findViewById(R.id.createDiscussionButton);
        viewDiscussionButton = findViewById(R.id.viewDiscussionButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion_home);
    }


//    public void goToCreateDiscussion(View view){
//
//        Intent createIntent = new Intent(getApplicationContext(),CreateDiscussion.class);
//        startActivity(createIntent);
//    }
//    public void goToViewDiscussion(View view){
//        Intent viewIntent = new Intent(getApplicationContext(),ViewDiscussion.class);
//        startActivity(viewIntent);
//    }

}
