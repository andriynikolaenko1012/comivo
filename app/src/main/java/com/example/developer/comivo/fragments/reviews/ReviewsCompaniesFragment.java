package com.example.developer.comivo.fragments.reviews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_reviews.ForCommentsActivity;
import com.example.developer.comivo.activities.activities_for_reviews.NotVerifiedCompanyActivity;
import com.example.developer.comivo.activities.activities_for_reviews.VerifiedCompanyActivity;


public class ReviewsCompaniesFragment extends Fragment{

    public LinearLayout not_verified_layout, verified_layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.reviews_fragment_companies, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        verified_layout = (LinearLayout) view.findViewById(R.id.verified_layout);
        not_verified_layout = (LinearLayout) view.findViewById(R.id.not_verified_layout);

        verified_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), VerifiedCompanyActivity.class);
                startActivity(intent);

            }
        });

        not_verified_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NotVerifiedCompanyActivity.class);
                startActivity(intent);

            }
        });

    }

}
