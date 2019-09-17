package com.amaz.jobsaround.ui.activities.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.amaz.jobsaround.R;
import com.amaz.jobsaround.ui.fragments.chat.ChatFragment;
import com.amaz.jobsaround.ui.fragments.location.LocationFragment;
import com.amaz.jobsaround.ui.fragments.menu.MenuFragment;
import com.amaz.jobsaround.ui.fragments.profile.ProfileFragment;
import com.amaz.jobsaround.ui.fragments.rejoins.RejoinsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {


    @BindView(R.id.nav_view)
    BottomNavigationView navView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_menu:
                attachMenuFragment();
                return true;

            case R.id.navigation_chat:

                attachChatFragment();
                return true;

            case R.id.navigation_rejoins:

                attachRejoinsFragment();
                return true;

            case R.id.navigation_location:

                attachLocationFragment();
                return true;

            case R.id.navigation_profile:

                attachProfileFragment();
                return true;


        }
        return false;
    };

    private void attachLocationFragment() {

        LocationFragment fragment = new LocationFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container ,fragment);
        fragmentTransaction.commit();
    }

    private void attachRejoinsFragment() {

        RejoinsFragment fragment = new RejoinsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container ,fragment);
        fragmentTransaction.commit();
    }

    private void attachChatFragment() {

        ChatFragment fragment = new ChatFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container ,fragment);
        fragmentTransaction.commit();
    }

    private void attachProfileFragment() {
        ProfileFragment fragment = new ProfileFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container ,fragment);
        fragmentTransaction.commit();
    }



    private void attachMenuFragment() {

        MenuFragment fragment = new MenuFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container ,fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        attachMenuFragment();
    }
}
