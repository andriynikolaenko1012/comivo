package com.example.developer.comivo.activities.activities_for_community;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivityNew;


public class ChemicalSelectedActivity extends AppCompatActivity {

    public TextView textView389, textView390, textView391, textView392, textView393, textView394;

    public LinearLayout post_selected, quest_selected, answ_selected;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemical_selected);
        initViews();
    }


    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText("Benzoic acid");
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        textView389 = (TextView) findViewById(R.id.textView389);
        textView390 = (TextView) findViewById(R.id.textView390);
        textView391 = (TextView) findViewById(R.id.textView391);
        textView392 = (TextView) findViewById(R.id.textView392);
        textView393 = (TextView) findViewById(R.id.textView393);
        textView394 = (TextView) findViewById(R.id.textView394);

        post_selected = (LinearLayout) findViewById(R.id.post_selected);
        quest_selected = (LinearLayout) findViewById(R.id.question_selected);
        answ_selected = (LinearLayout) findViewById(R.id.answer_selected);


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalSelectedActivity.this, MessageActivityNew.class);
                startActivity(intent);
                finish();
            }
        });

        post_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalSelectedActivity.this, ChemicalPostActivity.class);
                startActivity(intent);
                finish();
            }
        });

        quest_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalSelectedActivity.this, ChemicalQuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });

        answ_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalSelectedActivity.this, ChemicalAnswerActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
