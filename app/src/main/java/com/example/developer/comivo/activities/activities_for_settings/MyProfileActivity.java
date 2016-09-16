package com.example.developer.comivo.activities.activities_for_settings;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.developer.comivo.R;
import com.example.developer.comivo.ServerResponseParsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyProfileActivity extends AppCompatActivity {
    public LinearLayout myContactLayout, experienceLayout,
                        educationLayout, languageLayout;

    public TextView user_name_text_view, company_name_text_view;
    public ImageView my_photo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.my_profile_activity);

        new ProfileValidation().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        initViews();
    }

    private class ProfileValidation extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {

            String data = getJSON("http://beta.comivo.com/mobileapi/account/validatelogin?email=Comivobuyer@gmail.com&password=Com!vo01", 5000);

            return data;
        }


        @Override
        protected void onPostExecute(String responseString) {
            //super.onPostExecute(s);

            if (MyProfileActivity.this.isFinishing()) {
                return;
            }

            ServerResponseParsing serverResponseParsing = ServerResponseParsing.getInstance();
            serverResponseParsing.parseLoginValidate(responseString);

            Log.d("test LOG", "Parsed string: status " + serverResponseParsing.getStatus() +
                    " firstName " + serverResponseParsing.getFirstName() +
                    " lastName" + serverResponseParsing.getLastName() +
                    " profileImage" + serverResponseParsing.getProfileImage() +
                    " profileCoverImage" + serverResponseParsing.getProfileCoverImage() +
                    " accountType" + serverResponseParsing.getAccountType() +
                    " newUser" + serverResponseParsing.getNewUser() +
                    " companyName" + serverResponseParsing.getCompanyName() +
                    " tokenId" + serverResponseParsing.getTokenId() +
                    " token" + serverResponseParsing.getToken() +
                    " email" + serverResponseParsing.getEmail() +
                    " message" + serverResponseParsing.getMessage() +
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
                c.setRequestProperty("deviceId", "454sa4da4daa54d4d45asd45asd");
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



    private void initViews(){



        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        ImageView editPhoto = (ImageView) findViewById(R.id.edit_photo);

        myContactLayout = (LinearLayout) findViewById(R.id.myContactLayout);
        experienceLayout = (LinearLayout) findViewById(R.id.experienceLayout);
        educationLayout = (LinearLayout) findViewById(R.id.educationLayout);
        languageLayout = (LinearLayout) findViewById(R.id.languageLayout);

        tittle.setText(R.string.profile);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        toolbar.getParent();
        toolbar.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ImageView userPhoto = (ImageView) findViewById(R.id.my_photo);
        Glide.with(this).load(R.drawable.image_my_profile).into(userPhoto);

        user_name_text_view = (TextView) findViewById(R.id.user_name_text_view);
        company_name_text_view = (TextView) findViewById(R.id.company_name_text_view);
        my_photo = (ImageView) findViewById(R.id.my_photo);

        user_name_text_view.setText("COMIVO BUYER");
        company_name_text_view.setText("COMIVO BUYER");



        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfileActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        myContactLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfileActivity.this, MyContactActivity.class);
                startActivity(intent);
            }
        });

        experienceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfileActivity.this, ExperienceActivity.class);
                startActivity(intent);
            }
        });

        educationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfileActivity.this, EducationActivity.class);
                startActivity(intent);
            }
        });

        languageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfileActivity.this, LanguageActivity.class);
                startActivity(intent);
            }
        });

        editPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = LayoutInflater.from(MyProfileActivity.this);
                View layout = inflater.inflate(R.layout.edit_photo_dialog, null);
                final AlertDialog MyDialog;
                final AlertDialog.Builder MyBuilder = new AlertDialog.Builder(MyProfileActivity.this);
                MyBuilder.setView(layout);

                LinearLayout takeAPhoto = (LinearLayout) layout.findViewById(R.id.take_photo_layout);
                LinearLayout loadFromGallery = (LinearLayout) layout.findViewById(R.id.choose_from_galery_layout);
                LinearLayout deletePhoto = (LinearLayout) layout.findViewById(R.id.delete_photo_layout);
                Button cancel = (Button) layout.findViewById(R.id.btnCancel);
                MyDialog = MyBuilder.create();
                MyDialog.getWindow().setLayout(400, 300);

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyDialog.cancel();
                    }
                });

                MyDialog.show();

            }
        });
    }
}
