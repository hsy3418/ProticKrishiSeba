package com.oxfam.protickrishiseba;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;

/**
 * Created by Heaven on 2/2/16.
 */
public class CustomTabListener<T extends Fragment> implements ActionBar.TabListener {
    private Fragment fragment;
    private final Activity mActivity;
    private final String mTag;
    private final Class<T> mClass;

    public CustomTabListener(SubsidyActivity subsidyActivity, String name, Class<T> subsidyNameFragmentClass) {
        mActivity = subsidyActivity;
        mTag = name;
        mClass = subsidyNameFragmentClass;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        if(fragment==null){
            fragment = Fragment.instantiate(mActivity,mClass.getName());
            ft.add(android.R.id.content,fragment,mTag);
        }
        else{
           ft.attach(fragment);
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        if(fragment!=null){
            ft.detach(fragment);
        }

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
