package com.example.kosta.android15googlemap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        SupportMapFragment mapFragment2 = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2);
        mapFragment2.getMapAsync(this);
    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    int count;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        count++;
        Log.i("testLog","count:"+count);
        if(count==1){
            mMap = googleMap;
            // Add a marker in Sydney and move the camera
            LatLng kosta = new LatLng(37.402124, 127.106910);
            mMap.addMarker(new MarkerOptions().position(kosta).title("Marker in KOSTA"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(kosta));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f));
        }else{
            mMap = googleMap;
            // Add a marker in Sydney and move the camera
            LatLng bugerKing = new LatLng(37.400846, 127.106544);
            mMap.addMarker(new MarkerOptions().position(bugerKing).title("Marker in bugerKing"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(bugerKing));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f));
        }
    }
}
