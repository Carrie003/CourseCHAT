package com.example.course_chat.vocabquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.course_chat.R;
import com.example.course_chat.interfaces.Interface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class BuildVocabCheck extends AppCompatActivity implements AdapterView.OnItemSelectedListener, Interface {


    private Spinner languageSpinner;
    private int j;
    private String language;
    private ArrayList<String> languageList;
    private TextView descriptionTextView;
    private ListView vocabCheckListView;
    private VocabCheckListViewAdapter vocabCheckListViewAdapter;
    public static ArrayList<VocabCheck> vocabQuizList;
    private ArrayList<Vocabulary> initialVocabQuizList;
    public static Map<String, VocabCheck> idVocabCheckMap;
    private VocabCheck newVocabQuiz;
    private String newId;
    private ArrayList<Character> alphabetsList;
    private ArrayList<Character> speicalCharList;
    private Integer randomIndex;
    private String idIntegers;
    private String idAlphabets;
    private String idSpecialChars;
    private ArrayList<String> vocabQuizIdCollection;

    //    public static int newID;
//    private ArrayList<Integer> vocabIDList;
//    ArrayList<Vocabulary> initialVocabList;


    public BuildVocabCheck(){
        initialVocabQuizList = new ArrayList<>();

        languageList = new ArrayList<>();
        descriptionTextView = findViewById(R.id.descriptionTextView);
        idVocabCheckMap = new HashMap<>();

        vocabQuizList = new ArrayList<>();
        vocabQuizIdCollection= new ArrayList<>();


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_vocab_check);
        setUpLanguageSpinner();
        setUpVocabCheckListView();
//        vocabCheckListView = findViewById(R.id.vocabCheckListView);
//        initialVocabList.add(new Vocabulary("", ""));
//        vocabCheckListViewAdapter = new VocabCheckListViewAdapter(this, initialVocabList);
//        vocabCheckListView.setAdapter(vocabCheckListViewAdapter);
        j=1;



    }


    public void setUpLanguageSpinner(){
        languageSpinner = findViewById(R.id.languageSpinner);


        ArrayAdapter<CharSequence> subjectListAdaptor = ArrayAdapter.createFromResource(BuildVocabCheck.this, R.array.languages, android.R.layout.simple_spinner_item);
        subjectListAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(subjectListAdaptor);
        languageSpinner.setOnItemSelectedListener(this);
    }

    public void setUpVocabCheckListView(){
        vocabCheckListView = findViewById(R.id.vocabCheckListView);
        initialVocabQuizList.add(new Vocabulary("", ""));
        vocabCheckListViewAdapter = new VocabCheckListViewAdapter(this, initialVocabQuizList);
        vocabCheckListView.setAdapter(vocabCheckListViewAdapter);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        j--;
        language= parent.getItemAtPosition(position).toString();
        if(j<0){
            Toast.makeText(this, "Language "+language+" selected",Toast.LENGTH_SHORT).show();
        }





    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    public void addVocabCheck(View view){

        try{

            newVocabQuiz = new VocabCheck( language,"",  descriptionTextView.getText().toString(),VocabCheckListViewAdapter.temporaryVocabNameList, VocabCheckListViewAdapter.temporaryVocabMeaningList,0,0,generateCurrentDate());
            vocabQuizList.add(newVocabQuiz);
            idVocabCheckMap.put(generateNewId(),newVocabQuiz);
        }

        catch (Exception e){
//            System.out.println(e);
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();

        }
        VocabCheckListViewAdapter.setTemporaryVocabNameList(null);
        VocabCheckListViewAdapter.setTemporaryVocabMeaningList(null);

    }



    @Override
    public String generateNewId() {
        Random ran = new Random();


        idIntegers = String.valueOf(ran.nextInt(9000)+1000);
        for(int i =0; i<2; i++){
            randomIndex = ran.nextInt(26);
            idAlphabets += alphabetsList.get(randomIndex).toString();
        }
        for(int i =0; i<1; i++){
            randomIndex = ran.nextInt(15);
            idSpecialChars += speicalCharList.get(randomIndex).toString();

        }
        newId = idIntegers+ idAlphabets + idSpecialChars;

        while(vocabQuizIdCollection.contains(newId)){
            idIntegers = String.valueOf(ran.nextInt(9000)+1000);
            newId = idIntegers+ idAlphabets + idSpecialChars;
        }

        vocabQuizIdCollection.add(newId);
        return newId;

    }

    @Override
    public String  generateCurrentDate(){

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String currentDate = simpleDateFormat.format(new Date());
        return currentDate;
    }
















}
