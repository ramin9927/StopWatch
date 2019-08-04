package com.codepedia.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1,text2;
    Button startbtn;
    Animation atg,gone,two;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.splash_text);
        text2 = findViewById(R.id.splash_subtext);
        image = findViewById(R.id.splash_image);
        startbtn = findViewById(R.id.button_getstart);

        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        gone = AnimationUtils.loadAnimation(this,R.anim.btgone);
        two = AnimationUtils.loadAnimation(this,R.anim.bttwo);


        image.startAnimation(atg);
        text1.startAnimation(gone);
        text2.startAnimation(gone);
        startbtn.setAnimation(two);


        Typeface Light = Typeface.createFromAsset(getAssets(),"font/MLight.ttf");
        Typeface Medium = Typeface.createFromAsset(getAssets(),"font/MMedium.ttf");
        Typeface Regular = Typeface.createFromAsset(getAssets(),"font/MRegular.ttf");

        text1.setTypeface(Regular);
        text2.setTypeface(Light);
        startbtn.setTypeface(Medium);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,StopWatch.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

            }
        });
    }
}
