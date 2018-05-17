package com.example.duret.iceandroid;

import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import server.*;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {

    private AudioRecord recorder = null;
    private SearchView searchView;
    private ListView list;
    private ListAdapter adapter;
    private ImageButton recordButton, stopButton;
    private MediaPlayer mediaPlayer;
    private Music[] playlist;
    private IServerPrx ice;
    private String recordResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        list = findViewById(R.id.list);
        recordButton = findViewById(R.id.recordButton);
        stopButton = findViewById(R.id.stopButton);

        adapter = new ListAdapter(MainActivity.this, R.layout.list_item, new ArrayList<Music>());
        list = findViewById(R.id.list);
        list.setAdapter(adapter);

        ice = SharedIce.getInstance();
        updatePlaylistContent();
        clearAndFill(playlist);

        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordButton.setVisibility(View.INVISIBLE);
                stopButton.setVisibility(View.VISIBLE);

                if (checkPermission()) {
                    recordAudio();
                }
                else {
                    requestPermission();
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopButton.setVisibility(View.INVISIBLE);
                recordButton.setVisibility(View.VISIBLE);
                stopRecord();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (s.isEmpty()) {
                    clearAndFill(playlist);
                    return true;
                }

                Music[] names = ice.findByName(s);
                Music[] artists = ice.findByArtist(s);
                Music[] albums = ice.findByAlbum(s);

                Vector<Music> searchResult = new Vector<Music>();
                if (names.length != 0) {
                    for (Music music : names)
                        searchResult.add(music);
                }

                if (artists.length != 0) {
                    for (Music music : artists) {
                        boolean find = false;
                        for (Music current : searchResult) {
                            if (current.name.equals(music.name) && current.artist.equals(music.artist) && current.album.equals(music.album)) {
                                find = true;
                                break;
                            }
                        }
                        if (!find) {
                            searchResult.add(music);
                        }
                    }
                }

                if (albums.length != 0) {
                    for (Music music : albums) {
                        boolean find = false;
                        for (Music current : searchResult) {
                            if (current.name.equals(music.name) && current.artist.equals(music.artist) && current.album.equals(music.album)) {
                                find = true;
                                break;
                            }
                        }
                        if (!find) {
                            searchResult.add(music);
                        }
                    }
                }

                Music[] result = new Music[searchResult.size()];
                for (int i=0; i < searchResult.size(); i++)
                    result[i] = searchResult.get(i);

                clearAndFill(result);

                return true;
            }
        });
    }

    public void recordAudio() {
        recordResult = "";


    }

    public void stopRecord() {

        if (!recordResult.isEmpty()) {
            launchRequest(recordResult);
        }
        else {
            //afficher un message qui dit que l'audio n'as capturé aucun son
            makeToast("Votre requête est vide.");
        }
    }

    public void launchRequest(String recordResult) {
        //une fois fini on lance l'analyseur de requetes
        String[] requestResult = RequestParser.parse(recordResult);

        if (requestResult == null)  {
            makeToast("Votre requête est invalide.");
        }
        if (requestResult[0].equals("Exception")) {
            //afficher l'erreur -> requestResult[1]
            makeToast("Exception : "+requestResult[1]);
        }

        //regarder le résultat et selon l'action on fait un truc

        if (requestResult.equals("action1")) {

        }
    }

    public void playAndPauseOnClickHandler(View v) {
        Music music = (Music) v.getTag(R.id.musicRef);
        ImageButton button = (ImageButton) v.getTag(R.id.buttonRef);
        boolean isPlayButton = (boolean) v.getTag(R.id.playRef);

        if (isPlayButton) {
            stopMusic();
            for (int i=0; i < adapter.getCount(); i++) {
                View v2 = list.getChildAt(i);
                ImageButton tmpButton = v2.findViewById(R.id.playButton);
                tmpButton.setImageResource(android.R.drawable.ic_media_play);
                v2.setTag(R.id.playRef, true);
            }
            button.setImageResource(android.R.drawable.ic_media_pause);
            v.setTag(R.id.playRef, false);
            ice.playMusic(music.id);
            playMusic();
        }
        else {
            v.setTag(R.id.playRef, true);
            button.setImageResource(android.R.drawable.ic_media_play);
            stopMusic();
        }

    }

    private void updatePlaylistContent() {
        playlist = ice.getPlaylist();
    }

    private void clearAndFill(Music[] playlist) {
        adapter.clear();
        updatePlaylistContent();
        for (Music music : playlist) {
            adapter.insert(music, adapter.getCount());
        }
    }

    private void playMusic() {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(SharedIce.URL);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopMusic() {
        if (mediaPlayer != null) {
            ice.stopMusic();
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    protected void makeToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    public boolean checkPermission() {
        return ContextCompat.checkSelfPermission(getApplicationContext(),
                RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED;
    }

    protected void requestPermission() {
        ActivityCompat.requestPermissions(MainActivity.this, new
                String[]{RECORD_AUDIO}, 1);
    }
}
