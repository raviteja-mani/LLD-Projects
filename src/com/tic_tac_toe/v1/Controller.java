package com.tic_tac_toe.v1;

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
        game.setPlayer1(new Player(new Symbol(player1.charAt(0))));
        game.setPlayer2(new Player(new Symbol(player2.charAt(0))));
        game.display();
    }

    public GameStatus gameStatus() {
        return game.getStatus();
    }

    public Character getCurrentPlayerSymbol() {
      return game.nextPlayer().getSymbol().getSymbol();
    }

    public void makeMove(int x, int y) {
        game.makeMove(new Move(new Cell(x, y), game.nextPlayer()));
    }

    public void displayGame() {
        game.display();
    }

    public boolean validateMove(int x, int y) {
        return  game.validateMove(x,y);
    }

    public Player gameWinner() {
        return game.getWinner();
    }
}
