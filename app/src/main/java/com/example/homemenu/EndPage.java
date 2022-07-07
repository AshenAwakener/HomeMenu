package com.example.homemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

public class EndPage extends AppCompatActivity {

    Intent intent;
    VideoView view;
    String path;
    TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_page);

        intent = getIntent();
        back = findViewById(R.id.back);
        String type = intent.getStringExtra("Type");

        switch(type) {
            case "Alpha":
                view = findViewById(R.id.BG);
                path = "android.resource://" + getPackageName() + "/" + R.raw.end_alpha;
                view.setVideoURI(Uri.parse(path));
                view.start();
                view.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });
            break;

            case "Animals":
                view = findViewById(R.id.BG);
                path = "android.resource://" + getPackageName() + "/" + R.raw.end_animals;
                view.setVideoURI(Uri.parse(path));
                view.start();
                view.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });
            break;

            case "Colors":
                view = findViewById(R.id.BG);
                path = "android.resource://" + getPackageName() + "/" + R.raw.end_colors;
                view.setVideoURI(Uri.parse(path));
                view.start();
                view.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.setLooping(true);
                    }
                });
                break;

            default:
                break;
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(EndPage.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}