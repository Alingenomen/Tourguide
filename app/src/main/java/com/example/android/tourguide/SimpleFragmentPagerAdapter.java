package com.example.android.tourguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by DTPAdmin on 29/03/2018.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    // Global variables
    private MapsFragment mapsFragment = new MapsFragment();
    private NatureFragment natureFragment = new NatureFragment();
    private PublicTransportationFragment pubTransFragment = new PublicTransportationFragment();
    private RestaurantsFragment restaurantFragment = new RestaurantsFragment();
    private SportsFragment sportsFragment = new SportsFragment();

    // Constructor of the SimpleFragmentPagerAdapter
    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // Override method which enables Fragment navigation
    @Override
    public Fragment getItem(int position) {
        // Switch case to assign fragments to their positions

        switch (position){
            case 0:
                return mapsFragment;
            case 1:
                return restaurantFragment;
            case 2:
                return sportsFragment;
            case 3:
                return natureFragment;
            case 4:
                return pubTransFragment;
            // Supply a default return statement
            default:
                return null;
        }
    }

    // Override method which returns the total fragment count
    @Override
    public int getCount() {
        return 5;
    }

    // Override method which returns the Fragment Titles to display as headers
    // empty in this case bacause we use icons, set in the MainActivity
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}
