
package com.example.sam.no_please_test;

//
// Created by Kym on 3/7/15.
//

public class Card
{
    private int value;
    private int numChips;

    public Card(int newValue)
    {
        value = newValue;
        numChips = 0;
    }

    public int getValue()
    {
        return value;
    }

    void incrementChips()
    {
        numChips++;
    }
}


