package com.example.developer.comivo.activities.activities_for_messages;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_settings.SettingsActivity;

import com.example.developer.comivo.fragments.AccountBuyersFragment;
import com.example.developer.comivo.fragments.AccountSellersFragment;
import com.example.developer.comivo.fragments.CommunityFragment;
import com.example.developer.comivo.fragments.MessageFragment;
import com.example.developer.comivo.fragments.ReviewsFragment;
import com.example.developer.comivo.models.UserModel;


public class MessageActivityNew extends AppCompatActivity {

    public TextView message_tv, reviews_tv, community_tv, account_tv;
    public ImageView message_iv, reviews_iv, community_iv, account_iv;
    public LinearLayout layout_for_buttons_new, layout_for_reviews_button,
            layout_for_community_button, layout_for_account_button,
            layout_for_message_button;

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

        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);

        toolbar.getParent();
        toolbar.setContentInsetsAbsolute(0, 0);

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivityNew.this, MessageSearchActivity.class);
                startActivity(intent);
                finish();
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.my_container, new MessageFragment());
        ft.addToBackStack(null);
        ft.commit();


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

            }
        });


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageActivityNew.this, SettingsActivity.class);
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
