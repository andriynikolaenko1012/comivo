package com.example.developer.comivo.activities.activities_for_login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.comivo.network.BackendManager;
import com.example.developer.comivo.R;
import com.example.developer.comivo.network.ServerResponseParsing;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class SignUpActivity extends AppCompatActivity {

    public TextView member, privacy, pas_invalid, pass_not_match;
    public EditText etFirstName, etLastName, etEmail, etConfirmEmail, etPass, etConfirmPass,
                    etCompany;
    public LinearLayout pass_border, confirm_pass_border;
    public Button btnSignUp;

    public CheckBox buyer_acc, seller_acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.sign_up_activity);
        initViews();
    }


    private void initViews() {

        buyer_acc = (CheckBox) findViewById(R.id.buyer_acc);
        seller_acc = (CheckBox) findViewById(R.id.seller_acc);
        etFirstName = (EditText) findViewById(R.id.first_name);
        etLastName = (EditText) findViewById(R.id.last_name);
        etEmail = (EditText) findViewById(R.id.email);
        etConfirmEmail = (EditText) findViewById(R.id.confirm_email);
        etPass = (EditText) findViewById(R.id.pass);
        etConfirmPass = (EditText) findViewById(R.id.confirm_pass);
        etCompany = (EditText) findViewById(R.id.company);
        btnSignUp = (Button) findViewById(R.id.btn_sign_up);

        final CheckBox checkPrivacy = (CheckBox) findViewById(R.id.checked_privacy);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        final String accountType = spinner.getSelectedItem().toString();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView)v.findViewById(android.R.id.text1)).setText("");
                    ((TextView)v.findViewById(android.R.id.text1)).setTextSize(10);
                    ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount()));
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount()-1;
            }

        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Agency");
        adapter.add("Distributor");
        adapter.add("Business Type*");

        spinner.setAdapter(adapter);
        spinner.setSelection(adapter.getCount());

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner.getSelectedItem().toString().equals("Agency")){
                    buyer_acc.setChecked(true);
                    seller_acc.setChecked(false);
                    String accountType = "1";

                } else if (spinner.getSelectedItem().toString().equals("Distributor")){
                    seller_acc.setChecked(true);
                    buyer_acc.setChecked(false);
                    String accountType = "2";

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        buyer_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyer_acc.setChecked(true);
                seller_acc.setChecked(false);
                spinner.setSelection(0);
                String accountType = "1";
            }
        });

        seller_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyer_acc.setChecked(false);
                seller_acc.setChecked(true);
                spinner.setSelection(1);
                String accountType = "2";
            }
        });


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkPrivacy.isChecked()) {
                    Toast.makeText(SignUpActivity.this, "Please, tap \"I agree to abide by Comivo LLC'S\"", Toast.LENGTH_SHORT).show();
                } else {
                    if (isFieldsValidate()) {

                        Log.e("LOG", "is field validate");
                        String firstName = etFirstName.getText().toString();
                        String lastName = etLastName.getText().toString();
                        String email = etEmail.getText().toString();
                        String password = etPass.getText().toString();
                        String company = etCompany.getText().toString();

                        BackendManager backendManager = BackendManager.getInstance();
                        backendManager.getAccountRegistration(firstName, lastName, password, email, company, accountType).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                e.printStackTrace();
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                Log.e("LOGIN","---------------------------------------------\n" + response.body().string());
                                /*String s = response.body().string();*/
                                ServerResponseParsing serverResponseParsing = ServerResponseParsing.getInstance();
                                serverResponseParsing.parseSimpleResponse(response.body().string());

                                if (serverResponseParsing.getStatus().equals("4") && !serverResponseParsing.getData().equals("0")) {
                                    Intent intent = new Intent(SignUpActivity.this, ThanksSandingActivity.class);
                                    startActivity(intent);
                                }
                                else if (serverResponseParsing.getData().equals("0")){
                                    Log.e("test", serverResponseParsing.getData());
                                    runOnUiThread(new Runnable() {
                                        public void run() {
                                            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                            startActivity(intent);

                                            /*UserModel userModel = UserModel.getInstance();
                                            if (userModel.isNewUser()){
                                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                                startActivity(intent);
                                            } else {
                                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                                startActivity(intent);
                                                Toast.makeText(SignUpActivity.this, "This email already exist", Toast.LENGTH_SHORT).show();
                                            }*/

                                        }
                                    });
                                    
                                }


                            }
                        });
                    }


                }
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

    }

    private boolean isFieldsValidate() {

        boolean hasUppercase = !etPass.getText().toString().equals(etPass.getText().toString().toLowerCase());
        boolean hasLowercase = !etPass.getText().toString().equals(etPass.getText().toString().toUpperCase());
        boolean hasNumber = etPass.getText().toString().matches(".*\\d.*");
        boolean noSpecialChar = etPass.getText().toString().matches("[a-zA-Z0-9 ]*");

        String email = etEmail.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


        if (etFirstName.getText().toString().isEmpty()) {
            etFirstName.setError("First name is required");
            etFirstName.setFocusable(true);
            return false;
        }
        if (etLastName.getText().toString().isEmpty()) {
            etLastName.setError("Last name is required");
            etLastName.setFocusable(true);
            return false;
        }

        if (etEmail.getText().toString().isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.setFocusable(true);
            return false;
        }
        if (!etEmail.getText().toString().equals(etConfirmEmail.getText().toString())){
            Toast.makeText(SignUpActivity.this, "Emails are not matched", Toast.LENGTH_LONG).show();
            return false;
        }

        if (!email.matches(emailPattern)){
            etEmail.setError("Email not valid");
            return false;
        }

        if (etPass.getText().toString().isEmpty()) {
            etPass.setError("Password is required");
            etPass.setFocusable(true);
            return false;
        }

        if (etPass.getText().toString().length() < 8) {
            etPass.setError("Password is too short. Needs to have 8 characters");
            etPass.setFocusable(true);
            return false;
        }

        if (!etPass.getText().toString().equals(etConfirmPass.getText().toString())){
            pass_not_match.setVisibility(View.VISIBLE);
            etPass.setBackgroundResource(R.drawable.red_dark_border);
            etConfirmPass.setBackgroundResource(R.drawable.red_dark_border);
            return false;
        } else {
            pass_not_match.setVisibility(View.GONE);
            etPass.setBackgroundResource(R.color.color_text_views_background);
            etConfirmPass.setBackgroundResource(R.color.color_text_views_background);
        }

        if (!hasUppercase) {
            etPass.setError("Password needs an upper case");
            etPass.setFocusable(true);
            return false;
        }

        if (!hasLowercase) {
            etPass.setError("Password needs a lowercase");
            etPass.setFocusable(true);
            return false;
        }

        if (!hasNumber) {
            etPass.setError("Password needs a number");
            etPass.setFocusable(true);
            return false;
        }

        if (noSpecialChar) {
            etPass.setError("Password needs a special character i.e. !,@,#, etc.");
            etPass.setFocusable(true);
            return false;
        }

        if (etCompany.getText().toString().isEmpty()) {
            etCompany.setError("Company name is required");
            etCompany.setFocusable(true);
            return false;
        }

        return true;
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



}


