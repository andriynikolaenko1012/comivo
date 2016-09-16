package com.example.developer.comivo.activities.activities_for_login;


import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
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

public class PrivacyActivity extends AppCompatActivity {
    public Button btn_Deny, btn_Agree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.privacy_policy_activity);


        new PrivacyPolicyAgreement().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        tittle.setText(R.string.privacy_policy);

        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        toolbar.getParent();
        toolbar.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrivacyActivity.this, MembershipActivity.class);
                startActivity(intent);
                finish();
            }
        });


        btn_Deny = (Button) findViewById(R.id.btn_Deny);
        btn_Agree = (Button) findViewById(R.id.btn_Agree);
        btn_Deny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrivacyActivity.this, MembershipActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn_Agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrivacyActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private class PrivacyPolicyAgreement extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {

            String data = getJSON("http://beta.comivo.com/mobileapi/cms/cmstype?type=Privacy_Policy", 5000);


            return data;
        }


        @Override
        protected void onPostExecute(String responseString) {
            //super.onPostExecute(s);

            if (PrivacyActivity.this.isFinishing()) {
                return;
            }

            ServerResponseParsing serverResponseParsing = ServerResponseParsing.getInstance();
            serverResponseParsing.parseMembershipAndPrivacy(responseString);

            Log.d("test LOG", "Parsed string: status " + serverResponseParsing.getStatus() +
                    " cmsType " + serverResponseParsing.getCmsPageTypeId() +
                    " title" + serverResponseParsing.getTitle() +
                    " content" + serverResponseParsing.getContent() +
                    " isActive" + serverResponseParsing.getIsActive() +
                    " type" + serverResponseParsing.getType() +
                    " message" + serverResponseParsing.getMessage() +
                    " \n = " + responseString
            );

            String data = serverResponseParsing.getContent();
            WebView webview = (WebView) findViewById(R.id.webViewPrivacy);
            webview.getSettings().setJavaScriptEnabled(true);

            webview.loadDataWithBaseURL("", data, "text/html", "UTF-8", "");
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


        /*private void aaaaa() {
            URL myURL = new URL(serviceURL);
            HttpURLConnection myURLConnection = (HttpURLConnection)myURL.openConnection();
            String userCredentials = "username:password";
            String basicAuth = "Basic " + new String(new Base64().encode(userCredentials.getBytes()));
            myURLConnection.setRequestProperty ("Authorization", basicAuth);
            myURLConnection.setRequestMethod("POST");
            myURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            myURLConnection.setRequestProperty("Content-Length", "" + postData.getBytes().length);
            myURLConnection.setRequestProperty("Content-Language", "en-US");
            myURLConnection.setUseCaches(false);
            myURLConnection.setDoInput(true);
            myURLConnection.setDoOutput(true);
        }*/
    }


}
