package com.games.tic_tac_toe.v2;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Move> moves;
    private GameState state;
    private Player player1;
    private Player player2;
    private Player winner;
    private int nextIndexMove = 0;
    private List<WinningStrategy> winningStrategies;
    private Game(GameBuilder builder){
        this.player1 = builder.getPlayer1();
        this.player2 = builder.getPlayer2();
        this.board = builder.getBoard();
        this.moves = builder.getMoves();
        this.state = builder.getState();
        this.winningStrategies = builder.getWinningStrategies();
    }
    public static GameBuilder builder(){
        return new GameBuilder();
    }
    public void display(){
        board.displayBoard();
    }
    public boolean makeMove(int x,int y){
        if(validateMove(x,y)) {
            Move move = new Move(new Cell(x, y, getNextPlayer()), getNextPlayer());
            moves.add(move);
            if(!board.makeMove(move)) return false;
//            updateStrategies(move.getCell());
            winner = findWinner(move.getCell());
            if(winner!=null || moves.size() == board.getSize()* board.getSize()) state = GameState.ENDED;
            nextIndexMove++;
            return true;
        }
        else return false;
    }
    public Player findWinner(Cell cell){
        int playerNo=0;
        if(cell.getSymbol().equals(player1.getSymbol())) playerNo =1;
        else if(cell.getSymbol().equals(player2.getSymbol())) playerNo =2;
       for(WinningStrategy strategy : winningStrategies){
          if(strategy.checkWinner(playerNo,cell)) {
              if(playerNo==1) return player1;
              else if(playerNo==2) return player2;
          }
       }
       return null;
    }
    public GameState getState(){
        return state;
    }
    public Player getNextPlayer(){
        if(nextIndexMove%2==0) return player1;
        else return player2;
    }
    public Character getNextPlayerCharacter(){
       if(nextIndexMove%2==0) return player1.getSymbol();
       else return player2.getSymbol();
    }

    public Character getWinner() {
        if(winner==null) return null;
        else return winner.getSymbol();
    }

    public boolean validateMove(int x, int y) {
        return x >= 0 && x < board.getSize() && y >= 0 && y < board.getSize() && board.cellState(x, y).equals(CellState.EMPTY);
    }
//    public void updateStrategies(Cell currentCell){
//        int playerNo=0;
//        if(currentCell.getSymbol().equals(player1.getSymbol())) playerNo =1;
//        else if(currentCell.getSymbol().equals(player2.getSymbol())) playerNo =2;
//        for(WinningStrategy strategy :winningStrategies){
//            if(strategy.getClass()==(RowWinningStrategy.class)) strategy.updatePlayerCount(playerNo,currentCell.getRow());
//            else if(strategy.getClass()==(ColumnWinningStrategy.class)) strategy.updatePlayerCount(playerNo,currentCell.getCol());
//        }
//    }
    public static class GameBuilder{
        private Board board;
        private List<Move> moves;
        private GameState state;
        private Player player1;
        private Player player2;
        private List<WinningStrategy> winningStrategies;
        public GameBuilder(){
            board = new Board();
            moves = new ArrayList<>();
            state = GameState.IN_PROGRESS;
            winningStrategies = List.of(new ColumnWinningStrategy(),new DiagonalWinningStrategy(),new RowWinningStrategy());
        }
        public GameBuilder setBoard(Board board){
            this.board = board;
            return this;
        }
//        public GameBuilder setMoves(List<Move> moves){
//            this.moves = moves;
//            return this;
//        }
        public GameBuilder setPlayer1(Player player1){
            this.player1 = player1;
            return this;
        }
        public GameBuilder setPlayer2(Player player2){
            this.player2 = player2;
            return this;
        }
        public Player getPlayer1(){
            return this.player1;
        }
        public Player getPlayer2(){
            return this.player2;
        }
        public Board getBoard(){
            return this.board;
        }
        public List<Move> getMoves(){
            return this.moves;
        }
        public GameState getState(){
            return this.state;
        }
        public Game build(){
            return new Game(this);
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }
    }
}
