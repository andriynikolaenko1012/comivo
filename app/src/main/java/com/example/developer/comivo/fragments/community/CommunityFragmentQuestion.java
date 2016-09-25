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


public class CommunityFragmentQuestion extends Fragment {

    public LinearLayout answer_layout, comments_layout_5;

    public EditText search_text_post_question;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.community_fragment_question, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        search_text_post_question = (EditText) view.findViewById(R.id.search_text_post_question);
        answer_layout = (LinearLayout) view.findViewById(R.id.answer_layout);
        comments_layout_5 = (LinearLayout) view.findViewById(R.id.comments_layout_5);


        search_text_post_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QuestionPostActivity.class);
                startActivity(intent);
            }
        });

        answer_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QuestionWriteAnswerActivity.class);
                startActivity(intent);
            }
        });

        comments_layout_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QuestionCommentsActivity.class);
                startActivity(intent);
            }
        });


    }

}

