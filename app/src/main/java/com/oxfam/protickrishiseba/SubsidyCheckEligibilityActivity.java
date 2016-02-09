package com.oxfam.protickrishiseba;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SubsidyCheckEligibilityActivity extends ActionBarActivity {

    private  static RadioGroup radioGroup;
    private static RadioButton radioButton;
    private static Button button;
    private TextView textView;

    //private Fragment fragment;
    ArrayList list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subsidy_check_eligibility);
        textView = (TextView) findViewById(R.id.eligibility_criteria);
        MyDBHandler db = new MyDBHandler(this, null, null, 1);
        list = db.getAllAgrEligibilities();
        textView.setText((String) list.get(0));
        onClickListenerButton();
        //fragment = getSupportFragmentManager().findFragmentById(R.id.eligibility_criteria);


//        MyDBHandler db = new MyDBHandler(this, null, null, 1);
//        list = db.getAllAgrEligibilities();
//        //int i = 0;
//
//        Button btnYes = (Button) findViewById(R.id.yesbtn);
//        TextView textView = (TextView) findViewById(R.id.eligibility_criteria);
//        Button btnNo = (Button) findViewById(R.id.nobtn);
//
//        textView.setText((String) list.get(0));
//        btnYes.setOnClickListener(
//                new Button.OnClickListener(){
//                    @Override
//                    public void onClick(View view) {
//                        Intent i = new Intent(SubsidyCheckEligibilityActivity.this,SubsidyDetailActivity.class);
//                        startActivity(i);
//                    }
//                });
//
//            int i = 0;
//            btnNo.setOnClickListener(
//                    new Button.OnClickListener(){
//                        @Override
//                        public void onClick(View view) {
//
//
//                            TextView textView = (TextView) findViewById(R.id.eligibility_criteria);
//                            textView.setText((String) list.get(i+1));
//                        }
//                    });




//        for(int i = 0;i<list.size();i++) {
//            TextView textView = (TextView) findViewById(R.id.eligibility_criteria);
//            textView.setText((String) list.get(0));
//        }
//        FragmentManager fragmentManager = this.getSupportFragmentManager();
//        Fragment fragment = null;
//        fragment = new SubsidyCriteriaFragment("ii");
//        fragmentManager.beginTransaction()
//                .replace(R.id.container, fragment)
//                .commit();
    }
    public void onClickListenerButton(){
        radioGroup = (RadioGroup)findViewById(R.id.group);
        button = (Button)findViewById(R.id.yesbtn);
        MyDBHandler db = new MyDBHandler(this, null, null, 1);
        list = db.getAllAgrEligibilities();

        button.setOnClickListener(
                new View.OnClickListener(){
                    int i = 1;
                    @Override
                    public void onClick(View view) {


                        //while (i <= list.size()){
                            int selected_id = radioGroup.getCheckedRadioButtonId();
                        radioButton = (RadioButton) findViewById(selected_id);
                        if (radioButton.getText().toString().equals("Yes")) {
                            Intent intent = new Intent(SubsidyCheckEligibilityActivity.this, SubsidyDetailActivity.class);
                            startActivity(intent);

                        } else {
                            if(i < list.size()) {
                                TextView textView = (TextView) findViewById(R.id.eligibility_criteria);
                                textView.setText((String) list.get(i));
                                radioGroup.clearCheck();
                                i++;
                            }else if(i==list.size()){
                                AlertDialog.Builder builder = new AlertDialog.Builder(SubsidyCheckEligibilityActivity.this);
                                builder.setTitle("Sorry.");
                                builder.setMessage("You are not eligible for applying Agricultural Subsidies");
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // TODO Auto-generated method stub



                                    }

                                });
                                builder.show();

                            }



                        //}

                    }

                    }
                }
        );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subsidy_check_eligibility, menu);
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
