package com.example.developer.comivo.fragments.reviews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_reviews.ForCommentsActivity;
import com.example.developer.comivo.activities.activities_for_reviews.NotVerifiedCompanyActivity;
import com.example.developer.comivo.activities.activities_for_reviews.VerifiedCompanyActivity;


public class ReviewsReviewsFragment extends Fragment{

    public LinearLayout layout2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.reviews_fragment_reviews, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        layout2 = (LinearLayout) view.findViewById(R.id.layout2);

        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ForCommentsActivity.class);
                startActivity(intent);

            }
        });

    }

}
