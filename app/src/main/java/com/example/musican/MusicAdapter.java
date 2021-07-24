package com.example.musican;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;


 class MusicAdapter
        extends RecyclerView.Adapter<MusicViewHolder> {

    List<Music> list = Collections.emptyList();

    Context context;
    ClickListiner listiner;

    public MusicAdapter(List<Music> list,
                        Context context, ClickListiner listiner) {
        this.list = list;
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
                .setImageResource(list.get(position).getSongImg());
        viewHolder.songArtist
                .setText(list.get(position).getSongArtist());
        viewHolder.songTitle
                .setText(list.get(position).getSongTitle());
        viewHolder.songDuration
                .setText(list.get(position).getSongDuration());

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listiner.click(index);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}

//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//
//import java.util.ArrayList;
//
//public class MusicAdapter extends ArrayAdapter<Music> {
//
//    public MusicAdapter(Context context, ArrayList<Music> musics) {
//        super(context, 0, musics);
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        View listItemView = convertView;
//        if (listItemView == null) {
//            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
//        }
//
//        Music currentMusic = getItem(position);
//
//        TextView songTitle = listItemView.findViewById(R.id.song_title);
//        songTitle.setText(currentMusic.getSongTitle());
//
//
//        TextView songArtist = listItemView.findViewById(R.id.song_artist);
//        songArtist.setText(currentMusic.getSongArtist());
//
//        TextView songDuration = listItemView.findViewById(R.id.song_duration);
//        songDuration.setText(currentMusic.getSongDuration());
//
//        ImageView songImage = listItemView.findViewById(R.id.song_img);
//        songImage.setImageResource(currentMusic.getSongImg());
//        return listItemView;
//    }
//}