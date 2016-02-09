package com.oxfam.protickrishiseba;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Heaven on 2/2/16.
 */
public class SubsidyEligibilityFragment extends Fragment {


    private ListView listView;
    ArrayList list;
    SubsidyEligibilityAdapter adapter;
    public SubsidyEligibilityFragment() {



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.subsidy_eligbility_fragment, container, false);
        MyDBHandler db = new MyDBHandler(this.getActivity(), null, null, 1);


        // list = db.getAllAgrEligibilities();
//        MyDBHandler db = new MyDBHandler(this.getActivity(),null,null,1);
//        list = db.getAllAgrEligibilities();
        //list.add("None of them above");
//        adapter = new SubsidyEligibilityAdapter(list,this.getActivity());
        list = db.getAllAgrEligibilities();
        list.add("None of them above");
        listView = (ListView) rootView.findViewById(R.id.eligibility_listview);
//        listView.setAdapter(adapter);
        //SubsidyEligibilityAdapter adapter = new SubsidyEligibilityAdapter(this.getActivity(),list);
        listView.setAdapter(new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_multiple_choice, list) {
                                @Override
                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View v = super.getView(position, convertView, parent);
                                    //View v = LayoutInflater.from(InvitationFlowActivity.this).inflate(android.R.layout.simple_list_item_multiple_choice, null);
//                                    TextView tv =(TextView )v.findViewById(android.R.id.text1);
//                                    tv.setTextColor(Color.BLACK);
                                    TextView text = (TextView) v.findViewById(android.R.id.text1);
                                    text.setTextColor(Color.parseColor("#666666"));
                                    ListView.LayoutParams params = new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.WRAP_CONTENT);
                                    params.height = 140;
                                    text.setLayoutParams(params);


//                                  text.setHeight(180);
//                                    text.setHeight(50);
//                                    text.setMinimumHeight(50);
                                    //text.set(200); // Height
                                    text.setTextSize(15);
                                    return v;
                                }
                            }
        );

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int lastPosition = listView.getCount() - 1;
                //CheckedTextView checkedTextView = (CheckedTextView) rootView.findViewById(android.R.id.text1);
                //int lastView = listView.getPositionForView(view);
                CheckedTextView  checkedTextView  = (CheckedTextView)view;
                //toggle( checkedTextView );
               // Dialog dialog = new Dialog(getActivity(),android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                if (checkedTextView.isChecked() == true) {
                    if (position != lastPosition) {
                       // dialog.setTitle("Congratulation! You are eligible");

                          builder.setTitle("Check Eligibility");
                          int j = 0;
                          do {
                              //Toast.makeText(getContext(),j,Toast.LENGTH_LONG);
                              builder.setMessage((String)list.get(0));
                              builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                  @Override
                                  public void onClick(DialogInterface dialog, int which) {
                                      // TODO Auto-generated method stub
                                      Intent i = new Intent(getActivity(), subsidy_address_activity.class);
                                      startActivity(i);


                                  }

                              });
                              builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                                  @Override
                                  public void onClick(DialogInterface dialog, int which) {
                                      // TODO Auto-generated method stub
                                      //return;
                                  }
                              });
                              j++;

                          }while(j<10);

//                          for(int i = 0; i < list.size();i++ ){
//                              builder.setMessage((String)list.get(i+1));
//                              builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                              @Override
//                              public void onClick(DialogInterface dialog, int which) {
//                                // TODO Auto-generated method stub
//                                Intent i = new Intent(getActivity(), subsidy_address_activity.class);
//                                startActivity(i);
//
//
//                            }
//
//                        });
//                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                // TODO Auto-generated method stub
//                                    return;
//                            }
//                        });
//                          }
//                        builder.setTitle("Congratulation! You are eligible");
//                        builder.setMessage("Go to see how to apply...");
//                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                // TODO Auto-generated method stub
//                                Intent i = new Intent(getActivity(), subsidy_address_activity.class);
//                                startActivity(i);
//
//                            }
//                        });
//                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                // TODO Auto-generated method stub
//
//                            }
//                        });
//                    } else {
//                        builder.setTitle("Sorry");
//                        builder.setMessage("You are not eligible..");
//                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                // TODO Auto-generated method stub
//
//
//                            }
//                        });

                    }
                }
                //dialog.show();
                builder.show();


                ;
            }
        });
