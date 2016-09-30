package com.example.developer.comivo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.developer.comivo.R;
import com.example.developer.comivo.fragments.community.CommunityFragmentAnswer;
import com.example.developer.comivo.fragments.community.CommunityFragmentChemical;
import com.example.developer.comivo.fragments.community.CommunityFragmentPost;
import com.example.developer.comivo.fragments.community.CommunityFragmentQuestion;
import com.example.developer.comivo.fragments.community.CommunityFragmentTimeline;


public class CommunityFragment extends Fragment {

    public TextView timeline_tab,post_tab,answer_tab, question_tab, chemical_tab;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.community_fragment, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.my_container_community, new CommunityFragmentTimeline());
        ft.addToBackStack(null);
        ft.commit();

        timeline_tab = (TextView) view.findViewById(R.id.timeline_tab);
        post_tab = (TextView) view.findViewById(R.id.post_tab);
        answer_tab = (TextView) view.findViewById(R.id.answer_tab);
        question_tab = (TextView) view.findViewById(R.id.question_tab);
        chemical_tab = (TextView) view.findViewById(R.id.chemical_tab);

        timeline_tab.setTextColor(getResources().getColor(R.color.green_color));
        post_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
        answer_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
        question_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
        chemical_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

        timeline_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timeline_tab.setTextColor(getResources().getColor(R.color.green_color));
                post_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                answer_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                question_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                chemical_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.my_container_community, new CommunityFragmentTimeline());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        post_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timeline_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                post_tab.setTextColor(getResources().getColor(R.color.green_color));
                answer_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                question_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                chemical_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.my_container_community, new CommunityFragmentPost());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        answer_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timeline_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                post_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                answer_tab.setTextColor(getResources().getColor(R.color.green_color));
                question_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                chemical_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.my_container_community, new CommunityFragmentAnswer());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        question_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timeline_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                post_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                answer_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                question_tab.setTextColor(getResources().getColor(R.color.green_color));
                chemical_tab.setTextColor(getResources().getColor(R.color.colorSecondary));

                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.my_container_community, new CommunityFragmentQuestion());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        chemical_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timeline_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                post_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                answer_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                question_tab.setTextColor(getResources().getColor(R.color.colorSecondary));
                chemical_tab.setTextColor(getResources().getColor(R.color.green_color));

                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.my_container_community, new CommunityFragmentChemical());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }

}

