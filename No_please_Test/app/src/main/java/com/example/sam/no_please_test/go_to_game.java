package com.example.sam.no_please_test;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class go_to_game extends ActionBarActivity {
    //handles issues of displaying the game

    public String hand_list_to_string(List<Card> hand){
        String text_hand = " ";

        for (Card s : hand)
        {
            text_hand += s.getValue() + " ";
        }

        return text_hand;
    }

    public void update(Game new_game){
        TextView current_card = (TextView) this.findViewById(R.id.Current_Card);
        current_card.setText(String.valueOf(new_game.current_card.getValue()));

        TextView current_card_chips = (TextView) this.findViewById(R.id.Current_Card_Chips);
        current_card_chips.setText(String.valueOf(new_game.current_card.numChips));

        TextView current_player_name = (TextView) this.findViewById(R.id.current_player_name);
        current_player_name.setText(String.valueOf(new_game.Current_Player.playerName));

        TextView current_player_tokens = (TextView) this.findViewById(R.id.current_player_chip_count);
        current_player_tokens.setText(String.valueOf(new_game.Current_Player.chipCount));

        TextView player_1_cards = (TextView) this.findViewById(R.id.Player1_cards);
        player_1_cards.setText((hand_list_to_string(new_game.Player_List[0].Hand)));

        TextView player_2_cards = (TextView) this.findViewById(R.id.Player2_cards);
        player_2_cards.setText((hand_list_to_string(new_game.Player_List[1].Hand)));

        TextView player_3_cards = (TextView) this.findViewById(R.id.Player3_cards);
        player_3_cards.setText((hand_list_to_string(new_game.Player_List[2].Hand)));

        ImageView Player_4_icon = (ImageView)findViewById(R.id.Player_4_icon);
        Player_4_icon.setVisibility(View.INVISIBLE);

        ImageView Player_5_icon = (ImageView)findViewById(R.id.Player_5_icon);
        Player_5_icon.setVisibility(View.INVISIBLE);

        if(new_game.number_players>3)
        {
            TextView player_4_cards = (TextView) this.findViewById(R.id.Player4_cards);
            player_4_cards.setText((hand_list_to_string(new_game.Player_List[3].Hand)));
            Player_4_icon.setVisibility(View.VISIBLE);
        }

        if(new_game.number_players>4)
        {
            TextView player_5_cards = (TextView) this.findViewById(R.id.Player5_cards);
            player_5_cards.setText((hand_list_to_string(new_game.Player_List[4].Hand)));
            Player_5_icon.setVisibility(View.VISIBLE);
        }

        if (!new_game.Current_Player.enoughTokens())
        {
            View button = findViewById(R.id.pass_button);
            button.setVisibility(View.INVISIBLE);
        }
        else
        {
            View button = findViewById(R.id.pass_button);
            button.setVisibility(View.VISIBLE);
        }

        if(new_game.current_card.getValue()==-1)
        {
            View score_button = findViewById(R.id.score_button);
            score_button.setVisibility(View.VISIBLE);

            View pass_button = findViewById(R.id.pass_button);
            pass_button.setVisibility(View.INVISIBLE);

            View take_button = findViewById(R.id.take_button);
            take_button.setVisibility(View.INVISIBLE);
        }
    }

    Game new_game;

    Card test_card;
    int number_players;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        //FragmentManager FM = getFragmentManager();
        //FragmentTransaction FT = FM.beginTransaction();
        //WaitScreenFragment waitScreenFragment = new WaitScreenFragment();
        //FT.add(R.id., waitScreenFragment);
        //FT.commit();

        //this gets the number of players (doesn't get anything else yet that's what the commented out code is for).
        Bundle bundle = getIntent().getExtras();

        String player_1_name = getIntent().getExtras().getString("EXTRA_NUMBER_PLAYER_1_NAME");
        boolean player1_AI = getIntent().getExtras().getBoolean("EXTRA_NUMBER_PLAYER_1_AI");

        String player_2_name = getIntent().getExtras().getString("EXTRA_NUMBER_PLAYER_2_NAME");
        boolean player2_AI = getIntent().getExtras().getBoolean("EXTRA_NUMBER_PLAYER_2_AI");

        String player_3_name = getIntent().getExtras().getString("EXTRA_NUMBER_PLAYER_3_NAME");
        boolean player3_AI = getIntent().getExtras().getBoolean("EXTRA_NUMBER_PLAYER_3_AI");

        String player_4_name = getIntent().getExtras().getString("EXTRA_NUMBER_PLAYER_4_NAME");
        boolean player4_AI = getIntent().getExtras().getBoolean("EXTRA_NUMBER_PLAYER_4_AI");

        String player_5_name = getIntent().getExtras().getString("EXTRA_NUMBER_PLAYER_5_NAME");
        boolean player5_AI = getIntent().getExtras().getBoolean("EXTRA_NUMBER_PLAYER_5_AI");

        number_players=bundle.getInt("EXTRA_NUMBER_PLAYERS",0);
        setContentView(R.layout.activity_go_to_game);

        //displays the number of players
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
        new_game = new Game (number_players, player_1_name, player1_AI, player_2_name, player2_AI, player_3_name, player3_AI, player_4_name, player4_AI, player_5_name, player5_AI);

        //hides unused textviews (if statements for players 4 and 5)

        //update function pretty much
        update(new_game);
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
            //add current card to current player's hand-
            //add chips on card to current player's pool-
            //check if the game is over
            //draw a new card-
            //change current player to the next player-
            //check if that new player can pass or not (might be more of an image thing)
        //image changes
            //change the text view for current player
            //if game is over make score screen button visible
            //change current card to the newly drawn card
            //change current amount of chips (to the new current player)
            //change current highlighted player
            //check if the pass button should be greyed out for this player

        Intent intent = new Intent(this, WaitScreen.class);

        test_card=new_game.take_card();

        intent.putExtra("playerName", new_game.Current_Player.playerName);
        startActivity(intent);

        update(new_game);
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

        Intent intent = new Intent(this, WaitScreen.class);

        new_game.pass_card();

        intent.putExtra("playerName", new_game.Current_Player.playerName);
        startActivity(intent);

        update(new_game);
    }

    //should go to score screen activity
    public void score_screen(View view){
        //goes to next screen in response to button press

        Intent intent = new Intent(this, score_screen.class);

        Bundle scores_bundle = new Bundle();

        //put number of players
        scores_bundle.putInt("number_of_players", new_game.number_players);

        //put players in string array
        String[] playerNameArray = new String[5];
        for (int i = 0; i < number_players; i++) {
            playerNameArray[i] = new_game.Player_List[i].playerName;
        }
        scores_bundle.putStringArray("player_names", playerNameArray);

        //put player 1 cards and chips
        scores_bundle.putIntArray("player_1_cards", new_game.Player_List[0].getCardArray());
        scores_bundle.putInt("player_1_chips", new_game.Player_List[0].chipCount);
        //put player 2 cards and chips
        scores_bundle.putIntArray("player_2_cards", new_game.Player_List[1].getCardArray());
        scores_bundle.putInt("player_2_chips", new_game.Player_List[1].chipCount);
        //put player 3 cards and chips
        scores_bundle.putIntArray("player_3_cards", new_game.Player_List[2].getCardArray());
        scores_bundle.putInt("player_3_chips", new_game.Player_List[2].chipCount);

        if( new_game.number_players >= 4) {
            //put player 1 cards and chips
            scores_bundle.putIntArray("player_4_cards", new_game.Player_List[3].getCardArray());
            scores_bundle.putInt("player_4_chips", new_game.Player_List[3].chipCount);

            if (new_game.number_players == 5) {
                //put player 1 cards and chips
                scores_bundle.putIntArray("player_5_cards", new_game.Player_List[4].getCardArray());
                scores_bundle.putInt("player_5_chips", new_game.Player_List[4].chipCount);
            }
        }

        intent.putExtras(scores_bundle); //pass scores to intent
        startActivity(intent); //start score screen
    }
}
