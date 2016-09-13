package com.example.developer.comivo.activities.activities_for_community;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivity;


public class ChemicalCommentsActivity extends AppCompatActivity {

    public TextView text_389, text_390, text_391, text_392, text_393, text_394, likes_2;

    public LinearLayout question_selected_13, answer_selected_13;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemical_comments);
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


        text_389 = (TextView) findViewById(R.id.text_389);
        text_390 = (TextView) findViewById(R.id.text_390);
        text_391 = (TextView) findViewById(R.id.text_391);
        text_392 = (TextView) findViewById(R.id.text_392);
        text_393 = (TextView) findViewById(R.id.text_393);
        text_394 = (TextView) findViewById(R.id.text_394);
        likes_2 = (TextView) findViewById(R.id.likes_2);
        question_selected_13 = (LinearLayout) findViewById(R.id.question_selected_13);
        answer_selected_13 = (LinearLayout) findViewById(R.id.answer_selected_13);


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalCommentsActivity.this, CommunityActivity.class);
                startActivity(intent);
                finish();
            }
        });


        question_selected_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalCommentsActivity.this, ChemicalQuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });

        answer_selected_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalCommentsActivity.this, ChemicalAnswerActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
