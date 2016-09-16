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

public class PrivacyActivity extends AppCompatActivity {
    public Button btn_Deny, btn_Agree;


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


        BackendManager backendManager = BackendManager.getInstance();
        backendManager.getPrivacyPolicy().enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                ServerResponseParsing serverResponseParsing = ServerResponseParsing.getInstance();
                serverResponseParsing.parseMembershipAndPrivacy(response.body().string());

                Log.d("LOG", "Parsed string: status " + serverResponseParsing.getStatus() +
                        " cmsType " + serverResponseParsing.getCmsPageTypeId() +
                        " title" + serverResponseParsing.getTitle() +
                        " content" + serverResponseParsing.getContent() +
                        " isActive" + serverResponseParsing.getIsActive() +
                        " type" + serverResponseParsing.getType() +
                        " message" + serverResponseParsing.getMessage());
            }
        });




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


}
