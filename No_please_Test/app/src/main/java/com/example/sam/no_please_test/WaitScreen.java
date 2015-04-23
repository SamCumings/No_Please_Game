package com.example.sam.no_please_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

        TextView current_player_name = (TextView) this.findViewById(R.id.playerName);
        current_player_name.setText(intent.getStringExtra("playerName"));
}

}
