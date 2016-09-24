package com.example.developer.comivo.activities.activities_for_sellers_acc;

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
import com.example.developer.comivo.activities.activities_for_messages.MessageActivityNew;


public class OpportunityDetailsActivity extends AppCompatActivity{

    public RelativeLayout relative_666;
    public TextView tv_666, tv_react2;
    public Button btn_ignore22, btn_request22;
    public LinearLayout linear_react2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opportunity_details);
        initViews();


    }


    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText(R.string.opportunities);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);

        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        relative_666 = (RelativeLayout) findViewById(R.id.relative_666);
        tv_666 = (TextView) findViewById(R.id.tv_666);
        btn_ignore22 = (Button) findViewById(R.id.btn_ignore22);
        btn_request22 = (Button) findViewById(R.id.btn_request22);
        linear_react2 = (LinearLayout) findViewById(R.id.linear_react2);
        tv_react2 = (TextView) findViewById(R.id.tv_react2);

        btn_ignore22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_request22.setClickable(false);
                relative_666.setVisibility(View.GONE);
                tv_666.setVisibility(View.GONE);
                btn_request22.setBackgroundColor(getResources().getColor(R.color.colorSecondary));
                btn_ignore22.setBackgroundColor(getResources().getColor(R.color.colorSecondary));

                linear_react2.setVisibility(View.VISIBLE);

            }
        });

        tv_react2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_request22.setClickable(false);
                relative_666.setVisibility(View.VISIBLE);
                tv_666.setVisibility(View.VISIBLE);
                btn_request22.setBackgroundColor(getResources().getColor(R.color.colorMain));
                btn_ignore22.setBackgroundColor(getResources().getColor(R.color.colorMain));

                linear_react2.setVisibility(View.GONE);
            }
        });

        btn_request22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpportunityDetailsActivity.this, OpportunityUpdateQuoteActivity.class);
                startActivity(intent);
                finish();
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpportunityDetailsActivity.this, MessageActivityNew.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
