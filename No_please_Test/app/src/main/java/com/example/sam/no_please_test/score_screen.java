package com.example.sam.no_please_test;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class score_screen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        //insert score stuff here
        Bundle rcvScores = getIntent().getExtras(); //gets score strings that were passed

        int number_players = rcvScores.getInt("number_of_players");
        String player_1_score = rcvScores.getString("player_1_score");
        String player_2_score = rcvScores.getString("player_2_score");
        String player_3_score = rcvScores.getString("player_3_score");
        String player_4_score = rcvScores.getString("player_4_score");
        String player_5_score = rcvScores.getString("player_5_score");


        Score scoreCalc = new Score();
        int ply1score = scoreCalc.calculateScore(scoreCalc.StringToArray(player_1_score));
        int ply2score = scoreCalc.calculateScore(scoreCalc.StringToArray(player_2_score));
        int ply3score = scoreCalc.calculateScore(scoreCalc.StringToArray(player_3_score));
        int ply4score = scoreCalc.calculateScore(scoreCalc.StringToArray(player_4_score));
        int ply5score = scoreCalc.calculateScore(scoreCalc.StringToArray(player_5_score));

        setContentView(R.layout.activity_score_screen); //set up activity view to edit

        TextView player_1_score_view = (TextView) this.findViewById(R.id.Player1_score);
        player_1_score_view.setText(String.valueOf(ply1score));

        TextView player_2_score_view = (TextView) this.findViewById(R.id.Player2_score);
        player_2_score_view.setText(String.valueOf(ply2score));

        TextView player_3_score_view = (TextView) this.findViewById(R.id.Player3_score);
        player_3_score_view.setText(String.valueOf(ply3score));

        TextView player_4_score_view = (TextView) this.findViewById(R.id.Player4_score);
        player_4_score_view.setText(String.valueOf(ply4score));

        TextView player_5_score_view = (TextView) this.findViewById(R.id.Player5_score);
        player_5_score_view.setText(String.valueOf(ply5score));

        if ( number_players < 4 ) {
            TextView ply4 = (TextView) this.findViewById(R.id.Player4);
            ply4.setVisibility(View.INVISIBLE);
            player_4_score_view.setVisibility(View.INVISIBLE);
            if ( number_players < 5 ) {
                TextView ply5 = (TextView) this.findViewById(R.id.Player5);
                ply5.setVisibility(View.INVISIBLE);
                player_5_score_view.setVisibility(View.INVISIBLE);
            }
        } //maybe a better way to do this earlier?

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
