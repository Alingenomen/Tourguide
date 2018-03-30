package com.example.android.tourguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Global variables
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private int tabHeaderImages[] = new int[] {R.drawable.ic_googlemaps, R.drawable.ic_transport_off,
            R.drawable.ic_dinner_off, R.drawable.ic_nature_off, R.drawable.ic_sports_off};

    // Oncreate Method of the locator activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialise the ViewPager
        initialiseViewPager();

        // Initialise the TabLayout to navigate between fragments
        initialiseTabLayout();
    }

    // This method initialises the ViewPager
    private void initialiseViewPager(){
        viewPager = findViewById(R.id.locationPager);
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    // This method initialises the TabLayout and
    // assigns icons to the headers
    private void initialiseTabLayout(){
        tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        // configure icons
        for (int i = 0; i < tabHeaderImages.length; i++) {
            tabLayout.getTabAt(i).setIcon(tabHeaderImages[i]);
        }
    }
}
