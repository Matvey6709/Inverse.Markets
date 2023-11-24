package ru.n3studio.inversemarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import android.os.Handler;


public class Start_Activity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                System.out.println("Жив?");
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Start_Activity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}