package com.example.musicalbum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("노래 목록");
    }

    public void play(View v) {
        int id = v.getId();
        LinearLayout layout = (LinearLayout) findViewById(id);
        String tag = (String) layout.getTag();
        Intent it = new Intent(this, AudioImage.class);
        it.putExtra("it_tag", tag);
        startActivity(it);
    }
}