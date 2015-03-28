package com.example.sam.no_please_test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 3/28/15.
 */
public class Game {
    int number_players;
    Player Current_Player;
    Deck game_deck;
    Card current_card;
    Player[] Player_List;

    public Game(int number_player, String player1, String player2, String player3, String player4, String player5){
        number_players=number_player;

        Player_List = new Player[number_player];
        game_deck = new Deck();
        //game_deck.randomizeDeck();


        //for consistency Player number is going to be equal to it's array position (starting at zero)
        Player_List[0] = new Player(player1, 0);
        Player_List[1] = new Player(player2, 1);
        Player_List[2] = new Player(player3, 2);
        if(number_players >= 4) {
            Player_List[3] = new Player(player4, 3);
        }
        if(number_players == 5) {
            Player_List[4] = new Player(player5, 4);
        }


        Current_Player=Player_List[0];

    }
    public void draw_card(){
        current_card=game_deck.popCard();
    }
    public void go_next_player(){
        Current_Player=Player_List[Current_Player.playerNumber++%number_players];
    }
    public void take_card(Card current_card){
        //fix player class
        //Current_Player.take_card(current_card);
        go_next_player();
    }
    public boolean check_pass_card(){
        return Current_Player.enoughTokens();
    }
    public void pass_card(){
        current_card.incrementChips();
        Current_Player.tokenCount--;
        go_next_player();
    }
}
