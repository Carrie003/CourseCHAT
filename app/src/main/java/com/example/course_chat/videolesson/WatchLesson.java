package com.example.course_chat.videolesson;

import android.app.ProgressDialog;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.course_chat.R;

import java.util.ArrayList;

public class WatchLesson extends AppCompatActivity {


    private VideoView lessonVideoView;
    private ListView commentListView;
    private Button playButton;
    private ProgressDialog progressDialog;
    private MediaController lessonMedia;
    private CommetListViewAdapter commentAdapter;
    private ArrayList<Comment> commentArrayList;



    public WatchLesson(){
        lessonVideoView= findViewById(R.id.lessonVideo);
        commentListView= findViewById(R.id.commentListView);
//        playButton = findViewById(R.id.playButton);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_lesson);
        setUpLessonViews();

        setUpCommentViews();


    }


//    public void setUpLesson(){
//
//    }
//
//
//    public void playLesson(View view){
//
//        playButton.animate().alpha(0).setDuration(100);
//        lessonVideoView.start();
//
//
//    }
//
//    public void pauseLesson(View view){
//        playButton.animate().alpha(1).setDuration(100);
//        lessonVideoView.pause();
//    }


    public void setUpLessonViews(){
        try {

            lessonMedia = new MediaController(this);
            lessonMedia.setAnchorView(lessonVideoView);
            lessonVideoView.setMediaController(lessonMedia);
            Lesson videoLesson  = CreateLessons.IDlessonMap.get(LessonListViewAdapter.lessonID);
            Uri videoUri = videoLesson.getLessonUri();
            lessonVideoView.setVideoURI(videoUri);
            lessonVideoView.requestFocus();

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
    }

    public void setUpCommentViews(){

        commentListView = findViewById(R.id.commentListView);
        commentAdapter = new CommetListViewAdapter(this, commentArrayList);
        commentListView.setAdapter(commentAdapter);


    }









}
