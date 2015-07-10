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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        mp = MediaPlayer.create(this, R.raw.parousia);
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

    boolean started = false;

    public void onClick(View v){
        switch (v.getId()) {
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

                if (mp.isPlaying()) {
                    mp.pause();
                }
                else {
                    mp.start();
                    //findViewById(R.id.play).setBackgroundResource(R.drawable.);
                }

                break;
            case R.id.stop:
                mp.stop();
                mp.release();
                mp = MediaPlayer.create(this, R.raw.parousia);
                //started = false;
                break;
        }
    }

    @Override
    protected void onStop() {
        if (mp.isPlaying()){
            mp.stop();
            mp.release();
        }
        super.onStop();
    }
}
