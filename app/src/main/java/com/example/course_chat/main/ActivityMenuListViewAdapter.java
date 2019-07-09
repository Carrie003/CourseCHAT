package com.example.course_chat.main;

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

import com.example.course_chat.R;
import com.example.course_chat.discussion.Discussion;
import com.example.course_chat.discussion.DiscussionListViewAdapter;
import com.example.course_chat.discussion.ViewDiscussion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActivityMenuListViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;

    private List<String> activityList, arraylist;


    //    public static Integer lessonID;
    private Map<Integer, Discussion> idDiscussionMap;
    public static Integer currentId;
//    private Iterator iter;

//    private ArrayList<Integer> discussionIdCollection;





    public ActivityMenuListViewAdapter(Context context, List<String> activityList) {
        mContext = context;

//        this.idDiscussionMap = idDiscussionMap;
//        this.discussionList = discussionList;

        inflater = LayoutInflater.from(mContext);
        this.activityList = activityList;
        this.arraylist = new ArrayList<>();


//        for(Integer id: idDiscussionMap.keySet()){
//
//            discussionList.add(idDiscussionMap.get(id));
//        }
        this.arraylist.addAll(activityList);


        notifyDataSetChanged();




    }

    public class ViewHolder {

        ImageView acitivitySymbol;
        TextView activity;
        ImageView rightArrow;

//        TextView idLabel;
//        TextView id;
//
//
//
//        TextView topicLabel;
//        EditText topic;
//
//        TextView contentLabel;
//        EditText content;
//
//        ImageView thumbUpImage;
//        TextView thumbUpValue;
//        ImageView thumbDownImage;
//        TextView thumbDownValue;
//
//        TextView dateLabel;
//        TextView date;
//
//        Button viewDiscussionButton;

//
//        Button addButton;
//        Button submitButton;




    }

    @Override
    public int getCount() {
        return activityList.size();
    }

    @Override
    public String  getItem(int position) {
        return activityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;


        if (view == null) {
            holder = new ViewHolder();



            view = inflater.inflate(R.layout.activity_menu_list_view_item_holder, null);


            holder.acitivitySymbol = view.findViewById(R.id.activitySymbol);
            holder.activity = view.findViewById(R.id.activity);
            holder.rightArrow = view.findViewById(R.id.rightArrow);

            holder.activity.setText(activityList.get(position));



            view.setTag(holder);


            holder.activity.setText(arraylist.get(position));

        } else {
            holder = (ViewHolder) view.getTag();

        }

//       holder.submitButton.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View viewIn) {
//               try {
//
//                   String newTitle = holder.topic.getText().toString();
//                   String newContent = holder.content.getText().toString();
//                   vocabNameCollection.add(newVocabName);
//                   temporaryVocabNameList.add(newVocabName);
//                   vocabMeaningCollection.add(newMeaning);
//                   temporaryVocabMeaningList.add(newMeaning);
//
//
//               } catch (Exception except) {
//                   Log.e("hi","Some thing wrong happened, try again ");
//               }
//           }
//       });
















        return view;
    }
}
