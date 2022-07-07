package com.example.homemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Colors extends AppCompatActivity {

    int all_ctr = 0, id = 0;
    ImageButton next,back,speaker,exit;
    ImageView wordimg;
    String[] filename ={"red","green","yellow","orange","blue",
            "pink","violet","black","white","brown"};
    MediaPlayer ai;
    Intent intent;

    private int CurrentProgress = 1;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        next = findViewById(R.id.next);
        back = findViewById(R.id.back);
        exit = findViewById(R.id.exit);
        speaker = findViewById(R.id.speaker);
        wordimg = findViewById(R.id.WordImg);

        id = setImg();
        wordimg.setImageResource(id);

        progressBar = findViewById(R.id.ProgressBar); // need ito para sa progress
        progressBar.setMax(10);
        progressBar.setProgress(CurrentProgress);

        back.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                all_ctr--;
                id = setImg();
                wordimg.setImageResource(id);
                CurrentProgress = CurrentProgress + 1;
                progressBar.setProgress(CurrentProgress);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                stopPlaying();
                if(all_ctr < 9) {
                    all_ctr++;
                    id = setImg();
                    wordimg.setImageResource(id);
                    CurrentProgress = CurrentProgress + 1;
                    progressBar.setProgress(CurrentProgress);
                } else {
                    intent = new Intent(Colors.this, EndPage.class);
                    intent.putExtra("Type","Colors");
                    startActivity(intent);
                }
            }
        });

        speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
                Resources res = getResources();
                int sound = res.getIdentifier(filename[all_ctr].toLowerCase(), "raw", getPackageName());
                ai = MediaPlayer.create(Colors.this, sound);
                ai.start();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                finish();
            }
        });

    }

    public int setImg(){
        Resources res = this.getResources();
        int resID;
        return resID = res.getIdentifier(filename[all_ctr].toLowerCase(), "drawable", this.getPackageName());
    }

    protected void stopPlaying(){
        // If media player is not null then try to stop it
        if(ai!=null){
            ai.stop();
            ai.release();
            ai = null;
        }
    }
}