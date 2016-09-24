package com.example.developer.comivo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_sellers_acc.AddProductActivity;
import com.example.developer.comivo.activities.activities_for_sellers_acc.OpportunityDetailsActivity;
import com.example.developer.comivo.activities.activities_for_sellers_acc.OpportunityUpdateQuoteActivity;
import com.example.developer.comivo.activities.activities_for_sellers_acc.OrderProcessingActivity;
import com.example.developer.comivo.activities.activities_for_settings.SettingsActivity;


public class AccountSellersFragment extends Fragment{

    public TextView inquiry_tab, opportunity_tab, order_tab, product_tab,
            tv_sendOffer, tv_updateQuote;

    public ImageView iv_666, iv_777,add_new_product;

    public ScrollView scroll_opportunity, scroll_inquiry, scroll_order, scroll_product;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sellers_acc_fragment, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        tv_sendOffer = (TextView) view.findViewById(R.id.tv_sendOffer);
        tv_updateQuote = (TextView) view.findViewById(R.id.tv_sendOffer);


        iv_666 = (ImageView) view.findViewById(R.id.iv_666);

        iv_777 = (ImageView) view.findViewById(R.id.iv_777);

        add_new_product = (ImageView) view.findViewById(R.id.add_new_product);

        scroll_inquiry = (ScrollView) view.findViewById(R.id.scroll_inquiry);
        scroll_opportunity = (ScrollView) view.findViewById(R.id.scroll_opportunity);
        scroll_order = (ScrollView) view.findViewById(R.id.scroll_order);
        scroll_product = (ScrollView) view.findViewById(R.id.scroll_product);

        inquiry_tab = (TextView) view.findViewById(R.id.inquiry_tab);
        opportunity_tab = (TextView) view.findViewById(R.id.opportunity_tab);
        order_tab = (TextView) view.findViewById(R.id.order_tab);
        product_tab = (TextView) view.findViewById(R.id.product_tab);

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
                Intent intent = new Intent(getContext(), OpportunityUpdateQuoteActivity.class);
                startActivity(intent);
            }
        });

        tv_updateQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OpportunityUpdateQuoteActivity.class);
                startActivity(intent);
            }
        });

        iv_666.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OpportunityDetailsActivity.class);
                startActivity(intent);
            }
        });


        iv_777.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OrderProcessingActivity.class);
                startActivity(intent);
            }
        });

        add_new_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddProductActivity.class);
                startActivity(intent);
            }
        });

    }

}

