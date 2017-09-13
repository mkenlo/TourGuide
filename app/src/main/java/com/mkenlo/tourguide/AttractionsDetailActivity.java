package com.mkenlo.tourguide;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AttractionsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions_detail);
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

        Attractions place = (Attractions) getIntent().getSerializableExtra("attraction");

        TextView placeName = (TextView) findViewById(R.id.place_name);
        TextView placeLocation = (TextView) findViewById(R.id.place_location);
        TextView placeDesc = (TextView) findViewById(R.id.place_desc);
        placeName.setText(place.getName());
        placeLocation.setText(place.getLocation());
        placeDesc.setText(place.getDescription());
        ImageView placeImg = (ImageView) findViewById(R.id.place_image);
        Drawable drawable = ContextCompat.getDrawable(getBaseContext(),
                getBaseContext().getResources().getIdentifier(place.getHeader(), "drawable", getBaseContext().getPackageName()));

        placeImg.setImageDrawable(drawable);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.place_imagesList);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ImagesRecyclerAdapter mAdapter = new ImagesRecyclerAdapter(place.getImages(), getBaseContext());
        mRecyclerView.setAdapter(mAdapter);
    }
}
