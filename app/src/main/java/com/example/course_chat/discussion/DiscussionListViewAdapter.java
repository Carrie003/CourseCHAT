package com.example.course_chat.discussion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.course_chat.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DiscussionListViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;
    private List<Discussion> discussionList;
    private ArrayList<Discussion> arraylist;
    //    public static Integer lessonID;
    private Map<Integer, Discussion> idDiscussionMap;
//    private Iterator iter;

//    private ArrayList<Integer> discussionIdCollection;





    public DiscussionListViewAdapter(Context context, Map<Integer, Discussion> idDiscussionMap) {
        mContext = context;

        this.idDiscussionMap = idDiscussionMap;
//        this.discussionList = discussionList;

        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<>();


        for(Integer id: idDiscussionMap.keySet()){

            discussionList.add(idDiscussionMap.get(id));
        }
        this.arraylist.addAll(discussionList);


        notifyDataSetChanged();




    }

    public class ViewHolder {


        TextView idLabel;
        TextView id;



        TextView topicLabel;
        EditText topic;

        TextView contentLabel;
        EditText content;

        ImageView thumbUpImage;
        TextView thumbUpValue;
        ImageView thumbDownImage;
        TextView thumbDownValue;

        TextView dateLabel;
        TextView date;
//
//        Button addButton;
//        Button submitButton;




    }

    @Override
    public int getCount() {
        return discussionList.size();
    }

    @Override
    public Discussion getItem(int position) {
        return discussionList.get(position);
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



            view = inflater.inflate(R.layout.activity_discussion_list_view_item_holder, null);


                holder.idLabel = view.findViewById(R.id.idLabel);
                holder.id = view.findViewById(R.id.id);
                holder.topicLabel = view.findViewById(R.id.topicLabel);
                holder.topic = view.findViewById(R.id.topic);
                holder.contentLabel =  view.findViewById(R.id.commentLabel);
                holder.content = view.findViewById(R.id.newComment);

                holder.thumbUpImage =  view.findViewById(R.id.thumbUpImage);
                holder.thumbUpValue = view.findViewById(R.id.thumbUpValue);
                holder.thumbDownImage = view.findViewById(R.id.thumbDownImage);
                holder.thumbDownValue = view.findViewById(R.id.thumbDownValue);


                Integer id = idDiscussionMap.keySet().iterator().next();
                holder.id.setText(id);
                holder.topic.setText(idDiscussionMap.get(id).getTopic());
                holder.content.setText(idDiscussionMap.get(id).getContent());
                holder.thumbUpImage.setImageResource(R.drawable.thumbsup);
                holder.thumbDownImage.setImageResource(R.drawable.thumbsdown);
                holder.thumbUpValue.setText(idDiscussionMap.get(id).getThumbUp());
                holder.thumbDownValue.setText(idDiscussionMap.get(id).getThumbDown());

//                holder.addButton = view.findViewById(R.id.addButton);
//                holder.submitButton = view.findViewById(R.id.submitButton);

            view.setTag(holder);

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




        holder.thumbUpImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                Integer originalValue = Integer.valueOf(holder.thumbUpValue.getText().toString());

                Integer newValue = ++originalValue;
                holder.thumbUpValue.setText(newValue);

                idDiscussionMap.get(holder.id).setThumbUp(newValue);







            }
        });

       holder.thumbDownImage.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {

               Integer originalValue = Integer.valueOf(holder.thumbDownValue.getText().toString());

               Integer newValue = ++originalValue;
               holder.thumbDownValue.setText(newValue);

               idDiscussionMap.get(holder.id).setThumbDown(newValue);




           }
       });





        return view;
    }






}
