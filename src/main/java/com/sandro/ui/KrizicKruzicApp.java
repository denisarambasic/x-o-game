package com.sandro.ui;

import com.sandro.models.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class KrizicKruzicApp {

    private JFrame glavniProzor = new JFrame("Križić Kružić");
    private Player igrac1;
    private Player igrac2;
    private Player currentPlayer;
    private Player winner = null;
    String[] playBoard = new String[9];

    public KrizicKruzicApp() {
        postaviPocetniProzor();
    }

    private void postaviPocetniProzor() {
        //dodaj dimenzije programa
        glavniProzor.setSize(400, 400);
        glavniProzor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel centrirajComponentePanel = new JPanel(new GridBagLayout());
        centrirajComponentePanel.setBackground(Color.BLACK);

        //kreiraj sve komponente
        JPanel leftIgrac1LblPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftIgrac1LblPanel.setBackground(Color.BLACK);
        JLabel igrac1Lbl = new JLabel("Igrač_1:");
        igrac1Lbl.setForeground(Color.WHITE);
        leftIgrac1LblPanel.add(igrac1Lbl);
        JPanel leftIgrac2LblPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftIgrac2LblPanel.setBackground(Color.BLACK);
        JLabel igrac2Lbl = new JLabel("Igrač_2:");
        igrac2Lbl.setForeground(Color.WHITE);
        leftIgrac2LblPanel.add(igrac2Lbl);
        JLabel znak_x = new JLabel(" X");
        znak_x.setForeground(Color.WHITE);
        JLabel znak_o = new JLabel(" O");
        znak_o.setForeground(Color.WHITE);
        JTextField igrac1Txt = new JTextField(20);
        JTextField igrac2Txt = new JTextField(20);
        JPanel pocniIgruPanel = new JPanel(new GridBagLayout());
        pocniIgruPanel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,0,0,0);
        JButton pocniIgru = new JButton("Pokreni igru");
        pocniIgru.setForeground(Color.WHITE);
        pocniIgru.setBackground(Color.RED);
        pocniIgruPanel.add(pocniIgru, gbc);


        //dodaj sve komponente na prozor
        JPanel pocetniZaslon = new JPanel();
        BoxLayout boxLayout = new BoxLayout(pocetniZaslon, BoxLayout.Y_AXIS);
        pocetniZaslon.setLayout(boxLayout);
        pocetniZaslon.setBackground(Color.BLACK);


        //flow layout 1
        JPanel panelRedak1 = new JPanel();
        BoxLayout redakLayout1 = new BoxLayout(panelRedak1, BoxLayout.X_AXIS);
        panelRedak1.setBackground(Color.BLACK);
        panelRedak1.setLayout(redakLayout1);
        panelRedak1.add(igrac1Txt);
        panelRedak1.add(znak_x);


        //flow layout 2
        JPanel panelRedak2 = new JPanel();
        BoxLayout redakLayout2 = new BoxLayout(panelRedak2, BoxLayout.X_AXIS);
        panelRedak2.setBackground(Color.BLACK);
        panelRedak2.setLayout(redakLayout2);
        panelRedak2.add(igrac2Txt);
        panelRedak2.add(znak_o);
        //panelRedak2.setMaximumSize( panelRedak2.getPreferredSize() );

        pocetniZaslon.add(leftIgrac1LblPanel);
        pocetniZaslon.add(panelRedak1);

        pocetniZaslon.add(leftIgrac2LblPanel);
        pocetniZaslon.add(panelRedak2);

        pocetniZaslon.add(pocniIgruPanel);
        centrirajComponentePanel.add(pocetniZaslon);

        //glavniProzor.add(centrirajComponentePanel);
        glavniProzor.setContentPane(centrirajComponentePanel);

        glavniProzor.setVisible(true);
        glavniProzor.revalidate();
        //osluškuj btn
        pocniIgru.addActionListener((ae) -> {
            igrac1 = new Player(igrac1Txt.getText(), "X", true);
            currentPlayer = igrac1;
            igrac1Txt.setText("");
            igrac2 = new Player(igrac2Txt.getText(), "O", false);
            igrac2Txt.setText("");
            getGameBoard();
        });
    }

    private void getGameBoard() {
        JPanel mainBoard = new JPanel();
        BoxLayout gameBoardLayout = new BoxLayout(mainBoard, BoxLayout.Y_AXIS);
        mainBoard.setLayout(gameBoardLayout);
        //JPanel row1 = new JPanel(new FlowLayout());
        JPanel centerPlayerNames = new JPanel(new GridBagLayout());
        JPanel playerNamesInRows = new JPanel();
        BoxLayout playerNamesInRowBoxL = new BoxLayout(playerNamesInRows, BoxLayout.Y_AXIS);
        playerNamesInRows.setLayout(playerNamesInRowBoxL);
        playerNamesInRows.setBackground(Color.BLACK);
        JLabel igrac1GameLbl = new JLabel(getFirstNameCurrent(igrac1));
        JLabel igrac2GameLbl = new JLabel(getFirstNameCurrent(igrac2));
        //setActivePlayers();
        igrac1GameLbl.setFont(new Font("Arial", Font.PLAIN, 20));
        igrac2GameLbl.setFont(new Font("Arial", Font.PLAIN, 20));
        igrac1GameLbl.setForeground(Color.WHITE);
        igrac2GameLbl.setForeground(Color.WHITE);
        playerNamesInRows.add(igrac1GameLbl);
        playerNamesInRows.add(igrac2GameLbl);
        centerPlayerNames.add(playerNamesInRows);

        centerPlayerNames.setBackground(Color.BLACK);
        JPanel row2 = new JPanel();
        row2.setPreferredSize(new Dimension(400, 250));
        row2.setBackground(Color.BLACK);

        JPanel playerBoardFields = new JPanel(new GridLayout(3,3));
        playerBoardFields.setPreferredSize(new Dimension(240, 240));
        JButton btn1 = new JButton("");
        btn1.setFont(new Font("Arial", Font.PLAIN, 40));
        JButton btn2 = new JButton("");
        btn2.setFont(new Font("Arial", Font.PLAIN, 40));
        JButton btn3 = new JButton("");
        btn3.setFont(new Font("Arial", Font.PLAIN, 40));
        JButton btn4 = new JButton("");
        btn4.setFont(new Font("Arial", Font.PLAIN, 40));
        JButton btn5 = new JButton("");
        btn5.setFont(new Font("Arial", Font.PLAIN, 40));
        JButton btn6 = new JButton("");
        btn6.setFont(new Font("Arial", Font.PLAIN, 40));
        JButton btn7 = new JButton("");
        btn7.setFont(new Font("Arial", Font.PLAIN, 40));
        JButton btn8 = new JButton("");
        btn8.setFont(new Font("Arial", Font.PLAIN, 40));
        JButton btn9 = new JButton("");
        btn9.setFont(new Font("Arial", Font.PLAIN, 40));
        playerBoardFields.add(btn1);
        playerBoardFields.add(btn2);
        playerBoardFields.add(btn3);
        playerBoardFields.add(btn4);
        playerBoardFields.add(btn5);
        playerBoardFields.add(btn6);
        playerBoardFields.add(btn7);
        playerBoardFields.add(btn8);
        playerBoardFields.add(btn9);
        //tempPanel.add(playerBoardFields);
        //playerBoard.add(tempPanel);
        row2.add(playerBoardFields);

        btn1.addActionListener((ae) -> {
            if (ae.getActionCommand().equals("")){
                btn1.setText(currentPlayer.getSign());
                setSignInPlayBoardAndCheckGameStatus(0, currentPlayer);
                changeCurrentPlayer();
                igrac1GameLbl.setText(getFirstNameCurrent(igrac1));
                igrac2GameLbl.setText(getFirstNameCurrent(igrac2));
            }
        });
        btn2.addActionListener((ae) -> {
            if (ae.getActionCommand().equals("")){
                btn2.setText(currentPlayer.getSign());
                setSignInPlayBoardAndCheckGameStatus(1, currentPlayer);
                changeCurrentPlayer();
                igrac1GameLbl.setText(getFirstNameCurrent(igrac1));
                igrac2GameLbl.setText(getFirstNameCurrent(igrac2));
            }
        });
        btn3.addActionListener((ae) -> {
            if (ae.getActionCommand().equals("")){
                btn3.setText(currentPlayer.getSign());
                setSignInPlayBoardAndCheckGameStatus(2, currentPlayer);
                changeCurrentPlayer();
                igrac1GameLbl.setText(getFirstNameCurrent(igrac1));
                igrac2GameLbl.setText(getFirstNameCurrent(igrac2));
            }
        });
        btn4.addActionListener((ae) -> {
            if (ae.getActionCommand().equals("")){
                btn4.setText(currentPlayer.getSign());
                setSignInPlayBoardAndCheckGameStatus(3, currentPlayer);
                changeCurrentPlayer();
                igrac1GameLbl.setText(getFirstNameCurrent(igrac1));
                igrac2GameLbl.setText(getFirstNameCurrent(igrac2));
            }
        });
        btn5.addActionListener((ae) -> {
            if (ae.getActionCommand().equals("")){
                btn5.setText(currentPlayer.getSign());
                setSignInPlayBoardAndCheckGameStatus(4, currentPlayer);
                changeCurrentPlayer();
                igrac1GameLbl.setText(getFirstNameCurrent(igrac1));
                igrac2GameLbl.setText(getFirstNameCurrent(igrac2));
            }
        });
        btn6.addActionListener((ae) -> {
            if (ae.getActionCommand().equals("")){
                btn6.setText(currentPlayer.getSign());
                setSignInPlayBoardAndCheckGameStatus(5, currentPlayer);
                changeCurrentPlayer();
                igrac1GameLbl.setText(getFirstNameCurrent(igrac1));
                igrac2GameLbl.setText(getFirstNameCurrent(igrac2));
            }
        });
        btn7.addActionListener((ae) -> {
            if (ae.getActionCommand().equals("")){
                btn7.setText(currentPlayer.getSign());
                setSignInPlayBoardAndCheckGameStatus(6, currentPlayer);
                changeCurrentPlayer();
                igrac1GameLbl.setText(getFirstNameCurrent(igrac1));
                igrac2GameLbl.setText(getFirstNameCurrent(igrac2));
            }
        });
        btn8.addActionListener((ae) -> {
            if (ae.getActionCommand().equals("")){
                btn8.setText(currentPlayer.getSign());
                setSignInPlayBoardAndCheckGameStatus(7, currentPlayer);
                changeCurrentPlayer();
                igrac1GameLbl.setText(getFirstNameCurrent(igrac1));
                igrac2GameLbl.setText(getFirstNameCurrent(igrac2));
            }
        });
        btn9.addActionListener((ae) -> {
            if (ae.getActionCommand().equals("")){
                btn9.setText(currentPlayer.getSign());
                setSignInPlayBoardAndCheckGameStatus(8, currentPlayer);
                changeCurrentPlayer();
                igrac1GameLbl.setText(getFirstNameCurrent(igrac1));
                igrac2GameLbl.setText(getFirstNameCurrent(igrac2));
            }
        });

        mainBoard.add(centerPlayerNames);
        mainBoard.add(row2);
        glavniProzor.setContentPane(mainBoard);
        glavniProzor.revalidate();
    }

    private void setSignInPlayBoardAndCheckGameStatus(int position, Player currentPlayer) {
        playBoard[position] = currentPlayer.getSign();
        //check if you won the game
        checkWiningCombination(currentPlayer);
        //check if the game is done
        checkGameIsOver();

    }

    private void checkGameIsOver() {
        boolean statusIsInPlay = true;
        for (int i = 0; i < 9; i++) {
            if (playBoard[i] == null)
                break;
            if (i == 8 && playBoard[i] != null)
                statusIsInPlay = false;
        }

        if (!statusIsInPlay)
            gameOver();

    }

    private void checkWiningCombination(Player currentPlayer) {
        String sign = currentPlayer.getSign();
        boolean won = false;

        if ((playBoard[0] == sign && playBoard[1] == sign && playBoard[2] == sign) ||
            (playBoard[3] == sign && playBoard[4] == sign && playBoard[5] == sign) ||
            (playBoard[6] == sign && playBoard[7] == sign && playBoard[8] == sign) ||
            (playBoard[0] == sign && playBoard[3] == sign && playBoard[6] == sign) ||
            (playBoard[1] == sign && playBoard[4] == sign && playBoard[7] == sign) ||
            (playBoard[2] == sign && playBoard[5] == sign && playBoard[8] == sign) ||
            (playBoard[0] == sign && playBoard[4] == sign && playBoard[8] == sign) ||
            (playBoard[2] == sign && playBoard[4] == sign && playBoard[6] == sign)
        ){
            winner = currentPlayer;
            gameOver();
        }
    }

    private String getFirstNameCurrent(Player igrac1) {
        return currentPlayer.getName().equals(igrac1.getName()) ?
                igrac1.getSign() + " " + igrac1.getName() + " [*]" :
                igrac1.getSign() + " " + igrac1.getName();
    }

    public void changeCurrentPlayer() {
        currentPlayer = currentPlayer.getName().equals(igrac1.getName()) ? igrac2 : igrac1;
    }

    public void gameOver() {
        JPanel gameOverPanel = new JPanel(new GridBagLayout());
        gameOverPanel.setBackground(Color.BLACK);
        JPanel centerBox = new JPanel();
        BoxLayout boxCenterLayout = new BoxLayout(centerBox, BoxLayout.Y_AXIS);
        centerBox.setLayout(boxCenterLayout);
        centerBox.setBackground(Color.BLACK);
        //Components label and button
        String message = "";
        if (winner == null)
            message = "Nobdy wins play again.";
        else
            message = winner.getName() + " has won the game!";
        //set winner again to null
        winner = null;

        JLabel messageLbl = new JLabel(message);
        messageLbl.setForeground(Color.WHITE);
        messageLbl.setFont(new Font("Arial", Font.PLAIN, 20));
        JButton playAgainBtn = new JButton("Play Again");
        playAgainBtn.setForeground(Color.WHITE);
        playAgainBtn.setBackground(Color.RED);

        centerBox.add(messageLbl);
        centerBox.add(playAgainBtn);
        gameOverPanel.add(centerBox);

        glavniProzor.setContentPane(gameOverPanel);
        glavniProzor.revalidate();

        playAgainBtn.addActionListener((ae) -> {
            //reset every property
            igrac1 = null;
            igrac2 = null;
            currentPlayer = null;
            winner = null;
            playBoard = new String[9];
            //start game again so you can enter new players
            glavniProzor.setVisible(false);
            postaviPocetniProzor();
        });
    }
}
