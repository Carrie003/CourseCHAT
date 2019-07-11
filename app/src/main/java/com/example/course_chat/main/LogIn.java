package com.example.course_chat.main;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.course_chat.R;
import com.example.course_chat.vocabquiz.BuildVocabCheckMain;

import java.util.HashMap;
import java.util.Map;

public class LogIn extends AppCompatActivity {

    public static  Map<String, User> applicationUserMap;



    private String applicationId;


    private TextView userNameTextView;
    private TextView passwordTextView;

    private User currentUser;
    private Boolean signedUpSuccessful;



    public LogIn(){
        applicationUserMap = new HashMap<>();

        signedUpSuccessful = false;

    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

    }


    public User getCurrentUser(){





            for(User user: SignUp.idUserMap.values()){

                if(user.getUserName().equals(userNameTextView.getText()) && user.getUserName().equals(userNameTextView.getText())){
                    currentUser = user;
                    signedUpSuccessful = true;
                }


            }


        return currentUser;
    }
    public void logIn(View view){

        PackageManager packageManager = getPackageManager();
        try {
            applicationId = String.valueOf(packageManager.getApplicationInfo("com.example.app", PackageManager.GET_META_DATA));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if(signedUpSuccessful){
            applicationUserMap.put(applicationId, getCurrentUser());
        }
        else{

            Toast.makeText(this, "password or username wrong, please try again...", Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(getApplicationContext(),Menu.class);
        startActivity(intent);
    }


}
