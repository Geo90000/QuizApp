package com.example.ip2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

   Button buttonMenuGame;
   TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        buttonMenuGame = findViewById(R.id.btnMenuGame);

        buttonMenuGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameScreen.this, MainMenu.class);
                startActivity(intent);
            }
        });

        timer = findViewById(R.id.tvTimer);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                timer.setText("0");
            }
        }.start();
    }
}