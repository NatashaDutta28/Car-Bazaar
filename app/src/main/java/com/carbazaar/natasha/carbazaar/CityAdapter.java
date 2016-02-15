package com.carbazaar.natasha.carbazaar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by RU!NS on 09-05-2015.
 */
public class CityAdapter extends BaseAdapter{

    private final LayoutInflater l_Inflater;
    private String[] cityList;
    private Context context;

    public CityAdapter(Context context,String[] cityList) {

        this.context=context;
        this.cityList = cityList;
        l_Inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return cityList.length;
    }

    @Override
    public Object getItem(int position) {
        return cityList[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView==null){
            convertView = l_Inflater.inflate(R.layout.city_row, parent, false);
            viewHolder.cityName = (TextView)convertView.findViewById(R.id.cityName);
            viewHolder.cityName.setText(cityList[position]);
            convertView.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder) convertView.getTag();

        }
        return convertView;
    }

   class ViewHolder{
         TextView cityName;
    }
}
