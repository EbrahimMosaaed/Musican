package com.example.musican;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


class MusicAdapter
        extends RecyclerView.Adapter<MusicViewHolder> {

    ArrayList<Music> musicList;

    Context context;
    ClickListiner listiner;

    public MusicAdapter(ArrayList<Music> music,
                        Context context, ClickListiner listiner) {
        this.musicList = music;
        this.context = context;
        this.listiner = listiner;
    }

    @Override
    public MusicViewHolder
    onCreateViewHolder(ViewGroup parent,

                       int viewType) {

        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout
        View photoView
                = inflater
                .inflate(R.layout.list_item,
                        parent, false);

        MusicViewHolder viewHolder
                = new MusicViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void
    onBindViewHolder(final MusicViewHolder viewHolder,
                     final int position) {
        final int index = viewHolder.getAdapterPosition();
        viewHolder.songImg
                .setImageResource(musicList.get(position).getSongImg());
        viewHolder.songArtist
                .setText(musicList.get(position).getSongArtist());
        viewHolder.songTitle
                .setText(musicList.get(position).getSongTitle());
        viewHolder.songDuration
                .setText(musicList.get(position).getSongDuration());

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listiner.click(index);
            }
        });
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
