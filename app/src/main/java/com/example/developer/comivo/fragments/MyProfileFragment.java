package com.example.developer.comivo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.developer.comivo.R;
import com.example.developer.comivo.activities.activities_for_settings.EducationActivity;
import com.example.developer.comivo.activities.activities_for_settings.ExperienceActivity;
import com.example.developer.comivo.activities.activities_for_settings.LanguageActivity;
import com.example.developer.comivo.activities.activities_for_settings.MyContactActivity;
import com.example.developer.comivo.models.UserModel;


public class MyProfileFragment extends Fragment{

    public LinearLayout myContactLayout, experienceLayout,
            educationLayout, languageLayout;

    public TextView user_name_text_view, company_name_text_view;
    public ImageView my_photo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_profile_fragment, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        UserModel userModel = UserModel.getInstance();

        ImageView editPhoto = (ImageView) view.findViewById(R.id.edit_photo);

        myContactLayout = (LinearLayout) view.findViewById(R.id.myContactLayout);
        experienceLayout = (LinearLayout) view.findViewById(R.id.experienceLayout);
        educationLayout = (LinearLayout) view.findViewById(R.id.educationLayout);
        languageLayout = (LinearLayout) view.findViewById(R.id.languageLayout);

        my_photo = (ImageView) view.findViewById(R.id.my_photo);
        user_name_text_view = (TextView) view.findViewById(R.id.user_name_text_view);
        company_name_text_view = (TextView) view.findViewById(R.id.company_name_text_view);

        String fullName = userModel.getFirstName() + " " + userModel.getLastName();
        String companyName = userModel.getCompanyName();

        user_name_text_view.setText(fullName);
        company_name_text_view.setText(companyName);
        Glide.with(this).load(userModel.getProfileImage()).into(my_photo);


        myContactLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MyContactActivity.class);
                startActivity(intent);
            }
        });

        experienceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ExperienceActivity.class);
                startActivity(intent);
            }
        });

        educationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EducationActivity.class);
                startActivity(intent);
            }
        });

        languageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LanguageActivity.class);
                startActivity(intent);
            }
        });

        editPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = LayoutInflater.from(getContext());
                View layout = inflater.inflate(R.layout.edit_photo_dialog, null);
                final AlertDialog MyDialog;
                final AlertDialog.Builder MyBuilder = new AlertDialog.Builder(getContext());
                MyBuilder.setView(layout);

                LinearLayout takeAPhoto = (LinearLayout) layout.findViewById(R.id.take_photo_layout);
                LinearLayout loadFromGallery = (LinearLayout) layout.findViewById(R.id.choose_from_galery_layout);
                LinearLayout deletePhoto = (LinearLayout) layout.findViewById(R.id.delete_photo_layout);
                Button cancel = (Button) layout.findViewById(R.id.btnCancel);
                MyDialog = MyBuilder.create();
                MyDialog.getWindow().setLayout(400, 300);

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyDialog.cancel();
                    }
                });

                MyDialog.show();

            }
        });

    }

}
