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


public class AccountBuyersFragmentQuotes extends Fragment {

    public ImageView quote_1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.buyers_acc_fragment_quotes, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        quote_1 = (ImageView) view.findViewById(R.id.quote_1);

        quote_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QuoteActivity.class);
                startActivity(intent);
            }
        });
    }

}
