package com.example.developer.comivo.activities.activities_for_sellers_acc;

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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_buyers_acc.InquiriesEditActivity;
import com.example.developer.comivo.activities.activities_for_buyers_acc.OrderSignedSellerActivity;
import com.example.developer.comivo.activities.activities_for_buyers_acc.QuoteActivity;
import com.example.developer.comivo.activities.activities_for_community.CommunityActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivity;
import com.example.developer.comivo.activities.activities_for_reviews.ReviewsActivity;
import com.example.developer.comivo.activities.activities_for_settings.SettingsActivity;


public class SellersAccActivity extends AppCompatActivity{

    public TextView message_tv, reviews_tv, community_tv, account_tv,
            inquiry_tab, opportunity_tab, order_tab, product_tab,
            tv_sendOffer, tv_updateQuote;

    public ImageView message_iv, reviews_iv, community_iv, account_iv, iv_666, iv_777,
            add_new_product;

    public LinearLayout layout_for_buttons, layout_for_reviews_button,
            layout_for_community_button, layout_for_account_button,
            layout_for_message_button, sellers_tabs;

    public ScrollView scroll_opportunity, scroll_inquiry, scroll_order, scroll_product;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sellers_acc_layout);
        initViews();
    }



    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText(R.string.account);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_header_menu_icon);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        message_tv = (TextView) findViewById(R.id.message_tv_7);
        reviews_tv = (TextView) findViewById(R.id.reviews_tv_7);
        community_tv = (TextView) findViewById(R.id.community_tv_7);
        account_tv = (TextView) findViewById(R.id.account_tv_7);

        message_iv = (ImageView) findViewById(R.id.message_iv_7);
        reviews_iv = (ImageView) findViewById(R.id.reviews_iv_7);
        community_iv = (ImageView) findViewById(R.id.community_iv_7);
        account_iv = (ImageView) findViewById(R.id.account_iv_7);

        layout_for_message_button = (LinearLayout) findViewById(R.id.layout_for_message_button_7);
        layout_for_reviews_button = (LinearLayout) findViewById(R.id.layout_for_reviews_button_7);
        layout_for_community_button = (LinearLayout) findViewById(R.id.layout_for_community_button_7);
        layout_for_account_button = (LinearLayout) findViewById(R.id.layout_for_account_button_7);


        sellers_tabs = (LinearLayout) findViewById(R.id.sellers_tabs);
        sellers_tabs.setPressed(true);

        account_tv.setTextColor(getResources().getColor(R.color.colorMain));
        account_iv.setImageResource(R.drawable.accounts_pressed_icon);
        message_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
        message_iv.setImageResource(R.drawable.messages_icon);
        reviews_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
        reviews_iv.setImageResource(R.drawable.reviews_icon);
        community_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
        community_iv.setImageResource(R.drawable.community_icon);



        tv_sendOffer = (TextView) findViewById(R.id.tv_sendOffer);
        tv_updateQuote = (TextView) findViewById(R.id.tv_sendOffer);


        iv_666 = (ImageView) findViewById(R.id.iv_666);

        iv_777 = (ImageView) findViewById(R.id.iv_777);

        add_new_product = (ImageView) findViewById(R.id.add_new_product);

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

                Intent intent = new Intent(SellersAccActivity.this, ReviewsActivity.class);
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

                Intent intent = new Intent(SellersAccActivity.this, MessageActivity.class);
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

                Intent intent = new Intent(SellersAccActivity.this, CommunityActivity.class);
                startActivity(intent);
                finish();

            }
        });


        scroll_inquiry = (ScrollView) findViewById(R.id.scroll_inquiry);
        scroll_opportunity = (ScrollView) findViewById(R.id.scroll_opportunity);
        scroll_order = (ScrollView) findViewById(R.id.scroll_order);
        scroll_product = (ScrollView) findViewById(R.id.scroll_product);

        inquiry_tab = (TextView) findViewById(R.id.inquiry_tab);
        opportunity_tab = (TextView) findViewById(R.id.opportunity_tab);
        order_tab = (TextView) findViewById(R.id.order_tab);
        product_tab = (TextView) findViewById(R.id.product_tab);

        inquiry_tab.setTextColor(getResources().getColor(R.color.green_color));
        opportunity_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
        order_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
        product_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

        inquiry_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scroll_inquiry.setVisibility(View.VISIBLE);
                scroll_opportunity.setVisibility(View.GONE);
                scroll_order.setVisibility(View.GONE);
                scroll_product.setVisibility(View.GONE);

                inquiry_tab.setTextColor(getResources().getColor(R.color.green_color));
                opportunity_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                order_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                product_tab.setTextColor(getResources().getColor(R.color.colorSecondary));



            }
        });

        opportunity_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scroll_inquiry.setVisibility(View.GONE);
                scroll_opportunity.setVisibility(View.VISIBLE);
                scroll_order.setVisibility(View.GONE);
                scroll_product.setVisibility(View.GONE);

                inquiry_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                opportunity_tab.setTextColor(getResources().getColor(R.color.green_color));
                order_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                product_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

            }
        });

        order_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scroll_inquiry.setVisibility(View.GONE);
                scroll_opportunity.setVisibility(View.GONE);
                scroll_order.setVisibility(View.VISIBLE);
                scroll_product.setVisibility(View.GONE);


                inquiry_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                opportunity_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                order_tab.setTextColor(getResources().getColor(R.color.green_color));
                product_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

            }
        });

        product_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scroll_inquiry.setVisibility(View.GONE);
                scroll_opportunity.setVisibility(View.GONE);
                scroll_order.setVisibility(View.GONE);
                scroll_product.setVisibility(View.VISIBLE);

                inquiry_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                opportunity_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                order_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                product_tab.setTextColor(getResources().getColor(R.color.green_color));

            }
        });


        tv_sendOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellersAccActivity.this, OpportunityUpdateQuoteActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tv_updateQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellersAccActivity.this, OpportunityUpdateQuoteActivity.class);
                startActivity(intent);
                finish();
            }
        });

        iv_666.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellersAccActivity.this, OpportunityDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });


        iv_777.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellersAccActivity.this, OrderProcessingActivity.class);
                startActivity(intent);
                finish();
            }
        });

        add_new_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellersAccActivity.this, AddProductActivity.class);
                startActivity(intent);
                finish();
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellersAccActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
