package com.amaz.jobsaround.ui.fragments.menu;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amaz.jobsaround.R;
import com.amaz.jobsaround.adapters.CustomInfoWindowAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment implements OnMapReadyCallback {

    private static final String TAG = "MenuFragment";
    private static final String MAPVIEW_BUNDLE_KEY = "Map Bundle";
    private List<LatLng> latLngList = new ArrayList<>();
    private Unbinder unbinder;
    @BindView(R.id.map_view)
    MapView mMapView;
    private GoogleMap mGoogleMap;

    public MenuFragment() {
        // Required empty public constructor

        latLngList.add(new LatLng(31.2116923,29.9396));
        latLngList.add(new LatLng(31.2216923,29.9296));
        latLngList.add(new LatLng(31.2136923,29.9496));
        latLngList.add(new LatLng(31.2146923,29.9596));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        unbinder = ButterKnife.bind(this,view);
        initGoogleMap(savedInstanceState);
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

        addMarkersToMap();
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
            return;
        }

    }

    private void addMarkersToMap(){
        if (latLngList.size() < 0) {
            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(0.0, 0.0), 12.0f));
        } else {
            for (int i = 0; i < latLngList.size(); i++) {

//                Marker marker = mGoogleMap.addMarker(
//                        new MarkerOptions()
//                                .position(latLngList.get(i))
//                );
//                marker.setTag(i + "");

                CustomInfoWindowAdapter customInfoWindowAdapter = new CustomInfoWindowAdapter(getContext());
                View markerView = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.map_marker_layout, null);
                TextView tv_marker_text =  markerView.findViewById(R.id.tv_marker_text);

                Marker marker = mGoogleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(latLngList.get(i).latitude,latLngList.get(i).longitude)));
                        marker.setIcon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(getContext(), markerView)));

                        mGoogleMap.setInfoWindowAdapter(customInfoWindowAdapter);
                mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latLngList.get(i).latitude, latLngList.get(i).longitude), 12.0f));
            }


        }
    }

    private Bitmap createDrawableFromView(Context context, View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        return bitmap;
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
}
