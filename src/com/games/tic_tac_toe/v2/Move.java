package com.games.tic_tac_toe.v2;

public class Move {
    private Cell cell;
    private Player movedBy;
    public Move(Cell cell, Player movedBy) {
        this.cell = cell;
        this.movedBy = movedBy;
    }
}
