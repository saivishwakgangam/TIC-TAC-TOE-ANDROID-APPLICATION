package com.example.saivishwak.tictactoeminiproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SingleMulti extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_multi);
    }
    public void twoplayer(View view)
    {
        Intent i=new Intent(this,TwoPlayer.class);
        startActivity(i);
    }
    public void singlePlayer(View view)
    {
        Intent i=new Intent(this,singleplayer.class);
        startActivity(i);
    }
}
