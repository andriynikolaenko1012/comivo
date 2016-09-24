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
import com.example.developer.comivo.activities.activities_for_messages.MessageActivityNew;


public class ChemicalAnswerActivity extends AppCompatActivity {

    public LinearLayout post_selected_7, question_selected_7, layout_comments9;
    public TextView tv_999;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemical_answer);
        initViews();
    }


    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText("answer post");
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        post_selected_7 = (LinearLayout) findViewById(R.id.post_selected_7);
        question_selected_7 = (LinearLayout) findViewById(R.id.question_selected_7);
        layout_comments9 = (LinearLayout) findViewById(R.id.layout_comments9);
        tv_999 = (TextView) findViewById(R.id.tv_999);

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalAnswerActivity.this, MessageActivityNew.class);
                startActivity(intent);
                finish();
            }
        });

        post_selected_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalAnswerActivity.this, ChemicalPostActivity.class);
                startActivity(intent);
                finish();
            }
        });

        question_selected_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalAnswerActivity.this, ChemicalQuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });

        layout_comments9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalAnswerActivity.this, ChemicalAnswerCommentsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tv_999.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalAnswerActivity.this, ChemicalAnswerDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
