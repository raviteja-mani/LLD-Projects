package com.games.tic_tac_toe.v2;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe Game!");
        System.out.println("Choose player 1 symbol ");
        String p1 = sc.next().toUpperCase();
        String p2 = "";
        while(true) {
            System.out.println("Choose player 2 symbol ");
             p2 = sc.next().toUpperCase();
            if (!p1.equals(p2)) {
               break;
            }
            System.out.println("Symbol is taken try again!");
        }
        Game game = gameController.startGame(p1.charAt(0), p2.charAt(0));
        gameController.displayGame(game);
        while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)){
            Character nextPlayer = gameController.getNextPlayerCharacter(game);
            System.out.println("Please select x for player "+nextPlayer);
            int x = sc.nextInt();
            System.out.println("Please select y for player "+nextPlayer);
            int y = sc.nextInt();
            if(!gameController.makeMove(game,x,y)) {
                System.out.println("Please enter a valid move");
            }
            gameController.displayGame(game);
        }
       Character winner =  gameController.getGameWinner(game);
        if(winner == null){
            System.out.println("Game is a Tie!");
        }
        else System.out.println("player "+winner+" has won!");

    }
}
