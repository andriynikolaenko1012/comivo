package com.example.developer.comivo.activities.activities_for_sellers_acc;

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
import com.example.developer.comivo.activities.activities_for_messages.MessageActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageOrderDetailActivity;

public class OrderProcessingActivity extends AppCompatActivity{

    public ImageView iv_888, iv_999;

    public TextView tv_click_here, text_closed;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_processing);
        initViews();
    }

    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText(R.string.orders);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        iv_888 = (ImageView) findViewById(R.id.iv_888);
        iv_999 = (ImageView) findViewById(R.id.iv_999);
        tv_click_here = (TextView) findViewById(R.id.tv_click_here);
        text_closed = (TextView) findViewById(R.id.text_closed);

        tv_click_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_999.setVisibility(View.VISIBLE);
                text_closed.setBackgroundColor(getResources().getColor(R.color.green_color));
            }
        });


        iv_888.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderProcessingActivity.this, SellersAccActivity.class);
                startActivity(intent);
                finish();
            }
        });

        iv_999.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderProcessingActivity.this, MessageOrderDetailActivity.class);
                startActivity(intent);
                finish();
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderProcessingActivity.this, SellersAccActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
