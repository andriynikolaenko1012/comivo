package com.example.developer.comivo.activities.activities_for_sellers_acc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.developer.comivo.R;


public class OpportunityUpdateQuoteActivity extends AppCompatActivity{

    public RelativeLayout rel333, rel444;

    public LinearLayout first_button2, second_button2;

    public ImageView image_first2, image_second2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.opportunity_update_quote_layout);
        initViews();
    }



    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText(R.string.opportunities);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        rel333 = (RelativeLayout) findViewById(R.id.rel333);
        rel444 = (RelativeLayout) findViewById(R.id.rel444);

        first_button2 = (LinearLayout) findViewById(R.id.first_button2);
        second_button2 = (LinearLayout) findViewById(R.id.second_button2);

        image_first2 = (ImageView) findViewById(R.id.image_first2);
        image_second2 = (ImageView) findViewById(R.id.image_second2);

        first_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_first2.setImageResource(R.drawable.test_18_icon);
                image_second2.setImageResource(R.drawable.test_19_icon);
                rel333.setVisibility(View.VISIBLE);
                rel444.setVisibility(View.GONE);
            }
        });

        second_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_first2.setImageResource(R.drawable.test_19_icon);
                image_second2.setImageResource(R.drawable.test_18_icon);
                rel444.setVisibility(View.VISIBLE);
                rel333.setVisibility(View.GONE);
            }
        });



        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpportunityUpdateQuoteActivity.this, OpportunityDetailsActivity.class);
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
