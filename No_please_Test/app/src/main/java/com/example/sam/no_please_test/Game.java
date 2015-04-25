package com.example.sam.no_please_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Sam on 3/28/15.
 */
public class Game{
    int number_players;
    Player Current_Player;
    Deck game_deck;
    Card current_card;
    Card end_card;
    Player[] Player_List;
    Random random_num;

    public Game(int number_player, String player1, boolean player1_AI, String player2, boolean player2_AI, String player3, boolean player3_AI, String player4,boolean player4_AI, String player5, boolean player5_AI){
        number_players=number_player;

        Player_List = new Player[number_player];
        game_deck = new Deck();
        game_deck.initCards();
        random_num=new Random();


        //for consistency Player number is going to be equal to it's array position (starting at zero)
        Player_List[0] = new Player(player1, 0, player1_AI);
        Player_List[1] = new Player(player2, 1, player2_AI);
        Player_List[2] = new Player(player3, 2, player3_AI);
        if(number_players >= 4) {
            Player_List[3] = new Player(player4, 3, player4_AI);
        }
        if(number_players == 5) {
            Player_List[4] = new Player(player5, 4, player5_AI);
        }

        end_card=new Card(-1);
        Current_Player=Player_List[0];
        current_card=draw_card();

    }
    public Card draw_card(){
        return game_deck.popCard();
    }

    public void go_next_player(){
        Current_Player=Player_List[(Current_Player.playerNumber+1)%number_players];
        if (Current_Player.is_player_AI){
            AI_turn();
        }
    }
    public void AI_turn(){
        int decision=random_num.nextInt()%100;
        if (!check_pass_card()){
            take_card();
        }
        if (decision>10){
            pass_card();
        }
        else {
            take_card();
        }
    }
    public Card take_card(){
        //fix player class
        Current_Player.takeCard (current_card);
        if(is_game_over()){
            //game is over
            return current_card=end_card;
        }else {
            current_card=draw_card();
            go_next_player();
            return current_card;
        }

    }
    public boolean check_pass_card(){
        return Current_Player.enoughTokens();
    }
    public void pass_card(){
        current_card.incrementChips();
        Current_Player.chipCount--; //changed to chip for consistency
        go_next_player();
    }
    public boolean is_game_over(){
        if(game_deck.isDeckEmpty()){
            //game over
            return true;
        } else {
            //game not over
            return false;
        }
    }
}
