package com.games.tic_tac_toe.v1;

import java.util.List;

public class HorizontalWinningStrategy implements WinningStrategy{
    @Override
    public boolean validate(Board board, Move currentMove) {
       List<Cell> cells =  board.getGrid().get(currentMove.getCell().getRow());
       for (Cell cell : cells) {
           if(cell.getStatus().equals(CellStatus.EMPTY)) return false;
           if(cell.getSymbol()!=currentMove.getMovedBy().getSymbol().getSymbol()){
               return false;
           }
       }
        return true;
    }
}
