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
    private static final String DATABASE_NAME = "schemes.db";
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


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    //creating tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TABLE_AGRICULTURE+"("
                       + AGRICULTURE_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," + AGRICULTURE_COLUMN_Name+" TEXT"+");";
        String SerQuery = "CREATE TABLE "+TABLE_SERVICE+"("
                +  AGR_SERVICE_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," + AGR_SERVICE_COLUMN_Name+" TEXT"+");";
        String ProQuery = "CREATE TABLE "+TABLE_PROCESS+"("
                +  AGR_PROCESS_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +AGR_PROCESS_COLUMN_Name+" TEXT"+");";
        db.execSQL(query);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
            //drop older table if exists
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_AGRICULTURE);
        onCreate(db);
    }

    //add row
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

    //delete the schemes'name of agricultural subsidies
    public void deleteAgrNames() {
        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_AGRICULTURE, AGRICULTURE_COLUMN_ID + " = ?",
//                new String[] { String.valueOf(1) });
        db.close();
    }
}
