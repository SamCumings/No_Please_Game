package com.example.sam.no_please_test;

import java.util.Collections;
import java.util.Random;
import java.util.Stack;
//
// Created by Kym on 3/7/15.
//
class Deck
{
    private Stack<Card> deck = new Stack<>();
    private int numCardsLeft = 33;

     public void initCards()
    {
        for (int i = 3; i < 36; i++)
        {
            int tempId = i;
            Card tempCard = new Card(tempId);
            deck.add(tempCard);
        }
    }

    private void randomizeDeck()
    {
        Collections.shuffle(deck, new Random());
    }

    public boolean isDeckEmpty()
    {
        if(numCardsLeft <= 9)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private int decrementNumCards()
    {
        --numCardsLeft;
        return numCardsLeft;
    }

    Card popCard()
    {
        Card currentCard = deck.pop();
        return currentCard;
    }
}

