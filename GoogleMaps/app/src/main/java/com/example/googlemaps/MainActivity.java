package com.example.googlemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                // Add marker for Walchand College of Engineering, Sangli
                LatLng walchandCollege = new LatLng(16.845864, 74.601570);
                googleMap.addMarker(new MarkerOptions().position(walchandCollege).title("Walchand College of Engineering, Sangli"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(walchandCollege, 15)); // Zoom level 15
            }
        });
    }
}