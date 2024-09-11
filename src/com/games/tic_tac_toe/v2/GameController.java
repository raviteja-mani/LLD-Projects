package com.games.tic_tac_toe.v2;

import java.util.Scanner;

public class GameController {

    public Game startGame(Character p1, Character p2){
        Player player1 = new Player(new Symbol(p1));
        Player player2 = new Player(new Symbol(p2));
        Game game = Game.builder()
                        .setPlayer1(player1)
                        .setPlayer2(player2)
                        .build();
        return game;
    }
    public void displayGame(Game game){
        game.display();
    }
    public GameState getGameState(Game game){
        return game.getState();
    }
    public Character getNextPlayerCharacter(Game game){
        return game.getNextPlayerCharacter();
    }
    public boolean makeMove(Game game,int x,int y){
        return game.makeMove(x,y);
         
    }

    public Character getGameWinner(Game game) {
       return game.getWinner();
    }
    public boolean validateMove(Game game,int x,int y){
        return game.validateMove(x,y);
    }
}
