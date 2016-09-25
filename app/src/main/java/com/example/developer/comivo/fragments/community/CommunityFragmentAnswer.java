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


public class CommunityFragmentAnswer extends Fragment {

    public LinearLayout layout_comments_4;

    public TextView text_steel_4, some_text_4, tv_answer_4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.community_fragment_answer, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        text_steel_4 = (TextView) view.findViewById(R.id.text_steel_4);
        some_text_4 = (TextView) view.findViewById(R.id.some_text_4);
        tv_answer_4 = (TextView) view.findViewById(R.id.tv_answer_4);

        layout_comments_4 = (LinearLayout) view.findViewById(R.id.layout_comments_4);

        text_steel_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AnswerDetailsActivity.class);
                startActivity(intent);
            }
        });

        some_text_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AnswerDetailsActivity.class);
                startActivity(intent);
            }
        });

        tv_answer_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AnswerPostActivity.class);
                startActivity(intent);
            }
        });

        layout_comments_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AnswerCommentsActivity.class);
                startActivity(intent);
            }
        });

    }

}

