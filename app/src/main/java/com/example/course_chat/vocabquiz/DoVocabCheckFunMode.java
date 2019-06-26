package com.example.course_chat.vocabquiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.*;
import android.widget.TextView;
import android.widget.Toast;

import com.example.course_chat.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DoVocabCheckFunMode extends AppCompatActivity {



    ArrayList<String> vocabNames;
    ArrayList<String> vocabMeanings;
    ArrayList<String> mixedVocabMeanings;
    ArrayList<Integer> randomIntegers;
    ArrayList<Integer> colorList;
    Map<String, Integer> nameIndexMap;
    Map<String, Integer> meaningIndexMap;
    String vocabNameText, vocabMeaningText;
    Button temporaryVocabNameBtn;
    int bgColor;


    public DoVocabCheckFunMode(){

        vocabNames = new ArrayList<>();
        vocabMeanings =new ArrayList<>();
        mixedVocabMeanings = new ArrayList<>();
        randomIntegers = new ArrayList<>();
        colorList = new ArrayList<>();
        nameIndexMap =  new HashMap<>();
        meaningIndexMap =  new HashMap<>();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_do_vocab_check);
        setUpVocabNameList();
        setUpVocabMeaningList();
        setUpColorList();
        setUpMaps();
        setUpMixedMeaningList();
        initializeUI();
    }


    public void setUpVocabNameList(){
//        vocabNames = new ArrayList<>();
        vocabNames.add("apple");
        vocabNames.add("banana");
        vocabNames.add("pear");

    }
    public void setUpVocabMeaningList(){
        vocabMeanings.add("red fruit");
        vocabMeanings.add("yellow fruit");
        vocabMeanings.add("golden fruit");
    }

    public void setUpColorList(){
        colorList.add(Color.parseColor("#FDEBD0"));
        colorList.add(Color.parseColor("#FCF3CF"));
        colorList.add(Color.parseColor("#D5F5E3"));
        colorList.add(Color.parseColor("#D4E6F1"));
        colorList.add(Color.parseColor("#FADBD8"));
        colorList.add(Color.parseColor("#E8DAEF"));
    }
    public void setUpMaps(){
        for(int i = 0; i<vocabNames.size(); i++){
            nameIndexMap.put(vocabNames.get(i),i);
            meaningIndexMap.put(vocabMeanings.get(i), i);

        }

    }



    public void setUpMixedMeaningList(){
        for(int i=0 ; i<vocabMeanings.size(); i++){

            Random ran = new Random();
            Integer randInt = ran.nextInt(vocabMeanings.size());

            while(randomIntegers.contains(randInt)){
                randInt = ran.nextInt(vocabMeanings.size());
            }
            randomIntegers.add(randInt);
            Log.i("hi", randInt.toString());
            mixedVocabMeanings.add(vocabMeanings.get(randInt));

        }
    }

    public void initializeUI(){
        for (int i= 0; i<vocabNames.size(); i++){
            RelativeLayout layout = new RelativeLayout(this);
            RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

            RelativeLayout rl =  findViewById(R.id.rl);

//            Display display = getWindowManager().getDefaultDisplay();
//            Point size = new Point();
//            display.getSize(size);
//            int width = size.x;
//            int height = size.y;

            final Button vocabName = new Button(this);
            final TextView vocabMeaning = new TextView(this);

            vocabName.setBackgroundColor(Color.parseColor("#ffffff"));
            vocabName.setTextSize(20);
//            vocabName.setGravity(200);
            vocabMeaning.setTextSize(20);

            vocabName.setWidth(LayoutParams.WRAP_CONTENT);
            vocabMeaning.setWidth(LayoutParams.WRAP_CONTENT);
            vocabName.setHeight(LayoutParams.WRAP_CONTENT);
            vocabMeaning.setHeight(LayoutParams.WRAP_CONTENT);

            float positionY = vocabName.getY();
            float vocabNamePositionX = vocabName.getX();
            final float vocabMeaningPositionX = vocabNamePositionX+500;
            positionY+=200*i;
            vocabName.setLayoutParams(relativeParams);
            vocabMeaning.setLayoutParams(relativeParams);
            vocabName.setText(vocabNames.get(i));
            vocabMeaning.setText(mixedVocabMeanings.get(i));
            vocabName.setY(positionY);
            vocabMeaning.setX(vocabMeaningPositionX);
            vocabMeaning.setY(positionY);
            rl.addView(vocabName);
            rl.addView(vocabMeaning);


            vocabName.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    vocabNameText = vocabName.getText().toString();
                    temporaryVocabNameBtn = vocabName;
                    Random ran = new Random();
                    int randomColorIndex = ran.nextInt(6);
                    while(colorList.get(randomColorIndex) == bgColor){
                        randomColorIndex = ran.nextInt(6);
                    }
                    vocabName.setBackgroundColor(colorList.get(randomColorIndex));
                    bgColor = colorList.get(randomColorIndex);

                }
            });
            vocabMeaning.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    vocabMeaningText = vocabMeaning.getText().toString();
                    vocabMeaning.setBackgroundColor(bgColor);
                    if(nameIndexMap.get(vocabNameText) == meaningIndexMap.get(vocabMeaningText)){
                        vocabMeaning.animate().alpha(0);
                        temporaryVocabNameBtn.animate().alpha(0);

                    }
                    else{
                        temporaryVocabNameBtn.setBackgroundColor(Color.parseColor("#ffffff"));
                        vocabMeaning.setBackgroundColor(Color.parseColor("#ffffff"));
                         Toast.makeText(DoVocabCheckFunMode.this,"The answer is not right, please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }

    }
















}
