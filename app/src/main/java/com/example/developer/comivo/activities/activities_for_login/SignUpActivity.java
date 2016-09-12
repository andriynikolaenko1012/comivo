package com.example.developer.comivo.activities.activities_for_login;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivity;


public class SignUpActivity extends AppCompatActivity {
    
    public TextView member, privacy;
    public Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.sign_up_activity);
        initViews();

    }

    private void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        btnSignUp = (Button) findViewById(R.id.btn_sign_up);
        final CheckBox buyerAcc = (CheckBox) findViewById(R.id.buyer_acc);
        final CheckBox sellerAcc = (CheckBox) findViewById(R.id.seller_acc);
        final CheckBox checkPrivacy = (CheckBox) findViewById(R.id.checked_privacy);
        tittle.setText(R.string.app_name);

        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        buyerAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buyerAcc.isChecked()){
                    sellerAcc.setChecked(false);
                    buyerAcc.setChecked(true);

                }
            }
        });

        sellerAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sellerAcc.isChecked()){
                    buyerAcc.setChecked(false);
                    sellerAcc.setChecked(true);

                    Intent intent = new Intent(SignUpActivity.this, MessageActivity.class);
                    intent.putExtra("check", true);

                }
            }
        });


        checkPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPrivacy.isChecked()){
                    checkPrivacy.setChecked(true);
                    btnSignUp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(SignUpActivity.this, ThanksSandingActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        });

        /*Intent my_intent = new Intent();
        my_intent.putExtra("checkbox_state",true);*/

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUpActivity.this, "Please, tap \"I agree to abide by Comivo LLC'S\"", Toast.LENGTH_SHORT).show();
            }
        });

        member = (TextView) findViewById(R.id.tv_memberships);
        member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MembershipActivity.class);
                startActivity(intent);
            }
        });
        privacy = (TextView) findViewById(R.id.tv_privacy);
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, PrivacyActivity.class);
                startActivity(intent);
            }
        });


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
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

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) SignUpActivity.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(SignUpActivity.this.getComponentName()));
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }

}
