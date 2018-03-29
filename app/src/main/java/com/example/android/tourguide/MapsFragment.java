package com.example.android.tourguide;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggleButton;
    private NavigationView sideMenu;
    MapView mMapView;

    SupportMapFragment mapFragment;


    public MapsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);

        MapsInitializer.initialize(this.getActivity());

        mapFragment = SupportMapFragment.newInstance();
        mapFragment.getMapAsync(this);



        //TextView textView = new TextView(getActivity());
        //textView.setText(R.string.hello_blank_fragment);
        //return textView;

        getChildFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();

        return rootView;
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Eeklo = new LatLng(51.185272, 3.563890);
        mMap.addMarker(new MarkerOptions().position(Eeklo).title("Marker in Eeklo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Eeklo));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(13.0f));
    }

    /**
     * Proved the override function for the mToggleButton so
     * When it gets tapped, the Navigation menu appears
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mToggleButton.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    // This function adds markers for the given location type
    public void addMarkers(){

    }

    // This method initialises all the views available on the activity
    public void initialiseViews(){

    }

    public void initialiseOnClickListeners(){

    }

}
