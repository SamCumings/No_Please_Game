package com.example.sam.no_please_test;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class go_to_game extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        //this gets the number of players (doesn't get anything else yet that's what the commented out code is for).
        Bundle bundle = getIntent().getExtras();

        String player_1_name = getIntent().getExtras().getString("EXTRA_NUMBER_PLAYER_1_NAME");
        String player_2_name = getIntent().getExtras().getString("EXTRA_NUMBER_PLAYER_2_NAME");
        String player_3_name = getIntent().getExtras().getString("EXTRA_NUMBER_PLAYER_3_NAME");
        String player_4_name = getIntent().getExtras().getString("EXTRA_NUMBER_PLAYER_4_NAME");
        String player_5_name = getIntent().getExtras().getString("EXTRA_NUMBER_PLAYER_5_NAME");

        int number_players=bundle.getInt("EXTRA_NUMBER_PLAYERS",0);
        setContentView(R.layout.activity_go_to_game);

        //displays the number of players
        TextView textView = (TextView) this.findViewById(R.id.game_screen_title);
        textView.setText(String.valueOf(number_players));

        TextView player1 = (TextView) this.findViewById(R.id.Player1);
        player1.setText(String.valueOf(player_1_name));

        TextView player2 = (TextView) this.findViewById(R.id.Player2);
        player2.setText(String.valueOf(player_2_name));

        TextView player3 = (TextView) this.findViewById(R.id.Player3);
        player3.setText(String.valueOf(player_3_name));

        TextView player4 = (TextView) this.findViewById(R.id.Player4);
        player4.setText(String.valueOf(player_4_name));

        TextView player5 = (TextView) this.findViewById(R.id.Player5);
        player5.setText(String.valueOf(player_5_name));





    }

    //menu stuff
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_go_to_game, menu);
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

    //should go to score screen activity
    public void score_screen(View view){
        //goes to next screen in response to button press
        Intent intent = new Intent(this, score_screen.class);
        startActivity(intent);
    }
}
