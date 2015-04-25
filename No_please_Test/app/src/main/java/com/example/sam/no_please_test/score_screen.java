package com.example.sam.no_please_test;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.util.Arrays;


public class score_screen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        //insert score stuff here
        Bundle rcvScores = getIntent().getExtras(); //gets score strings that were passed

        int number_players = rcvScores.getInt("number_of_players");

        Score scoreCalc = new Score();

        setContentView(R.layout.activity_score_screen); //set up activity view to edit

        int[] scoreList = new int[5];

        scoreList[0] = scoreCalc.calculateScore(rcvScores.getIntArray("player_1_cards"), rcvScores.getInt("player_1_chips"));
        TextView player_1_score_view = (TextView) this.findViewById(R.id.Player1_score);
        player_1_score_view.setText(String.valueOf(scoreList[0]));

        scoreList[1] = scoreCalc.calculateScore(rcvScores.getIntArray("player_2_cards"), rcvScores.getInt("player_2_chips"));
        TextView player_2_score_view = (TextView) this.findViewById(R.id.Player2_score);
        player_2_score_view.setText(String.valueOf(scoreList[1]));

        scoreList[2] = scoreCalc.calculateScore(rcvScores.getIntArray("player_3_cards"), rcvScores.getInt("player_3_chips"));
        TextView player_3_score_view = (TextView) this.findViewById(R.id.Player3_score);
        player_3_score_view.setText(String.valueOf(scoreList[2]));

        if( number_players >= 4) {
            scoreList[3] = scoreCalc.calculateScore(rcvScores.getIntArray("player_4_cards"), rcvScores.getInt("player_4_chips"));
            TextView player_4_score_view = (TextView) this.findViewById(R.id.Player4_score);
            TextView ply4 = (TextView) this.findViewById(R.id.Player4);
            ply4.setVisibility(View.VISIBLE);
            player_4_score_view.setVisibility(View.VISIBLE);
            player_4_score_view.setText(String.valueOf(scoreList[3]));

            if( number_players == 5) {
                scoreList[4] = scoreCalc.calculateScore(rcvScores.getIntArray("player_5_cards"), rcvScores.getInt("player_5_chips"));
                TextView player_5_score_view = (TextView) this.findViewById(R.id.Player5_score);
                TextView ply5 = (TextView) this.findViewById(R.id.Player5);
                ply5.setVisibility(View.VISIBLE);
                player_5_score_view.setVisibility(View.VISIBLE);
                player_5_score_view.setText(String.valueOf(scoreList[4]));

            }
        }

        int winner = 07734;
        int tmp = 1000;
        for (int i = 0; i < number_players; i++) {
            if( scoreList[i] < tmp) {
                winner = i+1;
                tmp = scoreList[i];
            }
        }

        TextView winnerName = (TextView) this.findViewById(R.id.winner_name);
        winnerName.setText("Player " + String.valueOf(winner));

    }

    //just menu stuff
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_score_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //should back to the main screen
    public void activity_main(View view){
        //do something in response to button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
