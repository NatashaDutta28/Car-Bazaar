package com.carbazaar.natasha.carbazaar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ShowingDetailsAdapter extends BaseAdapter {

    private final LayoutInflater l_Inflater;
    private ArrayList<String> leftSideElement = new ArrayList<>();
    private ArrayList<String> rightSideEelement = new ArrayList<>();
    private Context context;

    public ShowingDetailsAdapter(Context context, ArrayList<String> leftSideElement, ArrayList<String> rightSideELement) {

        if (!leftSideElement.isEmpty()) {
            this.leftSideElement.clear();
            this.rightSideEelement.clear();

        }
        this.leftSideElement = leftSideElement;
        this.rightSideEelement = rightSideELement;
        this.context = context;
        l_Inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return leftSideElement.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = l_Inflater.inflate(R.layout.details_row, parent, false);
            holder.leftSideTextView = (TextView) convertView.findViewById(R.id.leftSideElement);
            holder.rightSideTextView = (TextView) convertView.findViewById(R.id.rightSideElement);


            holder.leftSideTextView.setText(leftSideElement.get(position));
            holder.rightSideTextView.setText(rightSideEelement.get(position));


            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();

        }
        return convertView;
    }

    class ViewHolder {
        TextView leftSideTextView, rightSideTextView;
    }
}
