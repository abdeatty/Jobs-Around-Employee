package com.amaz.jobsaround.ui.activities.seeker.my_jobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amaz.jobsaround.R;
import com.amaz.jobsaround.adapters.JobsAdapter;
import com.amaz.jobsaround.ui.activities.job_details.JobDetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyJobsActivity extends AppCompatActivity {

    private static final String TAG = "MyJobsActivity";
    private Unbinder unbinder;
    private JobsAdapter jobsAdapter;

    @BindView(R.id.jobs_rv)
    RecyclerView myJobsRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_jobs);

        unbinder = ButterKnife.bind(this);

        myJobsRv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyJobsActivity.this, JobDetailsActivity.class));
            }
        });
        initMyJobsRv();
    }

    private void initMyJobsRv() {
        jobsAdapter = new JobsAdapter(this);
        myJobsRv.setLayoutManager(new LinearLayoutManager(this));
        myJobsRv.setHasFixedSize(false);
        myJobsRv.setAdapter(jobsAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
