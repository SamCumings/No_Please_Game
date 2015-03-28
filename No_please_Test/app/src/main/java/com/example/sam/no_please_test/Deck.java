/*
package com.example.sam.no_please_test;

//
// Created by Kym on 3/7/15.
//
class Deck
{
    private List<Card> deck = new ArrayList<Card>();
    private int numCardsLeft = 33;

    private void initCards()
    {
        for (int i = 3; i < 35; i++)
        {
            int tempId = i;
            Card tempCard = new Card(tempId);
            int resourceId = getResources().getIdentifier("card" + tempId, "drawable", myContext.getPackageName());
            Bitmap tempBitmap = BitmapFactory.decodeResource(myContext.getResources(), resourceId);
            scaledCardW = (int) (screenW/8);
            scaledCardH = (int) (scaledCardW*1.28);
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(tempBitmap, scaledCardW, scaledCardH, false);
            tempCard.setBitmap(scaledBitmap);
            deck.add(tempCard);
        }
    }

    private void drawCard(List<Card> handToDraw)
    {
        handToDraw.add(0, deck.get(0));
        deck.remove(0);
    }
    private void randmizeDeck()
    {
        Collections.shuffle(deck,new Random());
    }

    private bool isDeckEmpty()
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
        --numcardsLeft;
        return numCardsLeft;
    }
}

*/