package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by DTPAdmin on 29/03/2018.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private String tabHeaders[] = new String[] {"Map", "Transport", "Resto", "Nature", "Sports"};

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // Switch case to assign fragments to their positions

        Bundle bundle;
        MapsFragment mapsFragment = new MapsFragment();
        NatureFragment natureFragment = new NatureFragment();
        PublicTransportationFragment pubTransFragment = new PublicTransportationFragment();
        RestaurantsFragment restaurantFragment = new RestaurantsFragment();
        SportsFragment sportsFragment = new SportsFragment();

        switch (position){
            case 0:
                return mapsFragment;
            case 1:
                return pubTransFragment;
            case 2:
                return restaurantFragment;
            case 3:
                return natureFragment;
            case 4:
                return sportsFragment;
            // Supply a default return statement
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabHeaders[position];
    }

}
