package com.tic_tac_toe.v1;

import java.util.List;

public class VerticalWinningStrategy implements WinningStrategy {

    @Override
    public boolean validate(Board board, Move currentMove) {
        List<Cell> cells =  board.getGrid().stream().map(x->x.get(currentMove.getCell().getCol())).toList();
        for (Cell cell : cells) {
            if(cell.getStatus().equals(CellStatus.EMPTY)) return false;
            if(cell.getSymbol()!=currentMove.getMovedBy().getSymbol().getSymbol()){
                return false;
            }
        }
        return true;
    }
    }

