//*****************************************************************************
//  Card.java       Author: Ye Xia (ID: 121866)
//  C SC152 - Assignment #5 - Problem #1
//  Represents a card with card value, suit, face, and if it faces up. 
//*****************************************************************************

import javax.swing.ImageIcon;

public class Card {
    // declare variables

    private int cardValue;//hold the card value
    private String suit;//hold the card suit
    private boolean faceUp;//hold if the card faces up
    private String face;//hold the card information
    private ImageIcon icon;
    //-----------------------------------------------------------------
    //  Constructor: Sets up the card by defining its value,
    //   suit.
    //-----------------------------------------------------------------

    public Card(int value, String suit) {
        this.cardValue = value;
        this.suit = suit;
        this.faceUp = false;
        this.face = "";
        setIcon();
    }
    // set the icon of the card 

    public void setIcon() {
    	if (faceUp == false) {
            icon = new ImageIcon("face/cover.jpg");
        }else{
	        switch (cardValue) {
	            case 1:
	                if (suit.equals("club")) {
	                    icon = new ImageIcon("face/1-club.jpg");
	                } else if (suit.equals("diamond")) {
	                    icon = new ImageIcon("face/1-diamond.jpg");
	                } else if (suit.equals("heart")) {
	                    icon = new ImageIcon("face/1-heart.jpg");
	                } else if (suit.equals("spade")) {
	                    icon = new ImageIcon("face/1-spade.jpg");
	                }
	                break;
	            case 2:
	                if (suit.equals("club")) {
	                    icon = new ImageIcon("face/2-club.jpg");
	                } else if (suit.equals("diamond")) {
	                    icon = new ImageIcon("face/2-diamond.jpg");
	                } else if (suit.equals("heart")) {
	                    icon = new ImageIcon("face/2-heart.jpg");
	                } else if (suit.equals("spade")) {
	                    icon = new ImageIcon("face/2-spade.jpg");
	                }
	                break;
	            case 3:
	                if (suit.equals("club")) {
	                    icon = new ImageIcon("face/3-club.jpg");
	                } else if (suit.equals("diamond")) {
	                    icon = new ImageIcon("face/3-diamond.jpg");
	                } else if (suit.equals("heart")) {
	                    icon = new ImageIcon("face/3-heart.jpg");
	                } else if (suit.equals("spade")) {
	                    icon = new ImageIcon("face/3-spade.jpg");
	                }
	                break;
	            case 4:
	                if (suit.equals("club")) {
	                    icon = new ImageIcon("face/4-club.jpg");
	                } else if (suit.equals("diamond")) {
	                    icon = new ImageIcon("face/4-diamond.jpg");
	                } else if (suit.equals("heart")) {
	                    icon = new ImageIcon("face/4-heart.jpg");
	                } else if (suit.equals("spade")) {
	                    icon = new ImageIcon("face/4-spade.jpg");
	                }
	                break;
	            case 5:
	                if (suit.equals("club")) {
	                    icon = new ImageIcon("face/5-club.jpg");
	                } else if (suit.equals("diamond")) {
	                    icon = new ImageIcon("face/5-diamond.jpg");
	                } else if (suit.equals("heart")) {
	                    icon = new ImageIcon("face/5-heart.jpg");
	                } else if (suit.equals("spade")) {
	                    icon = new ImageIcon("face/5-spade.jpg");
	                }
	                break;
	            case 6:
	                if (suit.equals("club")) {
	                    icon = new ImageIcon("face/6-club.jpg");
	                } else if (suit.equals("diamond")) {
	                    icon = new ImageIcon("face/6-diamond.jpg");
	                } else if (suit.equals("heart")) {
	                    icon = new ImageIcon("face/6-heart.jpg");
	                } else if (suit.equals("spade")) {
	                    icon = new ImageIcon("face/6-spade.jpg");
	                }
	                break;
	            case 7:
	                if (suit.equals("club")) {
	                    icon = new ImageIcon("face/7-club.jpg");
	                } else if (suit.equals("diamond")) {
	                    icon = new ImageIcon("face/7-diamond.jpg");
	                } else if (suit.equals("heart")) {
	                    icon = new ImageIcon("face/7-heart.jpg");
	                } else if (suit.equals("spade")) {
	                    icon = new ImageIcon("face/7-spade.jpg");
	                }
	                break;
	            case 8:
	                if (suit.equals("club")) {
	                    icon = new ImageIcon("face/8-club.jpg");
	                } else if (suit.equals("diamond")) {
	                    icon = new ImageIcon("face/8-diamond.jpg");
	                } else if (suit.equals("heart")) {
	                    icon = new ImageIcon("face/8-heart.jpg");
	                } else if (suit.equals("spade")) {
	                    icon = new ImageIcon("face/8-spade.jpg");
	                }
	                break;
	            case 9:
	                if (suit.equals("club")) {
	                    icon = new ImageIcon("face/9-club.jpg");
	                } else if (suit.equals("diamond")) {
	                    icon = new ImageIcon("face/9-diamond.jpg");
	                } else if (suit.equals("heart")) {
	                    icon = new ImageIcon("face/9-heart.jpg");
	                } else if (suit.equals("spade")) {
	                    icon = new ImageIcon("face/9-spade.jpg");
	                }
	                break;
	            case 10:
	                if (suit.equals("club")) {
	                    icon = new ImageIcon("face/10-club.jpg");
	                } else if (suit.equals("diamond")) {
	                    icon = new ImageIcon("face/10-diamond.jpg");
	                } else if (suit.equals("heart")) {
	                    icon = new ImageIcon("face/10-heart.jpg");
	                } else if (suit.equals("spade")) {
	                    icon = new ImageIcon("face/10-spade.jpg");
	                }
	                break;
	            case 11:
	                if (suit.equals("club")) {
	                    icon = new ImageIcon("face/J-club.jpg");
	                } else if (suit.equals("diamond")) {
	                    icon = new ImageIcon("face/J-diamond.jpg");
	                } else if (suit.equals("heart")) {
	                    icon = new ImageIcon("face/J-heart.jpg");
	                } else if (suit.equals("spade")) {
	                    icon = new ImageIcon("face/J-spade.jpg");
	                }
	                break;
	            case 12:
	                if (suit.equals("club")) {
	                    icon = new ImageIcon("face/Q-club.jpg");
	                } else if (suit.equals("diamond")) {
	                    icon = new ImageIcon("face/Q-diamond.jpg");
	                } else if (suit.equals("heart")) {
	                    icon = new ImageIcon("face/Q-heart.jpg");
	                } else if (suit.equals("spade")) {
	                    icon = new ImageIcon("face/Q-spade.jpg");
	                }
	                break;
	            case 13:
	                if (suit.equals("club")) {
	                    icon = new ImageIcon("face/K-club.jpg");
	                } else if (suit.equals("diamond")) {
	                    icon = new ImageIcon("face/K-diamond.jpg");
	                } else if (suit.equals("heart")) {
	                    icon = new ImageIcon("face/K-heart.jpg");
	                } else if (suit.equals("spade")) {
	                    icon = new ImageIcon("face/K-spade.jpg");
	                }
	                break;
	        }
        }
    }
    //return the icon of the card

    public ImageIcon getIcon() {
        return icon;
    }
    // return whether the card face up or not

    public boolean isFaceUp() {
        return faceUp;
    }
    // set is face up
    public void setIsFaceUp(){
    	faceUp = !faceUp;
    }
    // flip the card

    public void flip() {
        faceUp = !faceUp;
    }
    // return the card's value

    public int value() {
        switch (cardValue) {
            case 1:
                return 11;
            case 11:
            case 12:
            case 13:
                return 10;
            default:
                return cardValue;
        }
    }
}