package com.example.developer.comivo.activities.activities_for_settings;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.developer.comivo.R;
import com.example.developer.comivo.models.UserModel;
import com.example.developer.comivo.network.BackendManager;
import com.example.developer.comivo.network.ServerResponseParsing;
import com.example.developer.comivo.network.settingsParsing.SettingsResponseParsing;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class AboutCompanyActivity extends AppCompatActivity {

    public TextView tv_company_name, tv_website, tv_description;

    public ImageView iv_left, iv_right, iv_company_logo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
        initViews();
    }

    private void initViews(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        LinearLayout editLayout = (LinearLayout) findViewById(R.id.edit_layout);

        tittle.setText(R.string.about);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        toolbar.getParent();
        toolbar.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final UserModel userModel = UserModel.getInstance();
        String userId = String.valueOf(userModel.getUserId());

        tv_company_name = (TextView) findViewById(R.id.tv_company_name);
        tv_website = (TextView) findViewById(R.id.tv_website);
        tv_description = (TextView) findViewById(R.id.tv_description);

        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_right = (ImageView) findViewById(R.id.iv_right);
        iv_company_logo = (ImageView) findViewById(R.id.iv_company_logo);

        BackendManager backendManager = BackendManager.getInstance();
        backendManager.getCompanyInfo(Integer.parseInt(userId)).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                /*Log.e("COMPANY","---------------------------------------------\n" + response.body().string());*/

                final SettingsResponseParsing settingsResponseParsing = SettingsResponseParsing.getInstance();
                settingsResponseParsing.parseUserprofileCompany(response.body().string());

                if (settingsResponseParsing.getStatus().equals("4")){

                    final String companyId = settingsResponseParsing.getCompanyId();
                    final String companyName = settingsResponseParsing.getCompanyName();
                    final String website = settingsResponseParsing.getWebsite();
                    final String description = settingsResponseParsing.getDescription();
                    final String imageURL = settingsResponseParsing.getImageURL();

                    String photo1 = settingsResponseParsing.getPhotos1();
                    String photo2 = settingsResponseParsing.getPhotos2();

                    runOnUiThread(new Runnable() {
                        public void run() {
                            if (!companyName.isEmpty()){
                                userModel.setCompanyName(companyName);
                                tv_company_name.setText(companyName);
                            } else {
                                tv_company_name.setText(" ");
                            }
                            if (!website.isEmpty()){
                                userModel.setWebsite(website);
                                tv_website.setText(website);
                            }else {
                                tv_website.setText(" ");
                            }
                            if (!description.isEmpty()){
                                userModel.setDescription(description);
                                tv_description.setText(description);
                            }else {
                                tv_description.setText(" ");
                            }
                            if (!imageURL.isEmpty()){
                                userModel.setImageUrl(imageURL);
                                Glide.with(AboutCompanyActivity.this).load(imageURL).into(iv_company_logo);
                            }

                            if (!companyId.isEmpty()){
                                userModel.setCompanyId(companyId);
                            }
                        }
                    });

                } else {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(AboutCompanyActivity.this, settingsResponseParsing.getMessage(), Toast.LENGTH_LONG).show();                                        }
                    });
                }

            }
        });


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutCompanyActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        editLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutCompanyActivity.this, EditAboutCompanyActivity.class);
                startActivity(intent);
            }
        });

    }


}