//        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this.getActivity());
        //listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);
//        listView.setOnItemClickListener(
//                new AdapterView.OnItemClickListener(){
//                    @Override
////                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
////                        Toast.makeText(getActivity(), position + " checked : ",Toast.LENGTH_SHORT).show();
////                    }
////                }
////        );
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                String selectedValue = (String) adapter.getItem(position);
//                Toast.makeText(getActivity(), position+"ddd", Toast.LENGTH_SHORT).show();
////                String item = adapter.getItem(position);
////                Toast.makeText(getActivity(),"No."+item,Toast.LENGTH_LONG).show();
//
//            }
//        });
////
//        Button button = (Button)rootView.findViewById(R.id.checkButton);
//        button.setOnClickListener(
//                new Button.OnClickListener(){
//                    @Override
//                    public void onClick(View view) {
//                      // int pos = listView.getCheckedItemPosition();
//                        //Toast.makeText(getActivity(), "Click item"+pos, Toast.LENGTH_SHORT).show();
//                       // int pos = listView.getPositionForView(view);
//                        //Toast.makeText(getActivity(), "Click item"+pos, Toast.LENGTH_SHORT).show();
//                        //CheckBox checkBox = (CheckBox)rootView.findViewById(pos);
//                        for(int i = 0;i<listView.getChildCount();i++)
//                        {
//                            //View viewItem = listView.getChildAt(i);
//                            CheckedTextView cv = (CheckedTextView) rootView.findViewById(android.R.id.text1);
//                            //CheckedTextView cv =(CheckedTextView)viewItem.findViewById(android.R.id.text1);
//
//                            if(cv.isChecked())
//                            {
//                                Toast.makeText(getActivity(), "Click item", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }
//                });
//                        if(checkBox.isChecked()==true) {
//                            Toast.makeText(getActivity(), "Click item"+pos, Toast.LENGTH_SHORT).show();
//                        }
//                        else {
//                            Toast.makeText(getActivity(), "wRONG", Toast.LENGTH_SHORT).show();
//                        }



        return rootView;
    }

        public void toggle(CheckedTextView v)
        {
            if (v.isChecked())
            {
                v.setChecked(false);
            }
            else
            {
                v.setChecked(true);
            }
        }

//
//    @Override
//    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//        int pos = listView.getPositionForView(compoundButton);
//        if(pos != ListView.INVALID_POSITION){
//            String i = (String) list.get(pos);
//            Toast.makeText(getActivity(), "Click item"+pos, Toast.LENGTH_SHORT).show();
//
//        }
//    }

//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//        CheckBox chec
//        Toast.makeText(view.getContext(),checkbox.isSelected()+"d",Toast.LENGTH_LONG).show();
//    }

//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        CheckedTextView ctv = (CheckedTextView)view;
//        if(ctv.isChecked()){
//            Toast.makeText(this.getActivity(), "now it is unchecked", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(this.getActivity(), "now it is checked", Toast.LENGTH_SHORT).show();
//        }
//    }

//    @Override
//    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//        int pos = listView.getPositionForView(compoundButton);
//        if(pos != listView.INVALID_POSITION && pos != listView.getLastVisiblePosition()){
//            String o =(String) list.get(pos);
//
////            CheckBox chk = (CheckBox) customView.findViewById(R.id.subsidies_eligibility_checkBox);
////            chk.setChecked(false);
//            Toast.makeText(getContext(),"Hello",Toast.LENGTH_LONG).show();
//
//        }
//    }





}
