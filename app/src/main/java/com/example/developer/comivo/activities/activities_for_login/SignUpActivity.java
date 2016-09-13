package com.example.developer.comivo.activities.activities_for_login;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
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
import android.widget.CompoundButton;
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
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        EditText pass = (EditText) findViewById(R.id.pass);
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(SignUpActivity.this);
                View layout = inflater.inflate(R.layout.password_warning_dialog, null);
                final AlertDialog MyDialog;
                AlertDialog.Builder MyBuilder = new AlertDialog.Builder(SignUpActivity.this);
                MyBuilder.setView(layout);
                MyDialog = MyBuilder.create();
                MyDialog.getWindow().setLayout(400, 300);
                MyDialog.show();
            }
        });
        /*sellerAcc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                buyerAcc.setChecked(false);
                SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("USER_TYPE",1);
                editor.apply();
                int type = sharedPreferences.getInt("USER_TYPE",-1);
                Log.d("acc","++++++++++++++++++++++++++++1234"+type);
            }
        });

        buyerAcc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sellerAcc.setChecked(false);
                SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("USER_TYPE",2);
                editor.apply();
                int type = sharedPreferences.getInt("USER_TYPE",-1);
                Log.d("acc","++++++++++++++++++++++++++++4321"+type);
            }
        });*/


        /*buyerAcc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sellerAcc.setChecked(true);
            }
        });*/



        /*buyerAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buyerAcc.isChecked()){
                    sellerAcc.setChecked(false);
                    buyerAcc.setChecked(true);
                } else {
                    buyerAcc.setChecked(false);
                    sellerAcc.setChecked(true);
                }
            }
        });

        if (buyerAcc.isChecked()){
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("USER_TYPE",1);
            editor.commit();
            int type = sharedPreferences.getInt("USER_TYPE",-1);
            Log.d("acc","++++++++++++++++++++++++++++1234"+type);
        } else {
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("USER_TYPE",2);
            editor.commit();
            int type = sharedPreferences.getInt("USER_TYPE",-1);
            Log.d("acc","++++++++++++++++++++++++++++1234"+type);
        }*/

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

    public String validateNewPass(String pass1, String pass2){
        StringBuilder retVal = new StringBuilder();

        if(pass1.length() < 1 || pass2.length() < 1 )retVal.append("Empty fields <br>");

        if (pass1 != null && pass2 != null) {

            if (pass1.equals(pass2)) {

                pass1 = pass2;
                boolean hasUppercase = !pass1.equals(pass1.toLowerCase());
                boolean hasLowercase = !pass1.equals(pass1.toUpperCase());
                boolean hasNumber = pass1.matches(".*\\d.*");
                boolean noSpecialChar = pass1.matches("[a-zA-Z0-9 ]*");

                if (pass1.length() < 11) {
                    retVal.append("Password is too short. Needs to have 11 characters <br>");
                }

                if (!hasUppercase) {
                    retVal.append("Password needs an upper case <br>");
                }

                if (!hasLowercase) {
                    retVal.append("Password needs a lowercase <br>");
                }

                if (!hasNumber) {
                    retVal.append("Password needs a number <br>");
                }

                if(noSpecialChar){
                    retVal.append("Password needs a special character i.e. !,@,#, etc.  <br>");
                }
            }else{
                retVal.append("Passwords don't match<br>");
            }
        }else{
            retVal.append("Passwords Null <br>");
        }
        if(retVal.length() == 0){
            retVal.append("Success");
        }

        return retVal.toString();

    }


}
