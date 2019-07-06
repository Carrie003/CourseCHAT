package com.example.course_chat.videotutorial;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.course_chat.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Random;

public class CreateLessons extends AppCompatActivity {


    private Uri tutorialVideoUri;
    private final int REQUEST_VIDEO_CODE =1;
    private ArrayList<Lesson> lessons;

    private VideoView tutorialVideoView;
    public static ArrayList<Uri> videoUris;
    private Integer lessonID;
    public static  Map<Integer, Lesson> IDlessonMap;
    private ArrayList<Integer> lessonIdCollection;

    public CreateLessons(){
        tutorialVideoView  = findViewById(R.id.tutorialVideoView);
        videoUris = new ArrayList<>();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teach_class);


    }



    public void uploadClass(View view){
        Intent uploadVideoIntent = new Intent();
        uploadVideoIntent.setType("video/*");
        uploadVideoIntent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(uploadVideoIntent, 1);

    }

    public void recordClass(View view){
        Intent recordVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(recordVideoIntent, 1);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_VIDEO_CODE && resultCode == RESULT_OK  && data!=null){
            try{
                tutorialVideoUri = data.getData();
                tutorialVideoView.setVideoURI(tutorialVideoUri);
                tutorialVideoView.start();

                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String currentDate = simpleDateFormat.format(new Date());
                Lesson newLesson = new Lesson(tutorialVideoUri, "", "", 0,0, currentDate, new ArrayList<Comment>());
                lessons.add(newLesson);
                IDlessonMap.put(createNewID(),newLesson);

                Toast.makeText(CreateLessons.this, "Video uploaded successfully", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){

                Toast.makeText(CreateLessons.this, "Something went wrong, please try again", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(CreateLessons.this, "You have to select exactly one video to upload", Toast.LENGTH_SHORT).show();
        }
    }

    public Integer createNewID(){
        Random ran = new Random();
        Integer newID = ran.nextInt();
        while(lessonIdCollection.contains(newID)){

            newID = ran.nextInt();
        }
        return newID;
    }
}
