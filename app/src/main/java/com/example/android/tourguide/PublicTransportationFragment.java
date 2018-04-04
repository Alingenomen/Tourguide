package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class PublicTransportationFragment extends Fragment {

    private ListView pubTransportListView;


    public PublicTransportationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_public_transportation, container, false);

        pubTransportListView = rootView.findViewById(R.id.allPubTransportListView);

        initialiseArrayAdapter();

        return rootView;
    }

    private void initialiseArrayAdapter(){
        // Create an ArrayAdapter, whose data source is a list of playlists. The
        // adapter knows how to create layouts for each item in the list, using the
        // playlist_listitem.xml layout resource defined in the Android framework.
        // This list item layout contains one TextView, which the adapter will set to
        // display the information.
        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), MainActivity.pubTransportLocations);

        // Find the ListView object in the view hierarchy of the Activity.
        // There should be a ListView with the view ID called allPlaylistsListView, which is declared in the
        // PlaylistActivity layout file.
        ListView listView = pubTransportListView;

        // Make the ListView use the ArrayAdapter we created above, so that the
        // ListView will display list items for each playlist in the list of playlists.
        // Do this by calling the setAdapter method on the ListView object and pass in
        // 1 argument, which is the ArrayAdapter with the variable name itemsAdapter.
        listView.setAdapter(locationAdapter);
    }
}
