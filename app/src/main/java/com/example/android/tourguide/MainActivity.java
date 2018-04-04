package com.example.android.tourguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Global variables
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private int tabHeaderImages[] = new int[] {R.drawable.ic_googlemaps, R.drawable.ic_dinner_off,
            R.drawable.ic_sports_off, R.drawable.ic_nature_off, R.drawable.ic_transport_off};
    public static ArrayList<Location> restaurantLocations = new ArrayList();
    public static ArrayList<Location> natureLocations = new ArrayList();
    public static ArrayList<Location> sportsLocations = new ArrayList();
    public static ArrayList<Location> pubTransportLocations = new ArrayList();

    // Oncreate Method of the locator activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialise the ViewPager
        initialiseViewPager();

        // Initialise the TabLayout to navigate between fragments
        initialiseTabLayout();

        processAllLocationDataFromCSV();
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

    // This method reads the location data from a raw CSV file
    private void processAllLocationDataFromCSV(){

        String name, type, subtype;
        double lat, lon;
        InputStream csvStream = getResources().openRawResource(R.raw.locations);
        BufferedReader csvReader = new BufferedReader(
                new InputStreamReader(csvStream, Charset.forName("UTF-8")));
        String line = "";

        try {
            while ((line = csvReader.readLine()) != null) {
                // Split the line into different cells
                // using the comma as a separator).
                String[] cell = line.split(";");
                name = cell[0];
                type = cell[1];
                subtype = cell[2];
                lat = Double.parseDouble(cell[3]);
                lon = Double.parseDouble(cell[4]);
                // Read the location data and send it
                // to the addLocationToItsArrayList method to appoint
                // it to its respective Arraylist
                Location location = new Location(name, type, subtype, lat, lon);
                addLocationToItsArraylist(location);
            }
        } catch (IOException e1) {
            Log.e("csvReader", "Error" + line, e1);
            e1.printStackTrace();
        }
    }

    // This method adds the location, read from the
    private void addLocationToItsArraylist(Location loc){
        String locationType = loc.getType();

        switch (locationType){
            case "pubTransportLocation":
                pubTransportLocations.add(loc);
                break;
            case "restaurantLocation":
                restaurantLocations.add(loc);
                break;
            case "natureLocation":
                natureLocations.add(loc);
                break;
            case "sportLocation":
                sportsLocations.add(loc);
        }
    }
}
