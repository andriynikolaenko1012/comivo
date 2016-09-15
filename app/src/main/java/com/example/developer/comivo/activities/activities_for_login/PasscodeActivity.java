package com.example.developer.comivo.activities.activities_for_login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.developer.comivo.R;


public class PasscodeActivity extends Activity {

    public Button btnConfirm;

    public EditText first_char, second_char, third_char, fourth_char;

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
                Intent intent = new Intent(PasscodeActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
