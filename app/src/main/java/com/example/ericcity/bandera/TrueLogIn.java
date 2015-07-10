package com.example.ericcity.bandera;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class TrueLogIn extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_log_in);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_true_log_in, menu);
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

    BD bd;
    TextView tuser;
    TextView tpass;
    String user;
    String passcomp;
    boolean permis = false;
    Toast a;

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button10:
                Toast.makeText(TrueLogIn.this, "Register", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                break;
            case R.id.button9:
                tuser = (TextView) findViewById(R.id.editText5);
                tpass = (TextView) findViewById(R.id.editText6);

                bd = new BD(getApplicationContext());

                user = tuser.getText().toString();

                Cursor c = bd.getPassByUser(user);
                passcomp = c.toString();

                if (passcomp.equals(tpass)){
                    permis = true;
                }
                else{
                    a = Toast.makeText(TrueLogIn.this, "Wrong password.", Toast.LENGTH_SHORT);
                }
                break;
            default:
                break;
        }
    }
}
