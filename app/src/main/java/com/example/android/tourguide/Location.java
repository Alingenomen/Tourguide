package com.example.android.tourguide;

/**
 * Created by DTPAdmin on 30/03/2018.
 */

public class Location {

    // Global variables
    private String name, type, subtype;
    private int imageId;
    private double lat, lon;

    // Constructor without an ImageID
    public Location(String nameValue, String typeValue, String subtypeValue, double latitude, double longitude){
        name = nameValue;
        type = typeValue;
        subtype = subtypeValue;
        lat = latitude;
        lon = longitude;
    }

    // Constructor with an ImageID
    public Location(String nameValue, String typeValue, String subtypeValue, double latitude, double longitude, int imageID){
        name = nameValue;
        type = typeValue;
        subtype = subtypeValue;
        lat = latitude;
        lon = longitude;
        imageId = imageID;
    }

    // Getter methods
    private String getName(){
        return name;
    }

    private String getType(){
        return type;
    }

    private String getSubtype(){
        return subtype;
    }

    private double getLat(){
        return lat;
    }

    private double getLon(){
        return lon;
    }

    private int getImageId(){
        return imageId;
    }
}
