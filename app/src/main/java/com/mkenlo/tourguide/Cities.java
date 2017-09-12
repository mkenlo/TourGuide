package com.mkenlo.tourguide;

import java.util.List;

/**
 * Created by Melanie on 8/28/2017.
 */

public class Cities {

    private int id;
    private String name;
    private String description;
    private String image;
    private String location;
    private List<Attractions> attractions;

    public Cities() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public List<Attractions> getAttractions() {
        return attractions;
    }
}
