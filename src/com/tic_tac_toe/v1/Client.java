package com.tic_tac_toe.v1;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Controller gameController = new Controller();
        gameController.startGame();
        while(!gameController.gameStatus().equals(GameStatus.ENDED)) {
            System.out.println("Enter the x for " +gameController.getCurrentPlayerSymbol());
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            System.out.println("Enter the y for " +gameController.getCurrentPlayerSymbol());
            int y = scanner.nextInt();
            if(gameController.validateMove(x,y)){
                System.out.println("Enter a valid move");
                continue;
            }
            gameController.makeMove(x,y);
            gameController.displayGame();
        }
        if(gameController.gameWinner()==null){
            System.out.println("This game is a draw");
        }
        else{
            System.out.println(gameController.gameWinner().getSymbol().getSymbol()+" wins!");
        }
    }
}
