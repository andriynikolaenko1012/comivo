package com.example.developer.comivo.activities.activities_for_reviews;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivityNew;

public class NotVerifiedCompanyActivity extends AppCompatActivity{

    public RelativeLayout rel1;
    public LinearLayout write, claim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.not_verified_company);
        initViews();
    }


    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText(R.string.america);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        rel1 = (RelativeLayout) findViewById(R.id.rel1);
        claim = (LinearLayout) findViewById(R.id.claim_layout);
        write = (LinearLayout) findViewById(R.id.write_review_layout);


        rel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotVerifiedCompanyActivity.this, ForCommentsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotVerifiedCompanyActivity.this, WriteReviewActivity.class);
                startActivity(intent);
                finish();
            }
        });

        claim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotVerifiedCompanyActivity.this, ClaimActivity.class);
                startActivity(intent);
                finish();
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotVerifiedCompanyActivity.this, MessageActivityNew.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
