package com.example.developer.comivo.activities.activities_for_settings;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.comivo.R;


public class ExperienceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.experience_activity);
        initViews();
    }

    private void initViews(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        ImageView addExp = (ImageView) findViewById(R.id.btn_add);
        ImageView addExp2 = (ImageView) findViewById(R.id.exp_add);
        ImageView deleteExp = (ImageView) findViewById(R.id.btn_delete);

        tittle.setText(R.string.experience);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExperienceActivity.this, MyProfileActivity.class);
                startActivity(intent);
            }
        });

        addExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExperienceActivity.this, EditExperienceActivity.class);
                startActivity(intent);
            }
        });
        addExp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExperienceActivity.this, EditExperienceActivity.class);
                startActivity(intent);
            }
        });
        deleteExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = LayoutInflater.from(ExperienceActivity.this);
                View layout = inflater.inflate(R.layout.delete_educ_dialog, null);
                AlertDialog MyDialog;
                AlertDialog.Builder MyBuilder = new AlertDialog.Builder(ExperienceActivity.this);
                MyBuilder.setView(layout);
                MyDialog = MyBuilder.create();
                MyDialog.getWindow().setLayout(400, 300);
                MyDialog.show();
            }
        });
    }
}
