package com.example.developer.comivo.activities.activities_for_buyers_acc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.developer.comivo.R;


public class QuoteDetailsActivity extends AppCompatActivity{

    public Button ignore_2, request_2, make_order_2;

    public TextView tv_react, textView134;

    public LinearLayout linear_react;

    public RelativeLayout relativeLayout111;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quote_details);
        initViews();
    }



    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText(R.string.quotes);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        ignore_2 = (Button) findViewById(R.id.ignore_2);
        request_2 = (Button) findViewById(R.id.request_2);
        make_order_2 = (Button) findViewById(R.id.make_order_2);

        tv_react = (TextView) findViewById(R.id.tv_react);
        textView134 = (TextView) findViewById(R.id.textView134);
        relativeLayout111 = (RelativeLayout) findViewById(R.id.relativeLayout111);
        linear_react = (LinearLayout) findViewById(R.id.linear_react);


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuoteDetailsActivity.this, QuoteActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ignore_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ignore_2.setBackgroundColor(getResources().getColor(R.color.colorBackground));
                ignore_2.setClickable(false);
                request_2.setBackgroundColor(getResources().getColor(R.color.colorBackground));
                request_2.setClickable(false);
                make_order_2.setBackgroundColor(getResources().getColor(R.color.colorBackground));
                make_order_2.setClickable(false);
                textView134.setVisibility(View.GONE);
                relativeLayout111.setVisibility(View.GONE);
                linear_react.setVisibility(View.VISIBLE);
            }
        });

        tv_react.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ignore_2.setBackgroundColor(getResources().getColor(R.color.colorMain));
                ignore_2.setClickable(true);
                request_2.setBackgroundColor(getResources().getColor(R.color.colorMain));
                request_2.setClickable(true);
                make_order_2.setBackgroundColor(getResources().getColor(R.color.colorMain));
                make_order_2.setClickable(true);
                textView134.setVisibility(View.INVISIBLE);
                relativeLayout111.setVisibility(View.INVISIBLE);
                linear_react.setVisibility(View.GONE);
            }
        });

        request_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ignore_2.setBackgroundColor(getResources().getColor(R.color.colorBackground));
                ignore_2.setClickable(false);
                make_order_2.setBackgroundColor(getResources().getColor(R.color.colorBackground));
                make_order_2.setClickable(false);
                request_2.setBackgroundColor(getResources().getColor(R.color.orange_color));
                request_2.setText("71:59:34");
                request_2.setClickable(false);
            }
        });


    }
}
