package com.example.developer.comivo.activities.activities_for_settings;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.comivo.R;
import com.example.developer.comivo.network.ServerResponseParsing;
import com.example.developer.comivo.network.settingsParsing.SettingsResponseParsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LanguageActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_activity);
        initViews();
    }

    private void initViews(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        ImageView addLan = (ImageView) findViewById(R.id.btn_add);
        ImageView addLan2 = (ImageView) findViewById(R.id.add_btn);
        ImageView deleteLan = (ImageView) findViewById(R.id.delete_btn);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);

        tittle.setText(R.string.language);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        toolbar.getParent();
        toolbar.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LanguageActivity.this, MyProfileActivity.class);
                startActivity(intent);
            }
        });

        addLan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LanguageActivity.this, EditLanguageActivity.class);
                startActivity(intent);
            }
        });
        addLan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LanguageActivity.this, EditLanguageActivity.class);
                startActivity(intent);
            }
        });
        deleteLan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = LayoutInflater.from(LanguageActivity.this);
                View layout = inflater.inflate(R.layout.delete_lang_dialog, null);
                ImageView close_img = (ImageView) layout.findViewById(R.id.close_img_2);
                final AlertDialog MyDialog;
                AlertDialog.Builder MyBuilder = new AlertDialog.Builder(LanguageActivity.this);
                MyBuilder.setView(layout);
                MyDialog = MyBuilder.create();
                close_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyDialog.cancel();

                    }
                });
                MyDialog.show();
            }
        });
    }



}
