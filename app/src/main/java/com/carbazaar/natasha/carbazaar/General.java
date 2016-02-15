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
 * Created by Natasha on 08-05-2015.
 */
public class General extends Fragment {

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

        //add item in arrayList (left)
        leftSideElement.add("Seller");
        leftSideElement.add("Registration");
        leftSideElement.add("Owner");
        leftSideElement.add("Insurance");
        leftSideElement.add("Engine");


//add item in arrayList (right)
        rightSideEelement.add("Dealer");
        rightSideEelement.add("Mumbai");
        rightSideEelement.add("First");
        rightSideEelement.add("Comprehensive");
        rightSideEelement.add("Manual,Diesel");

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
