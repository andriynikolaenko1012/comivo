package com.example.developer.comivo.activities.activities_for_buyers_acc;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
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
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_community.CommunityActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivity;
import com.example.developer.comivo.activities.activities_for_reviews.ReviewsActivity;
import com.example.developer.comivo.activities.activities_for_settings.SettingsActivity;


public class InquiriesEditActivity extends AppCompatActivity{

    public LinearLayout lin70, lll28, first_button, second_button;

    public ImageView image_first, image_second;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.inquiries_edit_layout);
        initViews();
    }



    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText(R.string.inquiries);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        lin70 = (LinearLayout) findViewById(R.id.lin70);
        lll28 = (LinearLayout) findViewById(R.id.lll28);
        first_button = (LinearLayout) findViewById(R.id.first_button);
        second_button = (LinearLayout) findViewById(R.id.second_button);

        image_first = (ImageView) findViewById(R.id.image_first);
        image_second = (ImageView) findViewById(R.id.image_second);


        first_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_first.setImageResource(R.drawable.test_18_icon);
                image_second.setImageResource(R.drawable.test_19_icon);
                lll28.setVisibility(View.VISIBLE);
                lin70.setVisibility(View.GONE);
            }
        });

        second_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_first.setImageResource(R.drawable.test_19_icon);
                image_second.setImageResource(R.drawable.test_18_icon);
                lin70.setVisibility(View.VISIBLE);
                lll28.setVisibility(View.GONE);
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InquiriesEditActivity.this, BuyersAccActivity.class);
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
