package com.example.course_chat;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import android.view.View.OnClickListener;
public class QuizQuestionListViewAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
//    private List<AnimalNames> animalNamesList;
//    private ArrayList<AnimalNames> arraylist;
    public static  List<QuizQuestion> emptyQuizQuestionCollection;

    private ArrayList<QuizQuestion> quizQuestionCollection = new ArrayList<>();
    public static  ArrayList<String> quizQuestionStorage= new ArrayList<>();
    public static ArrayList<String> quizAnswerStorage= new ArrayList<>();
    private ArrayList<QuizQuestion> arraylist;
   public static  int QuizQuestionID = 0;

    public QuizQuestionListViewAdapter(Context context, List<QuizQuestion> quizQuestionList) {
        mContext = context;

        this.emptyQuizQuestionCollection = quizQuestionList;

        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(quizQuestionList);
    }

    public class ViewHolder {
        Spinner typeSpinner;
        TextView qLabel1;
        TextView ID;
        TextView qLabel2;
        EditText question;
        TextView aLabel;
        EditText answer;
        Button submitButton;
        Button addButton;
        ListView choices;
//        TextView description;

    }

    @Override
    public int getCount() {
        return emptyQuizQuestionCollection.size();
    }

    @Override
    public QuizQuestion getItem(int position) {
        return emptyQuizQuestionCollection.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;


        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.activity_quiz_question_list_view_item_holder, null);
            // Locate the TextViews in listview_item.xml
//            holder.title =  view.findViewById(R.id.title);
//            holder.description =  view.findViewById(R.id.description);
            holder.typeSpinner = view.findViewById(R.id.typeSpinner);
            holder.qLabel1 = view.findViewById(R.id.qLabel1);
            holder.qLabel2 = view.findViewById(R.id.qLabel2);
            holder.ID = view.findViewById(R.id.ID);
            holder.question = view.findViewById(R.id.question);
            holder.aLabel = view.findViewById(R.id.aLabel);
            holder.answer = view.findViewById(R.id.answer);
            holder.submitButton = view.findViewById(R.id.submitButton);
            holder.addButton = view.findViewById(R.id.addButton);


            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.ID.setText(String.valueOf(QuizQuestionID));
        holder.submitButton.setText("Submit");
        holder.addButton.setText("Add another question");


        holder.submitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View viewIn) {
                try {


                    quizQuestionCollection.add(new QuizQuestion(QuizQuestionID, "a", holder.question.getText().toString(), holder.answer.getText().toString(), null));
                    quizQuestionStorage.add(holder.question.getText().toString()); //TODO, if not work, do the listView.getItem(position) one
//                    holder.qLabel.setText("");
//                    holder.QuizQuestionID.setText("");

                    quizAnswerStorage.add(holder.answer.getText().toString());

                    Log.i("hi",holder.question.getText().toString());
                    Log.i("hi",holder.answer.getText().toString());


                    QuizQuestionID++;

                } catch (Exception except) {
                    Log.e("hi","Some thing wrong happened, try again ");
                }
            }
        });

        holder.addButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View viewIn) {
                try {

                    emptyQuizQuestionCollection.add(new QuizQuestion(QuizQuestionID, "a", "", "", null));
                    notifyDataSetChanged();
//                    QuizQuestionID++;
//                    holder.QuizQuestionID.setText(String.valueOf(QuizQuestionID));
//                    holder.question.setText("");
//                    holder.answer.setText("");
//                    holder.QuizQuestionID.setText("");




                } catch (Exception except) {
                    Log.e("hi","Some thing wrong happened, try again ");
                }
            }
        });
//
        return view;
    }

//    public List<QuizQuestion> getQuizQuestionStorage(){
//
//        return quizQuestionStorage;
//
//
//    }


    // Filter Class
//    public void filter(String charText) {
//        charText = charText.toLowerCase(Locale.getDefault());
//
//
//        emptyQuizQuestionCollection.clear();
//
//        if(charText.length()==0) {
//
//
//
//
//            emptyQuizQuestionCollection.addAll(arraylist);
//        }
////
//
//        else{
//
//
//
//            for (QuizQuestion wp : arraylist) {
//
//
//                if (wp.getAnimalName().toLowerCase(Locale.getDefault()).contains(charText) ) {
//                    emptyQuizQuestionCollection.add(wp);
////                    Log.i("LLLLLLL", String.valueOf(charText.length()));
//                }
//
//            }
////
//        }
//        notifyDataSetChanged();
//    }


//    public void add(){
////        i = i+1;
//////        i++;
////        k = String.valueOf(i);
//        emptyQuizQuestionCollection.add(new QuizQuestion());
//
//        notifyDataSetChanged();
//    }

}

