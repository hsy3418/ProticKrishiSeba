package com.oxfam.protickrishiseba;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Heaven on 1/2/16.
 */
public class CustomAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> items;

    public CustomAdapter(Context context, ArrayList<String> items) {
        super(context, R.layout.custom_subsidy_textview,items) ;
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_subsidy_textview,parent,false);

        String item = getItem(position);
        TextView itemText = (TextView)customView.findViewById(R.id.custom_textview);


        itemText.setText(items.get(position));

        return customView;

    }
}
