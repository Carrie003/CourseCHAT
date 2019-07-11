package com.example.course_chat.vocabquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;

import com.example.course_chat.R;
import com.example.course_chat.interfaces.SearchInterface;
import com.example.course_chat.videolesson.CreateLessons;
import com.example.course_chat.videolesson.Lesson;
import com.example.course_chat.videolesson.LessonListViewAdapter;

import java.util.Collections;
import java.util.List;

public class SearchVocabQuiz extends AppCompatActivity implements SearchView.OnQueryTextListener, AdapterView.OnItemSelectedListener, SearchInterface {


    private ListView vocabQuizListView;
    private SearchVocabQuizListViewAdapter adapter;
    private SearchView vocabQuizSearch;
    //    ArrayList<Lesson> arraylist, lessonList;
    private BuildVocabCheck bV;
    private Spinner sortingSpinner;
    private int j;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_vocab_quiz);

        setUpSearchViews();

        setUpSortingSpinner();
        j = 1;
    }


    @Override
    public void setUpSearchViews() {

        bV = new BuildVocabCheck();

        vocabQuizListView = findViewById(R.id.lessonListView);// TODO change to vocabQuiz

        adapter = new SearchVocabQuizListViewAdapter(this,bV.vocabQuizList); //TODO change to vocab quiz

        vocabQuizListView.setAdapter(adapter);
        vocabQuizSearch =  findViewById(R.id.vocabQuizSearchView);
        vocabQuizSearch.setOnQueryTextListener(this);

    }

    @Override
    public void setUpSortingSpinner() {

        ArrayAdapter<CharSequence> subjectListAdaptor = ArrayAdapter.createFromResource(this, R.array.sorting, android.R.layout.simple_spinner_item);//TODO change to SearchDiscussion.this if not work
        subjectListAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortingSpinner.setAdapter(subjectListAdaptor);
        sortingSpinner.setOnItemSelectedListener(this);
    }



    @Override
    public List<VocabCheck> getSortedListByVotes() {
        Collections.sort(adapter.vocabQuizList, VocabCheck.voteComparator);
        return adapter.vocabQuizList;
    }



    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        String text = newText;
        adapter.filter(text);

        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(j<=0){

            if(position == 1){
                adapter = new SearchVocabQuizListViewAdapter(this, getSortedListByVotes());

                vocabQuizListView.setAdapter(adapter);

            }

//            else if(position == 2){
//                adapter = new VocabCheckListViewAdapter(this, getSortedDiscussionListByCommentsOrReplies());
//
//                vocabQuizListView.setAdapter(adapter);
//
//            }





        }
        j--;


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }






}
