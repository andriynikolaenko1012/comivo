package com.example.developer.comivo.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_messages.BroadcastActivity;
import com.example.developer.comivo.activities.activities_for_messages.ChatWithCOMIVOActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageDirectlyActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageOfferActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageOrderActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageRemindingActivity;


public class MessageFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.message_fragment, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RelativeLayout chatWithComivo = (RelativeLayout) view.findViewById(R.id.comivo_layout);
        chatWithComivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChatWithCOMIVOActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout systemChat = (RelativeLayout) view.findViewById(R.id.holiday_layout);
        systemChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BroadcastActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout directlyChat = (RelativeLayout) view.findViewById(R.id.thomas_huang_layout);
        directlyChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MessageDirectlyActivity.class);
                startActivity(intent);
            }
        });


        RelativeLayout messageOffer2 = (RelativeLayout) view.findViewById(R.id.jim_kim_layout);
        messageOffer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MessageOfferActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout messageOrder = (RelativeLayout) view.findViewById(R.id.tony_sit_layout);
        messageOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MessageOrderActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout messageOffer = (RelativeLayout) view.findViewById(R.id.mishelle_taker_layout);
        messageOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MessageOfferActivity.class);
                startActivity(intent);
            }
        });


        RelativeLayout messageReminding = (RelativeLayout) view.findViewById(R.id.reminding_layout);
        messageReminding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MessageRemindingActivity.class);
                startActivity(intent);
            }
        });
    }

}
