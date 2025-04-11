package com.example.musicalbum;

import static android.content.Intent.getIntent;


import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AudioImage extends AppCompatActivity {
    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_image);
        setTitle("노래 재생");
        Intent it = getIntent();
        String tag = it.getStringExtra("it_tag");
        TextView title = findViewById(R.id.title);
        ImageView song_image = findViewById(R.id.song_image);
        TextView lyrics = findViewById(R.id.lyrics);
        Resources res = getResources();
        int stringId;
        String mkKey;
        stringId = res.getIdentifier("title"+tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        title.setText(mkKey);
        stringId = res.getIdentifier("song_image"+tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        int imageId = res.getIdentifier(mkKey, "drawable", getPackageName());
        song_image.setImageResource(imageId);
        stringId = res.getIdentifier("lyrics"+tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        lyrics.setText(mkKey);
        stringId = res.getIdentifier("audio"+tag, "string", getPackageName());
        mkKey = res.getString(stringId);
        int audioId = res.getIdentifier(mkKey, "raw", getPackageName());
        mp = MediaPlayer.create(this, audioId);
        mp.setLooping(false);
        mp.start();
    } //end of onCreate
    public void goBack(View v) {
        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
        finish();
    }
}
