package com.example.ericcity.bandera;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class Bandera extends ActionBarActivity implements View.OnClickListener{

    Button b;
    Button b2;
    ImageButton b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bandera);

        b = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        //b.setOnClickListener(lis);
        b.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3 =(ImageButton) findViewById(R.id.snicker);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bandera, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // Gestionamos la selección

        switch (item.getItemId()) {
            case R.id.about:
                Toast.makeText(Bandera.this,"Hello",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.exit:
                    //Intent intent = new Intent(getApplicationContext(), Login.class);
                    //startActivity(intent);
                    finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }/*
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);*/
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button1:
                Toast.makeText(Bandera.this, "Calculadora", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Calculadora.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Toast.makeText(Bandera.this,"Login",Toast.LENGTH_SHORT).show();
                intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }

    public void onClickS(View v){/*
        View.OnClickListener myOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ResultActivity.class);//si fessim this. esariem accedint al listener per aixo fem getaplicationcontext
                startActivity(i);
            }
        };

        Snackbar.make(layout, R.string.snackbar_text, Snackbar.LENGTH_LONG)
                .setAction(R.string.snackbar_action, myOnClickListener)
                .show(); // Importante!!! No olvidar mostrar la Snackbar.*/

    }
}
