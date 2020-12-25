package com.example.saivishwak.tictactoeminiproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class TwoPlayerGame extends AppCompatActivity {
    //0=x,1=o
    int activePlayer;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    boolean gameIsActive=true;
    int[][] winningposition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    String player1;
    String player2;
    String player1rb;
    String player2b;
    String winner;
    Timer timer;
    int win;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player_game);
        //Intent i=getIntent();
        Intent i=getIntent();
        /*player1=i.getStringExtra("player1");
        player2=i.getStringExtra("player2");*/
       player1=i.getExtras().getString("player1");
        player2=i.getExtras().getString("player2");
        player1rb=i.getExtras().getString("player1rb");
        player2b=i.getExtras().getString("player2rb");
        if(player1rb.equals("X"))
        {
            activePlayer=0;
            win=0;
        }
        else
        {
            activePlayer=1;
            win=1;
        }
        /*Log.i("player name",player1);
        Log.i("player name",player2);*/


    }
    public void dropIn(final View view)
    {
        ImageView counter=(ImageView)view;
        int tappedCounter=Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedCounter]==2&&gameIsActive) {
            gameState[tappedCounter]=activePlayer;
            counter.setTranslationY(-1000f);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.newx);
                counter.setTag(Integer.valueOf(R.drawable.newx));
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.newo);
                counter.setTag(Integer.valueOf(R.drawable.newo));
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).setDuration(300);
            for(int[] winningPositions:winningposition)
            {
                if((gameState[winningPositions[0]]==gameState[winningPositions[1]])&&(gameState[winningPositions[1]]==gameState[winningPositions[2]])&&gameState[winningPositions[0]]!=2)
                {

                    gameIsActive=false;
                    if(gameState[winningPositions[0]]==win)
                    {

                        winner=player1+" has  won";
                    }
                    if(gameState[winningPositions[0]]!=win)
                    {
                        winner=player2+"has won";
                    }


                    /*Intent intent=new Intent(this,Result.class);
                    intent.putExtra("winner",winner);

                    startActivity(intent);*/
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // do something
                            Intent intent = new Intent(getApplicationContext(),Result.class);
                            // If you just use this that is not a valid context. Use ActivityName.this
                            intent.putExtra("winner",winner);
                            startActivity(intent);
                        }
                    }, 5000);





                }
                else
                {
                    boolean gameIsOver=true;
                    for(int counterState:gameState)
                    {
                        if(counterState==2)
                        {
                            gameIsOver=false;
                        }
                    }
                    if(gameIsOver)
                    {
                        winner="game has drawn";
                        /*Intent intent=new Intent(this,Result.class);
                        intent.putExtra("winner",winner);
                        startActivity(intent);*/
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // do something
                                Intent intent = new Intent(getApplicationContext(),Result.class);
                                // If you just use this that is not a valid context. Use ActivityName.this
                                intent.putExtra("winner",winner);
                                startActivity(intent);
                            }
                        }, 2000);

                    }
                }

            }
        }
    }
    /*public void playAgain(View view)
    {
        gameIsActive=true;
        LinearLayout layout=(LinearLayout)findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);
        activePlayer=0;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        GridLayout gridLayout=(GridLayout)findViewById(R.id.gridLayout);
        for(int i=0;i<gridLayout.getChildCount();i++)
        {
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }

    }*/
}
