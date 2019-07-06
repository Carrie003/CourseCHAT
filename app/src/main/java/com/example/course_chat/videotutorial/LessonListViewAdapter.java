package com.example.course_chat.videotutorial;

import android.content.Context;
import android.content.Intent;
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



    private Context mContext;
    private LayoutInflater inflater;
    public static List<Lesson> emptyLessonList;
    private ArrayList<Lesson> arraylist;
    public static Integer lessonID;





    public LessonListViewAdapter(Context context, List<Lesson> emptyClassList) {
        mContext = context;

        this.emptyLessonList = emptyClassList;

        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(emptyLessonList);



    }

    public class ViewHolder {
        TextView idLabel;
        TextView lessonID;
        TextView titleLabel;
        TextView lessonTitle;
        VideoView lessonVideoView;
        Button watchLessonButton;
        TextView dateLabel;
        TextView dateCreated;



    }

    @Override
    public int getCount() {
        return emptyLessonList.size();
    }

    @Override
    public Lesson getItem(int position) {
        return emptyLessonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;


        if (view == null) {
            holder = new ViewHolder();

            view = inflater.inflate(R.layout.activity_lesson_list_view_item_holder, null);
            holder.idLabel = view.findViewById(R.id.idLabel);
            holder.lessonID = view.findViewById(R.id.lessonID);
            holder.titleLabel = view.findViewById(R.id.titleLabel);
            holder.lessonTitle = view.findViewById(R.id.lessonTitle);
            holder.lessonVideoView = view.findViewById(R.id.lessonVideo);
            holder.watchLessonButton = view.findViewById(R.id.watchVideo);
            holder.dateLabel = view.findViewById(R.id.dateLabel);
            holder.dateCreated = view.findViewById(R.id.dateCreated);

//            holder.lessonVideoView.setVideoURI();



                holder.watchLessonButton.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        lessonID = Integer.parseInt(holder.lessonID.getText().toString());
                        Intent watchLessonIntent = new Intent(mContext.getApplicationContext(),WatchLesson.class);
                        mContext.startActivity(watchLessonIntent);

                    }
                });


            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();

        }





        return view;
    }

    public void filter(){

    }





}
