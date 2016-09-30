package com.example.developer.comivo.activities.activities_for_community;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivityNew;
import com.example.developer.comivo.adapters.ListViewAdapter;
import com.example.developer.comivo.models.CommentModel;

import java.util.ArrayList;


public class TimelineCommentsActivity extends AppCompatActivity {

    public ListView list;
    public LinearLayout share_button, reply_button, more_text;
    public ArrayList<CommentModel> comments = new ArrayList<>();
    public ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_comments);

        list = (ListView) findViewById(R.id.list_for_comments);
        listViewAdapter = new ListViewAdapter(this);
        list.setAdapter(listViewAdapter);

        initViews();
    }


    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText(R.string.timeline);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        share_button = (LinearLayout) findViewById(R.id.layout_share);
        /*reply_button = (LinearLayout) findViewById(R.id.layout_reply2);
        more_text = (LinearLayout) findViewById(R.id.more_text_timeline);*/

        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimelineCommentsActivity.this, ShareActivity.class);
                startActivity(intent);
                finish();
            }
        });

        reply_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimelineCommentsActivity.this, TimelineCommentsReplyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        more_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimelineCommentsActivity.this, TimelinePostDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimelineCommentsActivity.this, MessageActivityNew.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
