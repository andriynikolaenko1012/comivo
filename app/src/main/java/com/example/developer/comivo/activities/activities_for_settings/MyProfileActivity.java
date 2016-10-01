package com.example.developer.comivo.activities.activities_for_settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.developer.comivo.R;
import com.example.developer.comivo.models.UserModel;
import com.example.developer.comivo.network.BackendManager;
import com.example.developer.comivo.network.communityParsing.CommunityResponseParsing;
import com.example.developer.comivo.network.settingsParsing.SettingsResponseParsing;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class MyProfileActivity extends AppCompatActivity {
    public LinearLayout myContactLayout, experienceLayout,
                        educationLayout, languageLayout;

    public TextView user_name_text_view, company_name_text_view, country_name_text_view;
    public ImageView my_photo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.my_profile_activity);

        initViews();

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


        final UserModel userModel = UserModel.getInstance();
        int userId = userModel.getUserId();

        my_photo = (ImageView) findViewById(R.id.my_photo);
        user_name_text_view = (TextView) findViewById(R.id.user_name_text_view);
        company_name_text_view = (TextView) findViewById(R.id.company_name_text_view);
        country_name_text_view = (TextView) findViewById(R.id.country_name_text_view);

        BackendManager backendManager = BackendManager.getInstance();
        backendManager.getUserProfile(userId).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final SettingsResponseParsing settingsResponseParsing = SettingsResponseParsing.getInstance();
                settingsResponseParsing.parseUserProfileDetail(response.body().string());

                Log.e("test LOG", "Parsed string: status " + settingsResponseParsing.getStatus() +
                        " userId " + settingsResponseParsing.getUserId() +
                        " userContactId " + settingsResponseParsing.getUserContactId() +
                        " firstName " + settingsResponseParsing.getFirstName() +
                        " lastName" + settingsResponseParsing.getLastName() +
                        " companyName " + settingsResponseParsing.getCompanyName() +
                        " countryName " + settingsResponseParsing.getCountryName() +
                        " photo " + settingsResponseParsing.getProfileImage() +
                        " message" + settingsResponseParsing.getMessage() );

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String firstName = settingsResponseParsing.getFirstName();
                        String lastName = settingsResponseParsing.getLastName();
                        String companyName = settingsResponseParsing.getCompanyName();
                        String countryName = settingsResponseParsing.getCountryName();
                        String userContactId = settingsResponseParsing.getUserContactId();
                        String photo = settingsResponseParsing.getProfileImage();

                        if (firstName !=null && lastName !=null){
                            user_name_text_view.setText(firstName + " " + lastName);
                            userModel.setFirstName(firstName);
                            userModel.setLastName(lastName);
                        } else {
                            user_name_text_view.setText("");
                        }

                        if (companyName !=null){
                            company_name_text_view.setText(companyName);
                            userModel.setCompanyName(companyName);
                        } else {
                            company_name_text_view.setText("");
                        }

                        if (photo != null) {
                            Glide.with(MyProfileActivity.this).load(photo).into(my_photo);
                            Log.e("photo ==============", settingsResponseParsing.getProfileImage());
                            userModel.setProfileImage(photo);
                        } else {
                            Glide.with(MyProfileActivity.this).load(R.drawable.ic_user_icon_test).into(my_photo);
                        }

                        if (countryName !=null){
                            country_name_text_view.setText(countryName);
                            userModel.setCountryName(countryName);
                        } else {
                            country_name_text_view.setText("");
                        }
                    }
                });

            }
        });

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
                ImageView cancel = (ImageView) layout.findViewById(R.id.btnCancel);
                MyDialog = MyBuilder.create();

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
