package com.example.developer.comivo.activities.activities_for_reviews;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
import com.example.developer.comivo.activities.activities_for_community.CommunityActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivity;
import com.example.developer.comivo.activities.activities_for_settings.SettingsActivity;


public class ReviewsSearchActivity extends AppCompatActivity {

    public TextView message_tv, reviews_tv, community_tv, account_tv,
            reviews_tab, companies_tab;
    public ImageView message_iv, reviews_iv, community_iv, account_iv;
    public LinearLayout layout_for_buttons, layout_for_reviews_button,
            layout_for_community_button, layout_for_account_button,
            layout_for_message_button, tabs_for_review, not_verified_layout,
            verified_layout, layout2;
    public ScrollView scroll_for_companies, scroll_for_reviews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.reviews_search_layout);
        initViews();
    }



    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_header_menu_icon);

        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);

        final RelativeLayout tool_bar_searching = (RelativeLayout) findViewById(R.id.tool_bar_searching);

        TextView tool_bar_cancel = (TextView) findViewById(R.id.tool_bar_cancel);

        EditText tool_bar_search = (EditText) findViewById(R.id.tool_bar_search);

        tool_bar_searching.setVisibility(View.VISIBLE);
        leftButton.setVisibility(View.GONE);
        tittle.setVisibility(View.GONE);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        rightButton.setVisibility(View.GONE);

        tool_bar_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewsSearchActivity.this, ReviewsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tool_bar_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewsSearchActivity.this, ReviewsSearchResultsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        verified_layout = (LinearLayout) findViewById(R.id.verified_layout);
        not_verified_layout = (LinearLayout) findViewById(R.id.not_verified_layout);

        verified_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewsSearchActivity.this, VerifiedCompanyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        not_verified_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewsSearchActivity.this, NotVerifiedCompanyActivity.class);
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
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }
}
