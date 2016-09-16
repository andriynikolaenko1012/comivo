package com.example.developer.comivo.activities.activities_for_login;


import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.developer.comivo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PrivacyActivity extends AppCompatActivity {
    public Button btn_Deny, btn_Agree;

    private final String baseUrl = "http://beta.comivo.com/mobileapi/";
    String api9 = "cms/cmstype?type=Privacy_Policy";
    OkHttpClient client;
    private Request request;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.privacy_policy_activity);

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

        client = new OkHttpClient();

        try {
            getRequest(baseUrl + api9);
            } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void getRequest(String url) throws IOException {
        request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("platform", "Android")
                .addHeader("version", "1.0.0")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("LOG", "onResponse " + response.body().string());
                /*String s = response.body().string();
                parseString(s);*/
            }
        });
    }


    private void parseString(String string) {
        try {
            JSONObject jsonObject = new JSONObject(string);
            String status = jsonObject.getString("Status");
            String data = jsonObject.getString("Data");
            String message = jsonObject.getString("Message");
            Log.d("LOG", "Parsed string: status " + status + " data " + data + " message" + message);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}
