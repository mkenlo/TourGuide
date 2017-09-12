package com.mkenlo.tourguide;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.fragment;
import static com.mkenlo.tourguide.R.id.city;

public class AttractionsPageTwo extends Fragment {

    private static final String ARG_ATTRACTION_PHOTOS = "attractionPhotos";

    private String[] attractionPhotos;


    public AttractionsPageTwo() {
    }

    public static AttractionsPageTwo newInstance(String [] photos) {
        AttractionsPageTwo fragment = new AttractionsPageTwo();
        Bundle args = new Bundle();
        args.putStringArray(ARG_ATTRACTION_PHOTOS, photos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            attractionPhotos = getArguments().getStringArray(ARG_ATTRACTION_PHOTOS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_attractions_page_two, container, false);

        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.attraction_images);

        mRecyclerView.setHasFixedSize(true);

        Log.d("PHOTOS Length", attractionPhotos.toString());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        ImagesAdapter mAdapter = new ImagesAdapter(getDrawableFromString(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }

    public List<Drawable> getDrawableFromString(Context context){
        List<Drawable> drawable = new ArrayList<>();
        for(int i=0; i< attractionPhotos.length;i++){
            drawable.add(ContextCompat.getDrawable(context,
                    context.getResources().getIdentifier(attractionPhotos[i], "drawable", context.getPackageName())));
        }
        return drawable;

    }

    public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder>{

        List<Drawable> images;

        public ImagesAdapter(List<Drawable> images) {
            this.images = images;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_attractions_images, parent, false);
            return new ImagesAdapter.ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.imageView.setImageDrawable(images.get(position));

        }

        @Override
        public int getItemCount() {
            return images.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView;

            public ViewHolder(View v) {
                super(v);

                imageView = (ImageView) v.findViewById(R.id.attractionImg);

            }
        }
    }
}
