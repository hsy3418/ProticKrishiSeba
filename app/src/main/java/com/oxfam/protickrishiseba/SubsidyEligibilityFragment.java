package com.oxfam.protickrishiseba;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Heaven on 2/2/16.
 */
public class SubsidyEligibilityFragment extends Fragment {

    public SubsidyEligibilityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.subsidy_eligbility_fragment, container, false);
        return rootView;
    }
}
