package com.example.developer.comivo.fragments;

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
import com.example.developer.comivo.fragments.reviews.ReviewsCompaniesFragment;
import com.example.developer.comivo.fragments.reviews.ReviewsReviewsFragment;


public class ReviewsFragment extends Fragment{

    TextView reviews_tab, companies_tab;
    public LinearLayout tabs_for_review;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.reviews_layout_new, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.my_container_reviews, new ReviewsCompaniesFragment());
        ft.addToBackStack(null);
        ft.commit();

        reviews_tab = (TextView) view.findViewById(R.id.reviews_tab);
        companies_tab = (TextView) view.findViewById(R.id.companies_tab);
        tabs_for_review = (LinearLayout) view.findViewById(R.id.tabs_for_review);
        tabs_for_review.setPressed(true);


        companies_tab.setTextColor(getResources().getColor(R.color.white_color));
        reviews_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

        companies_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companies_tab.setTextColor(getResources().getColor(R.color.white_color));
                reviews_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.my_container_reviews, new ReviewsCompaniesFragment());
                ft.addToBackStack(null);
                ft.commit();

            }
        });

        reviews_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companies_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                reviews_tab.setTextColor(getResources().getColor(R.color.white_color));

                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.my_container_reviews, new ReviewsReviewsFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });


    }

}
