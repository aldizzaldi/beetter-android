package com.example.beetter.ui.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.beetter.NavigationActivity;
import com.example.beetter.R;
import com.example.beetter.SharedPrefUtils;
import com.example.beetter.ui.listteam.ListTeamActivity;
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
                String token = SharedPrefUtils.getStringSharedPref("token", "null");

                if(token.equalsIgnoreCase("null")){
                    Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                    SplashScreen.this.startActivity(intent);
                    SplashScreen.this.finish();
                }
                else{
                    Intent intent1 = new Intent(SplashScreen.this, ListTeamActivity.class);
                    SplashScreen.this.startActivity(intent1);
                    SplashScreen.this.finish();
                }
//                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
//                SplashScreen.this.startActivity(intent);
//                SplashScreen.this.finish();
            }
        }, DELAY);
    }

    @Override
    public void moveToLogin() {

    }

    @Override
    public void moveToHome() {

    }

    @Override
    public void loading() {

    }
}
