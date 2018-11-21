package com.smarthome.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.content.Intent;

public class welcomeActivity extends AppCompatActivity {

    ImageView hsimage,shimage,wtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        hsimage =  findViewById(R.id.homesplash);
        shimage =  findViewById(R.id.smarthomesplash);
        wtext =  findViewById(R.id.welcometo);

        Animation imganim = AnimationUtils.loadAnimation(this,R.anim.splashimgfade);

        hsimage.startAnimation(imganim);
        shimage.startAnimation(imganim);
        wtext.startAnimation(imganim);

        final Intent intent = new Intent(this,AuthenticationActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally{
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();

    }
}
