package com.games.tic_tac_toe.v2;

import java.util.Scanner;

public class Controller {
    private Game game;
    public Controller() {
        this.game = new Game();
    }
    public void startGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe Game!");
        System.out.println("Choose player 1 symbol ");
        String player1 = sc.next().toUpperCase();
        System.out.println("Choose player 2 symbol ");
        String player2 = sc.next().toUpperCase();
//        game.setPlayer1(new Player(new Symbol(player1.charAt(0))));
//        game.setPlayer2(new Player(new Symbol(player2.charAt(0))));
    }

}
