package com.example.developer.comivo.activities.activities_for_settings;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.network.ServerResponseParsing;
import com.example.developer.comivo.network.settingsParsing.SettingsResponseParsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QAActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q_a_activity);
        initViews();
    }

    private void initViews(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);

        tittle.setText(R.string.q_a);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        toolbar.getParent();
        toolbar.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        new FaQ().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QAActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

    }

    private class FaQ extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {

            String data = getJSON("http://beta.comivo.com/mobileapi/faq/list", 5000);


            return data;
        }


        @Override
        protected void onPostExecute(String responseString) {
            //super.onPostExecute(s);

            if (QAActivity.this.isFinishing()) {
                return;
            }

            SettingsResponseParsing settingsResponseParsing = SettingsResponseParsing.getInstance();
            settingsResponseParsing.parseFAQList(responseString);

            Log.e("test LOG", "Parsed string: status " + settingsResponseParsing.getStatus() +
                    " FAQSectionId " + settingsResponseParsing.getFAQSectionId() +
                    " FAQSectionTitle" + settingsResponseParsing.getFAQSectionTitle() +
                    " FAQBoxId" + settingsResponseParsing.getFAQBoxId() +
                    " FAQBoxTitle" + settingsResponseParsing.getFAQBoxTitle() +
                    " FAQId" + settingsResponseParsing.getFAQId() +
                    " question" + settingsResponseParsing.getQuestion() +
                    " answer" + settingsResponseParsing.getAnswer() +
                    " message" + settingsResponseParsing.getMessage() +
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
