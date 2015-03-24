//*****************************************************************************
//  DeskPanel.java       Author: Ye Xia (ID: 121866)
//  C SC152 - Assignment #5 - Problem #1
//  Represents a panel which creates the panels, buttons and labels. 
//*****************************************************************************
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class DeskPanel extends JPanel {
    // declare variables

    private JLabel dealerLabel, playerLabel;
    private JLabel card01, card02, card03, card04, card05;
    private JLabel card11, card12, card13, card14, card15;
    private JLabel cardRemain;
    private JLabel dealerSize, playerSize;
    private JLabel dealerValue, playerValue;
    private JLabel playerMoney, currentBet, playerMoney1;
    private JLabel resultLabel;
    private JPanel dealerPanel, playerPanel, resultPanel, controlPanel, betPanel;
    private JButton hit, stand, nextRound, newGame, exit;
    private JButton bet1, bet5, bet25, bet100, doubleBet, deal, newBet, newGame1, betAll;
    private ButtonListener listener;
    private BetListener listener1;
    private BlackJackHand dealer, player;
    private DeskOfCards desk;
    private Font font;
    private ImageIcon icon;
    private int bet, dealCount;
    private NumberFormat fmt;
    //-----------------------------------------------------------------
    //  Constructor: Sets up the panel
    //-----------------------------------------------------------------

    public DeskPanel() {
        bet = 0;
        dealCount = 0;
        fmt = NumberFormat.getCurrencyInstance();
        font = new Font("Comic Sans MS", Font.BOLD, 15);
        dealer = new BlackJackHand();
        player = new BlackJackHand();
        dealerPanel = new JPanel();
        dealerPanel.setPreferredSize(new Dimension(800, 200));
        dealerPanel.setBackground(Color.green);
        playerPanel = new JPanel();
        playerPanel.setPreferredSize(new Dimension(800, 200));
        playerPanel.setBackground(Color.green);
        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(800, 100));
        controlPanel.setBackground(Color.green);
        resultPanel = new JPanel();
        resultPanel.setPreferredSize(new Dimension(800, 100));
        resultPanel.setBackground(Color.green);
        betPanel = new JPanel();;
        betPanel.setPreferredSize(new Dimension(800, 100));;
        betPanel.setBackground(Color.green);;
        playerMoney1 = new JLabel("money: " + fmt.format(player.getMoney()));
        playerMoney1.setFont(font);
        createDesk();
        createDealer();
        createPlayer();
        cardRemain = new JLabel("Cards remain: " + desk.cardsLeft());
        cardRemain.setFont(font);
        currentBet = new JLabel("current bet: " + fmt.format(bet));
        currentBet.setFont(font);
        createBetButton();
        createControlButton();
        resultLabel = new JLabel("-----------------");
        resultLabel.setFont(font);
        add();
        setBackground(Color.green);
        setPreferredSize(new Dimension(800, 800));
    }
    // create a desk

    public void createDesk() {
        desk = new DeskOfCards();
    }
    // create a dealer

    public void createDealer() {
        dealerLabel = new JLabel("Dealer: ");
        dealerLabel.setFont(font);
        icon = dealer.addCard(desk.dealDown());
        card01 = new JLabel("", icon, SwingConstants.CENTER);
        icon = dealer.addCard(desk.deal());
        card02 = new JLabel("", icon, SwingConstants.CENTER);
        card03 = new JLabel("");
        card04 = new JLabel("");
        card05 = new JLabel("");
        dealerSize = new JLabel("size: " + dealer.size());
        dealerSize.setFont(font);
        dealerValue = new JLabel("total value: " + dealer.value());
        dealerValue.setFont(font);
    }
    // create a player

    public void createPlayer() {
        playerLabel = new JLabel("Player: ");
        playerLabel.setFont(font);
        icon = player.addCard(desk.deal());
        card11 = new JLabel("", icon, SwingConstants.CENTER);
        icon = player.addCard(desk.deal());
        card12 = new JLabel("", icon, SwingConstants.CENTER);
        card13 = new JLabel("");
        card14 = new JLabel("");
        card15 = new JLabel("");
        playerSize = new JLabel("size: " + player.size());
        playerSize.setFont(font);
        playerValue = new JLabel("total value: " + player.value());
        playerValue.setFont(font);
        playerMoney = new JLabel("money: " + fmt.format(player.getMoney()));
        playerMoney.setFont(font);
    }
    // create control buttons

    public void createControlButton() {
        listener = new ButtonListener();
        hit = new JButton("Hit!");
        hit.setFont(font);
        hit.addActionListener(listener);
        stand = new JButton("Stand!");
        stand.setFont(font);
        stand.addActionListener(listener);
        nextRound = new JButton("Next Round");
        nextRound.setFont(font);
        nextRound.addActionListener(listener);
        newGame = new JButton("New Game");
        newGame.setFont(font);
        newGame.addActionListener(listener);
    }
    // create bet buttons

    public void createBetButton() {
        listener1 = new BetListener();
        deal = new JButton("Deal");
        deal.setFont(font);
        deal.addActionListener(listener1);
        bet1 = new JButton("Add Bet 1");
        bet1.setFont(font);
        bet1.addActionListener(listener1);
        bet5 = new JButton("Add Bet 5");
        bet5.setFont(font);
        bet5.addActionListener(listener1);
        bet25 = new JButton("Add Bet 25");
        bet25.setFont(font);
        bet25.addActionListener(listener1);
        bet100 = new JButton("Add Bet 100");
        bet100.setFont(font);
        bet100.addActionListener(listener1);
        doubleBet = new JButton("Double Bet");
        doubleBet.setFont(font);
        doubleBet.addActionListener(listener1);
        newBet = new JButton("set Bet to 0");
        newBet.setFont(font);
        newBet.addActionListener(listener1);
        newGame1 = new JButton("New Game");
        newGame1.setFont(font);
        newGame1.addActionListener(listener1);
        exit = new JButton("Exit");
        exit.setFont(font);
        exit.addActionListener(listener1);
        betAll = new JButton("Bet All!");
        betAll.setFont(font);
        betAll.addActionListener(listener1);
    }
    // add the panels, buttons, labels

    public void add() {
        dealerPanel.add(dealerLabel);
        dealerPanel.add(card01);
        dealerPanel.add(card02);
        dealerPanel.add(card03);
        dealerPanel.add(card04);
        dealerPanel.add(card05);
        dealerPanel.add(dealerSize);
        dealerPanel.add(dealerValue);
        this.add(dealerPanel);
        dealerPanel.setVisible(false);
        playerPanel.add(playerLabel);
        playerPanel.add(card11);
        playerPanel.add(card12);
        playerPanel.add(card13);
        playerPanel.add(card14);
        playerPanel.add(card15);
        playerPanel.add(playerSize);
        playerPanel.add(playerValue);
        this.add(playerPanel);
        playerPanel.setVisible(false);
        resultPanel.add(playerMoney);
        resultPanel.add(resultLabel);
        this.add(resultPanel);
        resultPanel.setVisible(false);
        controlPanel.add(hit);
        controlPanel.add(stand);
        controlPanel.add(nextRound);
        controlPanel.add(newGame);
        controlPanel.add(cardRemain);
        this.add(controlPanel);
        controlPanel.setVisible(false);
        betPanel.setLayout(new GridLayout(3,5));
        betPanel.add(deal);
        betPanel.add(bet1);
        betPanel.add(bet5);
        betPanel.add(bet25);
        betPanel.add(bet100);
        betPanel.add(doubleBet);
        betPanel.add(betAll);
        betPanel.add(newBet);
        betPanel.add(newGame1);
        betPanel.add(currentBet);
        betPanel.add(playerMoney1);
        betPanel.add(exit);
        this.add(betPanel);
    }
    // show the bet panel, and hide the other panels while the bet step

    public void addBetPanel() {
        controlPanel.setVisible(false);
        dealerPanel.setVisible(false);
        playerPanel.setVisible(false);
        resultPanel.setVisible(false);
        //betPanel.setVisible(true);
        newBet.setEnabled(true);
        deal.setEnabled(true);
        newGame1.setEnabled(true);
        player.setMoney((-bet));
        playerMoney1.setText("money: " + fmt.format(player.getMoney()));
    }
    // show the other panels, and hide the bet panel while the game start

    public void addControlPanel() {
        //betPanel.setVisible(false);
        newBet.setEnabled(false);
        deal.setEnabled(false);
        newGame1.setEnabled(false);
        playerPanel.setVisible(true);
        dealerPanel.setVisible(true);
        resultPanel.setVisible(true);
        controlPanel.setVisible(true);
        nextRound.setEnabled(false);
        newGame.setEnabled(false);
        hit.setEnabled(true);
        stand.setEnabled(true);
    }
    // reset everything while the new game button is clicked

    public void newInit() {
        dealCount = 0;
        resultLabel.setText("------------");
        cardRemain.setText("Cards remain: " + desk.cardsLeft());
        initDesk();
        initDealer();
        newPlayer();
        hit.setEnabled(true);
        stand.setEnabled(true);
        isBlackjack();
    }
    // reset everything of player

    public void newPlayer() {
        player.init();
        icon = player.addCard(desk.deal());
        card11.setIcon(icon);
        icon = player.addCard(desk.deal());
        card12.setIcon(icon);
        card13.setIcon(null);
        card14.setIcon(null);
        card15.setIcon(null);
        playerSize.setText("size: " + player.size());
        playerValue.setText("total value: " + player.value());
        playerMoney.setText("money: " + fmt.format(player.getMoney()));
    }
    // reset every thing except for player's money and bet

    public void init() {
        resultLabel.setText("------------");
        cardRemain.setText("Cards remain: " + desk.cardsLeft());
        initDesk();
        initDealer();
        initPlayer();
        hit.setEnabled(true);
        stand.setEnabled(true);
        isBlackjack();
    }
    // initialize the desk

    public void initDesk() {
        desk.setSize();
        //desk.create();
        desk.shuffle();
    }
    // initialize the dealer

    public void initDealer() {
        dealer.initNext();
        icon = dealer.addCard(desk.dealDown());
        card01.setIcon(icon);
        icon = dealer.addCard(desk.deal());
        card02.setIcon(icon);
        card03.setIcon(null);
        card04.setIcon(null);
        card05.setIcon(null);
        dealerSize.setText("size: " + dealer.size());
        dealerValue.setText("total value: " + dealer.value());
    }
    // initialize teh player

    public void initPlayer() {
        player.initNext();
        icon = player.addCard(desk.deal());
        card11.setIcon(icon);
        icon = player.addCard(desk.deal());
        card12.setIcon(icon);
        card13.setIcon(null);
        card14.setIcon(null);
        card15.setIcon(null);
        playerSize.setText("size: " + player.size());
        playerValue.setText("total value: " + player.value());
        playerMoney.setText("money: " + fmt.format(player.getMoney()));
    }
    // check if the player or the dealer gets a blackjack

    public void isBlackjack() {
        if (dealer.isBlackjack()) {
            setButtonEnabled();
            dealer.flip();
            dealer.getCard(0).setIcon();
            icon = dealer.getCard(0).getIcon();
            card01.setIcon(icon);
            resultLabel.setText("Dealer got the Blackjack! Dealer won!");
            dealerValue.setText("total value: " + dealer.value());
            playerMoney.setText("money: " + fmt.format(player.getMoney()));
			nextRound.setEnabled(true);
			newGame.setEnabled(true);
        } else if (player.isBlackjack()) {
            setButtonEnabled();
            resultLabel.setText("Player got the Blackjack! Player won!");
            player.setMoney((2 * bet));
            playerMoney.setText("money: " + fmt.format(player.getMoney()));
			nextRound.setEnabled(true);
			newGame.setEnabled(true);
        }
    }
    // double the bet

    public void doubleBet() {
        bet *= 2;
        player.setMoney(-bet);
    }
    // set a new bet

    public void setNewBet() {
        bet = 0;
    }
    // set buttons to be disabled

    public void setButtonEnabled() {
        hit.setEnabled(false);
        stand.setEnabled(false);
    }
    //-----------------------------------------------------------------------
    // a private class for listening to the buttons
    //-----------------------------------------------------------------------

    private class ButtonListener implements ActionListener {
        // decided to do which action perform by which button is clicked

        public void actionPerformed(ActionEvent event) {
            // while the hit is clicked
            if (event.getSource() == hit) {
                if (player.size() == 5) {
                    JOptionPane.showMessageDialog(null, "You have had 5"
                            + " cards.");
                } else {
                    playerHit();
                    if (player.value() > 21) {
                        playerBust();
                    }
                }
            }// while the stand is clicked
            else if (event.getSource() == stand) {
                setButtonEnabled();
                if (player.value() <= 21) {
                    playerStand();
                }
            } // while the new game is clicked
            else if (event.getSource() == newGame) {
                newInit();
                bet = 0;
                currentBet.setText("current bet: " + fmt.format(bet));
                addBetPanel();
            } // while the next round is clicked
            else if (event.getSource() == nextRound) {
                addBetPanel();
            }
        }

        // while the player hit
        public void playerHit() {
            icon = player.addCard(desk.deal());
            cardRemain.setText("Cards remain: " + desk.cardsLeft());
            switch (player.size()) {
                case 3:
                    card13.setIcon(icon);
                    break;
                case 4:
                    card14.setIcon(icon);
                    break;
                case 5:
                    card15.setIcon(icon);
            }
            playerSize.setText("size: " + player.size());
            playerValue.setText("total value: " + player.value());
        }
        // while the player bust

        public void playerBust() {
            resultLabel.setText("Player Bust!");
            playerMoney.setText("money: " + fmt.format(player.getMoney()));
            setButtonEnabled();
            nextRound.setEnabled(true);
			newGame.setEnabled(true);
        }
        // while the player stand

        public void playerStand() {
            dealer.flip();
            dealer.getCard(0).setIcon();
            icon = dealer.getCard(0).getIcon();
            card01.setIcon(icon);
            cardRemain.setText("Cards remain: " + desk.cardsLeft());
            dealerSize.setText("size: " + dealer.size());
            dealerValue.setText("total value: " + dealer.value());

            if (dealer.value() <= 16) {
                icon = dealer.addCard(desk.deal());
                card03.setIcon(icon);
                cardRemain.setText("Cards remain: " + desk.cardsLeft());
                dealerSize.setText("size: " + dealer.size());
                dealerValue.setText("total value: " + dealer.value());
            }
            if (dealer.value() <= 16) {
                icon = dealer.addCard(desk.deal());
                card04.setIcon(icon);
                cardRemain.setText("Cards remain: " + desk.cardsLeft());
                dealerSize.setText("size: " + dealer.size());
                dealerValue.setText("total value: " + dealer.value());
                if (dealer.value() <= 16) {
                    icon = dealer.addCard(desk.deal());
                    card05.setIcon(icon);
                    cardRemain.setText("Cards remain: " + desk.cardsLeft());
                    dealerSize.setText("size: " + dealer.size());
                    dealerValue.setText("total value: " + dealer.value());
                }
            }
            if (dealer.value() > 21) {
                resultLabel.setText("Dealer Bust!");
                player.setMoney((bet * 2));
                playerMoney.setText("money: " + fmt.format(player.getMoney()));
                nextRound.setEnabled(true);
				newGame.setEnabled(true);
            } else if (player.value() < 21 && dealer.value() < 21) {
                switch (dealer.compareTo(player)) {
                    case -1:
                        resultLabel.setText("Player's value is bigger"
                                + " than Dealer's. Player won!");
                        player.setMoney((2 * bet));
                        playerMoney.setText("money: " + fmt.format(player.getMoney()));
                        break;
                    case 0:
                        resultLabel.setText("Player's value equals to"
                                + " Dealer's. Push!");
                        player.setMoney(bet);
                        playerMoney.setText("money: " + fmt.format(player.getMoney()));
                        break;
                    case 1:
                        resultLabel.setText("Dealer's value is bigger"
                                + " than Dealer's. Dealer won!");
                        playerMoney.setText("money: " + fmt.format(player.getMoney()));
                        break;
                }
                nextRound.setEnabled(true);
				newGame.setEnabled(true);
            } else if (player.value() == 21) {
                resultLabel.setText("Player's value is 21"
                        + ". Player won!");
                player.setMoney((2 * bet));
                playerMoney.setText("money: " + fmt.format(player.getMoney()));
                nextRound.setEnabled(true);
				newGame.setEnabled(true);
            } else if (dealer.value() == 21) {
                resultLabel.setText("Dealer's value is 21"
                        + ". Dealer won!");
                playerMoney.setText("money: " + fmt.format(player.getMoney()));
                nextRound.setEnabled(true);
				newGame.setEnabled(true);
            }
        }
    }
    //-----------------------------------------------------------------------
    // a private class for listening to the buttons
    //-----------------------------------------------------------------------

    private class BetListener implements ActionListener {
        // decided to do which action perform by which button is clicked

        public void actionPerformed(ActionEvent event) {
            // while the deal is clicked
            if (event.getSource() == deal) {
                if (player.getMoney() < 0) {
                    JOptionPane.showMessageDialog(null, "You don't have any"
                            + " money. Please start a new game.");
                } else if (bet == 0) {
                    JOptionPane.showMessageDialog(null, "You don't bet any"
                            + " money. Please reset the bet.");
                } else {
                    addControlPanel();
                    init();
                }
            } // while the add bet 1 is clicked
            else if (event.getSource() == bet1) {
                if (player.getMoney() - 1 < 0) {
                    JOptionPane.showMessageDialog(null, "You don't have any"
                            + " money. Please reset the bet.");
                } else {
                    bet += 1;
                    player.setMoney((-1));
                    currentBet.setText("current bet: " + fmt.format(bet));
                    playerMoney1.setText("money: " + fmt.format(player.getMoney()));
                    playerMoney.setText("money: " + fmt.format(player.getMoney()));
                    dealCount = 0;
                }
            } // while the add bet 5 is clicked
            else if (event.getSource() == bet5) {
                if (player.getMoney() - 5 < 0) {
                    JOptionPane.showMessageDialog(null, "You don't have any"
                            + " money. Please reset the bet.");
                } else {
                    bet += 5;
                    player.setMoney((-5));
                    currentBet.setText("current bet: " + fmt.format(bet));
                    playerMoney1.setText("money: " + fmt.format(player.getMoney()));
                    playerMoney.setText("money: " + fmt.format(player.getMoney()));
                    dealCount = 0;
                }
            } // while the add bet 25 is clicked
            else if (event.getSource() == bet25) {
                if (player.getMoney() - 25 < 0) {
                    JOptionPane.showMessageDialog(null, "You don't have any"
                            + " money. Please reset the bet.");
                } else {
                    bet += 25;
                    player.setMoney((-25));
                    currentBet.setText("current bet: " + fmt.format(bet));
                    playerMoney1.setText("money: " + fmt.format(player.getMoney()));
                    playerMoney.setText("money: " + fmt.format(player.getMoney()));
                    dealCount = 0;
                }
            } // while the add bet 100 is clicked
            else if (event.getSource() == bet100) {
                if (player.getMoney() - 100 < 0) {
                    JOptionPane.showMessageDialog(null, "You don't have any"
                            + " money. Please reset the bet.");
                } else {
                    bet += 100;
                    player.setMoney((-100));
                    currentBet.setText("current bet: " + fmt.format(bet));
                    playerMoney1.setText("money: " + fmt.format(player.getMoney()));
                    playerMoney.setText("money: " + fmt.format(player.getMoney()));
                    dealCount = 0;
                }
            } // while the double bet is clicked
            else if (event.getSource() == doubleBet) {
                if (player.getMoney() - bet * 2 < 0) {
                    JOptionPane.showMessageDialog(null, "You don't have any"
                            + " money. Please reset the bet.");
                } else {
                    player.setMoney((-bet));
                    bet *= 2;
                    currentBet.setText("current bet: " + fmt.format(bet));
                    playerMoney1.setText("money: " + fmt.format(player.getMoney()));
                    playerMoney.setText("money: " + fmt.format(player.getMoney()));
                    dealCount = 0;
                }
            } // while the set bet to 0 is clicked
            else if (event.getSource() == newBet) {
                player.setMoney(bet);
                bet = 0;
                currentBet.setText("current bet: " + fmt.format(bet));
                playerMoney1.setText("money: " + fmt.format(player.getMoney()));
                dealCount = 0;
            } // while the new game is clicked
            else if (event.getSource() == newGame1) {
                newInit();
                bet = 0;
                playerMoney1.setText("money: " + fmt.format(player.getMoney()));
                currentBet.setText("current bet: " + fmt.format(bet));
            } // while the bet all is clicked
            else if (event.getSource() == betAll) {
                bet += player.getMoney();
                player.setMoney((-player.getMoney()));
                currentBet.setText("current bet: " + fmt.format(bet));
                playerMoney1.setText("money: " + fmt.format(player.getMoney()));
                playerMoney.setText("money: " + fmt.format(player.getMoney()));
                dealCount = 0;
            }
            else if (event.getSource() == exit) {
                System.exit(0);
            }
        }
    }
}