package com.example.course_chat.quiz;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.course_chat.R;

import java.util.ArrayList;
import java.util.List;

public class QuizListViewAdapter extends BaseAdapter {


        Context mContext;
        LayoutInflater inflater;
        private List<Quiz> quizList;
        private ArrayList<Quiz> arraylist;
        private int IDclicked;

        private int thumbsUp, thumbsDown;
        public int  currentPosition;
        private ViewHolder currentHolder;




        public QuizListViewAdapter(Context context, List<Quiz> quizList) {
            mContext = context;
            this.quizList = quizList;
            inflater = LayoutInflater.from(mContext);
            this.arraylist = new ArrayList<>();
            this.arraylist.addAll(quizList);
        }

        public class ViewHolder {
            TextView title;
            TextView description;
            TextView date;
            ImageView thumbsUp;
            TextView thumbsUpValue;
            TextView space, space2;
            ImageView thumbsDown;
            TextView thumbsDownValue;
            TextView dateLabel;
//            TextView ID;
//            Button doQuizButton;

        }

        @Override
        public int getCount() {
            return quizList.size();
        }

        @Override
        public Quiz getItem(int position) {
            return quizList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View view, ViewGroup parent) {
            final ViewHolder holder;
            if (view == null) {
                holder = new ViewHolder();
                view = inflater.inflate(R.layout.activity_quiz_list_view_item_holder, null);
                holder.title =  view.findViewById(R.id.title);
                holder.description =  view.findViewById(R.id.description);
                holder.date = view.findViewById(R.id.date);
                holder.thumbsUp = view.findViewById(R.id.thumbsUp);
                holder.thumbsUpValue = view.findViewById(R.id.thumbsUpValue);
                holder.space = view.findViewById(R.id.space);
                holder.thumbsDown = view.findViewById(R.id.thumbsDown);
                holder.thumbsDownValue = view.findViewById(R.id.thumbsDownValue);
                holder.space2= view.findViewById(R.id.space2);
                holder.dateLabel= view.findViewById(R.id.dateLabel);
//                holder.doQuizButton = view.findViewById(R.id.doQuizButton);

                holder.date.setText(quizList.get(position).getDateCreated());
                holder.thumbsUp.setImageResource(R.drawable.thumbup);
                holder.thumbsDown.setImageResource(R.drawable.thumbdown);
                holder.description.setText(quizList.get(position).getDescription());
                holder.thumbsUpValue.setText(quizList.get(position).getThumbUp().toString());
                holder.thumbsDownValue.setText(quizList.get(position).getThumbDown().toString());
                holder.thumbsUp.getLayoutParams().height = 50;
                holder.thumbsUp.getLayoutParams().width  = 50;
                holder.thumbsDown.getLayoutParams().height = 50;
                holder.thumbsDown.getLayoutParams().width  = 50;

                currentPosition = position;
                currentHolder = holder;

                view.setTag(holder);

                holder.thumbsUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View viewIn) {
                        try {

                            Log.i("hi", "thumbs up clicked");
                            thumbsUp = quizList.get(currentPosition).getThumbUp();
                            quizList.get(currentPosition).setThumbUp(++thumbsUp);
                            Log.i("hi",quizList.get(currentPosition).getThumbUp().toString());

                            currentHolder.thumbsUpValue.setText(quizList.get(currentPosition).getThumbUp().toString());

                        } catch (Exception except) {
                            Log.e("hi","Ooops GMAIL account selection problem "+except.getMessage());
                        }
                    }
                });



                holder.thumbsDown.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View viewIn) {
                        try {

                            Log.i("hi", "thumbs down clicked");
                            thumbsDown = quizList.get(currentPosition).getThumbDown();
                            quizList.get(currentPosition).setThumbDown(++thumbsDown);
                            Log.i("hi",quizList.get(currentPosition).getThumbDown().toString());
                            currentHolder.thumbsDownValue.setText(quizList.get(currentPosition).getThumbDown().toString());


                        } catch (Exception except) {
                            Log.e("hi","Ooops GMAIL account selection problem "+except.getMessage());
                        }
                    }
                });

            } else {
                holder = (ViewHolder) view.getTag();
            }
//            holder.title.setText(quizList.get(position).get);








//            holder.doQuizButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View viewIn) {
//                    try {
//
//
//
//                        Intent intent = new Intent(mContext.getApplicationContext(),DoQuiz.class);
//                        mContext.startActivity(intent);
//
//
//
//                    } catch (Exception except) {
//                        Log.e("hi","Ooops GMAIL account selection problem "+except.getMessage());
//                    }
//                }
//            });




//            holder.ID.setText();



            return view;
        }



    }


