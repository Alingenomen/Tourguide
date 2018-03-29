package com.example.android.tourguide;

import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggleButton;
    private NavigationView sideMenu;

    // Oncreate Method of the locator activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        sideMenu = findViewById(R.id.nav_view);
        mDrawerLayout = findViewById(R.id.drawerLayout);

        initialiseNavigationDrawer();

        ViewPager viewPager = (ViewPager) findViewById(R.id.locationPager);

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
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
                                Toast.makeText(MainActivity.this, "Menu item Settings has been tapped", Toast.LENGTH_SHORT).show();
                                break;
                            }
                            case R.id.menuSettings: {
                                Toast.makeText(MainActivity.this, "Menu item Settings has been tapped", Toast.LENGTH_SHORT).show();

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

}
