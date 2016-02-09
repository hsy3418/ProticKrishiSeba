package com.oxfam.protickrishiseba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Heaven on 31/1/16.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    //dataversion
    private static final int DATABASE_VERSION = 1;
    //database name
    //private static final String DATABASE_NAME = "schemes.db";
//    private static final String DATABASE_NAME = "subsidy.db";
//    private static final String DATABASE_NAME = "subsidies.db";
    private static final String DATABASE_NAME = "BangladeshSchemes.db";
    // table name of agricultural subsidies
    private static final String TABLE_AGRICULTURE = "agriculture";
    //column in agriculture table
    private static final String AGRICULTURE_COLUMN_ID = "id";
    private static final String AGRICULTURE_COLUMN_Name = "name";
    //table name agricultural service covered
    private static final String TABLE_SERVICE = "service";
    private static final String AGR_SERVICE_COLUMN_ID = "id";
    private static final String AGR_SERVICE_COLUMN_Name = "name";
    //table name agricultural process
    private static final String TABLE_PROCESS = "process";
    private static final String AGR_PROCESS_COLUMN_ID = "id";
    private static final String AGR_PROCESS_COLUMN_Name = "name";
    //table name agricultural eligibility
    private static final String TABLE_ELIGIBILITY = "Eligibility";
    private static final String AGR_ELIGIBILITY_COLUMN_ID = "id";
    private static final String AGR_ELIGIBILITY_COLUMN_Name = "name";


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    //creating tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SerQuery = "CREATE TABLE "+TABLE_SERVICE+"("
                +  AGR_SERVICE_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," + AGR_SERVICE_COLUMN_Name+" TEXT"+");";
        db.execSQL(SerQuery);
        String query = "CREATE TABLE "+TABLE_AGRICULTURE+"("
                       + AGRICULTURE_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," + AGRICULTURE_COLUMN_Name+" TEXT"+");";
        db.execSQL(query);

        String ProQuery = "CREATE TABLE "+TABLE_PROCESS+"("
                +  AGR_PROCESS_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +AGR_PROCESS_COLUMN_Name+" TEXT"+");";
        db.execSQL(ProQuery);
        String eligibilityQuery = "CREATE TABLE "+TABLE_ELIGIBILITY+"("
                +  AGR_ELIGIBILITY_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +AGR_ELIGIBILITY_COLUMN_Name+" TEXT"+");";
        db.execSQL(eligibilityQuery);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
            //drop older table if exists
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_AGRICULTURE);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_SERVICE);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_PROCESS);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_ELIGIBILITY);
        onCreate(db);
    }

    //add row into agriculture table
    public void addAgricultureSchemes(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AGRICULTURE_COLUMN_Name,"Technology education is given by 14 IPM farmer field school");
        db.insert(TABLE_AGRICULTURE, null, values);
        values.put(AGRICULTURE_COLUMN_Name,"By IPP(Integrated Agricultural Production Project) Non toxic vegetable production technical education is given");
        db.insert(TABLE_AGRICULTURE, null, values);
        values.put(AGRICULTURE_COLUMN_Name,"IFMC(Households fruit and vegetable garden project)");
        db.insert(TABLE_AGRICULTURE, null, values);
        values.put(AGRICULTURE_COLUMN_Name,"IANFP(Integrated food and nutrition project)");
        db.insert(TABLE_AGRICULTURE, null, values);
        values.put(AGRICULTURE_COLUMN_Name,"By mechanized farming crop harvesting and growth project");
        db.insert(TABLE_AGRICULTURE, null, values);
        values.put(AGRICULTURE_COLUMN_Name,"Intermediate and advanced level paddy, wheat, Jute preservation and distribution project");
        db.insert(TABLE_AGRICULTURE, null, values);
        values.put(AGRICULTURE_COLUMN_Name,"Intermediate and advanced level pulse, oil, spices seed production project");
        db.insert(TABLE_AGRICULTURE, null, values);
        values.put(AGRICULTURE_COLUMN_Name,"Advanced seed production project");
        db.insert(TABLE_AGRICULTURE, null, values);
        values.put(AGRICULTURE_COLUMN_Name,"Employment program for the ultra poor");
        db.insert(TABLE_AGRICULTURE, null, values);
        db.close(); // Closing database connection
    }

    //add row to the table of agricultural covered service
    public void addAgroService(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AGR_SERVICE_COLUMN_Name,"Number of Sub-district based wheat exhibition plot – 10(Percentage as well as 33%)");
        db.insert(TABLE_SERVICE, null, values);
        values.put(AGR_SERVICE_COLUMN_Name,"Number of  Sub-district based Kalijira exhibition plot.");
        db.insert(TABLE_SERVICE, null, values);
        values.put(AGR_SERVICE_COLUMN_Name,"Provide free Power Tyler");
        db.insert(TABLE_SERVICE, null, values);
        values.put(AGR_SERVICE_COLUMN_Name,"Provide free shallow machine.");
        db.insert(TABLE_SERVICE, null, values);
        values.put(AGR_SERVICE_COLUMN_Name,"30% subsidies for agricultural machine supply.");
        db.insert(TABLE_SERVICE, null, values);
        values.put(AGR_SERVICE_COLUMN_Name,"The government's proposed budget for 2015-16 sanctions Tk 12,699 crore");
        db.insert(TABLE_SERVICE, null, values);
    }

    public void addAgroSProcess(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AGR_PROCESS_COLUMN_Name,"Science -based guidance to support the creation of improved stoves");
        db.insert(TABLE_PROCESS, null, values);
        values.put(AGR_PROCESS_COLUMN_Name,"Health, nutrition and family welfare Guidelines");
        db.insert(TABLE_PROCESS, null, values);
        values.put(AGR_PROCESS_COLUMN_Name,"Guidelines for the cultivation of oilseed crops in Bangladesh");
        db.insert(TABLE_PROCESS, null, values);
        values.put(AGR_PROCESS_COLUMN_Name,"Helpful guideline for making Candles");
        db.insert(TABLE_PROCESS, null, values);
        values.put(AGR_PROCESS_COLUMN_Name,"Various IGA support related information guidelines");
        db.insert(TABLE_PROCESS, null, values);
        values.put(AGR_PROCESS_COLUMN_Name,"Tasty Vitamin enriched Vegetable growing guidelines");
        db.insert(TABLE_PROCESS, null, values);
        values.put(AGR_PROCESS_COLUMN_Name,"Water-saving irrigation technology in Paddy Production guidelines");
        db.insert(TABLE_PROCESS, null, values);
        values.put(AGR_PROCESS_COLUMN_Name,"Women’s propaganda and circular formation");
        db.insert(TABLE_PROCESS, null, values);
        values.put(AGR_PROCESS_COLUMN_Name,"Nursery and Garden care and seeding development strategies");
        db.insert(TABLE_PROCESS, null, values);
        values.put(AGR_PROCESS_COLUMN_Name,"Cattle vaccination schedule");
        db.insert(TABLE_PROCESS, null, values);
    }

    public void addAgroEligiblity(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AGR_ELIGIBILITY_COLUMN_Name,"River bank erosion, Monga diseased, Haor –baor and sand islands including " +
                "the countries rural areas marginal farmers, ultra poor and permanent earnable residents; temperate area.");
        db.insert(TABLE_ELIGIBILITY, null, values);
        values.put(AGR_ELIGIBILITY_COLUMN_Name,"Interested to work but workless and unskilled poor person:");
        db.insert(TABLE_ELIGIBILITY, null, values);
        values.put(AGR_ELIGIBILITY_COLUMN_Name,"Workable person aged between 18-60");
        db.insert(TABLE_ELIGIBILITY, null, values);
        values.put(AGR_ELIGIBILITY_COLUMN_Name,"Regardless man and woman anyone is eligible to get a work of the family");
        db.insert(TABLE_ELIGIBILITY, null, values);
        values.put(AGR_ELIGIBILITY_COLUMN_Name,"Landless (Except dwelling house if a person owes a land 0.5 or less than that)" +
                " People of low income who don’t have pond to culture fish or livestock.");
        db.insert(TABLE_ELIGIBILITY, null, values);
        values.put(AGR_ELIGIBILITY_COLUMN_Name,"Day labourer or topical  labourer whose earnings are irregular," +
                " very little or no provision of family income such kind of man or woman");
        db.insert(TABLE_ELIGIBILITY, null, values);
        values.put(AGR_ELIGIBILITY_COLUMN_Name,"Landless or who owes land less than 0.15 such poor man/Woman.");
        db.insert(TABLE_ELIGIBILITY, null, values);
        values.put(AGR_ELIGIBILITY_COLUMN_Name,"Wife of  physically disabled husband/Disabled\n" +
                "Damaged by natural disasters like River bank erosion/Flood such kind of man/ woman.\n");
        db.insert(TABLE_ELIGIBILITY, null, values);

    }




    //get all of the schemes of agricultural subsidies
    public ArrayList getAllAgrNames() {
        ArrayList<String> agrNameList = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT * FROM "+ TABLE_AGRICULTURE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                agrNameList.add(cursor.getString(1));

            } while (cursor.moveToNext());
        }

        // return contact list
        return agrNameList;
    }

    //GET ALL THE ITEMS FROM THE AGRICULTURAL SERVICE TABLE
    public ArrayList getAllAgrServices() {
        ArrayList<String> agrServiceList = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT * FROM "+ TABLE_SERVICE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                agrServiceList.add(cursor.getString(1));

            } while (cursor.moveToNext());
        }

        // return contact list
        return agrServiceList;
    }

    public ArrayList getAllAgrProcess() {
        ArrayList<String> agrProcessList = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT * FROM "+ TABLE_PROCESS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                agrProcessList.add(cursor.getString(1));

            } while (cursor.moveToNext());
        }

        // return contact list
        return agrProcessList;
    }

    //GET ALL THE ITEMS FROM THE AGRICULTURAL SERVICE TABLE
    public ArrayList getAllAgrEligibilities() {
        ArrayList<String> agrEligibilityList = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT * FROM "+ TABLE_ELIGIBILITY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                agrEligibilityList.add(cursor.getString(1));

            } while (cursor.moveToNext());
        }

        // return contact list
        return agrEligibilityList;
    }
    //delete the schemes'name of agricultural subsidies
    public void deleteAgrNames() {
        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_AGRICULTURE, AGRICULTURE_COLUMN_ID + " = ?",
//                new String[] { String.valueOf(1) });
        db.close();
    }
}
