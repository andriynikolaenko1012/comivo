package com.example.developer.comivo.activities.activities_for_settings;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.developer.comivo.R;
import com.example.developer.comivo.models.UserModel;
import com.example.developer.comivo.network.BackendManager;
import com.example.developer.comivo.network.settingsParsing.SettingsResponseParsing;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class MyContactActivity extends AppCompatActivity {

    public TextView company_name_tv, primacy_email_tv, alternative_email_tv, tel_tv,
            cell_tv, address_tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_contact_activity);

        initViews();
    }



    private void initViews(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        ImageView editContact = (ImageView) findViewById(R.id.editContact);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);

        tittle.setText(R.string.my_contact);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        toolbar.getParent();
        toolbar.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        UserModel userModel = UserModel.getInstance();
        int userId = userModel.getUserId();

        BackendManager backendManager = BackendManager.getInstance();
        backendManager.getUserContact(userId).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                company_name_tv = (TextView) findViewById(R.id.company_name_tv);
                primacy_email_tv = (TextView) findViewById(R.id.primacy_email_tv);
                alternative_email_tv = (TextView) findViewById(R.id.alternative_email_tv);
                tel_tv = (TextView) findViewById(R.id.tel_tv);
                cell_tv = (TextView) findViewById(R.id.cell_tv);
                address_tv = (TextView) findViewById(R.id.address_tv);

                final SettingsResponseParsing settingsResponseParsing = SettingsResponseParsing.getInstance();
                settingsResponseParsing.parseUserProfileContact(response.body().string());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String companyName = settingsResponseParsing.getCompanyName();
                        String primaryEmail = settingsResponseParsing.getEmail();
                        String alternativeEmail = settingsResponseParsing.getAlternativeEmail();

                        String countryCode = settingsResponseParsing.getCountryCode();
                        String areaCode = settingsResponseParsing.getAreaCode();
                        String number =  settingsResponseParsing.getNumber();
                        String extension = settingsResponseParsing.getExtension();
                        String mobileNumber = countryCode + "-" + areaCode + "-" + number;
                        Log.e("mobile=============== ", mobileNumber);

                        String country_code = settingsResponseParsing.getMobileCountryCode();
                        String area_code = settingsResponseParsing.getMobileAreaCode();
                        String number_cell = settingsResponseParsing.getMobileNumber();
                        String extension_cell = settingsResponseParsing.getMobileExtension();
                        String cellNumber = country_code + "-" + area_code + "-" + number_cell;
                        Log.e("cell=============== ", cellNumber);

                        String address = settingsResponseParsing.getAddress();
                        String state = settingsResponseParsing.getState();
                        String city = settingsResponseParsing.getCity();
                        String zipCode = settingsResponseParsing.getZipCode();
                        String country = settingsResponseParsing.getCountryName();
                        String userAddress = zipCode + ", "+ address + ", "+ city + ", "+ state +", "+ country;
                        Log.e("userAddress ======== ", userAddress);

                        if (companyName.length() >0){
                            company_name_tv.setText(companyName);
                        } else {
                            company_name_tv.setText("");
                        }

                        if (primaryEmail.length() >0){
                            primacy_email_tv.setText(primaryEmail);
                        } else {
                            primacy_email_tv.setText("");
                        }

                        if (alternativeEmail.length() >0){
                            alternative_email_tv.setText(alternativeEmail);
                        } else {
                            alternative_email_tv.setText("");
                        }

                        if (mobileNumber.length() >0){
                            tel_tv.setText(mobileNumber);
                        } else {
                            tel_tv.setText("");
                        }

                        if (cellNumber.length() >0){
                            cell_tv.setText(cellNumber);
                        } else {
                            cell_tv.setText("");
                        }

                        if (userAddress.length() >0){
                            address_tv.setText(userAddress);
                        } else {
                            address_tv.setText("");
                        }
                    }
                });
            }
        });


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyContactActivity.this, MyProfileActivity.class);
                startActivity(intent);
            }
        });

        editContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyContactActivity.this, EditMyContactActivity.class);
                startActivity(intent);
            }
        });

    }
}
