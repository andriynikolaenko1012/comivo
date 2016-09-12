package com.example.developer.comivo.activities.activities_for_buyers_acc;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_community.CommunityActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivity;
import com.example.developer.comivo.activities.activities_for_reviews.ReviewsActivity;
import com.example.developer.comivo.activities.activities_for_settings.SettingsActivity;


public class BuyersAccActivity extends AppCompatActivity{

    public TextView message_tv, reviews_tv, community_tv, account_tv,
            quotes_tab, inquiries_tab, orders_tab, favorites_tab;
    public ImageView message_iv, reviews_iv, community_iv, account_iv,
            quote_1, image_119, menu_1, menu_2, image_back, edit_image,
            add_image;
    public LinearLayout layout_for_buttons, layout_for_reviews_button,
            layout_for_community_button, layout_for_account_button,
            layout_for_message_button, buyers_tabs;
    public ScrollView scroll_quotes, scroll_inquiries, scroll_orders, scroll_favorites;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyers_acc_layout);
        initViews();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) BuyersAccActivity.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }

        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(BuyersAccActivity.this.getComponentName()));
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }

    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText(R.string.account);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_header_menu_icon);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        message_tv = (TextView) findViewById(R.id.message_tv_4);
        reviews_tv = (TextView) findViewById(R.id.reviews_tv_4);
        community_tv = (TextView) findViewById(R.id.community_tv_4);
        account_tv = (TextView) findViewById(R.id.account_tv_4);

        message_iv = (ImageView) findViewById(R.id.message_iv_4);
        reviews_iv = (ImageView) findViewById(R.id.reviews_iv_4);
        community_iv = (ImageView) findViewById(R.id.community_iv_4);
        account_iv = (ImageView) findViewById(R.id.account_iv_4);

        layout_for_buttons = (LinearLayout) findViewById(R.id.layout_for_buttons_4);
        layout_for_message_button = (LinearLayout) findViewById(R.id.layout_for_message_button_4);
        layout_for_reviews_button = (LinearLayout) findViewById(R.id.layout_for_reviews_button_4);
        layout_for_community_button = (LinearLayout) findViewById(R.id.layout_for_community_button_4);
        layout_for_account_button = (LinearLayout) findViewById(R.id.layout_for_account_button_4);


        buyers_tabs = (LinearLayout) findViewById(R.id.buyers_tabs);
        buyers_tabs.setPressed(true);

        account_tv.setTextColor(getResources().getColor(R.color.colorMain));
        account_iv.setImageResource(R.drawable.accounts_pressed_icon);
        message_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
        message_iv.setImageResource(R.drawable.messages_icon);
        reviews_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
        reviews_iv.setImageResource(R.drawable.reviews_icon);
        community_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
        community_iv.setImageResource(R.drawable.community_icon);

        quote_1 = (ImageView) findViewById(R.id.quote_1);
        image_119 = (ImageView) findViewById(R.id.image_119);

        menu_1 = (ImageView) findViewById(R.id.menu_1);
        menu_2 = (ImageView) findViewById(R.id.menu_2);

        image_back = (ImageView) findViewById(R.id.image_back);
        edit_image = (ImageView) findViewById(R.id.edit_image);
        add_image = (ImageView) findViewById(R.id.add_image);

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

                Intent intent = new Intent(BuyersAccActivity.this, ReviewsActivity.class);
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

                Intent intent = new Intent(BuyersAccActivity.this, MessageActivity.class);
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

                Intent intent = new Intent(BuyersAccActivity.this, CommunityActivity.class);
                startActivity(intent);
                finish();

            }
        });


        scroll_quotes = (ScrollView) findViewById(R.id.scroll_quotes);
        scroll_inquiries = (ScrollView) findViewById(R.id.scroll_inquiries);
        scroll_orders = (ScrollView) findViewById(R.id.scroll_orders);
        scroll_favorites = (ScrollView) findViewById(R.id.scroll_favorites);

        quotes_tab = (TextView) findViewById(R.id.quotes_tab);
        inquiries_tab = (TextView) findViewById(R.id.inquiries_tab);
        orders_tab = (TextView) findViewById(R.id.orders_tab);
        favorites_tab = (TextView) findViewById(R.id.favorites_tab);

        quotes_tab.setTextColor(getResources().getColor(R.color.green_color));
        inquiries_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
        orders_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
        favorites_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

        quotes_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scroll_quotes.setVisibility(View.VISIBLE);
                scroll_inquiries.setVisibility(View.GONE);
                scroll_orders.setVisibility(View.GONE);
                scroll_favorites.setVisibility(View.GONE);

                quotes_tab.setTextColor(getResources().getColor(R.color.green_color));
                inquiries_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                orders_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                favorites_tab.setTextColor(getResources().getColor(R.color.colorSecondary));



            }
        });

        inquiries_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scroll_quotes.setVisibility(View.GONE);
                scroll_inquiries.setVisibility(View.VISIBLE);
                scroll_orders.setVisibility(View.GONE);
                scroll_favorites.setVisibility(View.GONE);

                quotes_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                inquiries_tab.setTextColor(getResources().getColor(R.color.green_color));
                orders_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                favorites_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

            }
        });

        orders_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scroll_quotes.setVisibility(View.GONE);
                scroll_inquiries.setVisibility(View.GONE);
                scroll_orders.setVisibility(View.VISIBLE);
                scroll_favorites.setVisibility(View.GONE);


                quotes_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                inquiries_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                orders_tab.setTextColor(getResources().getColor(R.color.green_color));
                favorites_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

            }
        });

        favorites_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scroll_quotes.setVisibility(View.GONE);
                scroll_inquiries.setVisibility(View.GONE);
                scroll_orders.setVisibility(View.GONE);
                scroll_favorites.setVisibility(View.VISIBLE);

                quotes_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                inquiries_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                orders_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                favorites_tab.setTextColor(getResources().getColor(R.color.green_color));

            }
        });


        quote_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyersAccActivity.this, QuoteActivity.class);
                startActivity(intent);
                finish();
            }
        });


        image_119.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyersAccActivity.this, OrderSignedSellerActivity.class);
                startActivity(intent);
                finish();
            }
        });


        menu_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = LayoutInflater.from(BuyersAccActivity.this);
                View layout = inflater.inflate(R.layout.favourites_dialog, null);
                AlertDialog MyDialog;

                AlertDialog.Builder MyBuilder = new AlertDialog.Builder(BuyersAccActivity.this);
                MyBuilder.setView(layout);

                MyDialog = MyBuilder.create();
                MyDialog.getWindow().setLayout(400, 300);

                MyDialog.show();
            }
        });

        menu_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(BuyersAccActivity.this);
                View layout = inflater.inflate(R.layout.favourites_dialog, null);
                AlertDialog MyDialog;

                AlertDialog.Builder MyBuilder = new AlertDialog.Builder(BuyersAccActivity.this);
                MyBuilder.setView(layout);

                MyDialog = MyBuilder.create();
                MyDialog.getWindow().setLayout(400, 300);

                MyDialog.show();
            }
        });

        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scroll_quotes.setVisibility(View.VISIBLE);
                scroll_inquiries.setVisibility(View.GONE);
                scroll_orders.setVisibility(View.GONE);
                scroll_favorites.setVisibility(View.GONE);
            }
        });

        edit_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyersAccActivity.this, InquiriesEditActivity.class);
                startActivity(intent);
                finish();
            }
        });

        add_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyersAccActivity.this, CommunityActivity.class);
                startActivity(intent);
                finish();
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyersAccActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
