package com.example.sam.no_please_test;

/**
 * Created by Olaf on 4/2/2015.
 */
public class Score {

    //We shouldn't really this string to array function anymore
    int[] StringToArray(String stringToBeParsed) {

        String[] parseString = stringToBeParsed.split(" ");
        int[] newArray = new int[parseString.length];

        for(int i = 1; i < parseString.length; i++) {
            newArray[i] = Integer.parseInt(parseString[i]);
        }

        return newArray;
    }

    int calculateScore(int[] scoreArray, int numChips) {
        if(scoreArray.length == 0) {
            return 0;
        }
        else {
            int totalScore = scoreArray[0];
            int currentCard;
            for (int i=1; i < scoreArray.length; i++) {
                currentCard = scoreArray[i];

                if(noLowerCardByOne(scoreArray, currentCard, i)) {
                    totalScore += scoreArray[i];
                }
            }

            return totalScore-numChips;
        }
    }

    boolean noLowerCardByOne(int[] hand, int currCard, int index) {
        if(hand[index-1] == currCard-1) return false;
        return true;
    }

}
