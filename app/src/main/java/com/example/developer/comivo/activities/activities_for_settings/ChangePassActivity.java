package com.example.developer.comivo.activities.activities_for_settings;

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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_login.LoginActivity;
import com.example.developer.comivo.models.UserModel;
import com.example.developer.comivo.network.BackendManager;
import com.example.developer.comivo.network.ServerResponseParsing;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class ChangePassActivity extends AppCompatActivity {

    public EditText etCurrentPass, etNewPass, etConfirmPass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_pass_activity);
        initViews();
    }

    private void initViews(){



        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        TextView btnSubmit = (TextView) findViewById(R.id.btn_submit);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        tittle.setText(R.string.reset_password);
        toolbar.getParent();
        toolbar.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        etCurrentPass = (EditText) findViewById(R.id.etCurrentPass);
        etNewPass = (EditText) findViewById(R.id.etNewPass);
        etConfirmPass = (EditText) findViewById(R.id.etConfirmPass);
        final UserModel userModel = UserModel.getInstance();
        final String userId = String.valueOf(userModel.getUserId());
        final String new_pass = etNewPass.getText().toString();
        final String confirm_pass = etConfirmPass.getText().toString();

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangePassActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFieldsValidate()){

                    BackendManager backendManager = BackendManager.getInstance();
                    backendManager.getChangePassword(userId, new_pass, confirm_pass).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            ServerResponseParsing serverResponseParsing = ServerResponseParsing.getInstance();
                            serverResponseParsing.parseSimpleResponse(response.body().string());
                            if (serverResponseParsing.getStatus().equals("4") && serverResponseParsing.getData().equals("0")){
                                Intent intent = new Intent(ChangePassActivity.this, LoginActivity.class);
                                userModel.setPassword(new_pass);
                                startActivity(intent);
                                finish();
                            } else if (serverResponseParsing.getStatus().equals("4") && serverResponseParsing.getData().equals("1")){
                                runOnUiThread(new Runnable() {
                                    public void run() {
                                        Toast.makeText(ChangePassActivity.this, "Invalid old password", Toast.LENGTH_LONG).show();                                        }
                                });
                            }


                        }
                    });


                }

            }
        });
    }

    private boolean isFieldsValidate() {
        UserModel userModel = UserModel.getInstance();
        String userPassword = userModel.getPassword();


        boolean hasUppercase = !etCurrentPass.getText().toString().equals(etCurrentPass.getText().toString().toLowerCase());
        boolean hasUppercase2 = !etNewPass.getText().toString().equals(etNewPass.getText().toString().toLowerCase());
        boolean hasLowercase = !etCurrentPass.getText().toString().equals(etCurrentPass.getText().toString().toUpperCase());
        boolean hasLowercase2 = !etNewPass.getText().toString().equals(etNewPass.getText().toString().toUpperCase());
        boolean hasNumber = etCurrentPass.getText().toString().matches(".*\\d.*");
        boolean hasNumber2 = etNewPass.getText().toString().matches(".*\\d.*");
        boolean noSpecialChar = etCurrentPass.getText().toString().matches("[a-zA-Z0-9 ]*");
        boolean noSpecialChar2 = etNewPass.getText().toString().matches("[a-zA-Z0-9 ]*");

        if (etCurrentPass.getText().toString().isEmpty()) {
            etCurrentPass.setError("Password is required");
            etCurrentPass.setFocusable(true);
            return false;
        }

        if (!etCurrentPass.getText().toString().equals(userPassword)){
            etCurrentPass.setError("Current password must be such as existing");
            etCurrentPass.setFocusable(true);
            return false;
        }

        if (etNewPass.getText().toString().length() < 8) {
            etNewPass.setError("Password is too short. Needs to have 8 characters");
            etNewPass.setFocusable(true);
            return false;
        }

        if (etNewPass.getText().toString().isEmpty()) {
            etNewPass.setError("Password is required");
            etNewPass.setFocusable(true);
            return false;
        }


        if (etCurrentPass.getText().toString().length() < 8) {
            etCurrentPass.setError("Password is too short. Needs to have 8 characters");
            etCurrentPass.setFocusable(true);
            return false;
        }

        if (!hasUppercase) {
            etNewPass.setError("Password needs an upper case");
            etNewPass.setFocusable(true);
            return false;
        }

        if (!hasUppercase2) {
            etCurrentPass.setError("Password needs an upper case");
            etCurrentPass.setFocusable(true);
            return false;
        }

        if (!hasLowercase) {
            etNewPass.setError("Password needs a lowercase");
            etNewPass.setFocusable(true);
            return false;
        }

        if (!hasLowercase2) {
            etCurrentPass.setError("Password needs a lowercase");
            etCurrentPass.setFocusable(true);
            return false;
        }

        if (!hasNumber) {
            etNewPass.setError("Password needs a number");
            etNewPass.setFocusable(true);
            return false;
        }

        if (!hasNumber2) {
            etCurrentPass.setError("Password needs a number");
            etCurrentPass.setFocusable(true);
            return false;
        }

        if (noSpecialChar) {
            etNewPass.setError("Password needs a special character i.e. !,@,#, etc.");
            etNewPass.setFocusable(true);
            return false;
        }

        if (noSpecialChar2) {
            etCurrentPass.setError("Password needs a special character i.e. !,@,#, etc.");
            etCurrentPass.setFocusable(true);
            return false;
        }

        if (!etNewPass.getText().toString().equals(etConfirmPass.getText().toString())){
            Toast.makeText(ChangePassActivity.this, "Passwords didn't match", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (etCurrentPass.getText().toString().equals(etNewPass.getText().toString())){
            Toast.makeText(ChangePassActivity.this, "Password can't be the same", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
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
