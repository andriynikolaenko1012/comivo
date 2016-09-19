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

import com.example.developer.comivo.BackendManager;
import com.example.developer.comivo.R;
import com.example.developer.comivo.ServerResponseParsing;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.forgot_password_activity);

        new ForgotPassword().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        final EditText emailForgot = (EditText) findViewById(R.id.email_for_forgot);
        final String email = emailForgot.getText().toString();


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

                TextView tv_email = (TextView) layout.findViewById(R.id.tv_email);
                if (emailForgot.getText().length() > 5){
                    tv_email.setText(email);
                }

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

    private class ForgotPassword extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {

            String data = getJSON("http://beta.comivo.com/mobileapi/account/forgotpassword?email=Comivobuyer@gmail.com", 5000);


            return data;
        }


        @Override
        protected void onPostExecute(String responseString) {
            //super.onPostExecute(s);

            if (ForgotPasswordActivity.this.isFinishing()) {
                return;
            }

            ServerResponseParsing serverResponseParsing = ServerResponseParsing.getInstance();
            serverResponseParsing.parseSimpleResponse(responseString);

            Log.d("test LOG", "Parsed string: status " + serverResponseParsing.getStatus() +
                    " data " + serverResponseParsing.getData() +
                    " message " + serverResponseParsing.getMessage() +
                    " \n = " + responseString
            );
        }

        public String getJSON(String url, int timeout) {
            HttpURLConnection c = null;
            try {
                URL u = new URL(url);
                c = (HttpURLConnection) u.openConnection();
                c.setRequestMethod("GET");
                c.setRequestProperty("Content-length", "0");
                c.setRequestProperty("platform", "android");
                c.setRequestProperty("version", "1.0.0");
                c.setUseCaches(false);
                c.setAllowUserInteraction(false);
                c.setConnectTimeout(timeout);
                c.setReadTimeout(timeout);
                c.connect();
                int status = c.getResponseCode();

                switch (status) {
                    case 200:
                    case 201:
                        BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = br.readLine()) != null) {
                            sb.append(line+"\n");
                        }
                        br.close();
                        return sb.toString();
                }


            } catch (MalformedURLException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (c != null) {
                    try {
                        c.disconnect();
                    } catch (Exception ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            return null;
        }

    }

}
