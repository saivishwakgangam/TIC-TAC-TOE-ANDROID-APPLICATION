package com.example.saivishwak.tictactoeminiproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class TwoPlayer extends AppCompatActivity {
    AlertDialog.Builder builder1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);
        builder1 = new AlertDialog.Builder(this);
    }
    public void twoPlayerGame(View view)
    {
        EditText player1=(EditText)findViewById(R.id.player1Name);
        String player1Name=player1.getText().toString();
        EditText player2=(EditText)findViewById(R.id.player2Name);
        String player2Name=player2.getText().toString();
        RadioGroup radioplayer1group=(RadioGroup)findViewById(R.id.player1rg);
        RadioGroup radioplayer2group=(RadioGroup)findViewById(R.id.player2rg);
        int selectedId1=radioplayer1group.getCheckedRadioButtonId();
        int selectedId2=radioplayer2group.getCheckedRadioButtonId();
        RadioButton player1rb=(RadioButton)findViewById(selectedId1);
        RadioButton player2rb=(RadioButton)findViewById(selectedId2);
        String pl1rb=player1rb.getText().toString();
        String pl2rb=player2rb.getText().toString();

        System.out.println(pl1rb+pl2rb);
        if(player1Name.equals(""))
        {
            player1Name="player1";
            player1.setText("player1");
        }
        if(player2Name.equals(""))
        {
            player2Name="player2";
            player2.setText("player2");
        }


         if(pl1rb.equals(pl2rb))
        {
            builder1.setMessage("Symbols should not be equal");
            builder1.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id){


                    Intent intent = new Intent(getApplicationContext(),TwoPlayer.class);



                }

            });
            AlertDialog dialog = builder1.create();
            dialog.show();


        }
        else
        {
            Intent i=new Intent(this,TwoPlayerGame.class);
            i.putExtra("player1",player1Name);
            i.putExtra("player2",player2Name);
            i.putExtra("player1rb",pl1rb);
            i.putExtra("player2rb",pl2rb);
        /*i.putExtra("player1",player1Name);
        i.putExtra("player2",player2Name);*/

            startActivity(i);
        }






    }
}
