package com.example.course_chat.videolesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;

import com.example.course_chat.R;
import com.example.course_chat.discussion.Discussion;
import com.example.course_chat.discussion.DiscussionListViewAdapter;
import com.example.course_chat.interfaces.SearchInterface;

import java.util.Collections;
import java.util.List;

public class SearchLesson extends AppCompatActivity implements SearchView.OnQueryTextListener, AdapterView.OnItemSelectedListener, SearchInterface {

    private ListView lessonListView;
    private  LessonListViewAdapter adapter;
    private SearchView lessonSearch;
//    ArrayList<Lesson> arraylist, lessonList;
    private CreateLessons cL;
    private Spinner sortingSpinner;
    private int j;

    public SearchLesson(){
//        arraylist = new ArrayList<>();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_lesson_home);

        setUpSearchViews();

        setUpSortingSpinner();

        j = 1;
    }

//    public void setUpSearchLessonViews(){
//
//        }

    @Override
    public void setUpSearchViews() {
        cL = new CreateLessons();

        lessonListView = findViewById(R.id.lessonListView);

        adapter = new LessonListViewAdapter(this,cL.lessons);

        lessonListView.setAdapter(adapter);
        lessonSearch =  findViewById(R.id.lessonSearchView);
        lessonSearch.setOnQueryTextListener(this);

    }

    @Override
    public void setUpSortingSpinner() {

        ArrayAdapter<CharSequence> subjectListAdaptor = ArrayAdapter.createFromResource(this, R.array.sorting, android.R.layout.simple_spinner_item);//TODO change to SearchDiscussion.this if not work
        subjectListAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortingSpinner.setAdapter(subjectListAdaptor);
        sortingSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public List<Lesson> getSortedListByVotes() {
        Collections.sort(adapter.lessonList, Lesson.voteComparator);
        return adapter.lessonList;
    }

//    @Override
    public List<Lesson> getSortedListByCommentsOrReplies() {
        Collections.sort(adapter.lessonList, Lesson.commentComparator);
        return adapter.lessonList;
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
                adapter = new LessonListViewAdapter(this, getSortedListByVotes());

                lessonListView.setAdapter(adapter);

            }

            else if(position == 2){
                adapter = new LessonListViewAdapter(this, getSortedListByCommentsOrReplies());

                lessonListView.setAdapter(adapter);

            }





        }
        j--;


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
