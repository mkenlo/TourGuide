package com.mkenlo.tourguide;

/**
 * Created by Melanie on 9/13/2017.
 */
import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mkenlo.tourguide.R.raw.cities;
import static com.mkenlo.tourguide.R.raw.beaches;
import static com.mkenlo.tourguide.R.raw.parks;
import static com.mkenlo.tourguide.R.raw.streets;

public class JsonData {
    private List<Attractions> cityList;
    private List<Attractions> beachList;
    private List<Attractions> parkList;
    private List<Attractions> streetList;
    private Context context;

    public JsonData(Context context) {
        this.context = context;
    }


    public List<Attractions> getCityList() {
        String json;
        try {

            InputStream is = this.context.getResources().openRawResource(cities);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Gson gson = new Gson();
            cityList = new ArrayList<>(Arrays.asList(gson.fromJson(json, Attractions[].class)));
            return cityList;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }



    }
    public List<Attractions> getBeachList() {

        String json;
        try {

            InputStream is = this.context.getResources().openRawResource(beaches);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Gson gson = new Gson();
            beachList = new ArrayList<>(Arrays.asList(gson.fromJson(json, Attractions[].class)));
            return beachList;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }
    public List<Attractions> getParkList() {
        String json;
        try {

            InputStream is = this.context.getResources().openRawResource(parks);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Gson gson = new Gson();
            parkList = new ArrayList<>(Arrays.asList(gson.fromJson(json, Attractions[].class)));
            return parkList;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public List<Attractions> getStreetList() {
        String json;
        try {

            InputStream is = this.context.getResources().openRawResource(streets);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Gson gson = new Gson();
            streetList = new ArrayList<>(Arrays.asList(gson.fromJson(json, Attractions[].class)));
            return streetList;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
