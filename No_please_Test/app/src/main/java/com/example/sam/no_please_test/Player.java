/*
package com.example.sam.no_please_test;

 //
 // Created by olaf on 2/14/15.
 //
public class Player {

    int[] Hand = new int[33];
    int handSize;
    int tokenCount;
    //enum playerType {HUMAN, AI};
    int playerNumber;
    String playerName;

    public Player( String name, int number ) {

        handSize = 0;
        tokenCount = 11;
        //playerType type; //when do we assign this?
        playerName=name;
        playerNumber = number;

    } //Player constructor

    void passCard( Card card ) { //passing in Card object
        //take one token from player
        tokenCount--;
        //put the token on the card
        card.attachToken(); //increment token count on card

    } //passCard function

    void takeCard( Card card ) { //passing in Card object
        //put card id in hand
        Hand[handSize]=card.id;
        //increment hand size
        handSize = handSize++;
        //add tokens from card to user count
        tokenCount += card.numTokensAttached;

    } //takeCard function

    boolean enoughTokens() {

        if ( tokenCount == 0 ) return false;
        return true;

    }

}
*/