package com.example.sam.no_please_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by TJ on 4/21/2015.
 */
public class WaitScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent  = getIntent();

        setContentView(R.layout.activity_waitscreen);

        // Make a TextView on the Wait Screen for the next player's name
        TextView current_player_name = (TextView) this.findViewById(R.id.playerName);
        current_player_name.setText(intent.getStringExtra("playerName"));
}

    //goes to back to go_to_game (finish just closes the current activity and goes back to the last one.)
    public void back_to_game(View view) {
        //do something in response to button
        finish();
    }

}
