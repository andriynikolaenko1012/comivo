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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.network.commonParsing.CommonResponseParsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EditMyContactActivity extends AppCompatActivity{

    public EditText et_companyName, et_website, et_primacyEmail, et_countryCode, et_areaCode,
            et_number, et_extension, et_cell_country_code, et_cell_number, et_address, et_city,
            et_zipCode, et_stateProvince;

    public Spinner county_list;


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

        new getAllCountries().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

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

    private class getAllCountries extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            return getJSON("http://beta.comivo.com/mobileapi/countries", 5000);
        }


        @Override
        protected void onPostExecute(String responseString) {
            //super.onPostExecute(s);

            if (EditMyContactActivity.this.isFinishing()) {
                return;
            }

            CommonResponseParsing commonResponseParsing = CommonResponseParsing.getInstance();
            commonResponseParsing.parseCountriesList(responseString);

            for (int i = 0; i < commonResponseParsing.getCountriesList().size(); i+=4) {
                Log.e("test LOG", "Parsed string: status " + commonResponseParsing.getStatus() +
                        " countryId " + commonResponseParsing.getCountriesList().get(i) +
                        " countryName" + commonResponseParsing.getCountriesList().get(i +1) +
                        " countryPhoneCode" + commonResponseParsing.getCountriesList().get(i +2) +
                        " IsRequired" + commonResponseParsing.getCountriesList().get(i + 3) +
                        " message" + commonResponseParsing.getMessage() +
                        " \n = " + responseString
                );
            }

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
                            sb.append(line + "\n");
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
