
package com.example.sam.no_please_test;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections; //for compare

//
 // Created by olaf on 2/14/15.
 //
public class Player
{

    List<Card> Hand = new ArrayList<Card>();
    int handSize;
    int chipCount;
    boolean is_player_AI;
    int playerNumber;
    String playerName;

    public Player( String name, int number,boolean is_AI ) {

        handSize = 0;

        chipCount = 11;
        //playerType type; //when do we assign this?
        playerName = name;
        playerNumber = number;
        is_player_AI= is_AI;

    } //Player constructor

    /*void passCard( Card card ) { //passing in Card object
        //take one token from player
        tokenCount--;
        //put the token on the card
        card.attachToken(); //increment token count on card

    } //passCard function
*/
    public void takeCard( Card card ) { //passing in Card object
        //put Card in hand
        Hand.add(card);
        //increment hand size
        handSize = handSize++;
        //sort array
        Collections.sort(Hand);
        //add tokens from card to user count
        chipCount += card.numChips;

    } //takeCard function

    boolean enoughTokens() {

        if ( chipCount == 0 ) {
            return false;
        } else {
            return true;
        }


    } // enoughTokens function
}
