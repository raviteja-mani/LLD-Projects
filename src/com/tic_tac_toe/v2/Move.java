package com.tic_tac_toe.v2;

public class Move {
    private Cell cell;
    private Player movedByPlayer;
    public Move(Cell cell, Player movedBy) {
        this.cell = cell;
        this.movedByPlayer = movedBy;
    }
    public Cell getCell() {
        return cell;
    }
    public Player getMovedByPlayer() {
        return movedByPlayer;
    }
}
