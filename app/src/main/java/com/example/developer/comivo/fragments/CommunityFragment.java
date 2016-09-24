package com.example.developer.comivo.fragments;

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
import com.example.developer.comivo.activities.activities_for_settings.SettingsActivity;


public class CommunityFragment extends Fragment {

    public TextView timeline_tab,post_tab,
            answer_tab, question_tab, chemical_tab, text_steel, tv_post, text_steel2;


    public LinearLayout tabs_for_community, linear2,
            comments_button, share_button, layout_comm, layout_comments_4,
            answer_layout, comments_layout_5, post_linear, quest_linear,
            answ_linear;

    public ScrollView scroll_timeline, scroll_post, scroll_answer, scroll_question,
            scroll_chemical;

    public TextView tv_text_post, text_steel_4, some_text_4, tv_answer_4, textView291, textView292, textView293,
            textView294, textView296, textView297;

    public EditText search_text_post_question;

    public RelativeLayout selected_relative;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.community_fragment, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        text_steel = (TextView) view.findViewById(R.id.text_steel);
        tv_post = (TextView) view.findViewById(R.id.tv_post);
        text_steel2 = (TextView) view.findViewById(R.id.text_steel2);
        tv_text_post = (TextView) view.findViewById(R.id.tv_text_post3);

        text_steel_4 = (TextView) view.findViewById(R.id.text_steel_4);
        some_text_4 = (TextView) view.findViewById(R.id.some_text_4);
        tv_answer_4 = (TextView) view.findViewById(R.id.tv_answer_4);

        linear2 = (LinearLayout) view.findViewById(R.id.linear2);
        comments_button = (LinearLayout) view.findViewById(R.id.layout_comments);
        share_button = (LinearLayout) view.findViewById(R.id.layout_share);
        layout_comm = (LinearLayout) view.findViewById(R.id.layout_comments2);

        layout_comments_4 = (LinearLayout) view.findViewById(R.id.layout_comments_4);

        search_text_post_question = (EditText) view.findViewById(R.id.search_text_post_question);
        answer_layout = (LinearLayout) view.findViewById(R.id.answer_layout);
        comments_layout_5 = (LinearLayout) view.findViewById(R.id.comments_layout_5);


        post_linear = (LinearLayout) view.findViewById(R.id.post_linear3);
        quest_linear = (LinearLayout) view.findViewById(R.id.quest_linear3);
        answ_linear = (LinearLayout) view.findViewById(R.id.answ_linear3);
        selected_relative = (RelativeLayout) view.findViewById(R.id.selected_relative);



        tabs_for_community = (LinearLayout) view.findViewById(R.id.tabs_for_community);
        tabs_for_community.setPressed(true);


        scroll_timeline = (ScrollView) view.findViewById(R.id.scroll_timeline);
        scroll_post = (ScrollView) view.findViewById(R.id.scroll_post);
        scroll_answer = (ScrollView) view.findViewById(R.id.scroll_answer);
        scroll_question = (ScrollView) view.findViewById(R.id.scroll_question);
        scroll_chemical = (ScrollView) view.findViewById(R.id.scroll_chemical);

        timeline_tab = (TextView) view.findViewById(R.id.timeline_tab);
        post_tab = (TextView) view.findViewById(R.id.post_tab);
        answer_tab = (TextView) view.findViewById(R.id.answer_tab);
        question_tab = (TextView) view.findViewById(R.id.question_tab);
        chemical_tab = (TextView) view.findViewById(R.id.chemical_tab);

        timeline_tab.setTextColor(getResources().getColor(R.color.green_color));
        post_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
        answer_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
        question_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
        chemical_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

        timeline_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scroll_timeline.setVisibility(View.VISIBLE);
                scroll_post.setVisibility(View.GONE);
                scroll_answer.setVisibility(View.GONE);
                scroll_question.setVisibility(View.GONE);
                scroll_chemical.setVisibility(View.GONE);

                timeline_tab.setTextColor(getResources().getColor(R.color.green_color));
                post_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                answer_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                question_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                chemical_tab.setTextColor(getResources().getColor(R.color.colorSecondary));


            }
        });

        post_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scroll_timeline.setVisibility(View.GONE);
                scroll_post.setVisibility(View.VISIBLE);
                scroll_answer.setVisibility(View.GONE);
                scroll_question.setVisibility(View.GONE);
                scroll_chemical.setVisibility(View.GONE);

                timeline_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                post_tab.setTextColor(getResources().getColor(R.color.green_color));
                answer_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                question_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                chemical_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

            }
        });

        answer_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scroll_timeline.setVisibility(View.GONE);
                scroll_post.setVisibility(View.GONE);
                scroll_answer.setVisibility(View.VISIBLE);
                scroll_question.setVisibility(View.GONE);
                scroll_chemical.setVisibility(View.GONE);


                timeline_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                post_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                answer_tab.setTextColor(getResources().getColor(R.color.green_color));
                question_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                chemical_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

            }
        });

        question_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scroll_timeline.setVisibility(View.GONE);
                scroll_post.setVisibility(View.GONE);
                scroll_answer.setVisibility(View.GONE);
                scroll_question.setVisibility(View.VISIBLE);
                scroll_chemical.setVisibility(View.GONE);

                timeline_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                post_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                answer_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                question_tab.setTextColor(getResources().getColor(R.color.green_color));
                chemical_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

            }
        });

        chemical_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scroll_timeline.setVisibility(View.GONE);
                scroll_post.setVisibility(View.GONE);
                scroll_answer.setVisibility(View.GONE);
                scroll_question.setVisibility(View.GONE);
                scroll_chemical.setVisibility(View.VISIBLE);

                timeline_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                post_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                answer_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                question_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                chemical_tab.setTextColor(getResources().getColor(R.color.green_color));

            }
        });

        text_steel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TimelinePostDetailsActivity.class);
                startActivity(intent);
            }
        });

        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TimelinePostDetailsActivity.class);
                startActivity(intent);
            }
        });

        comments_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TimelineCommentsActivity.class);
                startActivity(intent);
            }
        });

        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ShareActivity.class);
                startActivity(intent);
            }
        });


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

