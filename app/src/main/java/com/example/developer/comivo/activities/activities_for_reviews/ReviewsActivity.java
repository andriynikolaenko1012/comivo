package com.example.developer.comivo.activities.activities_for_reviews;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_buyers_acc.BuyersAccActivity;
import com.example.developer.comivo.activities.activities_for_community.CommunityActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivity;
import com.example.developer.comivo.activities.activities_for_settings.SettingsActivity;


public class ReviewsActivity extends AppCompatActivity {

    public TextView message_tv, reviews_tv, community_tv, account_tv,
            reviews_tab, companies_tab;
    public ImageView message_iv, reviews_iv, community_iv, account_iv;
    public LinearLayout layout_for_buttons, layout_for_reviews_button,
            layout_for_community_button, layout_for_account_button,
            layout_for_message_button, tabs_for_review, not_verified_layout,
            verified_layout, layout2;
    public ScrollView scroll_for_companies, scroll_for_reviews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews_layout);
        initViews();
    }



    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_header_menu_icon);

        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewsActivity.this, ReviewsSearchActivity.class);
                startActivity(intent);
                finish();
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tittle.setText(R.string.reviews);

        message_tv = (TextView) findViewById(R.id.message_tv_2);
        reviews_tv = (TextView) findViewById(R.id.reviews_tv_2);
        community_tv = (TextView) findViewById(R.id.community_tv_2);
        account_tv = (TextView) findViewById(R.id.account_tv_2);

        message_iv = (ImageView) findViewById(R.id.message_iv_2);
        reviews_iv = (ImageView) findViewById(R.id.reviews_iv_2);
        community_iv = (ImageView) findViewById(R.id.community_iv_2);
        account_iv = (ImageView) findViewById(R.id.account_iv_2);

        layout_for_buttons = (LinearLayout) findViewById(R.id.layout_for_buttons_2);
        layout_for_message_button = (LinearLayout) findViewById(R.id.layout_for_message_button_2);
        layout_for_reviews_button = (LinearLayout) findViewById(R.id.layout_for_reviews_button_2);
        layout_for_community_button = (LinearLayout) findViewById(R.id.layout_for_community_button_2);
        layout_for_account_button = (LinearLayout) findViewById(R.id.layout_for_account_button_2);

        verified_layout = (LinearLayout) findViewById(R.id.verified_layout);
        not_verified_layout = (LinearLayout) findViewById(R.id.not_verified_layout);
        layout2 = (LinearLayout) findViewById(R.id.layout2);


        reviews_tab = (TextView) findViewById(R.id.reviews_tab);
        companies_tab = (TextView) findViewById(R.id.companies_tab);
        tabs_for_review = (LinearLayout) findViewById(R.id.tabs_for_review);
        tabs_for_review.setPressed(true);
        scroll_for_companies = (ScrollView) findViewById(R.id.scroll_for_companies);
        scroll_for_reviews = (ScrollView) findViewById(R.id.scroll_for_reviews);
        scroll_for_reviews.setVisibility(View.GONE);

        Log.d("LOG","CHP1");




        companies_tab.setTextColor(getResources().getColor(R.color.white_color));
        reviews_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

        companies_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LOG","CHP2");
                companies_tab.setTextColor(getResources().getColor(R.color.white_color));
                reviews_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                scroll_for_companies.setVisibility(View.VISIBLE);
                scroll_for_reviews.setVisibility(View.GONE);

            }
        });

        reviews_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companies_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                reviews_tab.setTextColor(getResources().getColor(R.color.white_color));
                scroll_for_companies.setVisibility(View.GONE);
                scroll_for_reviews.setVisibility(View.VISIBLE);
            }
        });


        verified_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewsActivity.this, VerifiedCompanyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        not_verified_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewsActivity.this, NotVerifiedCompanyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewsActivity.this, ForCommentsActivity.class);
                startActivity(intent);
                finish();
            }
        });



        layout_for_buttons.setPressed(true);

        reviews_tv.setTextColor(getResources().getColor(R.color.colorMain));
        reviews_iv.setImageResource(R.drawable.reviews_pressed_icon);

        message_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
        message_iv.setImageResource(R.drawable.messages_icon);
        community_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
        community_iv.setImageResource(R.drawable.community_icon);
        account_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
        account_iv.setImageResource(R.drawable.account_icon);

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

                Intent intent = new Intent(ReviewsActivity.this, CommunityActivity.class);
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

                Intent intent = new Intent(ReviewsActivity.this, BuyersAccActivity.class);
                startActivity(intent);
                finish();

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

                Intent intent = new Intent(ReviewsActivity.this, MessageActivity.class);
                startActivity(intent);
                finish();
            }
        });


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewsActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
