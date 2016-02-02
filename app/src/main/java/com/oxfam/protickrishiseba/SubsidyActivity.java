package com.oxfam.protickrishiseba;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class SubsidyActivity extends ActionBarActivity {

    //MyDBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subsidy_main);
        //get the reference of the list view
        //ListView listView = (ListView)findViewById(R.id.subsidy_name_listview);
        //set Customize Adapter
       // db = new MyDBHandler(this,null,null,1);
        //set action bar
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new subsidyNameFragment())
//                    .commit();
//        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);// NAVIGATION_MODE_TABS常量表示Tab导航模式
        actionBar.setDisplayShowTitleEnabled(true);// 这里的Title显示的是Activity的android:label属性指定的文字，也就是图1中”Google Play”


        ActionBar.Tab tab = actionBar.newTab().setText("Name").setTabListener(new CustomTabListener<subsidyNameFragment>(
                this,"Name",subsidyNameFragment.class));
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("Eligibility").setTabListener(new CustomTabListener<SubsidyEligibilityFragment>(
                this,"Eligibility",SubsidyEligibilityFragment.class));
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("Service").setTabListener(new CustomTabListener<SubsidyServiceFragment>(
                this,"Service",SubsidyServiceFragment.class));
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("Process").setTabListener(new CustomTabListener<SubsidyProcessFragment>(
                this,"Process",SubsidyProcessFragment.class));
        actionBar.addTab(tab);
        




//        ActionBar.Tab tab = actionBar.newTab().setText("Name").setTabListener(this);
//        actionBar.addTab(tab);
//        tab = actionBar.newTab().setText("Eligibility").setTabListener(this);
//        actionBar.addTab(tab);
//        tab = actionBar.newTab().setText("Service").setTabListener(this);
//        actionBar.addTab(tab);
//        tab = actionBar.newTab().setText("Process").setTabListener(this);
//        actionBar.addTab(tab);
        actionBar.setTitle("Agriculture Subsidy");




    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subsidy_name_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
//        switch (tab.getPosition()) {
//            case 0:
//                subsidyNameFragment subsidy = new subsidyNameFragment();
//                ft.add(android.R.id.content,subsidy);
//
////      ft.commit();
//                break;
//            case 1:
//
//                SubsidyEligibilityFragment eligibility = new SubsidyEligibilityFragment();
//                ft.add(android.R.id.content, eligibility);
//                Toast.makeText(this,"success",Toast.LENGTH_LONG).show();
////      ft.commit();
//                break;
//            case 2:
//                SubsidyServiceFragment service = new SubsidyServiceFragment();
//                ft.add(android.R.id.content, service);
////      ft.commit();
//                break;
//            case 3:
//                SubsidyProcessFragment process = new SubsidyProcessFragment();
//                ft.add(android.R.id.content, process);
//            default:
//                break;
//        }
//
//    }
//
//    @Override
//    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
//
//    }
//
//    @Override
//    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
//
//    }
}
