package com.example.developer.comivo.activities.activities_for_login;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.developer.comivo.BackendManager;
import com.example.developer.comivo.R;
import com.example.developer.comivo.ServerResponseParsing;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MembershipActivity extends AppCompatActivity {
    public Button btnDeny, btnAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.membership_agree_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        tittle.setText(R.string.membership);

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
                Intent intent = new Intent(MembershipActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnDeny = (Button) findViewById(R.id.btnDeny);
        btnAgree = (Button) findViewById(R.id.btnAgree);
        btnDeny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MembershipActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MembershipActivity.this, PrivacyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        BackendManager backendManager = BackendManager.getInstance();
        backendManager.getMemberShip().enqueue(new Callback() {
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

    }

}
