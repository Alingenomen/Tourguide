package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class RestaurantsFragment extends Fragment {

    private ListView restaurantListView;

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_restaurants, container, false);

        restaurantListView = rootView.findViewById(R.id.allRestaurantsListView);

        initialiseArrayAdapter();

        return rootView;
    }

    private void initialiseArrayAdapter(){
        // Create an ArrayAdapter, whose data source is a list of locations. The
        // adapter knows how to create layouts for each item in the list, using the
        // location_listitem.xml layout resource defined in the Android framework.
        // This list item layout contains one Views, which the adapter will set to
        // display the information.
        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), MainActivity.restaurantLocations);

        // Find the ListView object in the view hierarchy of the Activity.
        // There should be a ListView with the view ID called restaurantListView, which is declared in the
        // RestaurantsFragment layout file.
        ListView listView = restaurantListView;

        // Make the ListView use the ArrayAdapter we created above, so that the
        // ListView will display list items for each restaurant location in the list of location.
        // Do this by calling the setAdapter method on the ListView object and pass in
        // 1 argument, which is the ArrayAdapter with the variable name locationAdapter.
        listView.setAdapter(locationAdapter);
    }
}
