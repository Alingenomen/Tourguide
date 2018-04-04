package com.example.android.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DTPAdmin on 4/04/2018.
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(Activity context, ArrayList<Location> Locations) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, Locations);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.location_listitem, parent, false);
        }

        // Get the Location object located at this position in the list
        Location currentLocation = getItem(position);

        // Find the TextViews in the location_listitem.xml layout with their IDs
        // Get the information from the current location object and
        // set this text on its TextView

        TextView locationNameTextView = (TextView) listItemView.findViewById(R.id.locationItemName);
        locationNameTextView.setText(currentLocation.getName());

        TextView locationSubTypeTextView = (TextView) listItemView.findViewById(R.id.locationItemSubtype);
        locationSubTypeTextView.setText(currentLocation.getSubtype());

        ImageView locationIcon = listItemView.findViewById(R.id.locationItemIcon);
        locationIcon.setImageResource(currentLocation.getImageId());

        // Return the whole list item layout
        // so that it can be shown in the ListView
        return listItemView;
    }



}
