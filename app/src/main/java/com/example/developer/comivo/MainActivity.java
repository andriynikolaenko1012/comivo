package com.example.developer.comivo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.developer.comivo.activities.activities_for_login.LoginActivity;
import com.example.developer.comivo.activities.activities_for_messages.MessageActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        /*SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("DEVICE_ID", deviceId);
        editor.apply();*/

        /*String devId = sharedPreferences.getString("DEVICE_ID",deviceId);
        Log.d("Id","++++++++++++++++++++++++++++4321"+devId);*/

        new Timer().schedule(new TimerTask(){
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    public void run() {

                        if (userModel.isNewUser()){
                            Log.e("user", "user already exist");
                            startActivity(new Intent(MainActivity.this, MessageActivity.class));
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
