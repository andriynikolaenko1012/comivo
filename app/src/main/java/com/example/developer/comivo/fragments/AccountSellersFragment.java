package com.example.developer.comivo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.fragments.sellers.AccountSellersFragmentInquiries;
import com.example.developer.comivo.fragments.sellers.AccountSellersFragmentOpportunities;
import com.example.developer.comivo.fragments.sellers.AccountSellersFragmentOrders;
import com.example.developer.comivo.fragments.sellers.AccountSellersFragmentProducts;


public class AccountSellersFragment extends Fragment{

    public TextView inquiry_tab, opportunity_tab, order_tab, product_tab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sellers_acc_fragment, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.my_container_acc_sellers, new AccountSellersFragment());
        ft.addToBackStack(null);
        ft.commit();

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

                inquiry_tab.setTextColor(getResources().getColor(R.color.green_color));
                opportunity_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                order_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                product_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.my_container_acc_sellers, new AccountSellersFragmentInquiries());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        opportunity_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inquiry_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                opportunity_tab.setTextColor(getResources().getColor(R.color.green_color));
                order_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                product_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.my_container_acc_sellers, new AccountSellersFragmentOpportunities());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        order_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inquiry_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                opportunity_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                order_tab.setTextColor(getResources().getColor(R.color.green_color));
                product_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.my_container_acc_sellers, new AccountSellersFragmentOrders());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        product_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inquiry_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                opportunity_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                order_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                product_tab.setTextColor(getResources().getColor(R.color.green_color));

                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.my_container_acc_sellers, new AccountSellersFragmentProducts());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }

}

