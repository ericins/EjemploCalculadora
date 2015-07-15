package com.example.ericcity.bandera;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;


public class Reproductor extends ActionBarActivity {

    //Button play;
    MediaPlayer mp = new MediaPlayer();
    MediaPlayer mp2 = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        mp = MediaPlayer.create(this, R.raw.parousia);
        mp2 = MediaPlayer.create(this, R.raw.halcyon);

        //play = (Button)findViewById(R.id.play);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reproductor, menu);
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

    //MediaPlayer mediaPlayer = new MediaPlayer();

    //File sdCard = Environment.getExternalStorageDirectory();
    //File song = new File(sdCard.getAbsolutePath() + "/Music/Xi-parousia.mp3");

    boolean song = false;

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.buttpar:
                song = true;
                if (mp2.isPlaying()){
                    mp2.stop();
                    mp2.release();
                    mp2 = MediaPlayer.create(this, R.raw.halcyon);
                }
                mp.start();

                break;

            case R.id.buthal:
                song = false;
                if (mp.isPlaying()){
                    mp.stop();
                    mp.release();
                    mp = MediaPlayer.create(this, R.raw.parousia);
                }
                mp2.start();

                break;
            case R.id.play:/*
                if (!mp.isPlaying()&&(!started)){
                    try{
                        //mp.setDataSource(song.getAbsolutePath());

                        mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mp.start();
                    started = true;
                }
                else {
                    mp.start();
                                }*/
                if (song) {
                    if (mp.isPlaying()) {
                        mp.pause();
                    } else {
                        mp.start();
                        //findViewById(R.id.play).setBackgroundResource(R.drawable.);
                    }
                }
                else{
                    if (mp2.isPlaying()) {
                        mp2.pause();
                    } else {
                        mp2.start();
                        //findViewById(R.id.play).setBackgroundResource(R.drawable.);
                    }
                }

                break;
            case R.id.pause:
                if (song) {
                    mp.pause();
                }
                else{
                    mp2.pause();
                }
                break;
            case R.id.stop:
                if (song) {
                    mp.stop();
                    mp.release();
                    mp = MediaPlayer.create(this, R.raw.parousia);
                }
                else{
                    mp2.stop();
                    mp2.release();
                    mp2 = MediaPlayer.create(this, R.raw.halcyon);
                }
                //started = false;
                break;
        }
    }
/*
    @Override
    protected void onStop() {
        if (mp.isPlaying()){
            mp.stop();
            mp.release();
        }
        super.onStop();
    }
    */
}
