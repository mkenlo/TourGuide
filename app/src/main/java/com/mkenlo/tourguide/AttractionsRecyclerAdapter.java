package com.mkenlo.tourguide;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Melanie on 9/13/2017.
 */

public class AttractionsRecyclerAdapter extends RecyclerView.Adapter<AttractionsRecyclerAdapter.ViewHolder> {

    List<Attractions> places;
    Context context;

    public AttractionsRecyclerAdapter(List<Attractions> list, Context context) {
        this.places = list;
        this.context = context;
    }

    @Override
    public AttractionsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_attractions_item, parent, false);
        return new AttractionsRecyclerAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AttractionsRecyclerAdapter.ViewHolder holder, int position) {

        final Attractions place = places.get(position);
        holder.place_name.setText(place.getName());
        holder.place_location.setText(place.getLocation());
        Drawable drawable = ContextCompat.getDrawable(context,
                context.getResources().getIdentifier(place.getHeader(), "drawable", context.getPackageName()));
        holder.place_image.setImageDrawable(drawable);
        holder.place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailActivity = new Intent(v.getContext(), AttractionsDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("attraction", place);
                detailActivity.putExtras(bundle);
                v.getContext().startActivity(detailActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView place_name;
        ImageView place_image;
        TextView place_location;
        CardView place;

        public ViewHolder(View itemView) {
            super(itemView);

            place_image = (ImageView) itemView.findViewById(R.id.place_image);
            place_name = (TextView) itemView.findViewById(R.id.place_name);
            place_location = (TextView) itemView.findViewById(R.id.place_location);
            place = (CardView) itemView.findViewById(R.id.place);
        }
    }
}
