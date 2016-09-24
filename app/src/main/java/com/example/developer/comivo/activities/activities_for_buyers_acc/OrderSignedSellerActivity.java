package com.example.developer.comivo.activities.activities_for_buyers_acc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivityNew;
import com.example.developer.comivo.activities.activities_for_messages.MessageOrderDetailActivity;


public class OrderSignedSellerActivity extends AppCompatActivity{


    public ImageView image_1, image_2, arrow_2, arrow_3, arrow_4;

    public LinearLayout layout_for_signed_2, layout_for_process_2, layout_for_closed_2;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_signed_seller);
        initViews();
    }



    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText("ORDER");
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        image_1 = (ImageView) findViewById(R.id.image_1);
        image_2 = (ImageView) findViewById(R.id.image_2);
        arrow_2 = (ImageView) findViewById(R.id.arrow_2);
        arrow_3 = (ImageView) findViewById(R.id.arrow_3);
        arrow_4 = (ImageView) findViewById(R.id.arrow_4);

        layout_for_signed_2 = (LinearLayout) findViewById(R.id.layout_for_signed_2);
        layout_for_process_2 = (LinearLayout) findViewById(R.id.layout_for_process_2);
        layout_for_closed_2 = (LinearLayout) findViewById(R.id.layout_for_closed_2);

        image_2.setVisibility(View.INVISIBLE);


        layout_for_process_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrow_3.setVisibility(View.VISIBLE);
                layout_for_process_2.setBackgroundColor(getResources().getColor(R.color.green_color));
            }
        });

        layout_for_closed_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrow_4.setVisibility(View.VISIBLE);
                layout_for_closed_2.setBackgroundColor(getResources().getColor(R.color.green_color));
                image_2.setVisibility(View.VISIBLE);
                image_2.setImageResource(R.drawable.test_16_icon);
            }
        });

        image_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderSignedSellerActivity.this, MessageOrderDetailActivity.class);
                startActivity(intent);
                finish();
            }
        });


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderSignedSellerActivity.this, MessageActivityNew.class);
                startActivity(intent);
                finish();
            }
        });

        image_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderSignedSellerActivity.this, MessageActivityNew.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
