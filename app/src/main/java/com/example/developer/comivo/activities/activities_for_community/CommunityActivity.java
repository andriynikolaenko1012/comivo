package com.example.developer.comivo.activities.activities_for_community;


import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_buyers_acc.BuyersAccActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivity;
import com.example.developer.comivo.activities.activities_for_reviews.ReviewsActivity;
import com.example.developer.comivo.activities.activities_for_settings.SettingsActivity;

public class CommunityActivity extends AppCompatActivity {

    public TextView message_tv;
    public TextView reviews_tv;
    public TextView community_tv;
    public TextView account_tv;
    public TextView timeline_tab;
    public TextView post_tab;
    public TextView answer_tab;
    public TextView question_tab;
    public TextView chemical_tab;
    public TextView text_steel;
    public TextView tv_post;
    public TextView text_steel2;

    public ImageView message_iv, reviews_iv, community_iv, account_iv;

    public LinearLayout layout_for_buttons, layout_for_reviews_button,
            layout_for_community_button, layout_for_account_button,
            layout_for_message_button, tabs_for_community, linear2,
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.community_layout);
        initViews();
    }



    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText(R.string.community);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_header_menu_icon);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        message_tv = (TextView) findViewById(R.id.message_tv_3);
        reviews_tv = (TextView) findViewById(R.id.reviews_tv_3);
        community_tv = (TextView) findViewById(R.id.community_tv_3);
        account_tv = (TextView) findViewById(R.id.account_tv_3);


        text_steel = (TextView) findViewById(R.id.text_steel);
        tv_post = (TextView) findViewById(R.id.tv_post);
        text_steel2 = (TextView) findViewById(R.id.text_steel2);
        tv_text_post = (TextView) findViewById(R.id.tv_text_post3);

        text_steel_4 = (TextView) findViewById(R.id.text_steel_4);
        some_text_4 = (TextView) findViewById(R.id.some_text_4);
        tv_answer_4 = (TextView) findViewById(R.id.tv_answer_4);

        message_iv = (ImageView) findViewById(R.id.message_iv_3);
        reviews_iv = (ImageView) findViewById(R.id.reviews_iv_3);
        community_iv = (ImageView) findViewById(R.id.community_iv_3);
        account_iv = (ImageView) findViewById(R.id.account_iv_3);

        layout_for_buttons = (LinearLayout) findViewById(R.id.layout_for_buttons_3);
        layout_for_message_button = (LinearLayout) findViewById(R.id.layout_for_message_button_3);
        layout_for_reviews_button = (LinearLayout) findViewById(R.id.layout_for_reviews_button_3);
        layout_for_community_button = (LinearLayout) findViewById(R.id.layout_for_community_button_3);
        layout_for_account_button = (LinearLayout) findViewById(R.id.layout_for_account_button_3);

        linear2 = (LinearLayout) findViewById(R.id.linear2);
        comments_button = (LinearLayout) findViewById(R.id.layout_comments);
        share_button = (LinearLayout) findViewById(R.id.layout_share);
        layout_comm = (LinearLayout) findViewById(R.id.layout_comments2);

        layout_comments_4 = (LinearLayout) findViewById(R.id.layout_comments_4);

        search_text_post_question = (EditText) findViewById(R.id.search_text_post_question);
        answer_layout = (LinearLayout) findViewById(R.id.answer_layout);
        comments_layout_5 = (LinearLayout) findViewById(R.id.comments_layout_5);


        post_linear = (LinearLayout) findViewById(R.id.post_linear3);
        quest_linear = (LinearLayout) findViewById(R.id.quest_linear3);
        answ_linear = (LinearLayout) findViewById(R.id.answ_linear3);
        selected_relative = (RelativeLayout) findViewById(R.id.selected_relative);



        tabs_for_community = (LinearLayout) findViewById(R.id.tabs_for_community);
        tabs_for_community.setPressed(true);

        community_tv.setTextColor(getResources().getColor(R.color.colorMain));
        community_iv.setImageResource(R.drawable.community_pressed_icon);
        message_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
        message_iv.setImageResource(R.drawable.messages_icon);
        reviews_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
        reviews_iv.setImageResource(R.drawable.reviews_icon);
        account_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
        account_iv.setImageResource(R.drawable.account_icon);


        layout_for_reviews_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_for_message_button.setPressed(false);
                layout_for_reviews_button.setPressed(true);
                layout_for_community_button.setPressed(false);
                layout_for_account_button.setPressed(false);

                message_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                reviews_tv.setTextColor(getResources().getColor(R.color.colorMain));
                community_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                account_tv.setTextColor(getResources().getColor(R.color.colorSecondary));

                message_iv.setImageResource(R.drawable.messages_icon);
                reviews_iv.setImageResource(R.drawable.reviews_pressed_icon);
                community_iv.setImageResource(R.drawable.community_icon);
                account_iv.setImageResource(R.drawable.account_icon);

                Intent intent = new Intent(CommunityActivity.this, ReviewsActivity.class);
                startActivity(intent);
                finish();

            }
        });

        layout_for_account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_for_message_button.setPressed(false);
                layout_for_reviews_button.setPressed(false);
                layout_for_community_button.setPressed(false);
                layout_for_account_button.setPressed(true);

                message_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                reviews_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                community_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                account_tv.setTextColor(getResources().getColor(R.color.colorMain));

                message_iv.setImageResource(R.drawable.messages_icon);
                reviews_iv.setImageResource(R.drawable.reviews_icon);
                community_iv.setImageResource(R.drawable.community_icon);
                account_iv.setImageResource(R.drawable.accounts_pressed_icon);

                Intent intent = new Intent(CommunityActivity.this, BuyersAccActivity.class);
                startActivity(intent);
                finish();
            }
        });

        layout_for_message_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_for_message_button.setPressed(true);
                layout_for_reviews_button.setPressed(false);
                layout_for_community_button.setPressed(false);
                layout_for_account_button.setPressed(false);

                message_tv.setTextColor(getResources().getColor(R.color.colorMain));
                reviews_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                community_tv.setTextColor(getResources().getColor(R.color.colorSecondary));
                account_tv.setTextColor(getResources().getColor(R.color.colorSecondary));

                message_iv.setImageResource(R.drawable.message_pressed_icon);
                reviews_iv.setImageResource(R.drawable.reviews_icon);
                community_iv.setImageResource(R.drawable.community_icon);
                account_iv.setImageResource(R.drawable.account_icon);

                Intent intent = new Intent(CommunityActivity.this, MessageActivity.class);
                startActivity(intent);
                finish();
            }
        });


        scroll_timeline = (ScrollView) findViewById(R.id.scroll_timeline);
        scroll_post = (ScrollView) findViewById(R.id.scroll_post);
        scroll_answer = (ScrollView) findViewById(R.id.scroll_answer);
        scroll_question = (ScrollView) findViewById(R.id.scroll_question);
        scroll_chemical = (ScrollView) findViewById(R.id.scroll_chemical);

        timeline_tab = (TextView) findViewById(R.id.timeline_tab);
        post_tab = (TextView) findViewById(R.id.post_tab);
        answer_tab = (TextView) findViewById(R.id.answer_tab);
        question_tab = (TextView) findViewById(R.id.question_tab);
        chemical_tab = (TextView) findViewById(R.id.chemical_tab);

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
                Intent intent = new Intent(CommunityActivity.this, TimelinePostDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, TimelinePostDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        comments_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, TimelineCommentsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, ShareActivity.class);
                startActivity(intent);
                finish();
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });


        layout_comm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, PostCommentsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tv_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, PostWriteActivity.class);
                startActivity(intent);
                finish();
            }
        });
        text_steel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, PostDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        tv_text_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, PostDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        text_steel_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, AnswerDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        some_text_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, AnswerDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tv_answer_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, AnswerPostActivity.class);
                startActivity(intent);
                finish();
            }
        });

        layout_comments_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, AnswerCommentsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        search_text_post_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, QuestionPostActivity.class);
                startActivity(intent);
                finish();
            }
        });

        answer_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, QuestionWriteAnswerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        comments_layout_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, QuestionCommentsActivity.class);
                startActivity(intent);
                finish();
            }
        });


        post_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, ChemicalDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        quest_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, ChemicalQuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });

        answ_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, ChemicalAnswerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        selected_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunityActivity.this, ChemicalSelectedActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText &&
                !v.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + v.getLeft() - scrcoords[0];
            float y = ev.getRawY() + v.getTop() - scrcoords[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom())
                hideKeyboard(this);
        }
        return super.dispatchTouchEvent(ev);
    }

    public static void hideKeyboard(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }
}
