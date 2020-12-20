package com.example.ip2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Highscore extends AppCompatActivity {

    Button toMainMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        toMainMenu = findViewById(R.id.btnHighScoreListToHaupt);
         // test comment
        toMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Highscore.this, MainMenu.class);
                startActivity(intent);
            }
        });
    }
}