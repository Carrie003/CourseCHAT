package com.example.course_chat.discussion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.course_chat.R;
import com.example.course_chat.main.SignUp;
import com.example.course_chat.main.User;

import java.util.ArrayList;
import java.util.Map;

public class ViewDiscussion extends AppCompatActivity {

    private Map<Integer, Reply> idReplyMap;
    private Discussion currentDiscussion;
    private ArrayList<Reply> replyList;
    private ReplyListViewAdapter replyListViewAdapter;
    private ListView replyListView;
    private View discussionTopicView;
    private TextView topicTextView;
    private TextView detailTextView;
    private TextView userNameTextView;
    private View view;
    private LayoutInflater inflater;
    private ImageView topicUserImage;

    private User topicUser;
    private RelativeLayout.LayoutParams relativeParams;

    private RelativeLayout vdrl;
    public ViewDiscussion(){

        relativeParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        vdrl = findViewById(R.id.vdrl);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_discussion3);


        currentDiscussion = CreateDiscussion.idDiscussionMap.get(DiscussionListViewAdapter.currentId);
        createDiscussionView();
        createReplyListView();
    }

    public void createDiscussionView(){

//        view = inflater.inflate(R.layout.activity_view_discussion3, null);




        topicUserImage = new ImageView(this);
        topicUser = SignUp.idUserMap.get(currentDiscussion.getUserId());
        topicUserImage.setImageURI(topicUser.getUserIamgeUri());

        topicUserImage.setX(0); //TODO change the x, y position
        topicUserImage.setY(0);
        vdrl.addView(topicUserImage);


        discussionTopicView = findViewById(R.id.discussionTopicView);
        topicTextView = findViewById(R.id.topicTextView);
        detailTextView = findViewById(R.id.detailTextView);


        userNameTextView = findViewById(R.id.userNameTextView);


    }

    public void createReplyListView() {
        replyListView = findViewById(R.id.replyListView);

        try{
            idReplyMap = currentDiscussion.getIdReplyMap();
            replyList = new ArrayList<>();
            
            for(Integer id: idReplyMap.keySet()){
                replyList.add(idReplyMap.get(id));

            }
            replyListViewAdapter = new ReplyListViewAdapter(this, replyList);
            replyListView.setAdapter(replyListViewAdapter);

        }
        catch (Exception e){
            System.out.println(e);
        }



    }



}
