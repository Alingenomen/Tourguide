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
    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public String getSubtype(){
        return subtype;
    }

    public double getLat(){
        return lat;
    }

    public double getLon(){
        return lon;
    }

    public int getImageId(){
        return imageId;
    }
}
