package com.example.developer.comivo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.developer.comivo.activities.activities_for_login.LoginActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivityNew;
import com.example.developer.comivo.models.UserModel;
import com.example.developer.comivo.network.settingsParsing.SettingsResponseParsing;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.anim);
        Glide.with(this).load(R.drawable.loader).asGif().into(imageView);

        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = telephonyManager.getDeviceId();

        final UserModel userModel = UserModel.getInstance();
        userModel.setDeviceId(deviceId);
        userModel.setDevice_model(android.os.Build.MODEL);
        userModel.setPlatform("Android");
        userModel.setVersion(android.os.Build.VERSION.RELEASE);
        userModel.setManufacturer(android.os.Build.PRODUCT);
        userModel.setApp_version(BuildConfig.VERSION_NAME);

        // Testing JSON parsing
        /*String json = "{\n" +
                " \"Status\": 4,\n" +
                " \"Data\": {\n" +
                " \"CompanyId\": 123,\n" +
                " \"CompanyName\": \"Test\",\n" +
                " \"Website\": \"www.google.com\",\n" +
                " \"Description\": \"Test Description\",\n" +
                " \"ImageUrl\": \"152baf2c-55f5-4d7a-9a8d-ddc80e21db80.jpg\",\n" +
                " \"Photoes\": [\n" +
                " 5,\n" +
                " 6\n" +
                " ]\n" +
                " },\n" +
                " \"Message\": null\n" +
                " }";
        SettingsResponseParsing parser = SettingsResponseParsing.getInstance();
        parser.parseUserprofileCompany(json);*/

        new Timer().schedule(new TimerTask(){
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    public void run() {

                        if (userModel.isNewUser()){
                            Log.e("user", "user already exist");
                            startActivity(new Intent(MainActivity.this, MessageActivityNew.class));
                            finish();
                        } else {
                            Log.e("new user", "new user");
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            finish();
                        }
                    }
                });
            }
        }, 5000);

    }


}
