package com.oxfam.protickrishiseba;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Heaven on 1/2/16.
 */
public class subsidyNameFragment extends Fragment {

    //recylcerView
//    private RecyclerView recyclerView;
//    private RecyclerView.LayoutManager layoutManager;
//    private RecyclerView.Adapter recyclerAdapter;

    public subsidyNameFragment() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyDBHandler db = new MyDBHandler(this.getActivity(),null,null,1);
//        db.addAgricultureSchemes();
//        db.addAgroService();
//        db.addAgroSProcess();
//        db.addAgroEligiblity();
        ArrayList list = db.getAllAgrNames();

        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.subsidy_name_fragment, container, false);
        //get the reference of the list view
        ListView listView = (ListView)rootView.findViewById(R.id.subsidy_name_listview);
        //set Customize Adapter

        CustomAdapter adapter = new CustomAdapter(this.getActivity(),list);
        //ArrayAdapter adapter = new ArrayAdapter(this.getActivity(),android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent = new Intent(getActivity(),SubsidyDetailActivity.class);
                startActivity(intent);

            }
        });

        //View rootView = inflater.inflate(R.layout.subsidy_recycle_view, container, false);


        //recylerview
//        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.rv);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false);
//        recyclerView.setLayoutManager(layoutManager);
//        RecyclerView.Adapter recyclerAdapter = new subsidyNameAdapter(list);
//
//        recyclerView.setAdapter(recyclerAdapter);
//        recyclerAdapter.setOnItemClickListener(new subsidyNameAdapter.OnRecyclerViewItemClickListener() {
//            @Override
//            public void onItemClick(View view, String data) {
//
//            }
//        });


        return rootView;
    }
}
