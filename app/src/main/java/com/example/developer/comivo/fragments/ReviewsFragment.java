package com.example.developer.comivo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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


public class ReviewsFragment extends Fragment{

    TextView reviews_tab, companies_tab;
    public LinearLayout layout_for_buttons, layout_for_reviews_button,
            layout_for_community_button, layout_for_account_button,
            layout_for_message_button, tabs_for_review, not_verified_layout,
            verified_layout, layout2;
    public ScrollView scroll_for_companies, scroll_for_reviews;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.reviews_layout_new, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        verified_layout = (LinearLayout) view.findViewById(R.id.verified_layout);
        not_verified_layout = (LinearLayout) view.findViewById(R.id.not_verified_layout);
        layout2 = (LinearLayout) view.findViewById(R.id.layout2);


        reviews_tab = (TextView) view.findViewById(R.id.reviews_tab);
        companies_tab = (TextView) view.findViewById(R.id.companies_tab);
        tabs_for_review = (LinearLayout) view.findViewById(R.id.tabs_for_review);
        tabs_for_review.setPressed(true);
        scroll_for_companies = (ScrollView) view.findViewById(R.id.scroll_for_companies);
        scroll_for_reviews = (ScrollView) view.findViewById(R.id.scroll_for_reviews);
        scroll_for_reviews.setVisibility(View.GONE);


        companies_tab.setTextColor(getResources().getColor(R.color.white_color));
        reviews_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

        companies_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companies_tab.setTextColor(getResources().getColor(R.color.white_color));
                reviews_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                scroll_for_companies.setVisibility(View.VISIBLE);
                scroll_for_reviews.setVisibility(View.GONE);

            }
        });

        reviews_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companies_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                reviews_tab.setTextColor(getResources().getColor(R.color.white_color));
                scroll_for_companies.setVisibility(View.GONE);
                scroll_for_reviews.setVisibility(View.VISIBLE);
            }
        });


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

        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ForCommentsActivity.class);
                startActivity(intent);

            }
        });

    }

}
