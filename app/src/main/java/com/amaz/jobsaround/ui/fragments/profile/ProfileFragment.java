package com.amaz.jobsaround.ui.fragments.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amaz.jobsaround.R;
import com.amaz.jobsaround.ui.activities.FeesActivity;
import com.amaz.jobsaround.ui.activities.RulesActivity;
import com.amaz.jobsaround.ui.activities.create_job.CreateJobActivity;
import com.amaz.jobsaround.ui.activities.cv.CVActivity;
import com.amaz.jobsaround.ui.activities.favorite.FavoriteActivity;
import com.amaz.jobsaround.ui.activities.my_jobs.MyJobsActivity;


public class ProfileFragment extends Fragment {

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        view.findViewById(R.id.fav_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),FavoriteActivity.class));
            }
        });

        view.findViewById(R.id.my_jobs_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MyJobsActivity.class));
            }
        });


        view.findViewById(R.id.my_info_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), CVActivity.class));
            }
        });

        view.findViewById(R.id.add_job_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), CreateJobActivity.class));
            }
        });
        return view;
    }



}
