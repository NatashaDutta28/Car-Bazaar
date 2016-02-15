package com.carbazaar.natasha.carbazaar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by RU!NS on 08-05-2015.
 */
public class Features extends Fragment {

    private FrameLayout mFrameLayout;
    private ArrayList<String> leftSideElement =new ArrayList<>();
    private ArrayList<String> rightSideEelement =new ArrayList<>();
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (!leftSideElement.isEmpty()){
            leftSideElement.clear();
            rightSideEelement.clear();
        }
        leftSideElement.add("AC");
        leftSideElement.add("Engine");
        leftSideElement.add("Suspension");
        leftSideElement.add("Brakes");
        leftSideElement.add("Battery");



        rightSideEelement.add("Excellent");
        rightSideEelement.add("Excellent");
        rightSideEelement.add("Excellent");
        rightSideEelement.add("Excellent");
        rightSideEelement.add("Excellent");

        View view = inflater.inflate(R.layout.conditions, container, false);

        mFrameLayout = (FrameLayout) view.findViewById(R.id.frameLayoutContainer_fav_ads);

        View listGalleryView = LayoutInflater.from(getActivity()).inflate(R.layout.dynamic_list_view, container, false);


        mFrameLayout.removeAllViews();
        mFrameLayout.addView(listGalleryView);




        listView = (ListView) listGalleryView.findViewById(android.R.id.list);

        ShowingDetailsAdapter showingAdsAdapter = new ShowingDetailsAdapter(getActivity(), leftSideElement, rightSideEelement);

        listView.setAdapter(showingAdsAdapter);
        showingAdsAdapter.notifyDataSetInvalidated();




        return view;
    }

}
