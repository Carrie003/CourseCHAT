package com.example.course_chat.videotutorial;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import java.text.*;

import com.example.course_chat.R;
import com.example.course_chat.vocabquiz.Vocabulary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.util.Random;

public class CommetListViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private  List<Comment> commentList;
    private ArrayList<Comment> arraylist;
//    public static Integer lessonID;
    private Map<Integer, Comment> idCommentMap;

    private ArrayList<Integer> commentIdCollection;





    public CommetListViewAdapter(Context context, List<Comment> commentList) {
        mContext = context;

        this.commentList = commentList;

        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(commentList);

        idCommentMap = new HashMap<>();
        notifyDataSetChanged();




    }

    public class ViewHolder {

        TextView commentLabel;
        EditText newComment;
        Button addButton;

        TextView comment;
        ImageView thumbUpImage;
        TextView thumbUpValue;
        ImageView thumbDownImage;
        TextView thumbDownValue;

    }

    @Override
    public int getCount() {
        return commentList.size();
    }

    @Override
    public Comment getItem(int position) {
        return commentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder  holder;


        if (view == null) {
            holder = new ViewHolder();



            view = inflater.inflate(R.layout.activity_comment_list_view_item_holder, null);
            if(position == 0){

                holder.commentLabel =  view.findViewById(R.id.commentLabel);
                holder.newComment = view.findViewById(R.id.newComment);
                holder.addButton = view.findViewById(R.id.addButton);

            }
            else{
                holder.comment = view.findViewById(R.id.comment);
                holder.thumbUpImage =  view.findViewById(R.id.thumbUpImage);
                holder.thumbUpValue = view.findViewById(R.id.thumbUpValue);
                holder.thumbDownImage = view.findViewById(R.id.thumbDownImage);
                holder.thumbDownValue = view.findViewById(R.id.thumbDownValue);

                holder.comment.setText(commentList.get(position+1).getContent());



            }


            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();

        }

        holder.addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Comment newComment = new Comment( "", "", "", 0, 0,createCurrentDate();
                commentList.add(newComment);
                idCommentMap.put(createNewID(),newComment);
                notifyDataSetChanged();
            }
        });

        holder.thumbUpImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

               Integer originalValue = Integer.valueOf(holder.thumbUpValue.getText().toString());



            }
        });




        return view;
    }

    public void filter(){

    }

    public Integer createNewID(){
        Random ran = new Random();
        Integer newID = ran.nextInt();
        while(commentIdCollection.contains(newID)){

            newID = ran.nextInt();
        }
        return newID;
    }

    public String  createCurrentDate(){

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String currentDate = simpleDateFormat.format(new Date());
        return currentDate;
    }


}
