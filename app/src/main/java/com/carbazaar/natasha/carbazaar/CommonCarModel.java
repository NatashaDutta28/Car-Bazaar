package com.carbazaar.natasha.carbazaar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

public class CommonCarModel extends Fragment {
    private PagerSlidingTabStrip tabs;
    private LinearLayout mTabsLinearLayout;
    private ImageView mImageView;
    private TextView mCar,mPrice;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_car_model, container,
                false);



        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        ViewPager pager = (ViewPager) view.findViewById(R.id.pager);

        mImageView= (ImageView)view.findViewById(R.id.carPic);
        mCar=(TextView)view.findViewById(R.id.commonCarName);
        mPrice=(TextView)view.findViewById(R.id.commonCarPrice);
// u can now setThat image Price in the respective iMageView and TextViews
        mImageView.setImageResource(Constant.carImage);
        mCar.setText(Constant.car);
        mPrice.setText("Rs "+Constant.carPrice +" Lacs");


        MyPagerAdapter2 adapter = new MyPagerAdapter2(getActivity().getSupportFragmentManager());

        pager.setAdapter(adapter);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, getResources().getDisplayMetrics());
        pager.setPageMargin(pageMargin);
        tabs.setViewPager(pager);
        setUpTabStrip();
        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabsLinearLayout = ((LinearLayout) tabs.getChildAt(0));

                for (int i = 0; i < mTabsLinearLayout.getChildCount(); i++) {
                    TextView tv = (TextView) mTabsLinearLayout.getChildAt(i);

                    if (i == position) {
                        tv.setTextColor(Color.parseColor("#ffffff"));
                    } else {
                        tv.setTextColor(Color.parseColor("#6A7B76"));
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ////changeColor();
        return view;
    }
    public void setUpTabStrip(){

        //your other customizations related to tab strip...blahblah
        // Set first tab selected
        mTabsLinearLayout = ((LinearLayout)tabs.getChildAt(0));



        for(int i=0; i < mTabsLinearLayout.getChildCount(); i++){
            TextView tv = (TextView) mTabsLinearLayout.getChildAt(i);


            if(i == 0){
                Log.d("Pos", "Pos");
                tv.setTextColor(Color.parseColor("#ffffff"));
            } else {
                Log.d("Pos","Posq");
                tv.setTextColor(Color.parseColor("#6A7B76"));
            }
        }
    }




}
