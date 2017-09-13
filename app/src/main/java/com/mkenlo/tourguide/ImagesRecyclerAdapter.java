package com.mkenlo.tourguide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Melanie on 9/13/2017.
 */

public class ImagesRecyclerAdapter extends RecyclerView.Adapter<ImagesRecyclerAdapter.ViewHolder> {

    String[] images;
    Context context;

    public ImagesRecyclerAdapter(String[] list, Context context) {
        this.images = list;
        this.context = context;
    }

    @Override
    public ImagesRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_attractions_images, parent, false);
        return new ImagesRecyclerAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImagesRecyclerAdapter.ViewHolder holder, int position) {
        String img = images[position];
        Drawable drawable = ContextCompat.getDrawable(context,
                context.getResources().getIdentifier(img, "drawable", context.getPackageName()));
        holder.attraction_image.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return this.images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView attraction_image;

        public ViewHolder(View v) {
            super(v);
            attraction_image = (ImageView) v.findViewById(R.id.attractionImg);
        }

    }
}
