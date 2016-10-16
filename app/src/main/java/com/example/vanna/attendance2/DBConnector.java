package com.example.vanna.attendance2;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by malypoeur on 10/16/16.
 */

public class DBConnector extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "attendance.db.sqlite";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase sqliteDB;
    private static DBConnector instance = null;

    // singleton pattern

    public static DBConnector getDBInstance(Context context){
        if(instance == null){
            instance = new DBConnector(context);
        }
        return instance;
    }

    private DBConnector(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void displayAllStatus(){
        sqliteDB = getReadableDatabase();
        Cursor cursor = sqliteDB.rawQuery("SELECT * FROM ATTENDANCE", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Log.d("DB: ", "value column 0: " + cursor.getString(0) + " : " + cursor.getString(1) + " : " + cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.close();
    }


}


