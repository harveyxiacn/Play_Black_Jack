//*****************************************************************************
//  BlackJackHand.java       Author: Ye Xia (ID: 121866)
//  C SC152 - Assignment #5 - Problem #1
//  Represents a player or a dealer with some basic methods, like add cards,
//  return the value, flip the card.
//*****************************************************************************

import javax.swing.*;

public class BlackJackHand {
    // declare variables

    private Card[] handCard;
    private int totalValue, size;
    private int money;
    //-----------------------------------------------------------------
    //  Constructor: Sets up the player or the dealer.
    //-----------------------------------------------------------------

    public BlackJackHand() {
        handCard = new Card[5];
        totalValue = 0;
        size = 0;
        money = 10000;
    }
    // add a card and return all the information of the cards which 
    // are in the player or dealer's hand

    public ImageIcon addCard(Card card) {
        handCard[size] = card;
        size++;
        //return result;
        return card.getIcon();
    }
    // return the value of the cards on the hand

    public int value() {
        totalValue = 0;
        int aceCount = 0;
        for (int i = 0; i < size; i++) {
            if (handCard[i].isFaceUp() == false) {
                continue;
            }
            totalValue += handCard[i].value();
            if (handCard[i].value() == 11) {
                aceCount = 1;
            }
        }
        if (aceCount == 1 && totalValue > 21) {
            reduceHand();
        }
        return totalValue;
    }
    // return how many cards on hand

    public int size() {
        return size;
    }
    // if there is a ace on hand, and the total value is bigger than 21, 
    // reduce 10

    public void reduceHand() {
        totalValue -= 10;
    }
    // if the player and the dealer's value are both less then 21,
    // compare their value

    public int compareTo(BlackJackHand hand1) {
        if (totalValue > hand1.value()) {
            return 1;
        } else if (totalValue == hand1.value()) {
            return 0;
        } else {
            return -1;
        }
    }
    // flip the dealer's first card

    public void flip() {
        handCard[0].flip();
    }
    /* for testing the blackjack situation
    //public void flip1(){
    //handCard[0].flip();
    //handCard[1].flip();
    }*/
    // get to know if the player or the dealer get the blackjack

    public boolean isBlackjack() {
        if (handCard[0].value() + handCard[1].value() == 21) {
            return true;
        } else {
            return false;
        }
    }
    // return a card by index

    public Card getCard(int index) {
        return handCard[index];
    }
    // new money

    public void newMoney() {
        money = 10000;
    }
    //set money

    public void setMoney(int money) {
        this.money += money;
    }
    // return money

    public int getMoney() {
        return money;
    }
    // initialize a player or a dealer

    public void init() {
        totalValue = 0;
        size = 0;
        money = 10000;
    }
    // initialize next round

    public void initNext() {
        totalValue = 0;
        size = 0;
    }
}