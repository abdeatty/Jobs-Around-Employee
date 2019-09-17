package com.example.jobsaround.ui.activities.favorite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.jobsaround.R;
import com.example.jobsaround.adapters.JobsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FavoriteActivity extends AppCompatActivity {

    private static final String TAG = "FavoriteActivity";
    private Unbinder unbinder;
    private JobsAdapter jobsAdapter;

    @BindView(R.id.favorite_jobs_rv)
    RecyclerView favoriteJobsRv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        unbinder = ButterKnife.bind(this);
        initFavoriteRv();
    }

    private void initFavoriteRv() {

        jobsAdapter = new JobsAdapter();
        favoriteJobsRv.setLayoutManager(new LinearLayoutManager(this));
        favoriteJobsRv.setHasFixedSize(true);
        favoriteJobsRv.setAdapter(jobsAdapter);
    }
}