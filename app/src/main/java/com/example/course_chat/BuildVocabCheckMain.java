package com.example.course_chat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class BuildVocabCheckMain extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner languageSpinner;
    private int j;
    public static String language;
    private ArrayList<String> languageList;
//    public static int newID;
//    private ArrayList<Integer> vocabIDList;

    public BuildVocabCheckMain(){

        languageList = new ArrayList<>();


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_vocab_check_main);
        languageSpinner = findViewById(R.id.languageSpinner);
        j=1;

        ArrayAdapter<CharSequence> subjectListAdaptor = ArrayAdapter.createFromResource(BuildVocabCheckMain.this, R.array.languages, android.R.layout.simple_spinner_item);
        subjectListAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(subjectListAdaptor);
        languageSpinner.setOnItemSelectedListener(this);
    }


//    public void initializeLanguageList() {
//        languageList.add("Chinese");
//        languageList.add("Chinese");
//        languageList.add("Chinese");
//        languageList.add("Chinese");
//    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        language= parent.getItemAtPosition(position).toString();
//        languageList.add(language);
        if(j<=0){
                Toast.makeText(this, "Language "+language+" selected",Toast.LENGTH_SHORT).show();
        }
        j--;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void goToVocabTable(View view){
//        Random rand = new Random();
//        newID  = rand.nextInt();
//        while(vocabIDList.contains(newID)){
//            newID = rand.nextInt();
//        }
//        vocabIDList.add(newID);

        Intent intent = new Intent(getApplicationContext(), BuildVocabCheck.class);
        startActivity(intent);


    }

//    public String getLanguage(int ID){
//        return languageList.get(ID);
//    }





}

