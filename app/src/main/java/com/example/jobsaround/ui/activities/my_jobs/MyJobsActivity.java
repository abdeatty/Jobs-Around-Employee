package com.example.jobsaround.ui.activities.my_jobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.jobsaround.R;
import com.example.jobsaround.adapters.JobsAdapter;

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

        initMyJobsRv();
    }

    private void initMyJobsRv() {
        jobsAdapter = new JobsAdapter();
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
