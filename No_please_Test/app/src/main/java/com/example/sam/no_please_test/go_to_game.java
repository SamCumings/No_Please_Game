package com.example.sam.no_please_test;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;


public class go_to_game extends ActionBarActivity {
    //handles issues of displaying the game

    public void update(Game new_game){
        TextView current_card = (TextView) this.findViewById(R.id.Current_Card);
        current_card.setText(String.valueOf(new_game.current_card.getValue()));

        TextView current_card_chips = (TextView) this.findViewById(R.id.Current_Card_Chips);
        current_card_chips.setText(String.valueOf(new_game.current_card.numChips));

        TextView current_player_name = (TextView) this.findViewById(R.id.current_player_name);
        current_player_name.setText(String.valueOf(new_game.Current_Player.playerName));

        TextView current_player_tokens = (TextView) this.findViewById(R.id.current_player_chip_count);
        current_player_tokens.setText(String.valueOf(new_game.Current_Player.tokenCount));

        TextView player_1_cards = (TextView) this.findViewById(R.id.Player1_cards);
        player_1_cards.setText(Arrays.toString(new_game.Player_List[0].Hand));

        TextView player_2_cards = (TextView) this.findViewById(R.id.Player2_cards);
        player_2_cards.setText(Arrays.toString(new_game.Player_List[1].Hand));

        TextView player_3_cards = (TextView) this.findViewById(R.id.Player3_cards);
        player_3_cards.setText(Arrays.toString(new_game.Player_List[2].Hand));

        if(new_game.number_players>3) {
            TextView player_4_cards = (TextView) this.findViewById(R.id.Player4_cards);
            player_4_cards.setText(Arrays.toString(new_game.Player_List[3].Hand));
        }
        if(new_game.number_players>4){
            TextView player_5_cards = (TextView) this.findViewById(R.id.Player5_cards);
            player_5_cards.setText(Arrays.toString(new_game.Player_List[4].Hand));
        }
    }




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

        //game called
        Game new_game = new Game (number_players,player_1_name,player_2_name,player_3_name,player_4_name,player_5_name);

        //hides unused textviews (if statements for players 4 and 5)

        //update function pretty much
        TextView current_card = (TextView) this.findViewById(R.id.Current_Card);
        current_card.setText(String.valueOf(new_game.current_card.getValue()));

        TextView current_card_chips = (TextView) this.findViewById(R.id.Current_Card_Chips);
        current_card_chips.setText(String.valueOf(new_game.current_card.numChips));

        TextView current_player_name = (TextView) this.findViewById(R.id.current_player_name);
        current_player_name.setText(String.valueOf(new_game.Current_Player.playerName));

        TextView current_player_tokens = (TextView) this.findViewById(R.id.current_player_chip_count);
        current_player_tokens.setText(String.valueOf(new_game.Current_Player.tokenCount));

        TextView player_1_cards = (TextView) this.findViewById(R.id.Player1_cards);
        player_1_cards.setText(Arrays.toString(new_game.Player_List[0].Hand));

        TextView player_2_cards = (TextView) this.findViewById(R.id.Player2_cards);
        player_2_cards.setText(Arrays.toString(new_game.Player_List[1].Hand));

        TextView player_3_cards = (TextView) this.findViewById(R.id.Player3_cards);
        player_3_cards.setText(Arrays.toString(new_game.Player_List[2].Hand));

        if(number_players>3) {
            TextView player_4_cards = (TextView) this.findViewById(R.id.Player4_cards);
            player_4_cards.setText(Arrays.toString(new_game.Player_List[3].Hand));
        }
        if(number_players>4){
            TextView player_5_cards = (TextView) this.findViewById(R.id.Player5_cards);
            player_5_cards.setText(Arrays.toString(new_game.Player_List[4].Hand));
        }




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

    //called when take button pressed
    public void take_button(View view){
        //state changes
            //add current card to current player's hand
            //add chips on card to current player's pool
            //check if the game is over
            //draw a new card
            //change current player to the next player
            //check if that new player can pass or not (might be more of an image thing)
        //image changes
            //change the text view for current player
            //if game is over make score screen button visible
            //change current card to the newly drawn card
            //change current amount of chips (to the new current player)
            //change current highlighted player
            //check if the pass button should be greyed out for this player



    }
    //called when pass button pressed
    public void pass_button(View view){
        //state changes
            //lose a token from the current player
            //add a token to the current card
            //change the current player to the next player
            //check if the new player can hit the pass button
        //image changes
            //change current highlighted character
            //check if the pass button should be greyed out
            //change number of chips to the new player's chips
    }

    //should go to score screen activity
    public void score_screen(View view){
        //goes to next screen in response to button press

        //to do pass player information to score screen
        Intent intent = new Intent(this, score_screen.class);
        startActivity(intent);
    }
}
