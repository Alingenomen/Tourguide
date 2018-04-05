package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class SportsFragment extends Fragment {

    private ListView sportListView;

    public SportsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_sports, container, false);

        sportListView = rootView.findViewById(R.id.allSportsListView);

        initialiseArrayAdapter();

        return rootView;
    }

    private void initialiseArrayAdapter(){
        // Create an ArrayAdapter, whose data source is a list of locations. The
        // adapter knows how to create layouts for each item in the list, using the
        // location_listitem.xml layout resource defined in the Android framework.
        // This list item layout contains one Views, which the adapter will set to
        // display the information.
        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), MainActivity.sportsLocations);

        // Find the ListView object in the view hierarchy of the Activity.
        // There should be a ListView with the view ID called sportListView, which is declared in the
        // SportsFragment layout file.
        ListView listView = sportListView;

        // Make the ListView use the ArrayAdapter we created above, so that the
        // ListView will display list items for each sport location in the list of location.
        // Do this by calling the setAdapter method on the ListView object and pass in
        // 1 argument, which is the ArrayAdapter with the variable name locationAdapter.
        listView.setAdapter(locationAdapter);
    }
}
