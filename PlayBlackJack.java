//*****************************************************************************
//  PlayBlackJack.java       Author: Ye Xia (ID: 121866)
//  C SC152 - Assignment #5 - Problem #1
//  Represents a main class to play 
//*****************************************************************************

import javax.swing.*;

public class PlayBlackJack {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Black Jack!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DeskPanel());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
