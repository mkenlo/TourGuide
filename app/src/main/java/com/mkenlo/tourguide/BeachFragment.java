package com.mkenlo.tourguide;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BeachFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public BeachFragment() {
        // Required empty public constructor
    }

    public static BeachFragment newInstance(String param1, String param2) {
        BeachFragment fragment = new BeachFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beach, container, false);
    }

    public class BeachAdapter extends RecyclerView.Adapter<BeachAdapter.ViewHolder> {

        private List<Attractions> list_beach;
        private Context context;

        public BeachAdapter(List<Attractions> list, Context context) {
            this.list_beach = list;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_beach_item, parent, false);
            return new ViewHolder(v);

        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final Attractions city = list_beach.get(position);

            Drawable imgDrawable = ContextCompat.getDrawable(context,
                    context.getResources().getIdentifier(city.getHeader(), "drawable", context.getPackageName()));
            holder.city_image.setImageDrawable(imgDrawable);
            holder.city_name.setText(city.getName());
            holder.city_location.setText(city.getLocation());
            holder.city.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent cityActivity = new Intent(v.getContext(), CitiesActivity.class);
                    cityActivity.putExtra("cityId", city.getId());
                    context.startActivity(cityActivity);

                }
            });

        }

        @Override
        public int getItemCount() {
            return list_beach.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView city_name;
            TextView city_location;
            ImageView city_image;
            CardView city;

            public ViewHolder(View v) {
                super(v);

                city_name = (TextView) v.findViewById(R.id.city_name);
                city_location = (TextView) v.findViewById(R.id.city_location);
                city_image = (ImageView) v.findViewById(R.id.city_image);
                city = (CardView) v.findViewById(R.id.city);

            }
        }

    }
}
