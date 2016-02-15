package com.carbazaar.natasha.carbazaar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class MyPagerAdapter_2 extends FragmentPagerAdapter {
    //if you want to change title u can change it from here
    //the class name Should be Shame as to avoid confusion
// change Heading name here
    private final String[] TITLES = { "General", "Features", "Conditions" };

    public MyPagerAdapter_2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                // Fragement for Android Tab
                //change General to specification or the class you will create
                return new General();
            case 1:
                // Fragment for Ios Tab
                return new Features();
            case 2:
                // Fragment for Windows Tab
                return new Conditions();


        }
        return null;
    }

}