/*
package com.example.developer.comivo.activities.activities_for_messages;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_community.CommunitySearchActivity;
import com.example.developer.comivo.activities.activities_for_reviews.ReviewsSearchActivity;
import com.example.developer.comivo.activities.activities_for_settings.SettingsActivity;
import com.example.developer.comivo.adapters.MessageAdapter;
import com.example.developer.comivo.fragments.AccountBuyersFragment;
import com.example.developer.comivo.fragments.AccountSellersFragment;
import com.example.developer.comivo.fragments.CommunityFragment;
import com.example.developer.comivo.fragments.MessageFragment;
import com.example.developer.comivo.fragments.ReviewsFragment;
import com.example.developer.comivo.models.MessagesModel;
import com.example.developer.comivo.models.UserModel;

import java.util.ArrayList;
import java.util.List;


public class MessageActivityNew2 extends AppCompatActivity {

    public TextView message_tv, reviews_tv, community_tv, account_tv;
    public ImageView message_iv, reviews_iv, community_iv, account_iv;
    public LinearLayout layout_for_buttons_new, layout_for_reviews_button,
            layout_for_community_button, layout_for_account_button,
            layout_for_message_button;

    private List<MessagesModel> messagesModels = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_activity_new);

        final UserModel userModel = UserModel.getInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        final TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        tittle.setText(R.string.message);

        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_header_menu_icon);

        final ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);

        toolbar.getParent();
        toolbar.setContentInsetsAbsolute(0, 0);

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MessageActivityNew2.this, MessageSearchActivity.class);
                startActivity(intent);
                finish();

            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        recyclerView=(RecyclerView)findViewById(R.id.my_container);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);

        initializeData();
        initializeAdapter();



        */
/*FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.my_container, new MessageFragment());
        ft.addToBackStack(null);
        ft.commit();*//*



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

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.my_container, new ReviewsFragment());
                ft.addToBackStack(null);
                ft.commit();
                tittle.setText(R.string.reviews);

                rightButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(MessageActivityNew2.this, ReviewsSearchActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });

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

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.my_container, new CommunityFragment());
                ft.addToBackStack(null);
                ft.commit();
                tittle.setText(R.string.community);

                rightButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(MessageActivityNew2.this, CommunitySearchActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });

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


                int accountType = userModel.getAccountType();

                if (accountType == 1){

                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.my_container, new AccountBuyersFragment());
                    ft.addToBackStack(null);
                    ft.commit();

                } else if (accountType == 2) {

                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.my_container, new AccountSellersFragment());
                    ft.addToBackStack(null);
                    ft.commit();

                }

                tittle.setText(R.string.account);



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

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.my_container, new MessageFragment());
                ft.addToBackStack(null);
                ft.commit();

                tittle.setText(R.string.message);

                rightButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(MessageActivityNew2.this, MessageSearchActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });

            }
        });


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivityNew2.this, SettingsActivity.class);
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

    private void initializeData(){
        messagesModels = new ArrayList<>();
        messagesModels.add(new MessagesModel("Jim Kim", "ABC Chemical LLC", "9:38AM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                        "tempor incididunt ut labore et dolore magna aliqua...",
                R.drawable.ic_online_status, R.drawable.jim_img));

        messagesModels.add(new MessagesModel("Tony Sit", "SUNIVO AMERICA LLC", "9:38AM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                        "tempor incididunt ut labore et dolore magna aliqua...",
                R.drawable.ic_online_status, R.drawable.tony_img));

        messagesModels.add(new MessagesModel("Thomas Huang", "ABC Chemical LLC", "9:38AM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                        "tempor incididunt ut labore et dolore magna aliqua...",
                R.drawable.ic_offline_status, R.drawable.thomas_img));

        messagesModels.add(new MessagesModel("Michelle Tacker", "Dush International Chemical LLC", "9:38AM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                        "tempor incididunt ut labore et dolore magna aliqua...",
                R.drawable.ic_online_status, R.drawable.michelle_img));

        messagesModels.add(new MessagesModel("Reminding", "", "9:38AM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                        "tempor incididunt ut labore et dolore magna aliqua...",
                R.drawable.ic_online_status, R.drawable.reminding_img));

        messagesModels.add(new MessagesModel("Holiday", "", "9:38AM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                        "tempor incididunt ut labore et dolore magna aliqua...",
                R.drawable.ic_online_status, R.drawable.holiday_img));

        messagesModels.add(new MessagesModel("Jon Jones (COMIVO)", "", "9:38AM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                        "tempor incididunt ut labore et dolore magna aliqua...",
                R.drawable.ic_online_status, R.drawable.comivo_img));

        messagesModels.add(new MessagesModel("Jim Kim", "ABC Chemical LLC", "9:38AM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                        "tempor incididunt ut labore et dolore magna aliqua...",
                R.drawable.ic_online_status, R.drawable.jim_img));

        messagesModels.add(new MessagesModel("Tony Sit", "SUNIVO AMERICA LLC", "9:38AM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                        "tempor incididunt ut labore et dolore magna aliqua...",
                R.drawable.ic_online_status, R.drawable.tony_img));

        messagesModels.add(new MessagesModel("Thomas Huang", "ABC Chemical LLC", "9:38AM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                        "tempor incididunt ut labore et dolore magna aliqua...",
                R.drawable.ic_offline_status, R.drawable.thomas_img));

    }

    private void initializeAdapter(){
        MessageAdapter adapter = new MessageAdapter(messagesModels);
        recyclerView.setAdapter(adapter);
    }



    */
/*userName = (TextView) itemView.findViewById(R.id.tv_user_name);
    companyName = (TextView) itemView.findViewById(R.id.tv_company_name);
    time = (TextView) itemView.findViewById(R.id.tv_time);
    messageText = (TextView) itemView.findViewById(R.id.tv_message_text);
    status = (ImageView) itemView.findViewById(R.id.iv_online_status);
    coverImage = (ImageView) itemView.findViewById(R.id.iv_cover_image);
*//*



}
*/
