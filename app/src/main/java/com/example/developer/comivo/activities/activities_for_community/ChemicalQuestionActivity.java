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


public class ChemicalQuestionActivity extends AppCompatActivity {

    public TextView text_389, text_390, text_391, text_392, text_393, text_394, likes_2;

    public LinearLayout comments_layout6, answer_layout6, post_selected_3, answer_selected_3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemical_question);
        initViews();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) ChemicalQuestionActivity.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }

        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(ChemicalQuestionActivity.this.getComponentName()));
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }

    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText("Benzoic acid");
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        text_389 = (TextView) findViewById(R.id.text_389);
        text_390 = (TextView) findViewById(R.id.text_390);
        text_391 = (TextView) findViewById(R.id.text_391);
        text_392 = (TextView) findViewById(R.id.text_392);
        text_393 = (TextView) findViewById(R.id.text_393);
        text_394 = (TextView) findViewById(R.id.text_394);
        likes_2 = (TextView) findViewById(R.id.likes_2);
        comments_layout6 = (LinearLayout) findViewById(R.id.comments_layout6);
        answer_layout6 = (LinearLayout) findViewById(R.id.answer_layout6);
        post_selected_3 = (LinearLayout) findViewById(R.id.post_selected_3);
        answer_selected_3 = (LinearLayout) findViewById(R.id.answer_selected_3);


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalQuestionActivity.this, CommunityActivity.class);
                startActivity(intent);
                finish();
            }
        });

        post_selected_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalQuestionActivity.this, ChemicalPostActivity.class);
                startActivity(intent);
                finish();
            }
        });

        answer_selected_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalQuestionActivity.this, ChemicalAnswerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        answer_layout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalQuestionActivity.this, QuestionWriteAnswerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        comments_layout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChemicalQuestionActivity.this, ChemicalQuestionsCommentsActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
