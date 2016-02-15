package com.carbazaar.natasha.carbazaar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RU!NS on 07-05-2015.
 */
public class SearchAdapter extends BaseAdapter {

    private ArrayList<String> carCompanies = new ArrayList<>();
    private ArrayList<Integer> imagesArray = new ArrayList<>();
    private ArrayList<Integer> carPrice = new ArrayList<>();

    private LayoutInflater l_Inflater;

    public SearchAdapter(Context context, ArrayList<String> carsCompanies, ArrayList<Integer> imagesArray, ArrayList<Integer> carPrice) {
        this.carCompanies = carsCompanies;
        this.imagesArray = imagesArray;
        this.carPrice = carPrice;
        l_Inflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return carCompanies.size();
    }

    public Object getItem(int position) {
        return carCompanies.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = l_Inflater.inflate(R.layout.search_row, parent, false);
            holder = new ViewHolder();
            holder.companyName = (TextView) convertView.findViewById(R.id.carCompanyName);
            holder.carPriceTag = (TextView) convertView.findViewById(R.id.textCarPrice);
            holder.companyLogo = (ImageView) convertView.findViewById(R.id.companyLogo);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.companyName.setText(carCompanies.get(position));
        holder.companyLogo.setImageResource(imagesArray.get(position));
        holder.carPriceTag.setText("Rs "+carPrice.get(position)+" Lacs");
        return convertView;

    }

    static class ViewHolder {
        TextView companyName, carPriceTag;
        ImageView companyLogo;
    }

}
