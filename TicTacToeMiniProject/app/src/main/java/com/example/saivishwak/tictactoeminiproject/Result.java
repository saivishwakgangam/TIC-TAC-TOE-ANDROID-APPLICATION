package com.example.saivishwak.tictactoeminiproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {
   String winner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent i=getIntent();
        winner=i.getExtras().getString("winner");

        TextView t=(TextView)findViewById(R.id.winnerMessage);
        t.setText(winner);

    }
    public void playAgain(View view)
    {
        Intent i=new Intent(this,TwoPlayer.class);
        startActivity(i);
    }
    public void mainMenu(View view)
    {
        Intent i=new Intent(this,NextActivity.class);
        startActivity(i);
    }
}
