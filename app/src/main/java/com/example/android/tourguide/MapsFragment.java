package com.example.android.tourguide;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Set;

public class MapsFragment extends Fragment implements OnMapReadyCallback {

    // Global variables
    private GoogleMap mMap;
    private boolean restoOn, natureOn, transpoOn, sportsOn = false;
    private ImageView restoImage, natureImage, transpoImage, sportsImage;
    private SupportMapFragment mapFragment;

    // Public constructor of the fragment
    public MapsFragment() {
        // Required empty public constructor
    }

    // Oncreate Method of the MapsFragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);

        // initialise views
        initialiseViews(rootView);

        // Initialise the on click listeners
        initialiseOnclickListeners();

        // Initialise the Google Map
        initialiseGoogleMap();

        return rootView;
    }

    // This method initialises the on click listeners
    private void initialiseOnclickListeners() {
        // Set a click listener on that View

        restoImage.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                if (!restoOn) {
                    restoImage.setImageResource(R.drawable.ic_dinner_on);
                    restoOn = true;
                } else {
                    restoImage.setImageResource(R.drawable.ic_dinner_off);
                    restoOn = false;
                }
            }
        });

        natureImage.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                if (!natureOn) {
                    natureImage.setImageResource(R.drawable.ic_nature_on);
                    natureOn = true;
                } else {
                    natureImage.setImageResource(R.drawable.ic_nature_off);
                    natureOn = false;
                }
            }
        });

        transpoImage.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                if (!transpoOn) {
                    transpoImage.setImageResource(R.drawable.ic_transport_on);
                    transpoOn = true;
                } else {
                    transpoImage.setImageResource(R.drawable.ic_transport_off);
                    transpoOn = false;
                }
            }
        });

        sportsImage.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                if (!sportsOn) {
                    sportsImage.setImageResource(R.drawable.ic_sports_on);
                    sportsOn = true;
                } else {
                    sportsImage.setImageResource(R.drawable.ic_sports_off);
                    sportsOn = false;
                }
            }
        });
    }

    // This override method contains all the google map functionality
    // when the google map is ready via its callback method
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        styleTheMap(googleMap);

        setMyLocation(googleMap);

        // Add a marker in Sydney and move the camera
        LatLng Eeklo = new LatLng(51.185272, 3.563890);
        mMap.addMarker(new MarkerOptions().position(Eeklo).title("Marker in Eeklo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Eeklo));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(13.0f));
    }

    // Check the user's permission to use the GPS
    // If permission available, call the method googleMap.setMyLocationEnabled(true)
    // If permission not yet avail, request the permission to the user
    // If permission denied, do not show the user location
    private void setMyLocation(GoogleMap googleMap) {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
        } else {
            // permission request
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(false);
        }
    }

    // Set map style using the stylefile in
    //the resource folder raw/mapstyle.json
    private void styleTheMap(GoogleMap googleMap) {
        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(getActivity(), R.raw.mapstyle));
    }

    // This function adds markers for the given location type
    // it is declared as public because funcationality in the other fragments
    // also call this method to display certain markers
    public void addMarkers(){

    }

    // This method initialises all the views available on the activity
    private void initialiseViews(View view){
        restoImage = view.findViewById(R.id.restoIcon);
        natureImage = view.findViewById(R.id.natureIcon);
        transpoImage = view.findViewById(R.id.transportIcon);
        sportsImage = view.findViewById(R.id.sportsIcon);
    }

    // This method initialises the Google Map
    private void initialiseGoogleMap(){
        mapFragment = SupportMapFragment.newInstance();
        mapFragment.getMapAsync(this);
        getChildFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();
    }
}
