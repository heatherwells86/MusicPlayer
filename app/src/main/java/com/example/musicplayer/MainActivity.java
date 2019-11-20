package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play (View v) {

        if(player == null) {
        player = MediaPlayer.create(this, R.raw.songfile);

        //song credits to Composer: Benjamin Tissot (also known as Bensound)
            //
            //Epic orchestral royalty free music. Should be great for any epic war or battle footage or video game. I used Eastwest symphonic orchestra virtual instrument to compose this piece.
            //​Image copyright: Fotokostic - Shutterstock at https://www.bensound.com/royalty-free-music/track/epic

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
            stopPlayer();
            }
        });

        }

        player.start();
    }

    public void pause (View v) {

        if (player != null) {

        player.pause();

        }
    }

    public void stop (View v) {
        stopPlayer();

    }

    private void stopPlayer (){

        if (player != null); {

            player.release();
            player = null;

            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}
