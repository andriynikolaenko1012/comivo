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


public class MessageOfferDetailsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_offer_details_activity);
        initViews();


    }


    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText(R.string.quote_benzoic);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);

        final ImageView offer1 = (ImageView) findViewById(R.id.offer1);
        final ImageView offer2 = (ImageView) findViewById(R.id.offer2);
        final ImageView offer3 = (ImageView) findViewById(R.id.offer3);
        ImageView imageInfo = (ImageView) findViewById(R.id.iv_info);


        imageInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MessageOfferDetailsActivity.this, R.string.options_in, Toast.LENGTH_SHORT).show();
            }
        });

        offer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offer1.setImageResource(R.drawable.ic_online_status);
                offer2.setImageResource(R.drawable.ic_offline_status);
                offer3.setImageResource(R.drawable.ic_offline_status);

                offer1.setClickable(false);
                offer2.setClickable(true);
                offer3.setClickable(true);
                            }
        });

        offer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageOfferDetailsActivity.this, MessageOfferActivity.class);
                startActivity(intent);
                finish();
            }
        });

        offer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageOfferDetailsActivity.this, MessageOfferActivity.class);
                startActivity(intent);
                finish();
            }
        });

        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageOfferDetailsActivity.this, MessageOfferActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
