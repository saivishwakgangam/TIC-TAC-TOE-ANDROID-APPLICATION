package com.example.saivishwak.tictactoeminiproject;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextlayout);
    }
    public void newgame(View view)
    {
        Intent i=new Intent(this,SingleMulti.class);
        startActivity((i));
    }
    public void about(View view)
    {
        Intent i=new Intent(this,About.class);
        startActivity((i));
    }
    public void exit(View view)
    {
        /*finish();
        moveTaskToBack(true);*/
        LinearLayout l1=(LinearLayout)findViewById(R.id.nextLayout);
        l1.setVisibility(View.INVISIBLE);
        LinearLayout l2=(LinearLayout)findViewById(R.id.exitLayout);
        l2.setVisibility(View.VISIBLE);


    }
    public void yes(View view)
    {
        finish();
        moveTaskToBack(true);
    }
    public void no(View view)
    {
        LinearLayout l2=(LinearLayout)findViewById(R.id.exitLayout);
        l2.setVisibility(View.INVISIBLE);
        LinearLayout l1=(LinearLayout)findViewById(R.id.nextLayout);
        l1.setVisibility(View.VISIBLE);


    }



}
