package com.example.android.tourguide;

import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity {

    private int tabHeaderImages[] = new int[] {R.drawable.ic_googlemaps, R.drawable.ic_transport_off,
            R.drawable.ic_dinner_off, R.drawable.ic_nature_off, R.drawable.ic_sports_off};

    // Oncreate Method of the locator activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.locationPager);

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        // configure icons
        for (int i = 0; i < tabHeaderImages.length; i++) {
            tabLayout.getTabAt(i).setIcon(tabHeaderImages[i]);
        }
    }
}
