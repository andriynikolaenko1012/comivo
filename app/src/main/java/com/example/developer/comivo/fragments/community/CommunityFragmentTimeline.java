package com.example.developer.comivo.fragments.community;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_community.ShareActivity;


public class CommunityFragmentTimeline extends Fragment {

    public LinearLayout share_button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.community_fragment_timeline, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        share_button = (LinearLayout) view.findViewById(R.id.layout_share);

        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ShareActivity.class);
                startActivity(intent);
            }
        });
    }

}

