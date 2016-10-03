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
import android.widget.Toast;

import com.example.developer.comivo.activities.activities_for_messages.MessageActivityNew;
import com.example.developer.comivo.network.BackendManager;
import com.example.developer.comivo.R;
import com.example.developer.comivo.network.ServerResponseParsing;
import com.example.developer.comivo.models.UserModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class LoginActivity extends Activity{

    public TextView forgot_passw_tv;
    public Button log_in, sign_in, failed_log_in;
    private CheckBox keepLoggedIn;
    private EditText etEmail, etPass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.login_activity);
        initViews();
    }

    private void initViews(){

        final UserModel userModel = UserModel.getInstance();

        etEmail  = (EditText)findViewById(R.id.email_login);
        etPass  = (EditText)findViewById(R.id.passw_login);

        etEmail.setText("comivobuyer@gmail.com");
        etPass.setText("Com!vo01");

        keepLoggedIn = (CheckBox) findViewById(R.id.keep_me_logged_in);

        keepLoggedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel userModel = UserModel.getInstance();
                userModel.setNewUser(false);
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
                if (isFieldsValidate()) {

                    String email = etEmail.getText().toString();

                    String password = etPass.getText().toString();

                    String deviceId = userModel.getDeviceId();

                    BackendManager backendManager = BackendManager.getInstance();
                    backendManager.getLoginValidation(email, password, deviceId).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {

                            /*Log.e("LOGIN","---------------------------------------------\n" + response.body().string());*/

                            ServerResponseParsing serverResponseParsing = ServerResponseParsing.getInstance();
                            serverResponseParsing.parseLoginValidate(response.body().string());

                            if (serverResponseParsing.getStatus().equals("1")||serverResponseParsing.getStatus().equals("3")){
                                Log.e("test 1 3", serverResponseParsing.getData());
                                runOnUiThread(new Runnable() {
                                    public void run() {
                                        Toast.makeText(LoginActivity.this, "We don't recognize your Online ID and / or Password.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if (serverResponseParsing.getStatus().equals("2")){
                                Log.e("test 2", serverResponseParsing.getData());
                                runOnUiThread(new Runnable() {
                                    public void run() {
                                        Toast.makeText(LoginActivity.this, "Email is not confirm.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if (serverResponseParsing.getStatus().equals("4")){
                                Log.e("message", serverResponseParsing.getStatus());

                                if (serverResponseParsing.getTokenId() !=null) {
                                    userModel.setTokenId(Integer.parseInt(serverResponseParsing.getTokenId()));
                                }
                                if (serverResponseParsing.getProfileCoverImage() !=null) {
                                    userModel.setProfileCoverImage(serverResponseParsing.getProfileCoverImage());
                                }
                                if (serverResponseParsing.getProfileImage() !=null) {
                                    userModel.setProfileImage(serverResponseParsing.getProfileImage());
                                }
                                if (serverResponseParsing.getToken() !=null){
                                    userModel.setToken(serverResponseParsing.getToken());
                                }
                                if (serverResponseParsing.getFirstName() !=null){
                                    userModel.setFirstName(serverResponseParsing.getFirstName());
                                }
                                if (serverResponseParsing.getEmail() !=null){
                                    userModel.setEmail(serverResponseParsing.getEmail());
                                }
                                if (serverResponseParsing.getCompanyName() !=null) {
                                    userModel.setCompanyName(serverResponseParsing.getCompanyName());
                                }
                                if (serverResponseParsing.getLastName() !=null) {
                                    userModel.setLastName(serverResponseParsing.getLastName());
                                }
                                if (serverResponseParsing.getAccountType() !=null){
                                    userModel.setAccountType(Integer.parseInt(serverResponseParsing.getAccountType()));
                                }
                                if (serverResponseParsing.getNewUser() !=null){
                                    userModel.setNewUser(Boolean.parseBoolean(serverResponseParsing.getNewUser()));
                                }
                                if (serverResponseParsing.getUserId() !=null){
                                    userModel.setUserId(Integer.parseInt(serverResponseParsing.getUserId()));
                                }

                                Intent intent = new Intent(LoginActivity.this, MessageActivityNew.class);
                                startActivity(intent);

                                /*Intent intent = new Intent(LoginActivity.this, MessageActivityNew2.class);
                                startActivity(intent);*/

                            }

                            else if (serverResponseParsing.getStatus().equals("10")){
                                Log.e("test 10", serverResponseParsing.getData());
                                runOnUiThread(new Runnable() {
                                    public void run() {
                                        Toast.makeText(LoginActivity.this, "User is inactive. Please activate your account", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    });

                }
            }


        });

    }


    private boolean isFieldsValidate() {

        String email = etEmail.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        boolean hasUppercase = !etPass.getText().toString().equals(etPass.getText().toString().toLowerCase());
        boolean hasLowercase = !etPass.getText().toString().equals(etPass.getText().toString().toUpperCase());
        boolean hasNumber = etPass.getText().toString().matches(".*\\d.*");
        boolean noSpecialChar = etPass.getText().toString().matches("[a-zA-Z0-9 ]*");

        if (!email.matches(emailPattern)){
            etEmail.setError("Email not valid");
            return false;
        }

        if (etPass.getText().toString().isEmpty()) {
            etPass.setError("Password is required");
            etPass.setFocusable(true);
            return false;
        }

        if (etPass.getText().toString().length() < 8) {
            etPass.setError("Password is too short. Needs to have 8 characters");
            etPass.setFocusable(true);
            return false;
        }

        if (!hasUppercase) {
            etPass.setError("Password needs an upper case");
            etPass.setFocusable(true);
            return false;
        }

        if (!hasLowercase) {
            etPass.setError("Password needs a lowercase");
            etPass.setFocusable(true);
            return false;
        }

        if (!hasNumber) {
            etPass.setError("Password needs a number");
            etPass.setFocusable(true);
            return false;
        }

        if (noSpecialChar) {
            etPass.setError("Password needs a special character i.e. !,@,#, etc.");
            etPass.setFocusable(true);
            return false;
        }

        if (etEmail.getText().toString().isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.setFocusable(true);
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
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

}
