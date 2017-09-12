package com.mkenlo.tourguide;

/**
 * Created by Melanie on 8/28/2017.
 */

public class Attractions {

    private int id;
    private String name;
    private String description;
    private String[] images;
    private String location;
    private String city;

    public Attractions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
