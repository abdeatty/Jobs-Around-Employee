package com.amaz.jobsaround.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amaz.jobsaround.R;
import com.amaz.jobsaround.ui.activities.Home.HomeActivity;

public class FeesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees);
    }

    //TODO remove onClick method
    public void onClick(View view) {
        startActivity(new Intent(FeesActivity.this, HomeActivity.class));
    }
}
