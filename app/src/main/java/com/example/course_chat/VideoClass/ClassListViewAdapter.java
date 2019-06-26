package com.example.course_chat.VideoClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.course_chat.R;
import com.example.course_chat.VocabCheck.Vocabulary;

import java.util.ArrayList;
import java.util.List;

public class ClassListViewAdapter extends BaseAdapter {



    Context mContext;
    LayoutInflater inflater;
    public static List<Vocabulary> emptyClassList;
    private ArrayList<Vocabulary> arraylist;

    public ClassListViewAdapter(Context context, List<Vocabulary> emptyClassList) {
        mContext = context;

        this.emptyClassList = emptyClassList;

        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(ClassListViewAdapter.emptyClassList);


    }

    public class ViewHolder {
        TextView classTitle;
        VideoView classVideoView;
        Button watchVideoButton;


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
            holder.classTitle = view.findViewById(R.id.classTitle);
            holder.classVideoView = view.findViewById(R.id.classVideo);
            holder.watchVideoButton = view.findViewById(R.id.watchVideo);


//            holder.classVideoView.setVideoPath();


            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }



        return view;
    }





}
