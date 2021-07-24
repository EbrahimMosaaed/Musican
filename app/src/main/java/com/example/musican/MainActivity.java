package com.example.musican;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.musican.Constants.MUSICLIST;

public class MainActivity extends AppCompatActivity {

    MusicAdapter adapter;
    RecyclerView recyclerView;
    ClickListiner listiner;
    ArrayList<Music> musics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(R.string.home_txt);
//        final ArrayList<Music> musics = new ArrayList<Music>();
//        musics.add(new Music("Be the one", "Dua lipa", "3:20", R.raw.dualipa, R.string.Dua_lipa_lyrics, R.drawable.lo_ns));
//        musics.add(new Music("Peaches", "Justin bieber", "2:30", R.raw.justinbieber, R.string.justin_lyrics, R.drawable.lo_ns));
//        musics.add(new Music("Unstoppable", "Sia", "4:10", R.raw.sia, R.string.sia_lyrics, R.drawable.lo_ns));
//        musics.add(new Music("Back to you", "Selena gomez", "2:50", R.raw.selenagomez, R.string.selena_lyrics, R.drawable.lo_ns));

//        MusicAdapter musicAdapter = new MusicAdapter(MainActivity.this, musics);
//
//        ListView listView = findViewById(R.id.recyclerView);
//        listView.setAdapter(musicAdapter);
//        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent i = new Intent(MainActivity.this, DetailsActivity.class);
//                Bundle b = new Bundle();
//                b.putParcelableArrayList(MUSICLIST, musics);
//                b.putInt(MUSICINDEX, position);
//                i.putExtras(b);
//                startActivity(i);
//
//            }
//        });

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
        adapter
                = new MusicAdapter(
                musics, getApplication(), listiner);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(MainActivity.this));

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    //
    // Sample data for RecyclerView
    private ArrayList<Music> getData() {
        ArrayList<Music> list = new ArrayList<>();
        list.add(new Music("Be the one", "Dua lipa", "3:20", R.raw.dualipa, R.string.Dua_lipa_lyrics, R.drawable.lo_ns));
        list.add(new Music("Peaches", "Justin bieber", "2:30", R.raw.justinbieber, R.string.justin_lyrics, R.drawable.lo_ns));
        list.add(new Music("Unstoppable", "Sia", "4:10", R.raw.sia, R.string.sia_lyrics, R.drawable.lo_ns));
        list.add(new Music("Back to you", "Selena gomez", "2:50", R.raw.selenagomez, R.string.selena_lyrics, R.drawable.lo_ns));
        list.add(new Music("Be the one", "Dua lipa", "3:20", R.raw.dualipa, R.string.Dua_lipa_lyrics, R.drawable.lo_ns));
        list.add(new Music("Peaches", "Justin bieber", "2:30", R.raw.justinbieber, R.string.justin_lyrics, R.drawable.lo_ns));
        list.add(new Music("Unstoppable", "Sia", "4:10", R.raw.sia, R.string.sia_lyrics, R.drawable.lo_ns));
        list.add(new Music("Back to you", "Selena gomez", "2:50", R.raw.selenagomez, R.string.selena_lyrics, R.drawable.lo_ns));
        list.add(new Music("Be the one", "Dua lipa", "3:20", R.raw.dualipa, R.string.Dua_lipa_lyrics, R.drawable.lo_ns));
        list.add(new Music("Peaches", "Justin bieber", "2:30", R.raw.justinbieber, R.string.justin_lyrics, R.drawable.lo_ns));
        list.add(new Music("Unstoppable", "Sia", "4:10", R.raw.sia, R.string.sia_lyrics, R.drawable.lo_ns));
        list.add(new Music("Back to you", "Selena gomez", "2:50", R.raw.selenagomez, R.string.selena_lyrics, R.drawable.lo_ns));

        return list;
    }

}


//public class exam extends AppCompatActivity
//        implements NavigationView
//        .OnNavigationItemSelectedListener {
//
//    ImageGalleryAdapter2 adapter;
//    RecyclerView recyclerView;
//    ClickListiner listiner;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_exam);
//        Toolbar toolbar
//                = (Toolbar)findViewById(R.id.toolbar);
//        toolbar.setTitle("");
//        setSupportActionBar(toolbar);
//
//
//
//        List<examData> list = new ArrayList<>();
//        list = getData();
//
//        recyclerView
//                = (RecyclerView)findViewById(
//                R.id.recyclerView);
//        listiner = new ClickListiner() {
//            @Override
//            public void click(int index){
//                Toast.makeTexT(this,"clicked item index is "+index,Toast.LENGTH_LONG).show();
//            }
//        };
//        adapter
//                = new ImageGalleryAdapter2(
//                list, getApplication(),listiner);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(
//                new LinearLayoutManager(exam.this));
//    }
//
//    @Override
//    public void onBackPressed()
//    {
//        super.onBackPressed();
//    }
//
//    // Sample data for RecyclerView
//    private List<examData> getData()
//    {
//        List<examData> list = new ArrayList<>();
//        list.add(new examData("First Exam",
//                "May 23, 2015",
//                "Best Of Luck"));
//        list.add(new examData("Second Exam",
//                "June 09, 2015",
//                "b of l"));
//        list.add(new examData("My Test Exam",
//                "April 27, 2017",
//                "This is testing exam .."));
//
//        return list;
//    }
//}



