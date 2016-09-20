package com.example.developer.comivo.activities.activities_for_login;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.developer.comivo.R;


public class PasscodeActivity extends Activity{

    public Button btnConfirm;

    public EditText first_char, second_char, third_char, fourth_char, mPinHiddenEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.passcode_activity);



        first_char = (EditText) findViewById(R.id.first_char);
        second_char = (EditText) findViewById(R.id.second_char);
        third_char = (EditText) findViewById(R.id.third_char);
        fourth_char = (EditText) findViewById(R.id.fourth_char);

        first_char.getBackground().mutate().setColorFilter(getResources().getColor(R.color.white_color),
                PorterDuff.Mode.SRC_ATOP);
        second_char.getBackground().mutate().setColorFilter(getResources().getColor(R.color.white_color),
                PorterDuff.Mode.SRC_ATOP);
        third_char.getBackground().mutate().setColorFilter(getResources().getColor(R.color.white_color),
                PorterDuff.Mode.SRC_ATOP);
        fourth_char.getBackground().mutate().setColorFilter(getResources().getColor(R.color.white_color),
                PorterDuff.Mode.SRC_ATOP);


        btnConfirm = (Button) findViewById(R.id.btn_confirm_code);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first_char.length() == 0 && second_char.length() == 0
                        && third_char.length() == 0 && fourth_char.length() == 0) {
                    Toast.makeText(PasscodeActivity.this, "Please, enter your passcode", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(PasscodeActivity.this, ResetPasswordActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        });

    }

}
