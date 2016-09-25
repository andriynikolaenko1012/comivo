package com.example.developer.comivo.fragments.sellers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_sellers_acc.AddProductActivity;
import com.example.developer.comivo.activities.activities_for_sellers_acc.OpportunityDetailsActivity;
import com.example.developer.comivo.activities.activities_for_sellers_acc.OpportunityUpdateQuoteActivity;
import com.example.developer.comivo.activities.activities_for_sellers_acc.OrderProcessingActivity;


public class AccountSellersFragmentOrders extends Fragment{

    public ImageView iv_777;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sellers_acc_fragment_orders, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        iv_777 = (ImageView) view.findViewById(R.id.iv_777);

        iv_777.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OrderProcessingActivity.class);
                startActivity(intent);
            }
        });

    }

}

