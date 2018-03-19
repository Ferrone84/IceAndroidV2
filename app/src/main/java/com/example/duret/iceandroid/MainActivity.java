package com.example.duret.iceandroid;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.io.IOException;

import server.*;

public class MainActivity extends AppCompatActivity {
    private SearchView searchView;
    private ListView playlist;
    private ImageButton recordButton, stopButton;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        playlist = findViewById(R.id.list);
        recordButton = findViewById(R.id.recordButton);
        stopButton = findViewById(R.id.stopButton);

        IServerPrx ice = SharedIce.getInstance();

        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordButton.setVisibility(View.INVISIBLE);
                stopButton.setVisibility(View.VISIBLE);
                ice.playMusic(0);
                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(SharedIce.URL);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopButton.setVisibility(View.INVISIBLE);
                recordButton.setVisibility(View.VISIBLE);
                ice.stopMusic();
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        });

        /*bonsouar = findViewById(R.id.bonsouar);
        hw = findViewById(R.id.hw);

        bonsouar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hw.setText("Bonsouar");
                try {
                    System.out.println(ice.getPlaylist()[0].name);
                } catch (Throwable e) {
                    e.printStackTrace();
                }

                ice.playMusic(0);
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(SharedIce.URL);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/
    }
}
