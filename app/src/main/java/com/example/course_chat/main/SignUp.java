package com.example.course_chat.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.course_chat.R;
import com.example.course_chat.interfaces.Interface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class SignUp extends AppCompatActivity implements Interface {
    public static HashMap<String, User> idUserMap;
    private TextView userNameTextView;
    private TextView passwordTextView;
    private String userName;
    private String password;
    private String userId;
    private String userIamgeUri;
    private User newUser;
    private ArrayList<String> userIdCollection;
    private ArrayList<Character> alphabetsList;
    private ArrayList<Character> speicalCharList;
    private Integer randomIndex;
    private String idIntegers;
    private String idAlphabets;
    private String idSpecialChars;


    private String newId;


    public SignUp(){

        idUserMap = new HashMap<>();
        userIdCollection = new ArrayList<>();
        alphabetsList = new ArrayList<>();

        for(int i = 0; i < 26; i++){
            alphabetsList.add((char)(97 + i));

        }

        for(int i = 0; i <15; i++){
            speicalCharList.add((char)(33 + i));
        }
//        alphabetsList = Arrays.asList(idAlphabetsArray);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



    }


    public void signUp(View view){
        userName = userNameTextView.getText().toString();

        password = passwordTextView.getText().toString();

        newUser = new User(userName, password, null, createCurrentDate());

        idUserMap.put(generateNewId(), newUser );

        Intent intent = new Intent(getApplicationContext(), Menu.class);
        startActivity(intent);
    }

    @Override
    public String  generateNewId(){

        Random ran = new Random();


        idIntegers = String.valueOf(ran.nextInt(9000)+1000);
        for(int i =0; i<3; i++){
            randomIndex = ran.nextInt(3);
            idAlphabets += alphabetsList.get(randomIndex).toString();
        }
        for(int i =0; i<3; i++){
            randomIndex = ran.nextInt(3);
            idSpecialChars += speicalCharList.get(randomIndex).toString();

        }


        newId = idIntegers+ idAlphabets + idSpecialChars;

        while(userIdCollection.contains(newId)){
            idIntegers = String.valueOf(ran.nextInt(9000)+1000);
            newId = idIntegers+ idAlphabets + idSpecialChars;
        }

        userIdCollection.add(newId);
        return newId;




    }



    @Override
    public String  createCurrentDate(){

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String currentDate = simpleDateFormat.format(new Date());
        return currentDate;
    }
}
