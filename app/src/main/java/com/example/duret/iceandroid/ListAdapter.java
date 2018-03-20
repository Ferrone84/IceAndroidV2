package com.example.duret.iceandroid;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import server.Music;

public class ListAdapter extends ArrayAdapter<Music> {
    private List<Music> items;
    private int layoutResourceId;
    private Context context;

    public ListAdapter(Context context, int layoutResourceId, List<Music> items) {
        super(context, layoutResourceId, items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        MusicHolder holder;

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        holder = new MusicHolder();
        holder.music = items.get(position);

        holder.musicName = row.findViewById(R.id.music_name);
        holder.musicName.setTag(holder.music);
        holder.musicArtist = row.findViewById(R.id.music_artist);
        holder.musicArtist.setTag(holder.music);
        holder.musicAlbum = row.findViewById(R.id.music_album);
        holder.musicAlbum.setTag(holder.music);
        holder.playButton = row.findViewById(R.id.playButton);
        holder.playButton.setTag(R.id.musicRef, holder.music);
        holder.playButton.setTag(R.id.buttonRef, holder.playButton);
        holder.playButton.setTag(R.id.playRef, true);

        row.setTag(holder);

        setupItem(holder);
        return row;
    }

    private void setupItem(MusicHolder holder) {
        holder.musicName.setText(holder.music.name);
        holder.musicArtist.setText(holder.music.artist);
        holder.musicAlbum.setText(holder.music.album);
    }

    public static class MusicHolder {
        Music music;
        TextView musicName;
        TextView musicArtist;
        TextView musicAlbum;
        ImageButton playButton;
    }
}
