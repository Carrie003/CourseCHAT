package com.example.course_chat.videolesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.course_chat.R;

import java.util.ArrayList;

public class SearchLesson extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ListView list;
    LessonListViewAdapter adapter;
    SearchView lessonSearch;
    ArrayList<Lesson> arraylist, lessonList;
    CreateLessons cL;

    public SearchLesson(){
        arraylist = new ArrayList<>();
        cL = new CreateLessons();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_lesson_home);


        list = (ListView) findViewById(R.id.lessonListView);

        lessonList = cL.lessons;
        for (Lesson lesson: lessonList) {

            arraylist.add(lesson);
        }


        adapter = new LessonListViewAdapter(this, arraylist);


        list.setAdapter(adapter);


        lessonSearch = (SearchView) findViewById(R.id.lessonSearchView);
        lessonSearch.setOnQueryTextListener(this);
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
}
