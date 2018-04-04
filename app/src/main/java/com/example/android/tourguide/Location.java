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

        assignImageID(subtype);

    }

    private void assignImageID(String subtype){
        switch (subtype){
            case "Snack":
                imageId = R.drawable.ic_fastfood;
                break;
            case "Chinees":
                imageId = R.drawable.ic_chinesefood;
                break;
            case "Italiaan":
                imageId = R.drawable.ic_italianfood;
                break;
        }
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
