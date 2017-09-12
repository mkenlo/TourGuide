package com.mkenlo.tourguide;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mkenlo.tourguide.R.raw.cities;


/**
 * Created by Melanie on 9/6/2017.
 */

public class CitiesJson {

    private List<Cities> cityList;
    private Context context;

    public CitiesJson(Context context) {
        this.context = context;
    }

    private String loadJSONFromAsset() {
        String json;
        try {

            InputStream is = this.context.getResources().openRawResource(cities);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    public List<Cities> getCityList() {
        String jsonCities = loadJSONFromAsset();
        Gson gson = new Gson();
        cityList = new ArrayList<>(Arrays.asList(gson.fromJson(jsonCities, Cities[].class)));
        return cityList;
    }


}
