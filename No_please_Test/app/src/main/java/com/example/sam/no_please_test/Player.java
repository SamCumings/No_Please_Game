
package com.example.sam.no_please_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections; //for compare

//
 // Created by olaf on 2/14/15.
 //
public class Player{

     List<Card> Hand = new ArrayList<Card>();
    int handSize;
    int chipCount;
    //enum playerType {HUMAN, AI};
    int playerNumber;
    String playerName;

    public Player( String name, int number ) {

        handSize = 0;

        chipCount = 11;
        //playerType type; //when do we assign this?
        playerName = name;
        playerNumber = number;

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

        if ( chipCount == 0 ) return false;
        return true;

    } // enoughTokens function


 }
