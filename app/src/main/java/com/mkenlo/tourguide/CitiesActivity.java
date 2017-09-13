package com.mkenlo.tourguide;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.mkenlo.tourguide.R.id.city;

public class CitiesActivity extends AppCompatActivity {

    public Attractions city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You liked this", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        int cityId = getIntent().getIntExtra("cityId", 0);
        JsonData mCitiesData = new JsonData(getBaseContext());
        city = mCitiesData.getCityList().get(cityId-1);

        TextView cityName = (TextView) findViewById(R.id.city_name);
        TextView cityLocation = (TextView) findViewById(R.id.city_location);
        TextView cityDesc = (TextView) findViewById(R.id.city_desc);
        cityName.setText(city.getName());
        cityLocation.setText(city.getLocation());
        cityDesc.setText(city.getDescription());
        ImageView cityImg = (ImageView) findViewById(R.id.city_image);
        Drawable drawable = ContextCompat.getDrawable(getBaseContext(),
                getBaseContext().getResources().getIdentifier(city.getHeader(), "drawable", getBaseContext().getPackageName()));

        cityImg.setImageDrawable(drawable);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.attractionsPerCity);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        AttractionsImagesRecyclerAdapter mAdapter = new AttractionsImagesRecyclerAdapter(city.getImages());
        mRecyclerView.setAdapter(mAdapter);
    }

    public class AttractionsImagesRecyclerAdapter extends RecyclerView.Adapter<AttractionsImagesRecyclerAdapter.ViewHolder> {
        private String[] imagesList;


        public AttractionsImagesRecyclerAdapter(String[] list) {
            this.imagesList = list;
        }

        @Override
        public AttractionsImagesRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_cities_attractions, parent, false);
            return new AttractionsImagesRecyclerAdapter.ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(AttractionsImagesRecyclerAdapter.ViewHolder holder, int position) {
            final String image = imagesList[position];
            Drawable drawable = ContextCompat.getDrawable(getBaseContext(),
                    getBaseContext().getResources().getIdentifier(image, "drawable", getBaseContext().getPackageName()));
            holder.attraction_image.setImageDrawable(drawable);
            /*holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent attractionActivity = new Intent(v.getContext(), AttractionsActivity.class);
                    attractionActivity.putExtra("attractionId", place.getId());
                    attractionActivity.putExtra("cityId", city.getId() );
                    v.getContext().startActivity(attractionActivity);
                }
            });*/


        }

        @Override
        public int getItemCount() {
            return imagesList.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView attraction_name;
            ImageView attraction_image;
            CardView card;

            public ViewHolder(View v) {
                super(v);

                attraction_image = (ImageView) v.findViewById(R.id.attractionImg);
                attraction_name = (TextView) v.findViewById(R.id.attractionName);
                card = (CardView) v.findViewById(R.id.attractionInCity);
            }
        }
    }
}
