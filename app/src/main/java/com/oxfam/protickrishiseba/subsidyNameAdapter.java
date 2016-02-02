package com.oxfam.protickrishiseba;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Heaven on 1/2/16.
 */
public class subsidyNameAdapter extends RecyclerView.Adapter<subsidyNameAdapter.subsidyNameViewHolder> {

    private ArrayList<String> subsidyNames;

    public subsidyNameAdapter(ArrayList<String> subsidyNames) {
        this.subsidyNames = subsidyNames;
    }

    @Override
    public subsidyNameViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.subsidy_row_item_cardview,viewGroup,false);
        subsidyNameViewHolder subsidyHolder = new subsidyNameViewHolder(v);
        return subsidyHolder;
    }

    @Override
    public void onBindViewHolder(subsidyNameViewHolder subsidyNameViewHolder, int i) {
        subsidyNameViewHolder.subsidyName.setText(subsidyNames.get(i));
    }

    @Override
    public int getItemCount() {
        return subsidyNames.size();
    }

    public class subsidyNameViewHolder extends RecyclerView.ViewHolder{
        TextView subsidyName;

        public subsidyNameViewHolder(View itemView) {
            super(itemView);
            subsidyName = (TextView)itemView.findViewById(R.id.subsidy_name_card);
        }
    }
}
