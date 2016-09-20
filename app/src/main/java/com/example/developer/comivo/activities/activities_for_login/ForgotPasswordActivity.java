package com.example.developer.comivo.activities.activities_for_login;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.comivo.BackendManager;
import com.example.developer.comivo.R;
import com.example.developer.comivo.ServerResponseParsing;
import com.example.developer.comivo.UserModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ForgotPasswordActivity extends Activity {


    public LinearLayout back;
    public Button reset;

    public EditText emailForForgot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.forgot_password_activity);


        emailForForgot = (EditText) findViewById(R.id.email_for_forgot);

        UserModel userModel = UserModel.getInstance();
        final String user_email = userModel.getEmail();

        back = (LinearLayout) findViewById(R.id.back_to_login_activity);
        reset = (Button) findViewById(R.id.btn_reset_pass);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isFieldsValidate()) {

                    BackendManager backendManager = BackendManager.getInstance();
                    backendManager.getAccountForgotPass(user_email).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            ServerResponseParsing serverResponseParsing = ServerResponseParsing.getInstance();
                            serverResponseParsing.parseSimpleResponse(response.body().string());

                            if (serverResponseParsing.getStatus().equals("4")){
                                runOnUiThread(new Runnable() {
                                    public void run() {
                                        LayoutInflater inflater = LayoutInflater.from(ForgotPasswordActivity.this);
                                        View layout = inflater.inflate(R.layout.password_notification_dialog, null);
                                        final AlertDialog MyDialog;

                                        AlertDialog.Builder MyBuilder = new AlertDialog.Builder(ForgotPasswordActivity.this);
                                        MyBuilder.setView(layout);

                                        String email = emailForForgot.getText().toString();
                                        TextView btnOk = (TextView) layout.findViewById(R.id.btnOk);
                                        TextView btnCancel = (TextView) layout.findViewById(R.id.btnCancel);
                                        TextView tvEmail = (TextView) layout.findViewById(R.id.tv_email);
                                        tvEmail.setText(email);
                                        MyDialog = MyBuilder.create();

                                        btnOk.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent intent = new Intent(ForgotPasswordActivity.this, PasscodeActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        });

                                        btnCancel.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                MyDialog.cancel();
                                            }
                                        });

                                        MyDialog.show();
                                    }
                                });

                            }
                        }
                    });
                }

            }

        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    private boolean isFieldsValidate() {

        String email = emailForForgot.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


        if (!email.matches(emailPattern)){
            emailForForgot.setError("Email not valid");
            return false;
        }

        if (emailForForgot.getText().toString().isEmpty()) {
            emailForForgot.setError("Email is required");
            emailForForgot.setFocusable(true);
            return false;
        }

        return true;
    }

}
