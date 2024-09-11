package com.games.tic_tac_toe.v1;


import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Move> moves = new ArrayList<>();
    private int nextplayerIndex = 0;
    private GameStatus status;
    private Player player1;
    private Player player2;
    private Player winner;
    private List<WinningStrategy>  winningStrategies = List.of(new HorizontalWinningStrategy(),new VerticalWinningStrategy(),new DiagonalWinningStrategy());
    public Game(){
        this.board = new Board();
        this.status = GameStatus.IN_PROGRESS;
    }

    public void display(){
        board.display();
    }
    public void makeMove(Move move){
        moves.add(move);
        board.setMove(move);
        checkWinner(move);
    nextplayerIndex++;
    if(nextplayerIndex > (board.getSize()*board.getSize()+1)) {
        if (winner == null) {
            status = GameStatus.ENDED;
        }
    }
    }
    public void checkWinner(Move currentMove){
//        return null;
        for(WinningStrategy strategy : winningStrategies){
            if(strategy.validate(board,currentMove)) {
                status = GameStatus.ENDED;
                winner = nextPlayer();
                break;
            }

        }
    }

    public void setPlayer1(Player player1){
        this.player1 = player1;
    }
    public void setPlayer2(Player player2){
        this.player2 = player2;
    }
    public Player getPlayer1(){
        return player1;
    }
    public Player getPlayer2(){
        return player2;
    }

    public GameStatus getStatus() {
        return status;
    }
    public Player nextPlayer(){
        if(nextplayerIndex%2==0) return player1;
        else return player2;
    }

    public boolean validateMove(int x, int y) {
        if(board.getSize()>=x || board.getSize()>=y) return false;
        return board.isBoardFilled(x,y);
    }

    public Player getWinner() {
        return winner;
    }
}
