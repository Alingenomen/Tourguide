package com.example.android.tourguide;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Set;

public class MapsFragment extends Fragment implements OnMapReadyCallback {

    // Global variables
    private GoogleMap mMap;
    private boolean restoOn, natureOn, transpoOn, sportsOn = false;
    private ImageView restoIcon, natureIcon, transpoIcon, sportsIcon;
    private SupportMapFragment mapFragment;
    private ArrayList visiblePubTransportMarkers = new ArrayList();
    private ArrayList visibleNatureMarkers = new ArrayList();
    private ArrayList visibleRestaurantMarkers = new ArrayList();
    private ArrayList visibleSportMarkers = new ArrayList();

    // Public constructor of the fragment
    public MapsFragment() {
        // empty
    }

    // Oncreate Method of the MapsFragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);

        // initialise views
        initialiseViews(rootView);

        // Initialise the on click listeners
        initialiseOnclickListeners();

        // Initialise the Google Map
        initialiseGoogleMap();

        return rootView;
    }

    // This method initialises all the views available on the fragment
    private void initialiseViews(View view){
        restoIcon = view.findViewById(R.id.restoIcon);
        natureIcon = view.findViewById(R.id.natureIcon);
        transpoIcon = view.findViewById(R.id.transportIcon);
        sportsIcon = view.findViewById(R.id.sportsIcon);
    }

    // This method initialises the Google Map
    private void initialiseGoogleMap(){
        mapFragment = SupportMapFragment.newInstance();
        mapFragment.getMapAsync(this);
        getChildFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();
    }

    // This method initialises the on click listeners
    private void initialiseOnclickListeners() {
        // Set a click listener on that View

        restoIcon.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                if (!restoOn) {
                    addAllMarkers(MainActivity.restaurantLocations, "red");
                    restoIcon.setImageResource(R.drawable.ic_dinner_on);
                    restoOn = true;
                } else {
                    removeMarkers(visibleRestaurantMarkers);
                    restoIcon.setImageResource(R.drawable.ic_dinner_off);
                    restoOn = false;
                }
            }
        });

        natureIcon.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                if (!natureOn) {
                    addAllMarkers(MainActivity.natureLocations, "green");
                    natureIcon.setImageResource(R.drawable.ic_nature_on);
                    natureOn = true;
                } else {
                    removeMarkers(visibleNatureMarkers);
                    natureIcon.setImageResource(R.drawable.ic_nature_off);
                    natureOn = false;
                }
            }
        });

        transpoIcon.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                if (!transpoOn) {
                    addAllMarkers(MainActivity.pubTransportLocations, "orange");
                    transpoIcon.setImageResource(R.drawable.ic_transport_on);
                    transpoOn = true;
                } else {
                    removeMarkers(visiblePubTransportMarkers);
                    transpoIcon.setImageResource(R.drawable.ic_transport_off);
                    transpoOn = false;
                }
            }
        });

        sportsIcon.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                if (!sportsOn) {
                    addAllMarkers(MainActivity.sportsLocations, "blue");
                    sportsIcon.setImageResource(R.drawable.ic_sports_on);
                    sportsOn = true;
                } else {
                    removeMarkers(visibleSportMarkers);
                    sportsIcon.setImageResource(R.drawable.ic_sports_off);
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
    // it is declared as public because functionality in the other fragments
    // also call this method to display certain markers
    public void addAllMarkers(ArrayList<Location> list, String color){
        switch (color){
            case "orange":
                // The markers to add are Public Transportation locations
                for (int i=0; i < list.size(); i++){
                    LatLng markerLocation = new LatLng(list.get(i).getLat(),list.get(i).getLon());
                    Marker marker = mMap.addMarker(new MarkerOptions().position(markerLocation)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                    visiblePubTransportMarkers.add(marker);
                }
                break;
            case "green":
                // The markers to add are Nature locations
                for (int i=0; i < list.size(); i++){
                    LatLng markerLocation = new LatLng(list.get(i).getLat(),list.get(i).getLon());
                    Marker marker = mMap.addMarker(new MarkerOptions().position(markerLocation)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                    visibleNatureMarkers.add(marker);
                }                break;
            case "red":
                // The markers to add are Restaurant locations
                for (int i=0; i < list.size(); i++){
                    LatLng markerLocation = new LatLng(list.get(i).getLat(),list.get(i).getLon());
                    Marker marker = mMap.addMarker(new MarkerOptions().position(markerLocation)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                    visibleRestaurantMarkers.add(marker);
                }                break;
            case "blue":
                // The markers to add are Sport locations
                for (int i=0; i < list.size(); i++){
                    LatLng markerLocation = new LatLng(list.get(i).getLat(),list.get(i).getLon());
                    Marker marker = mMap.addMarker(new MarkerOptions().position(markerLocation)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                    visibleSportMarkers.add(marker);
                }        }
    }

    // This function removes markers for the given location type
    // it is declared as public because functionality in the other fragments
    // also call this method to display certain markers
    public void removeMarkers(ArrayList<Marker> list){
        for (int i=0; i < list.size(); i++){
            list.get(i).remove();
        }
    }
}
