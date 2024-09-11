package com.games.tic_tac_toe.v2;

import java.util.List;

public class Game {
    private Board board;
    private List<Move> moves;
    private GameStatus status;
    private Player player1;
    private Player player2;
    public Game(){
        this.board = new Board();
    }

    public void display(){

    }
    public void makeMove(Move move){

    }
    public Player checkWinner(){
        return null;
    }
}
