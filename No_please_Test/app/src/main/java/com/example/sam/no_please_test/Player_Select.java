package com.example.sam.no_please_test;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import android.view.View.OnClickListener;


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

    /*
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_Player1:
                if (checked){

                }
                else{

                }

                break;
            case R.id.checkbox_Player2:
                if (checked){

                }
                else{

                }
                break;
            case R.id.checkbox_Player3:
                if (checked){

                }
                else{

                }
                break;
            case R.id.checkbox_Player4:
                if (checked){

                }
                else{

                }
                break;
            case R.id.checkbox_Player5:
                if (checked){

                }
                else{

                }
                break;
        }
    }
    */

    /*
    Spinner spinner = (Spinner) findViewById(R.id.player_select_spinner);
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.player_select_spinner, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
    spinner.setAdapter(adapter);
    */

    int number_players=0;

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        View button = findViewById(R.id.button);
        button.setVisibility(View.VISIBLE);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_three_players:
                if (checked)
                    number_players=3;
                    break;
            case R.id.radio_four_players:
                if (checked)
                    number_players=4;
                    break;
            case R.id.radio_five_players:
                if (checked)
                    number_players=5;
                    break;
        }
    }

    /*should go to game screen activity*/
    public void go_to_game(View view){
        //do something in response to button
        Intent intent = new Intent(this, go_to_game.class);
        intent.putExtra("EXTRA_NUMBER_PLAYERS",number_players);
        startActivity(intent);
    }




}
