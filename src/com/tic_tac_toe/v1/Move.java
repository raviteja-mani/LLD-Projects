package com.tic_tac_toe.v1;


public class Move {
    private Cell cell;
    private Player movedBy;
    public Move(Cell cell, Player movedBy) {
        this.cell = cell;
        this.movedBy = movedBy;
    }
    public Cell getCell() {
        return cell;
    }
    public Player getMovedBy() {
        return movedBy;
    }
}
