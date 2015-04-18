package com.example.sam.no_please_test;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;
import android.widget.RadioButton;

import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;


public class Player_Select extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_player__select);
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

    int number_players=0;
    boolean player1_AI=false;
    boolean player2_AI=false;
    boolean player3_AI=false;
    boolean player4_AI=false;
    boolean player5_AI=false;

    //toggle buttons
    public void onToggleClicked_1(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            player1_AI=false;
        } else {
            player1_AI=true;
        }
    }
    public void onToggleClicked_2(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            player2_AI=false;
        } else {
            player2_AI=true;
        }
    }
    public void onToggleClicked_3(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            player3_AI=false;
        } else {
            player3_AI=true;
        }
    }
    public void onToggleClicked_4(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            player4_AI=false;
        } else {
            player4_AI=true;
        }
    }
    public void onToggleClicked_5(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            player5_AI=false;
        } else {
            player5_AI=true;
        }
    }

    //does the radio buttons
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        View button = findViewById(R.id.button);
        button.setVisibility(View.VISIBLE);

        // Check which radio button was clicked
        // reveals the appropriate text fields depending on the players selected. (that's what the invisible vs. visible means)
        switch(view.getId()) {
            case R.id.radio_three_players:
                if (checked) {
                    number_players = 3;

                    View player1 = findViewById(R.id.Player1_Name);
                    player1.setVisibility(View.VISIBLE);

                    View player2 = findViewById(R.id.Player2_Name);
                    player2.setVisibility(View.VISIBLE);

                    View player3 = findViewById(R.id.Player3_Name);
                    player3.setVisibility(View.VISIBLE);

                    View player4 = findViewById(R.id.Player4_Name);
                    player4.setVisibility(View.INVISIBLE);

                    View player5 = findViewById(R.id.Player5_Name);
                    player5.setVisibility(View.INVISIBLE);
                }
                    break;
            case R.id.radio_four_players:
                if (checked) {
                    number_players = 4;
                    View player1 = findViewById(R.id.Player1_Name);
                    player1.setVisibility(View.VISIBLE);

                    View player2 = findViewById(R.id.Player2_Name);
                    player2.setVisibility(View.VISIBLE);

                    View player3 = findViewById(R.id.Player3_Name);
                    player3.setVisibility(View.VISIBLE);

                    View player4 = findViewById(R.id.Player4_Name);
                    player4.setVisibility(View.VISIBLE);

                    View player5 = findViewById(R.id.Player5_Name);
                    player5.setVisibility(View.INVISIBLE);
                }
                    break;
            case R.id.radio_five_players:
                if (checked) {
                    number_players = 5;
                    View player1 = findViewById(R.id.Player1_Name);
                    player1.setVisibility(View.VISIBLE);

                    View player2 = findViewById(R.id.Player2_Name);
                    player2.setVisibility(View.VISIBLE);

                    View player3 = findViewById(R.id.Player3_Name);
                    player3.setVisibility(View.VISIBLE);

                    View player4 = findViewById(R.id.Player4_Name);
                    player4.setVisibility(View.VISIBLE);

                    View player5 = findViewById(R.id.Player5_Name);
                    player5.setVisibility(View.VISIBLE);
                }
                    break;
        }
    }

    //should go to game screen activity
    public void go_to_game(View view){
        //response to button press pass the number of players to game screen. Pass it the Number of players through the put Extra thing.
        // need to get bundles understood so I can pass more than just one tiny bit of information.

        EditText editText1 = (EditText) findViewById(R.id.Player1_Name);
        String player_1_name = editText1.getText().toString();

        EditText editText2 = (EditText) findViewById(R.id.Player2_Name);
        String player_2_name = editText2.getText().toString();

        EditText editText3 = (EditText) findViewById(R.id.Player3_Name);
        String player_3_name = editText3.getText().toString();

        EditText editText4 = (EditText) findViewById(R.id.Player4_Name);
        String player_4_name = editText4.getText().toString();

        EditText editText5 = (EditText) findViewById(R.id.Player5_Name);
        String player_5_name = editText5.getText().toString();


        Intent intent = new Intent(this, go_to_game.class);
        Bundle bundle = new Bundle();

        bundle.putString("EXTRA_NUMBER_PLAYER_1_NAME", player_1_name);
        bundle.putBoolean("EXTRA_NUMBER_PLAYER_1_AI",player1_AI);
        bundle.putString("EXTRA_NUMBER_PLAYER_2_NAME", player_2_name);
        bundle.putBoolean("EXTRA_NUMBER_PLAYER_2_AI",player2_AI);
        bundle.putString("EXTRA_NUMBER_PLAYER_3_NAME", player_3_name);
        bundle.putBoolean("EXTRA_NUMBER_PLAYER_3_AI",player3_AI);
        bundle.putString("EXTRA_NUMBER_PLAYER_4_NAME", player_4_name);
        bundle.putBoolean("EXTRA_NUMBER_PLAYER_4_AI",player4_AI);
        bundle.putString("EXTRA_NUMBER_PLAYER_5_NAME", player_5_name);
        bundle.putBoolean("EXTRA_NUMBER_PLAYER_5_AI",player5_AI);

        bundle.putInt("EXTRA_NUMBER_PLAYERS", number_players);

        intent.putExtras(bundle);
        startActivity(intent);
    }




}
