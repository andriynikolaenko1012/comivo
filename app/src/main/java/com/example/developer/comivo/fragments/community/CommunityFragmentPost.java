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


public class CommunityFragmentPost extends Fragment {

    public TextView tv_post, tv_text_post, text_steel2;

    public LinearLayout layout_comm;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.community_fragment_post, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        tv_post = (TextView) view.findViewById(R.id.tv_post);
        text_steel2 = (TextView) view.findViewById(R.id.text_steel2);
        tv_text_post = (TextView) view.findViewById(R.id.tv_text_post3);

        layout_comm = (LinearLayout) view.findViewById(R.id.layout_comments2);

        layout_comm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PostCommentsActivity.class);
                startActivity(intent);
            }
        });

        tv_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PostWriteActivity.class);
                startActivity(intent);
            }
        });
        text_steel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PostDetailsActivity.class);
                startActivity(intent);
            }
        });
        tv_text_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PostDetailsActivity.class);
                startActivity(intent);
            }
        });

    }

}

