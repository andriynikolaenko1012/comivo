package com.example.developer.comivo.activities.activities_for_messages;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.developer.comivo.BackendManager;
import com.example.developer.comivo.R;
import com.example.developer.comivo.ServerResponseParsing;
import com.example.developer.comivo.activities.activities_for_community.CommunityActivity;
import com.example.developer.comivo.activities.activities_for_reviews.ReviewsActivity;
import com.example.developer.comivo.activities.activities_for_sellers_acc.SellersAccActivity;
import com.example.developer.comivo.activities.activities_for_settings.SettingsActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class MessageActivity extends AppCompatActivity {

    public TextView message_tv, reviews_tv, community_tv, account_tv;
    public ImageView message_iv, reviews_iv, community_iv, account_iv;
    public LinearLayout layout_for_buttons_new, layout_for_reviews_button,
            layout_for_community_button, layout_for_account_button,
            layout_for_message_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_activity);


        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        tittle.setText(R.string.message);

        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_header_menu_icon);

        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);

        toolbar.getParent();
        toolbar.setContentInsetsAbsolute(0, 0);

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivity.this, MessageSearchActivity.class);
                startActivity(intent);
                finish();
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        BackendManager backendManager = BackendManager.getInstance();
        backendManager.getBusinessType().enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                ServerResponseParsing serverResponseParsing = ServerResponseParsing.getInstance();
                serverResponseParsing.parseBusinessType(response.body().string());

                Log.d("LOG", "Parsed string: status " + serverResponseParsing.getStatus() +
                        " data " + serverResponseParsing.getData() +
                        " message" + serverResponseParsing.getMessage());
            }
        });





        message_tv = (TextView) findViewById(R.id.message_tv);
        reviews_tv = (TextView) findViewById(R.id.reviews_tv);
        community_tv = (TextView) findViewById(R.id.community_tv);
        account_tv = (TextView) findViewById(R.id.account_tv);

        message_iv = (ImageView) findViewById(R.id.message_iv);
        reviews_iv = (ImageView) findViewById(R.id.reviews_iv);
        community_iv = (ImageView) findViewById(R.id.community_iv);
        account_iv = (ImageView) findViewById(R.id.account_iv);

        layout_for_buttons_new = (LinearLayout) findViewById(R.id.layout_for_buttons);
        layout_for_message_button = (LinearLayout) findViewById(R.id.layout_for_message_button);
        layout_for_reviews_button = (LinearLayout) findViewById(R.id.layout_for_reviews_button);
        layout_for_community_button = (LinearLayout) findViewById(R.id.layout_for_community_button);
        layout_for_account_button = (LinearLayout) findViewById(R.id.layout_for_account_button);


        layout_for_buttons_new.setPressed(true);


        message_tv.setTextColor(getResources().getColor(R.color.colorMain));
        message_iv.setImageResource(R.drawable.message_pressed_icon);

        layout_for_reviews_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_for_message_button.setPressed(false);
                layout_for_reviews_button.setPressed(true);
                layout_for_community_button.setPressed(false);
                layout_for_account_button.setPressed(false);

                message_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                reviews_tv.setTextColor(getResources().getColor(R.color.colorMain));
                community_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                account_tv.setTextColor(getResources().getColor(R.color.colorSecondary));

                message_iv.setImageResource(R.drawable.messages_icon);
                reviews_iv.setImageResource(R.drawable.reviews_pressed_icon);
                community_iv.setImageResource(R.drawable.community_icon);
                account_iv.setImageResource(R.drawable.account_icon);

                Intent intent = new Intent(MessageActivity.this, ReviewsActivity.class);
                startActivity(intent);
                finish();

            }
        });
        layout_for_community_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_for_message_button.setPressed(false);
                layout_for_reviews_button.setPressed(false);
                layout_for_community_button.setPressed(true);
                layout_for_account_button.setPressed(false);

                message_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                reviews_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                community_tv.setTextColor(getResources().getColor(R.color.colorMain));
                account_tv.setTextColor(getResources().getColor(R.color.colorSecondary));

                message_iv.setImageResource(R.drawable.messages_icon);
                reviews_iv.setImageResource(R.drawable.reviews_icon);
                community_iv.setImageResource(R.drawable.community_pressed_icon);
                account_iv.setImageResource(R.drawable.account_icon);

                Intent intent = new Intent(MessageActivity.this, CommunityActivity.class);
                startActivity(intent);
                finish();

            }
        });
        layout_for_account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_for_message_button.setPressed(false);
                layout_for_reviews_button.setPressed(false);
                layout_for_community_button.setPressed(false);
                layout_for_account_button.setPressed(true);

                message_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                reviews_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                community_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                account_tv.setTextColor(getResources().getColor(R.color.colorMain));

                message_iv.setImageResource(R.drawable.messages_icon);
                reviews_iv.setImageResource(R.drawable.reviews_icon);
                community_iv.setImageResource(R.drawable.community_icon);
                account_iv.setImageResource(R.drawable.accounts_pressed_icon);

                Intent intent2 = new Intent(MessageActivity.this, SellersAccActivity.class);
                startActivity(intent2);
                startActivity(intent2);


               /* SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                int type = sharedPreferences.getInt("USER_TYPE",-1);
                Log.d("acc","++++++++++++++++++++++++++++1111"+sharedPreferences);
                switch (type){
                    case 1:
                        Intent intent = new Intent(MessageActivity.this, BuyersAccActivity.class);
                        startActivity(intent);
                        Log.d("acc","++++++++++++++++++++++++++++"+type);
                        break;
                    case 2:
                        Intent intent2 = new Intent(MessageActivity.this, SellersAccActivity.class);
                        startActivity(intent2);
                        Log.d("acc","++++++++++++++++++++++++++++"+sharedPreferences);
                        break;
                }*/


            }
        });
        layout_for_message_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_for_message_button.setPressed(true);
                layout_for_reviews_button.setPressed(false);
                layout_for_community_button.setPressed(false);
                layout_for_account_button.setPressed(false);

                message_tv.setTextColor(getResources().getColor(R.color.colorMain));
                reviews_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                community_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                account_tv.setTextColor(getResources().getColor(R.color.colorSecondary));

                message_iv.setImageResource(R.drawable.message_pressed_icon);
                reviews_iv.setImageResource(R.drawable.reviews_icon);
                community_iv.setImageResource(R.drawable.community_icon);
                account_iv.setImageResource(R.drawable.account_icon);

            }
        });

        RelativeLayout chatWithComivo = (RelativeLayout) findViewById(R.id.comivo_layout);
        chatWithComivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivity.this, ChatWithCOMIVOActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout systemChat = (RelativeLayout) findViewById(R.id.holiday_layout);
        systemChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivity.this, BroadcastActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout directlyChat = (RelativeLayout) findViewById(R.id.thomas_huang_layout);
        directlyChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivity.this, MessageDirectlyActivity.class);
                startActivity(intent);
            }
        });


        RelativeLayout messageOffer2 = (RelativeLayout) findViewById(R.id.jim_kim_layout);
        messageOffer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivity.this, MessageOfferActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout messageOrder = (RelativeLayout) findViewById(R.id.tony_sit_layout);
        messageOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivity.this, MessageOrderActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout messageOffer = (RelativeLayout) findViewById(R.id.mishelle_taker_layout);
        messageOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivity.this, MessageOfferActivity.class);
                startActivity(intent);
            }
        });


        RelativeLayout messageReminding = (RelativeLayout) findViewById(R.id.reminding_layout);
        messageReminding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivity.this, MessageRemindingActivity.class);
                startActivity(intent);
            }
        });



        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        message_tv = (TextView) findViewById(R.id.message_tv);
        reviews_tv = (TextView) findViewById(R.id.reviews_tv);
        community_tv = (TextView) findViewById(R.id.community_tv);
        account_tv = (TextView) findViewById(R.id.account_tv);

        message_iv = (ImageView) findViewById(R.id.message_iv);
        reviews_iv = (ImageView) findViewById(R.id.reviews_iv);
        community_iv = (ImageView) findViewById(R.id.community_iv);
        account_iv = (ImageView) findViewById(R.id.account_iv);


    }



}
