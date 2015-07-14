package com.example.ericcity.bandera;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Perfil extends ActionBarActivity {

    TextView Nom;
    TextView Adreca;
    SharedPreferences nombre;
    SharedPreferences.Editor editor;

    String noma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nombre = getSharedPreferences("Nom", Context.MODE_PRIVATE);
        editor = nombre.edit();


        Nom = (TextView)findViewById(R.id.textView9);
        Adreca = (TextView)findViewById(R.id.textView12);


        noma = nombre.getString("Nom", "a");
        Nom.setText(noma);
        Adreca.setText("My Awesome Text");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_perfil, menu);
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

    public void onClick(View v) {
        //silent = logged.getBoolean("LOGGED", false);
        switch (v.getId()) {
            case R.id.button13:
                Intent intent = new Intent(getApplicationContext(), Bandera.class);
                startActivity(intent);

                break;
            default:
                break;
        }
    }
}
