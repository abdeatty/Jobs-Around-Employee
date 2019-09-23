package com.amaz.jobsaround.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.amaz.jobsaround.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomEmployeeInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private final View mWindow;
    private final Context mContext;

    public CustomEmployeeInfoWindowAdapter(Context mContext) {
        this.mContext = mContext;
        mWindow = LayoutInflater.from(mContext).inflate(R.layout.employee_marker_info_window_content_layout,null);
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return mWindow;
    }
}
