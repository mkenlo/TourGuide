package com.mkenlo.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AttractionsFragment extends Fragment {

    private static final String ARG_ATTRACTION = "attraction_type_param";

    private int attraction_type;


    public AttractionsFragment() {
        // Required empty public constructor
    }

    public static AttractionsFragment newInstance(int attraction_type) {
        AttractionsFragment fragment = new AttractionsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ATTRACTION, attraction_type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            attraction_type = getArguments().getInt(ARG_ATTRACTION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_attractions, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.attractions);
        rv.setHasFixedSize(true);

        List<Attractions> places = getAttractionType(attraction_type);
        AttractionsRecyclerAdapter mAdapter = new AttractionsRecyclerAdapter(places, getContext());
        rv.setAdapter(mAdapter);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);

        return rootView;
    }

    public List<Attractions> getAttractionType(int type) {
        JsonData mData = new JsonData(getContext());
        switch (type) {
            case 0:
                return mData.getCityList();
            case 1:
                return mData.getBeachList();
            case 2:
                return mData.getParkList();
            case 3:
                return mData.getStreetList();
        }
        return null;
    }
}
