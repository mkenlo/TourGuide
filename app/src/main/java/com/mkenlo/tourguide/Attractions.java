package com.mkenlo.tourguide;

import java.io.Serializable;

/**
 * Created by Melanie on 8/28/2017.
 */

public class Attractions implements Serializable {

    private int id;
    private String name;
    private String description;
    private String[] images;
    private String location;
    private String city;
    private String header;

    public Attractions() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getImages() {
        return images;
    }

    public String getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getHeader() {
        return header;
    }
}
