package com.mkenlo.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AttractionsPageOne extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ATTRACTION_NAME = "attractionName";
    private static final String ARG_ATTRACTION_DESC = "attractionDesc";

    private String attractionName;
    private String attractionDesc;

    public AttractionsPageOne() {
    }

    public static AttractionsPageOne newInstance(String placeName, String placeDesc) {
        AttractionsPageOne fragment = new AttractionsPageOne();
        Bundle args = new Bundle();
        args.putString(ARG_ATTRACTION_NAME, placeName);
        args.putString(ARG_ATTRACTION_DESC, placeDesc);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            attractionName = getArguments().getString(ARG_ATTRACTION_NAME);
            attractionDesc = getArguments().getString(ARG_ATTRACTION_DESC);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_attractions_page_one, container, false);
        TextView textViewName = (TextView) rootView.findViewById(R.id.attraction_name);

        TextView textViewDesc = (TextView) rootView.findViewById(R.id.attraction_desc);
        textViewName.setText(attractionName);
        textViewDesc.setText(attractionDesc);
        return rootView;
    }

}
