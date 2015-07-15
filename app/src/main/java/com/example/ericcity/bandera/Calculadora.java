package com.example.ericcity.bandera;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Calculadora extends ActionBarActivity {

    TextView Numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        Numero = (TextView) findViewById(R.id.editText3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.nav:
                Toast a = Toast.makeText(Calculadora.this, "Abriendo navegador", Toast.LENGTH_SHORT);
                a.setGravity(Gravity.CENTER, 0, 0);
                a.setDuration(Toast.LENGTH_SHORT);
                a.show();
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.google.com"));
                startActivity(i);
            case R.id.exit:
                //Intent intent = new Intent(getApplicationContext(), Login.class);
                //startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    /*
    public void onClick(View v){
        Toast.makeText(Calculadora.this, "Borrado", Toast.LENGTH_SHORT).show();
    }
    */

    int primero = 0;
    int segundo = 0;
    boolean sign = false;
    String signo;
    int ans = 0;

    public void onClick(View v) {
        if (!sign) {
            int num;

            // i = Integer.parseInt(Numero.getText().toString());
            primero *= 10;

            switch (v.getId()) {
                case R.id.butt1:
                    num = 1;
                    primero += num;
                    Numero.setText(String.valueOf(primero));
                    break;
                case R.id.butt2:
                    num = 2;
                    primero += num;
                    Numero.setText(String.valueOf(primero));
                    break;
                case R.id.butt3:
                    num = 3;
                    primero += num;
                    Numero.setText(String.valueOf(primero));
                    break;
                case R.id.butt4:
                    num = 4;
                    primero += num;
                    Numero.setText(String.valueOf(primero));
                    break;
                case R.id.butt5:
                    num = 5;
                    primero += num;
                    Numero.setText(String.valueOf(primero));
                    break;
                case R.id.butt6:
                    num = 6;
                    primero += num;
                    Numero.setText(String.valueOf(primero));
                    break;
                case R.id.butt7:
                    num = 7;
                    primero += num;
                    Numero.setText(String.valueOf(primero));
                    break;
                case R.id.butt8:
                    num = 8;
                    primero += num;
                    Numero.setText(String.valueOf(primero));
                    break;
                case R.id.butt9:
                    num = 9;
                    primero += num;
                    Numero.setText(String.valueOf(primero));
                    break;
                case R.id.butt0:
                    num = 0;
                    primero += num;
                    Numero.setText(String.valueOf(primero));
                    break;
                default:
                   // Toast.makeText(Calculadora.this, "It's free", Toast.LENGTH_SHORT).show();
                    break;
            }

        }else{
            int num;
            // i = Integer.parseInt(Numero.getText().toString());
            segundo *= 10;

            switch (v.getId()) {
                case R.id.butt1:
                    num = 1;
                    segundo += num;
                    Numero.setText(String.valueOf(primero + signo + segundo));
                    break;
                case R.id.butt2:
                    num = 2;
                    segundo += num;
                    Numero.setText(String.valueOf(primero + signo + segundo));
                    break;
                case R.id.butt3:
                    num = 3;
                    segundo += num;
                    Numero.setText(String.valueOf(primero + signo + segundo));
                    break;
                case R.id.butt4:
                    num = 4;
                    segundo += num;
                    Numero.setText(String.valueOf(primero + signo + segundo));
                    break;
                case R.id.butt5:
                    num = 5;
                    segundo += num;
                    Numero.setText(String.valueOf(primero + signo + segundo));
                    break;
                case R.id.butt6:
                    num = 6;
                    segundo += num;
                    Numero.setText(String.valueOf(primero + signo + segundo));
                    break;
                case R.id.butt7:
                    num = 7;
                    segundo += num;
                    Numero.setText(String.valueOf(primero + signo + segundo));
                    break;
                case R.id.butt8:
                    num = 8;
                    segundo += num;
                    Numero.setText(String.valueOf(primero + signo + segundo));
                    break;
                case R.id.butt9:
                    num = 9;
                    segundo += num;
                    Numero.setText(String.valueOf(primero + signo + segundo));
                    break;
                case R.id.butt0:
                    num = 0;
                    segundo += num;
                    Numero.setText(String.valueOf(primero + signo + segundo));
                    break;
                default:
                    // Toast.makeText(Calculadora.this, "It's free", Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    }


    public void onClickSigno(View v){
        String signo2;
        switch(v.getId()){
            case R.id.butts:
                if (!sign){
                    sign = true;
                    Numero.setText(primero + "+");
                    signo="+";
                }
                else{
                    signo2 = "+";
                    int resultado=0;
                    switch (signo){
                        case "+":
                            resultado = primero + segundo;
                            Numero.setText(resultado + signo2);
                            break;
                        case "-":
                            resultado = primero - segundo;
                            Numero.setText(resultado + signo2);
                            break;
                        case "*":
                            resultado = primero * segundo;
                            Numero.setText(resultado + signo2);
                            break;
                        case "/":
                            if (segundo==0){
                                Toast.makeText(Calculadora.this, "Error /0", Toast.LENGTH_SHORT).show();
                                int def = 0;
                                Numero.setText(String.valueOf(def));
                                primero = 0;
                                segundo = 0;
                                sign = false;
                            }
                            else {
                                resultado = primero / segundo;
                                Numero.setText(resultado + signo2);
                            }
                            break;
                    }
                    primero = resultado;
                    ans = resultado;
                    segundo = 0;
                    signo="+";
                }
                break;
            case R.id.buttr:
                if (!sign) {
                    sign = true;
                    Numero.setText(primero + "-");
                    signo = "-";
                }
                else{
                    signo2 = "-";
                    int resultado=0;
                    switch (signo){
                        case "+":
                            resultado = primero + segundo;
                            Numero.setText(resultado + signo2);
                            break;
                        case "-":
                            resultado = primero - segundo;
                            Numero.setText(resultado + signo2);
                            break;
                        case "*":
                            resultado = primero * segundo;
                            Numero.setText(resultado + signo2);
                            break;
                        case "/":
                            if (segundo==0){
                                Toast.makeText(Calculadora.this, "Error /0", Toast.LENGTH_SHORT).show();
                                int def = 0;
                                Numero.setText(String.valueOf(def));
                                primero = 0;
                                segundo = 0;
                                sign = false;
                            }
                            else {
                                resultado = primero / segundo;
                                Numero.setText(resultado + signo2);
                            }
                            break;
                    }
                    primero = resultado;
                    segundo = 0;
                    ans = resultado;
                    signo="-";
                }
                break;
            case R.id.buttd:
                if (!sign) {
                    Numero.setText(primero + "/");
                    signo = "/";
                    sign = true;
                }
                else{
                    signo2 = "/";
                    int resultado=0;
                    switch (signo){
                        case "+":
                            resultado = primero + segundo;
                            Numero.setText(resultado + signo2);
                            break;
                        case "-":
                            resultado = primero - segundo;
                            Numero.setText(resultado + signo2);
                            break;
                        case "*":
                            resultado = primero * segundo;
                            Numero.setText(resultado + signo2);
                            break;
                        case "/":
                            if (segundo==0){
                                Toast.makeText(Calculadora.this, "Error /0", Toast.LENGTH_SHORT).show();
                                int def = 0;
                                Numero.setText(String.valueOf(def));
                                primero = 0;
                                segundo = 0;
                                sign = false;
                            }
                            else {
                                resultado = primero / segundo;
                                Numero.setText(resultado + signo2);
                            }
                            break;
                    }
                    primero = resultado;
                    segundo = 0;
                    signo="/";
                    ans = resultado;

                }
                break;
            case R.id.buttm:
                if (!sign) {
                    Numero.setText(primero + "*");
                    signo = "*";
                    sign = true;
                }
                else{
                    signo2 = "*";
                    int resultado=0;
                    switch (signo){
                        case "+":
                            resultado = primero + segundo;
                            Numero.setText(resultado + signo2);
                            break;
                        case "-":
                            resultado = primero - segundo;
                            Numero.setText(resultado + signo2);
                            break;
                        case "*":
                            resultado = primero * segundo;
                            Numero.setText(resultado + signo2);
                            break;
                        case "/":
                            if (segundo==0){
                                Toast.makeText(Calculadora.this, "Error /0", Toast.LENGTH_SHORT).show();
                                int def = 0;
                                Numero.setText(String.valueOf(def));
                                primero = 0;
                                segundo = 0;
                                sign = false;
                            }
                            else {
                                resultado = primero / segundo;
                                Numero.setText(resultado + signo2);
                            }
                            break;
                    }
                    primero = resultado;
                    segundo = 0;
                    signo="*";
                    ans = resultado;
                }
                break;
            case R.id.butti:
                int resultado;

                if (sign) {
                    switch (signo) {
                        case "+":
                            resultado = primero + segundo;
                            Numero.setText(String.valueOf(resultado));
                            primero = resultado;
                            segundo = 0;
                            ans = resultado;
                            break;
                        case "-":
                            resultado = primero - segundo;
                            Numero.setText(String.valueOf(resultado));
                            primero = resultado;
                            segundo = 0;
                            ans = resultado;
                            break;
                        case "*":
                            resultado = primero * segundo;
                            Numero.setText(String.valueOf(resultado));
                            primero = resultado;
                            segundo = 0;
                            ans = resultado;
                            break;
                        case "/":
                            if (segundo == 0) {
                                Toast.makeText(Calculadora.this, "Error /0", Toast.LENGTH_SHORT).show();
                                int def = 0;
                                Numero.setText(String.valueOf(def));
                                primero = 0;
                                segundo = 0;
                                sign = false;
                            } else {
                                resultado = primero / segundo;
                                Numero.setText(String.valueOf(resultado));
                                primero = resultado;
                                segundo = 0;
                                ans = resultado;
                            }
                            break;

                    }
                }
                else{
                    resultado = primero;
                    Numero.setText(String.valueOf(resultado));
                    segundo = 0;
                    ans = resultado;
                }
                break;
            case R.id.buttp:
                break;
            case R.id.buttdel:
                int def=0;
                Numero.setText(String.valueOf(def));
                primero = 0;
                segundo = 0;
                sign = false;
                break;
        }
    }

    public void onClickCall(View v) {

        Toast a = Toast.makeText(Calculadora.this, "TOAST", Toast.LENGTH_SHORT);
        a.setGravity(Gravity.CENTER, 0, 0);
        a.setDuration(Toast.LENGTH_LONG);
        a.show();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:112"));
        startActivity(intent);
    }
    public void onClickAns(View v) {
        if (!sign){
            primero = ans;
            Numero.setText(String.valueOf(primero));
        }
        else{
            segundo = ans;
            Numero.setText(String.valueOf(primero + signo + segundo));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outSave){
        super.onSaveInstanceState(outSave);
        outSave.putString("result", Numero.getText().toString());
        outSave.putInt("ans",ans);
        outSave.putInt("primero",primero);
        outSave.putInt("segundo", segundo);
        outSave.putBoolean("sign", sign);
        outSave.putString("signo", signo);
    }
    @Override
    public void onRestoreInstanceState(Bundle inRestore){
        super.onRestoreInstanceState(inRestore);
        Numero.setText(inRestore.getString("result"));
        ans = inRestore.getInt("ans");
        primero = inRestore.getInt("primero");
        segundo = inRestore.getInt("segundo");
        sign = inRestore.getBoolean("sign");
        signo = inRestore.getString("signo");
    }
}