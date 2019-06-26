package com.example.course_chat.vocabquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.course_chat.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class BuildVocabCheck extends AppCompatActivity {


    ListView vocabCheckListView;
    VocabCheckListViewAdapter vocabCheckListViewAdapter;
    ArrayList<VocabCheck> vocabCheckList;
    ArrayList<Vocabulary> emptyVocabList;


    public BuildVocabCheck(){
        vocabCheckList = new ArrayList<>();
        emptyVocabList = new ArrayList<>();

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_vocab_check);
        vocabCheckListView = findViewById(R.id.vocabCheckListView);
        emptyVocabList.add(new Vocabulary("", ""));
        vocabCheckListViewAdapter = new VocabCheckListViewAdapter(this, emptyVocabList);
        vocabCheckListView.setAdapter(vocabCheckListViewAdapter);


    }




    public void addVocabCheck(View view){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String currentDate = simpleDateFormat.format(new Date());
        vocabCheckList.add(new VocabCheck(BuildVocabCheckMain.language, "hhh",VocabCheckListViewAdapter.temporaryVocabNameList, VocabCheckListViewAdapter.temporaryVocabMeaningList,0,0,currentDate));
        VocabCheckListViewAdapter.setTemporaryVocabNameList(null);
        VocabCheckListViewAdapter.setTemporaryVocabMeaningList(null);

//        Log.i("hi",vocabCheckList.get(0).getDateCreated());

    }









}
