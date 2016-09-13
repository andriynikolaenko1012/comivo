package com.example.developer.comivo.activities.activities_for_messages;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.comivo.R;


public class MessageRemindingActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_reminding_activity);
        initViews();


    }


    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText(R.string.quote_benzoic);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        ImageView sendMess = (ImageView) findViewById(R.id.send_mess);

        final ImageView offer1 = (ImageView) findViewById(R.id.offer1);
        final ImageView offer2 = (ImageView) findViewById(R.id.offer2);
        final ImageView offer3 = (ImageView) findViewById(R.id.offer3);


        offer1.setImageResource(R.drawable.ic_online_status);
        offer2.setImageResource(R.drawable.ic_offline_status);
        offer3.setImageResource(R.drawable.ic_offline_status);

        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        sendMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MessageRemindingActivity.this, R.string.options_in, Toast.LENGTH_SHORT).show();
            }
        });


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageRemindingActivity.this, MessageActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
