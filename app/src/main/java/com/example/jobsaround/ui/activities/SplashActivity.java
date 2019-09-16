package com.example.jobsaround.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.jobsaround.R;
import com.example.jobsaround.ui.activities.Home.HomeActivity;
import com.example.jobsaround.ui.activities.job_seeker_register.JobSeekerRegisterActivity;

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

                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
            }
        },SPLASH_TIME_OUT);
    }
}
