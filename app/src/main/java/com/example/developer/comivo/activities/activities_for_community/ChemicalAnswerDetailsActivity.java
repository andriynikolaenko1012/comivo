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


public class ChemicalAnswerDetailsActivity extends AppCompatActivity {

    public LinearLayout question_selected_12, post_selected_12, layout_comments_12;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemical_answer_details);
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


        question_selected_12 = (LinearLayout) findViewById(R.id.question_selected_12);
        post_selected_12 = (LinearLayout) findViewById(R.id.post_selected_12);
        layout_comments_12 = (LinearLayout) findViewById(R.id.layout_comments_12);

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalAnswerDetailsActivity.this, MessageActivityNew.class);
                startActivity(intent);
                finish();
            }
        });


        question_selected_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalAnswerDetailsActivity.this, ChemicalQuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });

        post_selected_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalAnswerDetailsActivity.this, ChemicalPostActivity.class);
                startActivity(intent);
                finish();
            }
        });

        layout_comments_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalAnswerDetailsActivity.this, ChemicalAnswerCommentsActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
