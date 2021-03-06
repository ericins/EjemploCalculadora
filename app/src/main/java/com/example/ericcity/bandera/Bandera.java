package com.example.ericcity.bandera;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;
import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import java.io.File;


public class Bandera extends ActionBarActivity implements View.OnClickListener{


    private TwitterLoginButton loginButton;

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "t3jsjzbaaj8RYthOgyhvD3R61";
    private static final String TWITTER_SECRET = "tNcVT34QyB9w3p6S0SofdLXndT0c4YnchhhZd756br8egQxeqh";

    //File myImageFile = new File("/path/to/image");
    //Uri myImageUri = Uri.fromFile(myImageFile);

    SharedPreferences logged;
    SharedPreferences.Editor editor;

    Button b;
    Button b2;
    Boolean TwitOk = false;

    //ImageButton b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_bandera);

        b = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);

        //b.setOnClickListener(lis);
        b.setOnClickListener(this);
        b2.setOnClickListener(this);

        logged = getSharedPreferences("LOGGED", Context.MODE_PRIVATE);
        editor = logged.edit();

        //editor.putBoolean("LOGGED", false);
        //editor.apply();


        //b3 =(ImageButton) findViewById(R.id.snicker);
        //b3.setOnClickListener(this);
        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
                TwitOk = true;
                editor.putBoolean("LOGGED", true);
                editor.apply();

            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                TwitOk = false;
                editor.putBoolean("LOGGED", false);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
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

        // Gestionamos la selecci�n

        switch (item.getItemId()) {
            case R.id.about:
                Toast.makeText(Bandera.this,"About",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.exit:
                    //Intent intent = new Intent(getApplicationContext(), Login.class);
                    //startActivity(intent);
                    finish();
                return true;

            case R.id.twitter:/*
                if (TwitOk == false) {
                    loginButton.setCallback(new Callback<TwitterSession>() {
                        @Override
                        public void success(Result<TwitterSession> result) {
                            // Do something with result, which provides a TwitterSession for making API calls
                            TwitOk = true;
                            editor.putBoolean("LOGGED", true);
                            editor.apply();

                        }

                        @Override
                        public void failure(TwitterException exception) {
                            // Do something on failure
                            TwitOk = false;
                            editor.putBoolean("LOGGED", false);

                        }
                    });
                }
                else{
                    Toast.makeText(Bandera.this,"Ya estas logueado con Twitter.",Toast.LENGTH_SHORT).show();

                }*/

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

    boolean silent;

    public void onClick(View v){
        silent = logged.getBoolean("LOGGED", false);
        switch(v.getId()){
            case R.id.button1:
                if (silent == true) {
                    Toast.makeText(Bandera.this, "Calculadora", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Calculadora.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Bandera.this, "No estas logueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button2:
                Toast.makeText(Bandera.this,"Register",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                break;
            case R.id.button5:
                if (silent == true) {
                    intent = new Intent(getApplicationContext(), Reproductor.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Bandera.this, "No estas logueado", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button6:
                intent = new Intent(getApplicationContext(), GPS.class);
                startActivity(intent);
                break;
            case R.id.button8:
                if (TwitOk == true) {
                    TweetComposer.Builder builder = new TweetComposer.Builder(this).text("Twit Twit");//.image(myImageUri);
                    builder.show();
                }
                else{
                    Toast.makeText(Bandera.this,"No estas logueado con Twitter.",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button7:
                if (silent == false) {
                    intent = new Intent(getApplicationContext(), TrueLogIn.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Bandera.this,"Ya estas logueado.",Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.button11:
                if (silent == true){
                    editor.putBoolean("LOGGED", false);
                    editor.apply();
                    TwitOk = false;
                    Toast.makeText(Bandera.this,"Logged out.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Bandera.this,"No estas logueado.",Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.button12:
                if (TwitOk == false) {
                    if (silent == true) {
                        intent = new Intent(getApplicationContext(), Perfil.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Bandera.this, "No estas logueado.", Toast.LENGTH_SHORT).show();

                    }
                }
                else{
                    Toast.makeText(Bandera.this, "Estas logueado con Twitter.", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }

    }
/*
    public void onClickS(View v){
        View.OnClickListener myOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ResultActivity.class);//si fessim this. esariem accedint al listener per aixo fem getaplicationcontext
                startActivity(i);
            }
        };

        Snackbar.make(layout, R.string.snackbar_text, Snackbar.LENGTH_LONG)
                .setAction(R.string.snackbar_action, myOnClickListener)
                .show(); // Importante!!! No olvidar mostrar la Snackbar.

    }*/
}
