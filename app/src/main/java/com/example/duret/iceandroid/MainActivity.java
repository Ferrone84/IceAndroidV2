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
    private Button bonsouar;
    private TextView hw;
    private SearchView searchView;
    private ListView playlist;
    private ImageButton previousButton, playButton, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        playlist = findViewById(R.id.list);
        previousButton = findViewById(R.id.previousButton);
        playButton = findViewById(R.id.playButton);
        nextButton = findViewById(R.id.nextButton);

        IServerPrx ice = SharedIce.getInstance();

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
