package com.amaz.jobsaround.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amaz.jobsaround.R;

public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
    }

    // TODO remove method on click
    public void onClick(View view) {

        startActivity(new Intent(RulesActivity.this, FeesActivity.class));
    }
}
