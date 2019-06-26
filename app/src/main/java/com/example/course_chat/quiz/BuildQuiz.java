package com.example.course_chat.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.course_chat.R;

import java.util.ArrayList;
import java.util.List;

public class BuildQuiz extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int i= 1;
    Spinner subjectCategorySpinner, difficultyCategorySppinner;
//    ArrayList<String> subjectCategoryList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_quiz);
        subjectCategorySpinner = findViewById(R.id.subjectCategorySpinner);//TODO change id add spinner
        ArrayAdapter<CharSequence> subjectListAdaptor = ArrayAdapter.createFromResource(BuildQuiz.this, R.array.subjects, android.R.layout.simple_spinner_item);
        subjectListAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectCategorySpinner.setAdapter(subjectListAdaptor);
        subjectCategorySpinner.setOnItemSelectedListener(this);

        difficultyCategorySppinner = findViewById(R.id.spinner4);//TODO change id add spinner
        ArrayAdapter<CharSequence> difficultyListAdapter = ArrayAdapter.createFromResource(this, R.array.difficulties, android.R.layout.simple_spinner_item);
        difficultyListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultyCategorySppinner.setAdapter(difficultyListAdapter);
        difficultyCategorySppinner.setOnItemSelectedListener(this);

        ListView list;
        QuizQuestionListViewAdapter quizQuestionadapter;

//        list =  findViewById(R.id.listview);//TODO change id add listVew

        List<QuizQuestion> arrayList = new ArrayList<>();
        arrayList.add(new QuizQuestion(0,"","","",null));


       quizQuestionadapter = new QuizQuestionListViewAdapter(this, arrayList);


//        list.setAdapter(quizQuestionadapter); //TODO set adapter for the list view created
//        addQbtn = findViewById(R.id.addQbtn);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        if(i<0){
            if(parent == difficultyCategorySppinner){
                Toast.makeText(this, "Difficulty "+text+" selected",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Subject "+text+" selected",Toast.LENGTH_SHORT).show();
            }
           i--;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

//    public void initializeSubjectList(){
//
//        subjectCategoryList = new ArrayList<>();
//        subjectCategoryList.add("Math");
//        subjectCategoryList.add("Computer Science");
//        subjectCategoryList.add("Physics");
//        subjectCategoryList.add("Chemistry");
//        subjectCategoryList.add("Biology");
//        subjectCategoryList.add("Economics");
//        subjectCategoryList.add("Psychology");
//        subjectCategoryList.add("History");
//
//
//
//
//    }

}
