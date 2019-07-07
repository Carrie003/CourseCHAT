package com.example.course_chat.discussion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.course_chat.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CreateDiscussion extends AppCompatActivity {


    private EditText topicEditText;
    private EditText contentEditText;
    private Button submitButton;
    private List<Discussion> discussionList;
    private Map<Integer, Discussion> idDiscussionMap;
    private Discussion newDiscussion;
    private String topic;
    private String content;


    private ArrayList<Integer> discussionIdCollection;


    public CreateDiscussion(){
        topicEditText = findViewById(R.id.topicEditText);
        contentEditText = findViewById(R.id.contentEditText);
        submitButton = findViewById(R.id.submitButton);
        discussionList = new ArrayList<>();
        idDiscussionMap = new HashMap<>();
        discussionIdCollection = new ArrayList<>();



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_discussion);



    }


    public void submit(View view){
        topic = topicEditText.getText().toString();
        content = contentEditText.getText().toString();
        newDiscussion = new Discussion( topic, content, 0,0, createCurrentDate(), new ArrayList<String>());
        discussionList.add(newDiscussion);
        idDiscussionMap.put(createNewID(),newDiscussion);
    }



    public Integer createNewID(){
        Random ran = new Random();
        Integer newID = ran.nextInt();
        while(discussionIdCollection.contains(newID)){

            newID = ran.nextInt();
        }
        return newID;
    }

    public String  createCurrentDate(){

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String currentDate = simpleDateFormat.format(new Date());
        return currentDate;
    }


}
