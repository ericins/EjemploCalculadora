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
            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, pass INTEGER)";


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
        db.insert(
                tableName,
                null,
                values);
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
