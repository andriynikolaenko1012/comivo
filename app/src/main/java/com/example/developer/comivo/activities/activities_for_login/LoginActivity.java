package com.example.developer.comivo.activities.activities_for_login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
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

import com.example.developer.comivo.BackendManager;
import com.example.developer.comivo.R;
import com.example.developer.comivo.ServerResponseParsing;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class LoginActivity extends Activity{

    public EditText editTextEmail, editTextPassw;
    public TextView forgot_passw_tv;
    public Button log_in, sign_in, failed_log_in;
    private CheckBox keepLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.login_activity);

        initViews();

    }

    private void initViews(){
        editTextEmail = (EditText)findViewById(R.id.email);
        editTextPassw = (EditText)findViewById(R.id.passw);
        keepLoggedIn = (CheckBox) findViewById(R.id.keep_me_logged_in);

        String edEmail = editTextEmail.getText().toString();
        String edPassword = editTextPassw.getText().toString();


        keepLoggedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        forgot_passw_tv = (TextView) findViewById(R.id.forgot_passw_tv);
        forgot_passw_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
        log_in = (Button) findViewById(R.id.btn_log_in);
        sign_in = (Button) findViewById(R.id.btn_sign_up);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        failed_log_in = (Button) findViewById(R.id.btn_failed);
        failed_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = LayoutInflater.from(LoginActivity.this);
                View layout = inflater.inflate(R.layout.login_warning_dialog, null);
                final AlertDialog MyDialog;
                AlertDialog.Builder MyBuilder = new AlertDialog.Builder(LoginActivity.this);
                TextView tv = (TextView) layout.findViewById(R.id.tv_forgot_pssw);
                ImageView close_icon = (ImageView) layout.findViewById(R.id.close_icon);
                MyBuilder.setView(layout);
                MyDialog = MyBuilder.create();

                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

                close_icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyDialog.cancel();

                    }
                });

                MyDialog.show();
            }
        });


        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BackendManager backendManager = BackendManager.getInstance();
                backendManager.getLoginValidation("Comivobuyer@gmail.com","Com!vo01","454sa4da4daa54d4d45asd45asd").enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        ServerResponseParsing serverResponseParsing = ServerResponseParsing.getInstance();
                        serverResponseParsing.parseLoginValidate(response.body().string());
                        Log.d("LOG", "Parsed string: status " + serverResponseParsing.getStatus() +
                                " firstName " + serverResponseParsing.getFirstName() +
                                " lastName " + serverResponseParsing.getLastName() +
                                " profileImage " + serverResponseParsing.getProfileImage() +
                                " profileCoverImage " + serverResponseParsing.getProfileCoverImage() +
                                " accountTipe " + serverResponseParsing.getAccountTipe() +
                                " newUser " + serverResponseParsing.getNewUser() +
                                " companyName " + serverResponseParsing.getCompanyName() +
                                " tokenId " + serverResponseParsing.getTokenId() +
                                " token " + serverResponseParsing.getToken() +
                                " email " + serverResponseParsing.getEmail() +
                                " message " + serverResponseParsing.getMessage());

                        Intent intent = new Intent(LoginActivity.this, MessageActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });

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
