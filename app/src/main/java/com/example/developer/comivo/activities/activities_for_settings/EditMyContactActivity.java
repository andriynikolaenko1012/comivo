package com.example.developer.comivo.activities.activities_for_settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.comivo.R;
import com.example.developer.comivo.models.Country;
import com.example.developer.comivo.models.UserModel;
import com.example.developer.comivo.network.BackendManager;
import com.example.developer.comivo.network.commonParsing.CommonResponseParsing;
import com.example.developer.comivo.network.settingsParsing.SettingsResponseParsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class EditMyContactActivity extends AppCompatActivity{

    public EditText et_companyName, et_website, et_primacyEmail, et_countryCode, et_areaCode,
            et_number, et_extension, et_cell_country_code, et_cell_number, et_address, et_city,
            et_zipCode, et_stateProvince;

    public Spinner county_list;

    ArrayList<String> countrieslist;
    ArrayList<Country> country;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.edit_contact_activity);
        initViews();
    }

    private void initViews(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_tool_bar);
        TextView tittle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        ImageView leftButton = (ImageView) toolbar.findViewById(R.id.left_button);
        TextView btnSubmit = (TextView) findViewById(R.id.btnSubmit);

        tittle.setText(R.string.edit_contact);
        leftButton.setImageResource(R.drawable.ic_icon_arrow);
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(R.drawable.ic_search_button);
        toolbar.getParent();
        toolbar.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        et_companyName = (EditText) findViewById(R.id.et_companyName);
        et_website= (EditText) findViewById(R.id.et_website);
        et_primacyEmail= (EditText) findViewById(R.id.et_primacyEmail);
        et_countryCode= (EditText) findViewById(R.id.et_countryCode);
        et_areaCode= (EditText) findViewById(R.id.et_areaCode);
        et_number= (EditText) findViewById(R.id.et_number);
        et_extension= (EditText) findViewById(R.id.et_extension);
        et_cell_country_code= (EditText) findViewById(R.id.et_cell_country_code);
        et_cell_number= (EditText) findViewById(R.id.et_cell_number);
        et_address= (EditText) findViewById(R.id.et_address);
        et_city= (EditText) findViewById(R.id.et_city);
        et_zipCode= (EditText) findViewById(R.id.et_zipCode);
        et_stateProvince = (EditText) findViewById(R.id.et_stateProvince);
        county_list = (Spinner) findViewById(R.id.county_list);



        BackendManager backendManager = BackendManager.getInstance();
        backendManager.getCountries().enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final CommonResponseParsing commonResponseParsing = CommonResponseParsing.getInstance();
                commonResponseParsing.parseCountriesList(response.body().string());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        /*country = new ArrayList<Country>();
                        countrieslist = new ArrayList<String>();

                        Country countries = new Country();

                        countries.setId(commonResponseParsing.getCountryId());
                        countries.setName(commonResponseParsing.getCountryName());
                        countries.setTelephoneCode(String.valueOf(commonResponseParsing.getCountryPhoneCode()));
                        countries.setRequired(Boolean.parseBoolean(String.valueOf(commonResponseParsing.isRequired())));
                        country.add(countries);
                        countrieslist.add(commonResponseParsing.getCountryName());

                        county_list
                                .setAdapter(new ArrayAdapter<String>(EditMyContactActivity.this,
                                        android.R.layout.simple_spinner_dropdown_item,
                                        countrieslist));*/
                    }
                });

            }
        });


        /*send post request change my contact*/


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditMyContactActivity.this, MyContactActivity.class);
                startActivity(intent);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditMyContactActivity.this, MyContactActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

        @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText &&
                !v.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + v.getLeft() - scrcoords[0];
            float y = ev.getRawY() + v.getTop() - scrcoords[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom())
                hideKeyboard(this);
        }
        return super.dispatchTouchEvent(ev);
    }

    public static void hideKeyboard(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }
}
