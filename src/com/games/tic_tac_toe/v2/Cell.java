package com.games.tic_tac_toe.v2;

public class Cell {
    private int row;
    private int col;
    private CellState state = CellState.EMPTY;
    private Player player;
    public Cell(int row, int col, Player nextPlayer){
        this.row = row;
        this.col = col;
        if(nextPlayer != null) state = CellState.FILLED;
        this.player = nextPlayer;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public CellState getState() {
        return state;
    }
    public void setStatus(CellState status) {
        this.state = status;
    }
    public Character getSymbol() {
        if(state == CellState.EMPTY){
            return ' ';
        }
        return player.getSymbol();
    }
}
