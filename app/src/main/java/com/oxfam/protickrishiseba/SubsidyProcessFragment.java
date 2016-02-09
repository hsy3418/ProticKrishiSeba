package com.oxfam.protickrishiseba;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Heaven on 2/2/16.
 */
public class SubsidyProcessFragment extends Fragment {

    public SubsidyProcessFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
         View rootView = inflater.inflate(R.layout.subsidy_recycle_view, container, false);
        MyDBHandler db = new MyDBHandler(this.getActivity(),null,null,1);
        ArrayList list = db.getAllAgrProcess();
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//
//                // user interface interactions and updates on screen
//                // if you want to run this handler only once then delete below line
//
//
//                RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.rv);
//
//                recyclerView.setLayoutManager(layoutManager);
//                RecyclerView.Adapter recyclerAdapter = new subsidyNameAdapter(list);
//                recyclerView.setAdapter(recyclerAdapter);
//            }
//
//
//        };
//        Thread thread = new Thread(runnable);
//        thread.start();
        //ArrayList list = db.getAllAgrServices();
        //View rootView = inflater.inflate(R.layout.subsidy_recycle_view, container, false);
        //recylerview
        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter recyclerAdapter = new subsidyNameAdapter(list);
        recyclerView.setAdapter(recyclerAdapter);
        return rootView;
    }
}
