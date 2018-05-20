package com.example.duret.iceandroid;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.provider.ContactsContract;
import android.speech.RecognizerIntent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import server.*;

import static android.Manifest.permission.RECORD_AUDIO;

public class MainActivity extends AppCompatActivity {

    private AudioRecord recorder = null;
    private SearchView searchView;
    private ListView list;
    private TextView resultAudioRecord;
    private ListAdapter adapter;
    private ImageButton recordButton;
    private MediaPlayer mediaPlayer;
    private Music[] playlist;
    private IServerPrx ice;
    private String recordResult = "", currentMusic = "";
    private Map<String, Integer> musicsIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        recordButton = findViewById(R.id.recordButton);
        resultAudioRecord = findViewById(R.id.result_record);
        musicsIds = new HashMap<String, Integer>();

        adapter = new ListAdapter(MainActivity.this, R.layout.list_item, new ArrayList<Music>());
        list = findViewById(R.id.list);
        list.setAdapter(adapter);

        ice = SharedIce.getInstance();
        updatePlaylistContent();
        clearAndFill(playlist);

        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean canRecord = false;

                if (checkPermission()) {
                    canRecord = true;
                }
                else {
                    requestPermission();
                }

                if (canRecord)
                    recordAudio();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return search(s);
            }
        });
    }

    public void recordAudio() {
        recordResult = "";

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Donnez moi un ordre :-)");
        try {
            startActivityForResult(intent, 100);
        } catch (ActivityNotFoundException a) {
            makeToast(a.getMessage());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 100: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    recordResult = result.get(0).toLowerCase();
                    resultAudioRecord.setText(recordResult);

                    if (!recordResult.isEmpty()) {
                        launchRequest(recordResult);
                    }
                    else {
                        makeToast("Votre requête est vide.");
                    }
                }
                break;
            }
        }
    }

    public void launchRequest(String recordResult) {
        String[] requestResult = RequestParser.parse(recordResult);

        if (requestResult == null || requestResult.length != 2)  {
            makeToast("Votre requête est invalide.");
            return;
        }
        else if (requestResult[0].equals("Exception")) {
            makeToast("Exception : "+requestResult[1]);
            return;
        }

        //regarder le résultat et selon l'action on fait un truc
        if (requestResult[0].equals("lancer") || requestResult[0].equals("lance")) {
            if (musicsIds.containsKey(requestResult[1])) {
                int musicId = musicsIds.get(requestResult[1]);
                View v2 = list.getChildAt(musicId);
                ImageButton tmpButton = v2.findViewById(R.id.playButton);
                playAndPauseOnClickHandler(tmpButton);
            }
            else {
                makeToast("Cette chanson n'existe pas ! :-(");
            }
        }
        else if (requestResult[0].equals("arrêter") || requestResult[0].equals("stop")) {
            stopMusic();
        }
        else if (requestResult[0].equals("chercher") || requestResult[0].equals("cherche")) {
            search(requestResult[1]);
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
            musicsIds.put(music.name.toLowerCase(), music.id);
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
        ice.stopMusic();
        if (mediaPlayer != null) {
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

    private boolean search(String s) {
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
}
