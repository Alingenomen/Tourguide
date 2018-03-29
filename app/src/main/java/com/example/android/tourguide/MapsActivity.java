package com.example.android.tourguide;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggleButton;
    private NavigationView sideMenu;

    // Oncreate Method of the locator activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        sideMenu = findViewById(R.id.nav_view);
        mDrawerLayout = findViewById(R.id.drawerLayout);

        initialiseNavigationDrawer();
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

    private void initialiseNavigationDrawer() {
        mToggleButton = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggleButton);
        mToggleButton.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sideMenu.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        switch (menuItem.getItemId()) {
                            case R.id.menuLocations: {
                                //Intent showRadarChoice = new Intent(MapsActivity.this, RadarChoiceActivity.class);
                                // Start the new activity
                                //startActivityForResult(showRadarChoice, 1);
                                break;
                            }
                            case R.id.menuSettings: {
                                break;
                            }
                        }
                        return true;
                    }
                });
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
