package com.example.ericcity.bandera;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Eric City on 03/07/2015.
 */
public class BD extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BaseDeDades";
    private static final String STATISTICS_TABLE_NAME = "Login";
    private static final String STATISTICS_TABLE_CREATE = "CREATE TABLE " + STATISTICS_TABLE_NAME
            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, pass TEXT, address TEXT, tries INTEGER)";


    BD(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(STATISTICS_TABLE_CREATE);
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + STATISTICS_TABLE_NAME);

        db.execSQL(STATISTICS_TABLE_CREATE);
    }

    public void createUser (ContentValues values, String tableName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(tableName, null, values);
    }

    public Cursor getPassByUser(String user) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {"pass"};
        String[] where = {user};
        Cursor c = db.query(
                STATISTICS_TABLE_NAME,                      // The table to query
                columns,                                    // The columns to return
                "name=?",                                   // The columns for the WHERE clause
                where,                                      // The values for the WHERE clause
                null,                                       // don't group the rows
                null,                                       // don't filter by row groups
                null                                        // The sort order
        );
        return c;
    }

    public Cursor getAddrByUser(String user) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {"address"};
        String[] where = {user};
        Cursor c = db.query(
                STATISTICS_TABLE_NAME,                      // The table to query
                columns,                                    // The columns to return
                "name=?",                                   // The columns for the WHERE clause
                where,                                      // The values for the WHERE clause
                null,                                       // don't group the rows
                null,                                       // don't filter by row groups
                null                                        // The sort order
        );
        return c;
    }

    public Cursor getAllUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {"name"};
        Cursor c = db.query(
                STATISTICS_TABLE_NAME,                  // The table to query
                columns,                                // The columns to return
                null,                                   // The columns for the WHERE clause
                null,                                   // The values for the WHERE clause
                null,                                   // don't group the rows
                null,                                   // don't filter by row groups
                null                                    // The sort order
        );

        return c;
    }


/*
    public void createUser(ContentValues user, ContentValues pass){/*
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(STATISTICS_TABLE_NAME, null, user);
        db.insert(STATISTICS_TABLE_NAME , null,pass) ;
        db.close();/*
        SQLiteDatabase bd = BD.getWritableDatabase();

        if (bd != null) {

            bd.execSQL("INSERT INTO STATISTICS_TABLE_NAME ('user','pass') VALUES ('us1','45')");
            bd.close();

        }

    }
*/
    /*
    public Cursor getIdByName(String Name) {
        BD bd = new BD (this);
        SQLiteDatabase db = bd.getReadableDatabase();
        Cursor c;
        return c;
    }*/
}
