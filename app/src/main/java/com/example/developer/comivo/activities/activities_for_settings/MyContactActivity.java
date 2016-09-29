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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.developer.comivo.R;
import com.example.developer.comivo.models.UserModel;


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

        String companyName = userModel.getCompanyName();
        String primaryEmail = userModel.getEmail();
        String alternativeEmail = userModel.getAlternativeEmail();

        String countryCode = String.valueOf(userModel.getCountryCode());
        String areaCode = String.valueOf(userModel.getAreaCode());
        String number = String.valueOf(userModel.getNumber());
        String extension = String.valueOf(userModel.getExtension());
        String phoneNumber = countryCode + "-" + areaCode + "-" + number + "-" + extension;

        String country_code = String.valueOf(userModel.getCellCountryCode());
        String area_code = String.valueOf(userModel.getCellAreaCode());
        String number_cell = String.valueOf(userModel.getCellNumber());
        String extension_cell = String.valueOf(userModel.getCellExtension());
        String cellNumber = country_code + " " + area_code + " " + number_cell + " " + extension_cell;

        String address = userModel.getAddress();
        String state = userModel.getState();
        String city = userModel.getCity();
        String zipCode = String.valueOf(userModel.getZipCode());
        String country = userModel.getCountryName();
        String userAddress = zipCode + ", "+ address + ", "+ state + ", "+ city +", "+ country;

        company_name_tv = (TextView) findViewById(R.id.company_name_tv);
        primacy_email_tv = (TextView) findViewById(R.id.primacy_email_tv);
        alternative_email_tv = (TextView) findViewById(R.id.alternative_email_tv);
        tel_tv = (TextView) findViewById(R.id.tel_tv);
        cell_tv = (TextView) findViewById(R.id.cell_tv);
        address_tv = (TextView) findViewById(R.id.address_tv);

        if (companyName != null){
            company_name_tv.setText(companyName);
        } else {
            company_name_tv.setText("");
        }

        if (primaryEmail != null){
            primacy_email_tv.setText(primaryEmail);
        } else {
            primacy_email_tv.setText("");
        }

        if (alternativeEmail != null){
            alternative_email_tv.setText(alternativeEmail);
        } else {
            alternative_email_tv.setText("");
        }

        if (phoneNumber.length() == 0){
            tel_tv.setText(phoneNumber);
        } else {
            tel_tv.setText("");
        }

        if (phoneNumber.length() == 0){
            cell_tv.setText(cellNumber);
        } else {
            cell_tv.setText("");
        }

        if (phoneNumber.length() == 0){
            address_tv.setText(userAddress);
        } else {
            address_tv.setText("");
        }


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
