package com.amaz.jobsaround.ui.activities.seeker.job_seeker_register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.amaz.jobsaround.R;

import com.amaz.jobsaround.ui.activities.RulesActivity;
import com.amaz.jobsaround.ui.fragments.map_dialog.MapDialogFragment;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class JobSeekerRegisterActivity extends AppCompatActivity{

    private static final String TAG = "JobSeekerRegisterActivi";
    private Unbinder unbinder;
    @BindViews({R.id.english_level_beginner_tv , R.id.english_level_intermediate_tv ,R.id.english_level_good_tv})
    List<TextView> englishLevelList;


    @BindViews({R.id.partial_job_type_tv , R.id.full_time_job_type_tv ,R.id.both_partial_and_part_job_type_tv})
    List<TextView> jobTypeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_seeker_register);


        unbinder = ButterKnife.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
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


    @OnClick(R.id.english_level_beginner_tv)
    public void onBeginnerLevelClicked(View view){

        englishLevelList.get(0).setBackground(getResources().getDrawable(R.drawable.rect_light_blue));
        englishLevelList.get(1).setBackground(null);
        englishLevelList.get(2).setBackground(null);

    }

    @OnClick(R.id.english_level_intermediate_tv)
    public void onIntermediateLevelClicked(View view){

        englishLevelList.get(0).setBackground(null);
        englishLevelList.get(1).setBackground(getResources().getDrawable(R.drawable.rect_light_blue));
        englishLevelList.get(2).setBackground(null);

    }


    @OnClick(R.id.english_level_good_tv)
    public void onGoodLevelClicked(View view){

        englishLevelList.get(0).setBackground(null);
        englishLevelList.get(1).setBackground(null);
        englishLevelList.get(2).setBackground(getResources().getDrawable(R.drawable.rect_light_blue));

    }

    @OnClick(R.id.partial_job_type_tv)
    public void onPartialJobTypeClicked(View view){

        jobTypeList.get(0).setBackground(getResources().getDrawable(R.drawable.rect_light_blue));
        jobTypeList.get(1).setBackground(null);
        jobTypeList.get(2).setBackground(null);
    }

    @OnClick(R.id.full_time_job_type_tv)
    public void onFullTimeJobTypeClicked(View view){


        jobTypeList.get(0).setBackground(null);
        jobTypeList.get(1).setBackground(getResources().getDrawable(R.drawable.rect_light_blue));
        jobTypeList.get(2).setBackground(null);
    }


    @OnClick(R.id.both_partial_and_part_job_type_tv)
    public void onBothPartialAndFullTimeJobTypeClicked(View view){


        jobTypeList.get(0).setBackground(null);
        jobTypeList.get(1).setBackground(null);
        jobTypeList.get(2).setBackground(getResources().getDrawable(R.drawable.rect_light_blue));
    }
    @OnClick(R.id.map_iv)
    public void onMapImageClicked(){
        openMap();
    }
    @OnClick(R.id.save_btn)
    public void onSaveButtonClicked(){
        startActivity(new Intent(JobSeekerRegisterActivity.this , RulesActivity.class));
    }

}
