package com.example.bilaizi.androidsample.ui;

import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.example.bilaizi.androidsample.DemoActivity;
import com.example.bilaizi.androidsample.DemoApplication;

import javax.inject.Inject;

public class HomeActivity extends DemoActivity {

    @Inject
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DemoApplication) getApplication()).component().inject(this);
        // TODO do something with the injected dependencies here!
        Log.d("HomeActivity", locationManager.toString());
    }
}
