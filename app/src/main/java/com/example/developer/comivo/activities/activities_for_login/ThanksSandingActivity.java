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

import com.example.developer.comivo.BuildConfig;
import com.example.developer.comivo.R;
import com.example.developer.comivo.models.UserModel;
import com.example.developer.comivo.network.BackendManager;
import com.example.developer.comivo.network.ServerResponseParsing;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class ThanksSandingActivity extends AppCompatActivity {


    public Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.thanks_sanding_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tittle.setText(R.string.app_name);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        toolbar.getParent();
        toolbar.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final UserModel userModel = UserModel.getInstance();
        final String userId = String.valueOf(userModel.getUserId());
        final String device_id = userModel.getDeviceId();
        final String device_model = android.os.Build.MODEL;;
        final String platform = "Android";
        final String version = android.os.Build.VERSION.RELEASE;;
        final String manufacturer = android.os.Build.PRODUCT;
        final String app_version = BuildConfig.VERSION_NAME;

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThanksSandingActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BackendManager backendManager = BackendManager.getInstance();
                backendManager.getDeviceSave(userId,device_model, platform, device_id,
                        version, manufacturer, app_version).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final ServerResponseParsing serverResponseParsing = ServerResponseParsing.getInstance();
                        serverResponseParsing.parseSimpleResponse(response.body().string());
                        Log.e("response ======", response.body().string());

                        Intent intent = new Intent(ThanksSandingActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }
        });

    }

}
