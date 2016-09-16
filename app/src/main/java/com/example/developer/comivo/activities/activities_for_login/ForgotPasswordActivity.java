package com.example.developer.comivo.activities.activities_for_login;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.developer.comivo.BackendManager;
import com.example.developer.comivo.R;
import com.example.developer.comivo.ServerResponseParsing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ForgotPasswordActivity extends Activity {


    public LinearLayout back;
    public Button reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.forgot_password_activity);


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

                LayoutInflater inflater = LayoutInflater.from(ForgotPasswordActivity.this);
                View layout = inflater.inflate(R.layout.password_notification_dialog, null);
                final AlertDialog MyDialog;

                AlertDialog.Builder MyBuilder = new AlertDialog.Builder(ForgotPasswordActivity.this);
                MyBuilder.setView(layout);

                TextView btnOk = (TextView) layout.findViewById(R.id.btnOk);
                TextView btnCancel = (TextView) layout.findViewById(R.id.btnCancel);

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
