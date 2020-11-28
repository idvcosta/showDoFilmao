package com.ingrid.showdofilmao.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ingrid.showdofilmao.R;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_TIME =
            100;
            //5000;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();
        handler.postDelayed(() -> openGameActivity(), SPLASH_TIME);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    private void openGameActivity() {
        startActivity(new Intent(this, GameActivity.class));
        finish();
    }
}