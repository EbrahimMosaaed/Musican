package com.example.musican;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.musican.Constants.MUSICLIST;

public class MainActivity extends AppCompatActivity {

    MusicAdapter musicAdapter;
    RecyclerView recyclerView;
    ClickListiner listiner;
    ArrayList<Music> musics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(R.string.home_txt);
        musics = new ArrayList<>();
        musics = getData();
        recyclerView
                = (RecyclerView) findViewById(
                R.id.recyclerView);
        listiner = new ClickListiner() {
            @Override
            public void click(int index) {
                Intent i = new Intent(MainActivity.this, DetailsActivity.class);
                Bundle b = new Bundle();
                b.putParcelableArrayList(MUSICLIST, musics);
                b.putInt(Constants.MUSICINDEX, index);
                i.putExtras(b);
                startActivity(i);
            }
        };
        musicAdapter
                = new MusicAdapter(
                musics, getApplication(), listiner);
        recyclerView.setAdapter(musicAdapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(MainActivity.this));

    }

    // Sample data for RecyclerView
    private ArrayList<Music> getData() {
        ArrayList<Music> musics = new ArrayList<>();
        musics.add(new Music("Be the one", "Dua lipa", "3:20", R.raw.dualipa, R.string.Dua_lipa_lyrics, R.drawable.lo_ns));
        musics.add(new Music("Peaches", "Justin bieber", "2:30", R.raw.justinbieber, R.string.justin_lyrics, R.drawable.lo_ns));
        musics.add(new Music("Unstoppable", "Sia", "4:10", R.raw.sia, R.string.sia_lyrics, R.drawable.lo_ns));
        musics.add(new Music("Back to you", "Selena gomez", "2:50", R.raw.selenagomez, R.string.selena_lyrics, R.drawable.lo_ns));
        musics.add(new Music("Be the one", "Dua lipa", "3:20", R.raw.dualipa, R.string.Dua_lipa_lyrics, R.drawable.lo_ns));
        musics.add(new Music("Peaches", "Justin bieber", "2:30", R.raw.justinbieber, R.string.justin_lyrics, R.drawable.lo_ns));
        musics.add(new Music("Unstoppable", "Sia", "4:10", R.raw.sia, R.string.sia_lyrics, R.drawable.lo_ns));
        musics.add(new Music("Back to you", "Selena gomez", "2:50", R.raw.selenagomez, R.string.selena_lyrics, R.drawable.lo_ns));
        musics.add(new Music("Be the one", "Dua lipa", "3:20", R.raw.dualipa, R.string.Dua_lipa_lyrics, R.drawable.lo_ns));
        musics.add(new Music("Peaches", "Justin bieber", "2:30", R.raw.justinbieber, R.string.justin_lyrics, R.drawable.lo_ns));
        musics.add(new Music("Unstoppable", "Sia", "4:10", R.raw.sia, R.string.sia_lyrics, R.drawable.lo_ns));
        musics.add(new Music("Back to you", "Selena gomez", "2:50", R.raw.selenagomez, R.string.selena_lyrics, R.drawable.lo_ns));
        return musics;
    }
}



