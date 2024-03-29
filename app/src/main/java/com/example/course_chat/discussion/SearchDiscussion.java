package com.example.course_chat.discussion;

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

import java.util.Collections;
import java.util.List;

public class SearchDiscussion extends AppCompatActivity implements SearchView.OnQueryTextListener, AdapterView.OnItemSelectedListener, SearchInterface {

    private ListView discussionListView;
    private SearchView discussionSearchView;
    private CreateDiscussion cD;
    private DiscussionListViewAdapter adapter;
    private Spinner sortingSpinner;
    private String sortingCategory;
    private int j;

    







//    public SearchDiscussion(){
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_discussion);

        setUpSearchViews();
        setUpSortingSpinner();
        j =1;
    }




        @Override
    public void setUpSearchViews(){
       discussionListView = findViewById(R.id.discussionListView);

       discussionSearchView = findViewById(R.id.discussionSearchView);


        discussionListView =  findViewById(R.id.lessonListView);

        adapter = new DiscussionListViewAdapter(this, cD.discussionList);

        discussionListView.setAdapter(adapter);
        discussionSearchView =  findViewById(R.id.lessonSearchView);
        discussionSearchView.setOnQueryTextListener(this);

    }
    @Override
    public void setUpSortingSpinner(){
        ArrayAdapter<CharSequence> subjectListAdaptor = ArrayAdapter.createFromResource(this, R.array.sorting, android.R.layout.simple_spinner_item);//TODO change to SearchDiscussion.this if not work
        subjectListAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortingSpinner.setAdapter(subjectListAdaptor);
        sortingSpinner.setOnItemSelectedListener(this);
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

        sortingCategory= parent.getItemAtPosition(position).toString();
//        languageList.add(language);
        if(j<=0){

            if(position == 1){
                adapter = new DiscussionListViewAdapter(this, getSortedListByVotes());

                discussionListView.setAdapter(adapter);

            }

            else if(position == 2){
                adapter = new DiscussionListViewAdapter(this, getSortedListByCommentsOrReplies());

                discussionListView.setAdapter(adapter);

            }





        }
        j--;

    }

    @Override
    public List<Discussion> getSortedListByVotes() {
        Collections.sort(adapter.discussionList, Discussion.voteComparator);
        return adapter.discussionList;
    }

//    @Override
    public List<Discussion> getSortedListByCommentsOrReplies() {
        Collections.sort(adapter.discussionList, Discussion.ReplyComparator);
        return adapter.discussionList;
    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
