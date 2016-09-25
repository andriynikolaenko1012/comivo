package com.example.developer.comivo.fragments.buyers;

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


public class AccountBuyersFragmentFavorites extends Fragment {

    public ImageView menu_1, menu_2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.buyers_acc_fragment_favorites, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        menu_1 = (ImageView) view.findViewById(R.id.menu_1);
        menu_2 = (ImageView) view.findViewById(R.id.menu_2);

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

    }

}
