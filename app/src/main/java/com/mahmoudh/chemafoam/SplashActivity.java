package com.mahmoudh.chemafoam;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    ImageView logo;
    Handler handler=new Handler(Looper.getMainLooper());
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
            Log.d("inside runnable",Thread.currentThread().toString());
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo=findViewById(R.id.chema_logo);
        Animation anim=AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        logo.startAnimation(anim);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable,4000);
        Log.d("outside runnable",Thread.currentThread().toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }
}