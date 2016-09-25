package com.example.developer.comivo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.fragments.buyers.AccountBuyersFragmentFavorites;
import com.example.developer.comivo.fragments.buyers.AccountBuyersFragmentInquiries;
import com.example.developer.comivo.fragments.buyers.AccountBuyersFragmentOrders;
import com.example.developer.comivo.fragments.buyers.AccountBuyersFragmentQuotes;


public class AccountBuyersFragment extends Fragment {

    public TextView  quotes_tab, inquiries_tab, orders_tab, favorites_tab;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.buyers_acc_fragment, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.my_container_acc_buyers, new AccountBuyersFragmentQuotes());
        ft.addToBackStack(null);
        ft.commit();

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

                quotes_tab.setTextColor(getResources().getColor(R.color.green_color));
                inquiries_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                orders_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                favorites_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.my_container_acc_buyers, new AccountBuyersFragmentQuotes());
                ft.addToBackStack(null);
                ft.commit();


            }
        });

        inquiries_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quotes_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                inquiries_tab.setTextColor(getResources().getColor(R.color.green_color));
                orders_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                favorites_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.my_container_acc_buyers, new AccountBuyersFragmentInquiries());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        orders_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quotes_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                inquiries_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                orders_tab.setTextColor(getResources().getColor(R.color.green_color));
                favorites_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.my_container_acc_buyers, new AccountBuyersFragmentOrders());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        favorites_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quotes_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                inquiries_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                orders_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                favorites_tab.setTextColor(getResources().getColor(R.color.green_color));

                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.my_container_acc_buyers, new AccountBuyersFragmentFavorites());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }

}
