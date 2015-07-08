package com.example.ericcity.bandera;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Eric City on 08/07/2015.
 */
public class Adapter extends ListActivity{

    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    BD bd;

    protected void onCreate(Bundle savedInstanceState){

        bd = new BD(getApplicationContext());

        Cursor c = bd.getAllUsers();
    }
}
