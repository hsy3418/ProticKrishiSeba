package com.oxfam.protickrishiseba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Heaven on 4/2/16.
 *
 */

//class EligibilityItems{
//    String time;
//    boolean selected = false;
//
//
//    EligibilityItems(String time) {
//        this.time = time;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
//
//    public boolean isSelected() {
//        return selected;
//    }
//
//    public void setSelected(boolean selected) {
//        this.selected = selected;
//    }
//}







public class SubsidyEligibilityAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> items;

    public SubsidyEligibilityAdapter(Context context, ArrayList<String> items) {
        super(context, R.layout.subsidy_eligibilty_checkbox,items) ;
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.subsidy_eligibilty_checkbox,parent,false);

        //String item = getItem(position);
        CheckedTextView itemText = (CheckedTextView)customView.findViewById(R.id.checkbox);


        itemText.setText(items.get(position));

        return customView;

    }
}
