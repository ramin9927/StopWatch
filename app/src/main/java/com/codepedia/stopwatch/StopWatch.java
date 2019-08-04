package com.codepedia.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatch extends AppCompatActivity {

    Button startwatch,stopwatch;
    ImageView imagekata;
    Animation rotate;
    Chronometer timerhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        startwatch = findViewById(R.id.start);
        stopwatch = findViewById(R.id.finish);
        imagekata = findViewById(R.id.bg_kata);
        timerhere = findViewById(R.id.timer);


        //optional animation
        stopwatch.setAlpha(0);


        rotate = AnimationUtils.loadAnimation(this,R.anim.rotate_anim);

        Typeface text = Typeface.createFromAsset(getAssets(),"font/MMedium.ttf");
        startwatch.setTypeface(text);
        stopwatch.setTypeface(text);


        startwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagekata.startAnimation(rotate);
                stopwatch.animate().alpha(1).translationY(-80).setDuration(300).start();
                startwatch.animate().alpha(0).setDuration(300).start();


                timerhere.setBase(SystemClock.elapsedRealtime());
                timerhere.start();
            }
        });

        stopwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerhere.stop();
                imagekata.clearAnimation();


                stopwatch.animate().alpha(0).setDuration(300).start();
                startwatch.animate().alpha(1).setDuration(300).start();


            }
        });
    }
}
