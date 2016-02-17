package com.example.artur.myapplication;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, LocationListener {

    private GoogleMap mMap;
    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);

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
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);
        // Add a marker in Sydney and move the camera

        LatLng ciarka = new LatLng(50.9308778, 18.298255414);
        mMap.addMarker(new MarkerOptions().position(ciarka).title("Ciarka"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(ciarka));
        //mMap.moveCamera(CameraUpdateFactory.zoomTo(11));

        LatLng choc = new LatLng(50.9410951, 18.2573842);
        mMap.addMarker(new MarkerOptions().position(choc).title("Chocianowice"));

    }

    @Override
    public boolean onMarkerClick(Marker marker)
    {
        Toast.makeText(this, marker.getTitle(), Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public void onLocationChanged(Location location)
    {
        LatLng polozenie = new LatLng(location.getLatitude(),location.getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(polozenie));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(11));

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        LatLng polozenie = new LatLng(location.getLatitude(),location.getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(polozenie));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(11));

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


}
