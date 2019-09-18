package com.amaz.jobsaround.ui.activities.job_seeker_register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amaz.jobsaround.R;
import com.amaz.jobsaround.ui.activities.RulesActivity;
import com.amaz.jobsaround.ui.activities.owner_register.OwnerRegisterActivity;
import com.amaz.jobsaround.ui.fragments.map_dialog.MapDialogFragment;

public class JobSeekerRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker_register);

    }

    public void onClick(View view) {
        startActivity(new Intent(JobSeekerRegisterActivity.this, RulesActivity.class));
    }

    public void openMap() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        Fragment mapRegisterFragment = getSupportFragmentManager().findFragmentByTag("map_fragment");

        if (mapRegisterFragment != null ){
            fragmentTransaction.remove(mapRegisterFragment);
        }
        fragmentTransaction.addToBackStack(null);

        DialogFragment dialogFragment = new MapDialogFragment();
        dialogFragment.show(fragmentTransaction,"map_fragment");

    }

    public void onClick1(View view) {
        openMap();
    }
}
