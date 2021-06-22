package com.game.dubaisattagame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.game.dubaisattagame.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class Splashscreen extends AppCompatActivity {
    ProgressBar splashProgress;
    int SPLASH_TIME = 2000;
    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getWindow().getDecorView().getBackground().setDither(true);
        getWindow().setFormat(PixelFormat.RGBA_8888);

        Animation anim1 = AnimationUtils.loadAnimation(this,R.anim.anim_down);
        CircularImageView img =findViewById(R.id.imglogo);
        img.setAnimation(anim1);
        Thread timer=new Thread()
        {
            @Override
            public void run() {
                try                {
                    music=MediaPlayer.create(Splashscreen.this,R.raw.music);
                    music.start();
                    sleep(SPLASH_TIME);

                }
                catch(InterruptedException e)
                {

                }
                finally {
                    Intent i=new Intent(Splashscreen.this,StartActivity.class);
                    startActivity(i);
                }
            }
        };

        timer.start();


    }

    @Override    protected void onPause() {
        super.onPause();
        music.release();
    }
    }
