
package com.example.sam.no_please_test;

//
// Created by Kym on 3/7/15.
//

public class Card implements Comparable
{
    private int value;
    public int numChips;

    public Card(int newValue)
    {
        value = newValue;
        numChips = 0;
    }

    public int getValue()
    {
        return value;
    }

    public int getNumChips()
    {
        return numChips;
    }

    void incrementChips()
    {
        numChips++;
    }

    //this makes cards comparable to each other so that collections.sort can be called in the
    //Player class. It's pretty involved and I don't completely understand it, but hey it works :)
    @Override
    public int compareTo(Object anotherCard) {
        int compareCard=((Card)anotherCard).getValue();
        return this.getValue()-compareCard;
    }
}


