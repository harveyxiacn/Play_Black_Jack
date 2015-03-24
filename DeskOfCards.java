//*****************************************************************************
//  DeskOfCards.java       Author: Ye Xia (ID: 121866)
//  C SC152 - Assignment #5 - Problem #1
//  Represents a desk with cards on it and some basic method, like deal the 
//  card to the player or the dealer, return how many cards left.
//*****************************************************************************

import java.util.*;

public class DeskOfCards {
    // declare variables

    private Card[] desk;// hold the cards
    private int size;// hold how many cards remainded
    private Card dealCard;// hold the dealed card
    //-----------------------------------------------------------------
    //  Constructor: Sets up the desk by defining its cards' number,
    //  create the cards, and shuffle the cards..
    //-----------------------------------------------------------------

    public DeskOfCards() {
        size = 52;
        create();
        shuffle();
    }
    // create the 52 cards

    public void create() {
        desk = new Card[size];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                switch (j) {
                    case 0:
                        desk[i] = new Card(i + 1, "club");
                        break;
                    case 1:
                        desk[i + 13] = new Card(i + 1, "diamond");
                        break;
                    case 2:
                        desk[i + 26] = new Card(i + 1, "heart");
                        break;
                    case 3:
                        desk[i + 39] = new Card(i + 1, "spade");
                        break;
                }
            }
        }
    }
    // shuffle the cards

    public void shuffle() {
        Random random = new Random();
        int index;
        Card tempCard;
        for (int i = 0; i < size; i++) {
            index = random.nextInt(52);
            tempCard = desk[i];
            desk[i] = desk[index];
            desk[index] = tempCard;
        }
    }
    // set the size of cards

    public void setSize() {
        size = 52;
    }
    // deal a card to a player or a dealer

    public Card deal() {
        dealCard = desk[size - 1];
        if (dealCard.isFaceUp() == false) {
            dealCard.flip();
            dealCard.setIcon();
        }
        size--;
        return dealCard;
    }
    // deal a card without flip it to a dealer

    public Card dealDown() {
        dealCard = desk[size - 1];
        size--;
        if (dealCard.isFaceUp() == true) {
            dealCard.flip();
            dealCard.setIcon();
        }
        dealCard.setIcon();
        return dealCard;
    }
    // return how many cards remain

    public int cardsLeft() {
        return size;
    }
}