package com.example.developer.comivo.activities.activities_for_settings;

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
import android.widget.Toast;

import com.example.developer.comivo.R;

public class SocialActivity extends AppCompatActivity{

    public LinearLayout facebook_layout, linkedin_layout, twitter_layout,
            google_layout, instagram_layout, pinterest_layout,
            tumblr_layout, wechat_layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_activity);
        initViews();
    }


    private void initViews(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);

        tittle.setText(R.string.social_media);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        toolbar.getParent();
        toolbar.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        facebook_layout = (LinearLayout) findViewById(R.id.facebook_layout);
        linkedin_layout = (LinearLayout) findViewById(R.id.linkedin_layout);
        twitter_layout = (LinearLayout) findViewById(R.id.twitter_layout);
        google_layout = (LinearLayout) findViewById(R.id.google_layout);
        instagram_layout = (LinearLayout) findViewById(R.id.instagram_layout);
        pinterest_layout = (LinearLayout) findViewById(R.id.pinterest_layout);
        tumblr_layout = (LinearLayout) findViewById(R.id.tumblr_layout);
        wechat_layout = (LinearLayout) findViewById(R.id.wechat_layout);

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SocialActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

    }

}
