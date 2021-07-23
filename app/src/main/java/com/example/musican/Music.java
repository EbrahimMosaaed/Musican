package com.example.musican;

import android.os.Parcel;
import android.os.Parcelable;

public class Music implements Parcelable {

    public static final Creator<Music> CREATOR = new Creator<Music>() {

        @Override
        public Music createFromParcel(Parcel in) {
            return new Music(in);
        }

        @Override
        public Music[] newArray(int size) {
            return new Music[size];
        }
    };
    private final String mSongTitle;
    private final String mSongArtist;
    private final String mSongDuration;
    private final int mSongId;
    private final int mSongLyrics;
    private final int mSongImg;

    protected Music(Parcel in) {
        mSongTitle = in.readString();
        mSongArtist = in.readString();
        mSongDuration = in.readString();
        mSongId = in.readInt();
        mSongLyrics = in.readInt();
        mSongImg = in.readInt();
    }

    Music(String title, String artist, String duration, int songId, int lyrics, int img) {
        this.mSongTitle = title;
        this.mSongArtist = artist;
        this.mSongDuration = duration;
        this.mSongId = songId;
        this.mSongLyrics = lyrics;
        this.mSongImg = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSongTitle);
        dest.writeString(mSongArtist);
        dest.writeString(mSongDuration);
        dest.writeInt(mSongId);
        dest.writeInt(mSongLyrics);
        dest.writeInt(mSongImg);
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getSongArtist() {
        return mSongArtist;
    }

    public String getSongDuration() {
        return mSongDuration;
    }

    public int getSongId() {
        return mSongId;
    }

    public int getSongLyrics() {
        return mSongLyrics;
    }

    public int getSongImg() {
        return mSongImg;
    }
}
