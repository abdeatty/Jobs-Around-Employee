package com.amaz.jobsaround.ui.activities.owner_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amaz.jobsaround.R;
import com.amaz.jobsaround.ui.activities.RulesActivity;
import com.amaz.jobsaround.ui.activities.UserTypeActivity;
import com.amaz.jobsaround.ui.activities.job_seeker_register.JobSeekerRegisterActivity;

public class OwnerRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_register);
    }

    public void onClick(View view) {
        startActivity(new Intent(OwnerRegisterActivity.this, RulesActivity.class));
    }
}
