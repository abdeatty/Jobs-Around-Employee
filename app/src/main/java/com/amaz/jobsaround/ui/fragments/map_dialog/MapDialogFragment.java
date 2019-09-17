package com.amaz.jobsaround.ui.fragments.map_dialog;


import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.amaz.jobsaround.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapDialogFragment extends DialogFragment implements OnMapReadyCallback ,View.OnClickListener {

    private static final String TAG = "MapDialogFragment";
    private static final String MAPVIEW_BUNDLE_KEY = "Map Bundle";
    private Unbinder unbinder;
    @BindView(R.id.map_view)
    MapView mMapView;
    @BindView(R.id.confirm_btn)
    Button confirmButton;
    private GoogleMap mGoogleMap;

    public MapDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map_dialog, container, false);

        unbinder = ButterKnife.bind(this,view);
        initGoogleMap(savedInstanceState);
        confirmButton.setOnClickListener(this::onClick);

//        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        return view;
    }

    private void initGoogleMap(Bundle savedInstanceState) {
        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        mMapView.onCreate(mapViewBundle);
        mMapView.getMapAsync(this);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }

        mMapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mGoogleMap = googleMap;

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
            return;
        }

        mGoogleMap.setMyLocationEnabled(true);
        Log.e(TAG, "onMapReady: "+mGoogleMap.getCameraPosition().target.longitude);
        Log.e(TAG, "onMapReady: "+mGoogleMap.getCameraPosition().target.latitude);

    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        unbinder.unbind();


    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.confirm_btn:
                Toast.makeText(getContext(), mGoogleMap.getCameraPosition().target.longitude+"", Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), mGoogleMap.getCameraPosition().target.latitude+"", Toast.LENGTH_SHORT).show();
                dismiss();
                break;
        }
    }
}
