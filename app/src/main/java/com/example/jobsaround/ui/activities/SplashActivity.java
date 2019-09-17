package com.example.jobsaround.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.jobsaround.R;
import com.example.jobsaround.ui.activities.Home.HomeActivity;
import com.example.jobsaround.ui.activities.chat.ChatActivity;
import com.example.jobsaround.ui.activities.cv.CVActivity;
import com.example.jobsaround.ui.activities.favorite.FavoriteActivity;
import com.example.jobsaround.ui.activities.job_details.JobDetailsActivity;
import com.example.jobsaround.ui.activities.job_seeker_register.JobSeekerRegisterActivity;
import com.example.jobsaround.ui.activities.my_jobs.MyJobsActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 2000; //2 SECS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this, CVActivity.class));
            }
        },SPLASH_TIME_OUT);
    }
}
