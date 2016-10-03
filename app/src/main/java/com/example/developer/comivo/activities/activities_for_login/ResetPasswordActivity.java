package com.example.developer.comivo.activities.activities_for_login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.developer.comivo.R;
import com.example.developer.comivo.models.UserModel;
import com.example.developer.comivo.network.BackendManager;
import com.example.developer.comivo.network.ServerResponseParsing;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class ResetPasswordActivity extends Activity {

    public Button btnChangePass;

    public EditText newPass, confirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.reset_password_activity);

        newPass = (EditText) findViewById(R.id.new_pass);
        confirmPass = (EditText) findViewById(R.id.conf_pass);

        final String new_pass = newPass.getText().toString();
        final String confirm_pass = confirmPass.getText().toString();

        final UserModel userModel = UserModel.getInstance();
        final String userId = String.valueOf(userModel.getUserId());
        btnChangePass = (Button) findViewById(R.id.btn_change_pass);
        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFieldsValidate()){

                    BackendManager backendManager = BackendManager.getInstance();
                    backendManager.getResetPassword(userId, new_pass, confirm_pass).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            ServerResponseParsing serverResponseParsing = ServerResponseParsing.getInstance();
                            serverResponseParsing.parseSimpleResponse(response.body().string());
                            if (serverResponseParsing.getStatus().equals("4") && serverResponseParsing.getData().equals("0")){
                                Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
                                userModel.setPassword(new_pass);
                                startActivity(intent);
                                finish();
                            } else if (serverResponseParsing.getStatus().equals("4") && serverResponseParsing.getData().equals("1")){
                                runOnUiThread(new Runnable() {
                                    public void run() {
                                        Toast.makeText(ResetPasswordActivity.this, "Invalid old password", Toast.LENGTH_LONG).show();                                        }
                                });
                            }


                        }
                    });


                }

            }
        });
    }

    private boolean isFieldsValidate() {

        boolean hasUppercase = !newPass.getText().toString().equals(newPass.getText().toString().toLowerCase());
        boolean hasLowercase = !newPass.getText().toString().equals(newPass.getText().toString().toUpperCase());
        boolean hasNumber = newPass.getText().toString().matches(".*\\d.*");
        boolean noSpecialChar = newPass.getText().toString().matches("[a-zA-Z0-9 ]*");

        if (newPass.getText().toString().isEmpty()) {
            newPass.setError("Password is required");
            newPass.setFocusable(true);
            return false;
        }

        if (newPass.getText().toString().length() < 8) {
            newPass.setError("Password is too short. Needs to have 8 characters");
            newPass.setFocusable(true);
            return false;
        }

        if (!hasUppercase) {
            newPass.setError("Password needs an upper case");
            newPass.setFocusable(true);
            return false;
        }

        if (!hasLowercase) {
            newPass.setError("Password needs a lowercase");
            newPass.setFocusable(true);
            return false;
        }

        if (!hasNumber) {
            newPass.setError("Password needs a number");
            newPass.setFocusable(true);
            return false;
        }

        if (noSpecialChar) {
            newPass.setError("Password needs a special character i.e. !,@,#, etc.");
            newPass.setFocusable(true);
            return false;
        }

        if (!newPass.getText().toString().equals(confirmPass.getText().toString())){
            Toast.makeText(ResetPasswordActivity.this, "Passwords didn't match", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
