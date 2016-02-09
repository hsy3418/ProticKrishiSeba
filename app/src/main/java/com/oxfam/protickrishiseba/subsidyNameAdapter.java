package com.oxfam.protickrishiseba;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Heaven on 1/2/16.
 */
public class subsidyNameAdapter extends RecyclerView.Adapter<subsidyNameAdapter.subsidyNameViewHolder> implements View.OnClickListener{

    private ArrayList<String> subsidyNames;

    public subsidyNameAdapter(ArrayList<String> subsidyNames) {
        this.subsidyNames = subsidyNames;
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }

    @Override
    public subsidyNameViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.subsidy_row_item_cardview,viewGroup,false);
        subsidyNameViewHolder subsidyHolder = new subsidyNameViewHolder(v);
        v.setOnClickListener(this);
        return subsidyHolder;
    }

    @Override
    public void onBindViewHolder(subsidyNameViewHolder subsidyNameViewHolder, int i) {
        subsidyNameViewHolder.subsidyName.setText(subsidyNames.get(i));
        subsidyNameViewHolder.itemView.setTag(subsidyNames.get(i));
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(String)v.getTag());
        }

    }


    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
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
//            itemView.setOnClickListener(new View.OnClickListener(){
//
//                @Override
//                public void onClick(View view) {
//                    Intent i = new Intent(view.getContext(), SubsidyDetailActivity.class);
//                    view.getContext().startActivity(i);
//
//                }
//            });
        }
    }
}
