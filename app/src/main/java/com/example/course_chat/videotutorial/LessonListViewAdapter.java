package com.example.course_chat.videotutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.course_chat.R;
import com.example.course_chat.vocabquiz.Vocabulary;

import java.util.ArrayList;
import java.util.List;

public class LessonListViewAdapter extends BaseAdapter {



    Context mContext;
    LayoutInflater inflater;
    public static List<Vocabulary> emptyClassList;
    private ArrayList<Vocabulary> arraylist;

    public LessonListViewAdapter(Context context, List<Vocabulary> emptyClassList) {
        mContext = context;

        this.emptyClassList = emptyClassList;

        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(LessonListViewAdapter.emptyClassList);



    }

    public class ViewHolder {
        TextView lessonTitle;
        VideoView lessonVideoView;
        Button watchLessonButton;
        TextView dateCreated;
    }

    @Override
    public int getCount() {
        return emptyClassList.size();
    }

    @Override
    public Vocabulary getItem(int position) {
        return emptyClassList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;


        if (view == null) {
            holder = new ViewHolder();

            view = inflater.inflate(R.layout.activity_class_list_view_item_holder, null);
            holder.lessonTitle = view.findViewById(R.id.classTitle);
            holder.lessonVideoView = view.findViewById(R.id.classVideo);
            holder.watchLessonButton = view.findViewById(R.id.watchVideo);



            holder.lessonVideoView.setVideoPath("android://");


            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();

        }



        return view;
    }





}
