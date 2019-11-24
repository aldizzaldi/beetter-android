package com.example.beetter.ui.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.beetter.R;
import com.example.beetter.SharedPrefUtils;
import com.example.beetter.ui.login.LoginActivity;

public class SplashScreen extends AppCompatActivity implements ISplashScreenVIew {

    private final int DELAY = 4000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        SharedPrefUtils.initSharedPreference("BEETTER", this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                SplashScreen.this.startActivity(intent);
                SplashScreen.this.finish();
            }
        }, DELAY);
    }
}
