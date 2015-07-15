package com.example.ericcity.bandera;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends ActionBarActivity implements View.OnClickListener{


    EditText name;
    EditText pass;
    EditText address;

    BD baseDades;

    Button b;
    Button b2;
    Button ok;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = (EditText)findViewById(R.id.editText);
        pass =  (EditText) findViewById(R.id.editText2);
        address = (EditText) findViewById(R.id.editText4);

        b = (Button) findViewById(R.id.button3);
        b.setOnClickListener(this);
        b2 =(Button) findViewById(R.id.button4);
        b2.setOnClickListener(this);
        ok = (Button) findViewById(R.id.button);
        ok.setOnClickListener(this);

        baseDades = new BD(getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    int count = 0;

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                if ((name.getText().toString()==null)||(pass.getText().toString()==null)||(name.getText().toString()==null)) {
                    Toast.makeText(getApplicationContext(), "Hay campos en blanco.", Toast.LENGTH_SHORT).show();
                }
                else{
                    ContentValues valuesToStore = new ContentValues();
                    valuesToStore.put("name", String.valueOf(name.getText()));
                    valuesToStore.put("pass", String.valueOf(pass.getText()));
                    valuesToStore.put("address", String.valueOf(address.getText()));

                    baseDades.createUser(valuesToStore, "Login");

                    Toast.makeText(getApplicationContext(), "Fet", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    pass.setText("");
                    address.setText("");
                    Intent intent = new Intent(getApplicationContext(), TrueLogIn.class);
                    startActivity(intent);
                }
                break;
            case R.id.button4:
                Log.v("button4","Clicat");
                if (count == 5){
                    b.setVisibility(View.VISIBLE);
                }
                else{
                    count += 1;
                }
                break;
            case R.id.button3:
                Intent intent = new Intent(getApplicationContext(), UserList.class);
                startActivity(intent);
                break;

        }

    }
        //BD.createUser("dd",55);
        /*
        Intent intent = new Intent(getApplicationContext(), Calculadora.class);
        startActivity(intent);*/


}
