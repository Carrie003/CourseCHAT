package com.example.course_chat.vocabquiz;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.course_chat.R;

import java.util.ArrayList;
import java.util.List;

public class VocabCheckListViewAdapter extends BaseAdapter {


    Context mContext;
    LayoutInflater inflater;
    public static List<Vocabulary> emptyVocabularyList;
    public static ArrayList<String> vocabNameCollection, temporaryVocabNameList, vocabMeaningCollection, temporaryVocabMeaningList;
    public static int VocabCheckID;
    private ArrayList<Vocabulary> arraylist;

    public VocabCheckListViewAdapter(Context context, List<Vocabulary> emptyVocabularyList) {
        mContext = context;

        this.emptyVocabularyList = emptyVocabularyList;

        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(emptyVocabularyList);
        vocabNameCollection = new ArrayList<>();
        temporaryVocabNameList = new ArrayList<>();
        vocabMeaningCollection = new ArrayList<>();
        temporaryVocabMeaningList = new ArrayList<>();
        VocabCheckID = 0;

    }

    public class ViewHolder {
        TextView vocabLabel;
        TextView meaningLabel;
        EditText vocab;
        EditText meaning;
        Button submitButton;
        Button addButton;

//        TextView description;

    }

    @Override
    public int getCount() {
        return emptyVocabularyList.size();
    }

    @Override
    public Vocabulary getItem(int position) {
        return emptyVocabularyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;


        if (view == null) {
            holder = new ViewHolder();


            view = inflater.inflate(R.layout.activity_vocab_check_item_holder, null);

            holder.vocabLabel = view.findViewById(R.id.vocabLabel);
            holder.meaningLabel= view.findViewById(R.id.meaningLabel);
            holder.vocab = view.findViewById(R.id.vocab);
            holder.meaning = view.findViewById(R.id.meaning);
            holder.submitButton = view.findViewById(R.id.submitButton);
            holder.addButton = view.findViewById(R.id.addButton);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }


        holder.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewIn) {
                try {

                    String newVocabName = holder.vocab.getText().toString();
                    String newMeaning = holder.meaning.getText().toString();
                    vocabNameCollection.add(newVocabName);
                    temporaryVocabNameList.add(newVocabName);
                    vocabMeaningCollection.add(newMeaning);
                    temporaryVocabMeaningList.add(newMeaning);


                } catch (Exception except) {
                    Log.e("hi","Some thing wrong happened, try again ");
                }
            }
        });

        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewIn) {
                try {

                    emptyVocabularyList.add(new Vocabulary("", ""));
                    notifyDataSetChanged();


                } catch (Exception except) {
                    Log.e("hi","Some thing wrong happened, try again ");
                }
            }
        });
//
        return view;
    }


    public static void setTemporaryVocabNameList(ArrayList<String> newTemporaryVocabNameList){
        temporaryVocabNameList = newTemporaryVocabNameList;
    }

    public static void setTemporaryVocabMeaningList(ArrayList<String> newTemporaryVocabMeaningList){
        temporaryVocabMeaningList = newTemporaryVocabMeaningList;
    }

}
