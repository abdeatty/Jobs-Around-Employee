package com.amaz.jobsaround.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.amaz.jobsaround.R;
import com.amaz.jobsaround.ui.activities.job_seeker_register.JobSeekerRegisterActivity;
import com.amaz.jobsaround.ui.activities.login.LoginActivity;
import com.amaz.jobsaround.ui.activities.owner_register.OwnerRegisterActivity;

public class UserTypeActivity extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);




            /*
             * Request location permission, so that we can get the location of the
             * device. The result of the permission request is handled by a callback,
             * onRequestPermissionsResult.
             */
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                //get excuted every time but not first time
//                isLocationPermissionGranted = true;
//                Log.e(TAG, "getLocationPermission: permission granted" );


            } else {
                ActivityCompat.requestPermissions(UserTypeActivity.this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
            }
        }


    // TODO remove method on click
    public void onClick(View view) {
        startActivity(new Intent(UserTypeActivity.this, OwnerRegisterActivity.class));
    }

    public void onClick1(View view) {

        startActivity(new Intent(UserTypeActivity.this, JobSeekerRegisterActivity.class));
    }

    public void onClick3(View view) {

        startActivity(new Intent(UserTypeActivity.this , LoginActivity.class));
    }
}
