package com.kripton.onboardingscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        SharedPreferences sh = getSharedPreferences("Splash", Context.MODE_PRIVATE);
                        boolean s1 = sh.getBoolean("Open",false);
                        if(s1)
                        {
                            Intent intent = new Intent(getApplicationContext(),IndexMain.class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            SharedPreferences sharedPreferences = getSharedPreferences("Splash",MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("Open",true);
                            editor.apply();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t1.start();

    }
}