package com.example.developer.comivo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_buyers_acc.InquiriesEditActivity;
import com.example.developer.comivo.activities.activities_for_buyers_acc.OrderSignedSellerActivity;
import com.example.developer.comivo.activities.activities_for_buyers_acc.QuoteActivity;


public class AccountBuyersFragment extends Fragment {

    public TextView  quotes_tab, inquiries_tab, orders_tab, favorites_tab;
    public ImageView quote_1, image_119, menu_1, menu_2, image_back, edit_image,
            add_image;
    public LinearLayout layout_for_buttons, layout_for_reviews_button,
            layout_for_community_button, layout_for_account_button,
            layout_for_message_button, buyers_tabs;
    public ScrollView scroll_quotes, scroll_inquiries, scroll_orders, scroll_favorites;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.buyers_acc_fragment, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        quote_1 = (ImageView) view.findViewById(R.id.quote_1);
        image_119 = (ImageView) view.findViewById(R.id.image_119);

        menu_1 = (ImageView) view.findViewById(R.id.menu_1);
        menu_2 = (ImageView) view.findViewById(R.id.menu_2);

        image_back = (ImageView) view.findViewById(R.id.image_back);
        edit_image = (ImageView) view.findViewById(R.id.edit_image);
        add_image = (ImageView) view.findViewById(R.id.add_image);

        scroll_quotes = (ScrollView) view.findViewById(R.id.scroll_quotes);
        scroll_inquiries = (ScrollView) view.findViewById(R.id.scroll_inquiries);
        scroll_orders = (ScrollView) view.findViewById(R.id.scroll_orders);
        scroll_favorites = (ScrollView) view.findViewById(R.id.scroll_favorites);

        quotes_tab = (TextView) view.findViewById(R.id.quotes_tab);
        inquiries_tab = (TextView) view.findViewById(R.id.inquiries_tab);
        orders_tab = (TextView) view.findViewById(R.id.orders_tab);
        favorites_tab = (TextView) view.findViewById(R.id.favorites_tab);

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
                Intent intent = new Intent(getContext(), QuoteActivity.class);
                startActivity(intent);
            }
        });


        image_119.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OrderSignedSellerActivity.class);
                startActivity(intent);
            }
        });


        menu_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = LayoutInflater.from(getContext());
                View layout = inflater.inflate(R.layout.favourites_dialog, null);
                AlertDialog MyDialog;

                AlertDialog.Builder MyBuilder = new AlertDialog.Builder(getContext());
                MyBuilder.setView(layout);

                MyDialog = MyBuilder.create();
                MyDialog.getWindow().setLayout(400, 300);

                MyDialog.show();
            }
        });

        menu_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                View layout = inflater.inflate(R.layout.favourites_dialog, null);
                AlertDialog MyDialog;

                AlertDialog.Builder MyBuilder = new AlertDialog.Builder(getContext());
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
                Intent intent = new Intent(getContext(), InquiriesEditActivity.class);
                startActivity(intent);
            }
        });

        /*add_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CommunityActivity.class);
                startActivity(intent);
            }
        });*/
    }

}
