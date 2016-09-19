package com.example.developer.comivo.activities.activities_for_login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.comivo.R;
import com.example.developer.comivo.ServerResponseParsing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import butterknife.internal.Utils;


public class SignUpActivity extends AppCompatActivity {

    public TextView member, privacy, pas_invalid, pass_not_match;
    public EditText confirm_pass, pass;
    public LinearLayout pass_border, confirm_pass_border;
    public Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.sign_up_activity);
        initViews();
    }


    private class UserRegistration extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {

            String data = getJSON("http://beta.comivo.com/mobileapi/account/register", 5000);

            return data;

        }


        @Override
        protected void onPostExecute(String responseString) {
            //super.onPostExecute(s);

            if (SignUpActivity.this.isFinishing()) {
                return;
            }

            ServerResponseParsing serverResponseParsing = ServerResponseParsing.getInstance();
            serverResponseParsing.parseSimpleResponse(responseString);

            Log.d("test LOG", "Parsed string: status " + serverResponseParsing.getStatus() +
                    " data " + serverResponseParsing.getData() +
                    " message " + serverResponseParsing.getMessage() +
                    " \n = " + responseString
            );

        }

        String otherParametersUrServiceNeed =  "FirstName=abc&LastName=xyz&Email=abc.xyz@gmail.com" +
                "&Password=Comivo123&Company=abcCtpl&AccountType=1&BusinessType=1";
        String request = "http://beta.comivo.com/mobileapi/account/register";

        public String getJSON(String url, int timeout) {
            HttpURLConnection c = null;
            try {
                URL u = new URL(url);
                c = (HttpURLConnection) u.openConnection();
                c.setReadTimeout(timeout);
                c.setConnectTimeout(timeout);
                c.setRequestMethod("POST");
                c.setRequestProperty("Content-Type", "application/json");
                c.setRequestProperty("platform", "android");
                c.setRequestProperty("version", "1.0.0");
                c.setUseCaches(false);
                c.setDoInput(true);
                c.setDoOutput(true);






                /*URL urlToRequest = new URL(urlStr);
    HttpURLConnection urlConnection = (HttpURLConnection)urlToRequest.openConnection();
    urlConnection.setDoOutput(true);
    urlConnection.setRequestMethod("POST");
    urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

    String postParamaters = "param1=value1&param2=value2"
    urlConnection.setFixedLengthStreamingMode(postParameters.getBytes().length);
    PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
    out.print(postParameters);
    out.close();

    urlConnection.connect();
*/




               /* Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("FirstName", "abc")
                        .appendQueryParameter("LastName", "xyz")
                        .appendQueryParameter("Email", "abc.xyz@gmail.com")
                        .appendQueryParameter("Password", "Comivo123")
                        .appendQueryParameter("Company", "abcCtpl")
                        .appendQueryParameter("AccountType", "1")
                        .appendQueryParameter("BusinessType", "1");
                String query = builder.build().getEncodedQuery();

                OutputStream os = c.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                c.connect();*/

                DataOutputStream wr = new DataOutputStream(c.getOutputStream ());
                wr.writeBytes(otherParametersUrServiceNeed);


                JSONObject jsonParam = new JSONObject();
                jsonParam.put("FirstName", "abc");
                jsonParam.put("LastName", "xyz");
                jsonParam.put("Email", "abc.xyz@gmail.com");
                jsonParam.put("Password", "Comivo123");
                jsonParam.put("Company", "abcCtpl");
                jsonParam.put("AccountType", "1");
                jsonParam.put("BusinessType", "1");
                wr.writeBytes(jsonParam.toString());

                wr.flush();
                wr.close();

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
            } catch (JSONException e) {
                e.printStackTrace();
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
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

    private void initViews() {

        btnSignUp = (Button) findViewById(R.id.btn_sign_up);
        pass = (EditText) findViewById(R.id.pass);
        confirm_pass = (EditText) findViewById(R.id.confirm_pass);

        final String password = pass.getText().toString();
        final String confirmPassword = confirm_pass.getText().toString();


        final CheckBox checkPrivacy = (CheckBox) findViewById(R.id.checked_privacy);


        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(SignUpActivity.this);
                View layout = inflater.inflate(R.layout.password_warning_dialog, null);
                final AlertDialog MyDialog;
                AlertDialog.Builder MyBuilder = new AlertDialog.Builder(SignUpActivity.this);
                MyBuilder.setView(layout);
                MyDialog = MyBuilder.create();
                MyDialog.show();
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.type_of_business, R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);

        /*buyerAcc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sellerAcc.setChecked(true);
            }
        });*/



        /*buyerAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buyerAcc.isChecked()){
                    sellerAcc.setChecked(false);
                    buyerAcc.setChecked(true);
                } else {
                    buyerAcc.setChecked(false);
                    sellerAcc.setChecked(true);
                }
            }
        });

        if (buyerAcc.isChecked()){
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("USER_TYPE",1);
            editor.commit();
            int type = sharedPreferences.getInt("USER_TYPE",-1);
            Log.d("acc","++++++++++++++++++++++++++++1234"+type);
        } else {
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("USER_TYPE",2);
            editor.commit();
            int type = sharedPreferences.getInt("USER_TYPE",-1);
            Log.d("acc","++++++++++++++++++++++++++++1234"+type);
        }*/

            checkPrivacy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkPrivacy.isChecked()) {
                        checkPrivacy.setChecked(true);
                        btnSignUp.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                validateNewPass(password, confirmPassword);
                                new UserRegistration().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                                /*Intent intent = new Intent(SignUpActivity.this, ThanksSandingActivity.class);
                                startActivity(intent);*/
                            }
                        });
                    }
                }
            });


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(SignUpActivity.this, "Please, tap \"I agree to abide by Comivo LLC'S\"", Toast.LENGTH_SHORT).show();
            }
        });

        member = (TextView) findViewById(R.id.tv_memberships);
        member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MembershipActivity.class);
                startActivity(intent);
            }
        });
        privacy = (TextView) findViewById(R.id.tv_privacy);
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, PrivacyActivity.class);
                startActivity(intent);
            }
        });



        pas_invalid = (TextView) findViewById(R.id.pass_invalid);
        pass_not_match = (TextView) findViewById(R.id.pass_not_match);
        pass_border = (LinearLayout) findViewById(R.id.pass_border);
        confirm_pass_border = (LinearLayout) findViewById(R.id.confirm_pass_border);



            /*confirm_pass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pass.setVisibility(View.GONE);
                    confirm_pass.setVisibility(View.GONE);
                    pas_invalid.setVisibility(View.VISIBLE);
                    pass_not_match.setVisibility(View.VISIBLE);
                    pass_border.setVisibility(View.VISIBLE);
                    confirm_pass_border.setVisibility(View.VISIBLE);
                }
            });*/

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
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }


    public String validateNewPass(String pass1, String pass2) {
        StringBuilder retVal = new StringBuilder();

        if (pass1.length() < 1 || pass2.length() < 1) retVal.append("Empty fields <br>");

        if (pass1 != null && pass2 != null) {

            if (pass1.equals(pass2)) {

                pass1 = pass2;
                boolean hasUppercase = !pass1.equals(pass1.toLowerCase());
                boolean hasLowercase = !pass1.equals(pass1.toUpperCase());
                boolean hasNumber = pass1.matches(".*\\d.*");
                boolean noSpecialChar = pass1.matches("[a-zA-Z0-9 ]*");

                if (pass1.length() < 8) {
                    retVal.append("Password is too short. Needs to have 8 characters <br>");
                }

                if (!hasUppercase) {
                    retVal.append("Password needs an upper case <br>");
                }

                if (!hasLowercase) {
                    retVal.append("Password needs a lowercase <br>");
                }

                if (!hasNumber) {
                    retVal.append("Password needs a number <br>");
                }

                if (noSpecialChar) {
                    retVal.append("Password needs a special character i.e. !,@,#, etc.  <br>");
                }
            } else {
                retVal.append("Passwords don't match<br>");
            }
        } else {
            retVal.append("Passwords Null <br>");
        }
        if (retVal.length() == 0) {
            retVal.append("Success");
        }

        return retVal.toString();

    }
}


