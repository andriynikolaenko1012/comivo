package com.example.developer.comivo.fragments.community;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_community.AnswerCommentsActivity;
import com.example.developer.comivo.activities.activities_for_community.AnswerDetailsActivity;
import com.example.developer.comivo.activities.activities_for_community.AnswerPostActivity;
import com.example.developer.comivo.activities.activities_for_community.ChemicalAnswerActivity;
import com.example.developer.comivo.activities.activities_for_community.ChemicalDetailsActivity;
import com.example.developer.comivo.activities.activities_for_community.ChemicalQuestionActivity;
import com.example.developer.comivo.activities.activities_for_community.ChemicalSelectedActivity;
import com.example.developer.comivo.activities.activities_for_community.PostCommentsActivity;
import com.example.developer.comivo.activities.activities_for_community.PostDetailsActivity;
import com.example.developer.comivo.activities.activities_for_community.PostWriteActivity;
import com.example.developer.comivo.activities.activities_for_community.QuestionCommentsActivity;
import com.example.developer.comivo.activities.activities_for_community.QuestionPostActivity;
import com.example.developer.comivo.activities.activities_for_community.QuestionWriteAnswerActivity;
import com.example.developer.comivo.activities.activities_for_community.ShareActivity;
import com.example.developer.comivo.activities.activities_for_community.TimelineCommentsActivity;
import com.example.developer.comivo.activities.activities_for_community.TimelinePostDetailsActivity;


public class CommunityFragmentChemical extends Fragment {

    public LinearLayout post_linear, quest_linear, answ_linear;

    public RelativeLayout selected_relative;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.community_fragment_chemical, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        post_linear = (LinearLayout) view.findViewById(R.id.post_linear3);
        quest_linear = (LinearLayout) view.findViewById(R.id.quest_linear3);
        answ_linear = (LinearLayout) view.findViewById(R.id.answ_linear3);
        selected_relative = (RelativeLayout) view.findViewById(R.id.selected_relative);

        post_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChemicalDetailsActivity.class);
                startActivity(intent);
            }
        });

        quest_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChemicalQuestionActivity.class);
                startActivity(intent);
            }
        });

        answ_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChemicalAnswerActivity.class);
                startActivity(intent);
            }
        });

        selected_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChemicalSelectedActivity.class);
                startActivity(intent);
            }
        });

    }

}

