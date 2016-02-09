package com.oxfam.protickrishiseba;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class SubsidyDetailActivity extends ActionBarActivity {

    public void checkEligibility(View view){
        Intent i = new Intent(this,SubsidyCheckEligibilityActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subsidy_detail_activity);
//        Button btn = (Button)findViewById(R.id.subsidy_check_btn);
//        btn.setOnClickListener(
//                new Button.OnClickListener(){
//                    @Override
//                    public void onClick(View view) {
//                        Intent i = new Intent(this,SubsidyCheckEligibilityActivity.class);
//                        startActivity(i);
//                    }
//                }
//        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subsidy_detail_activity, menu);
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


}
