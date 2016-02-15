package com.carbazaar.natasha.carbazaar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CarCompanyAdapter extends BaseAdapter {

    private String[] carCompanies;
    private Integer[] imagesArray;


    private LayoutInflater l_Inflater;

    public CarCompanyAdapter(Context context, String[] carsCompanies, Integer[] imagesArray) {
        this.carCompanies = carsCompanies;
        this.imagesArray= imagesArray;
        l_Inflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return carCompanies.length;
    }

    public Object getItem(int position) {
        return carCompanies[position];
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = l_Inflater.inflate(R.layout.row_layout_2, parent, false);
            holder = new ViewHolder();
            holder.companyName = (TextView) convertView.findViewById(R.id.carCompanyName);
            holder.companyLogo = (ImageView) convertView.findViewById(R.id.companyLogo);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.companyName.setText(carCompanies[position]);
        holder.companyLogo.setImageResource(imagesArray[position]);
        return convertView;

    }

    static class ViewHolder {
        TextView companyName;
        ImageView companyLogo;
    }

}
