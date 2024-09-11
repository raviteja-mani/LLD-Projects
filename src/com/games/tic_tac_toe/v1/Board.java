package com.games.tic_tac_toe.v1;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Cell>> grid ;
    final int size =3;
    public Board() {
        grid = new ArrayList<>();
        for(int i = 0; i < size; i++){
           List<Cell> row = new ArrayList<>();
            for(int j = 0; j < size; j++){
                row.add(new Cell(i, j));
            }
            grid.add(row);
        }
    }

    public int getSize() {
        return size;
    }
    public List<List<Cell>> getGrid() {
        return grid;
    }
    public void display(){
        for(int i = 0 ;i<size;i++){
            for(Cell cell: grid.get(i)){
                if(cell.getStatus().equals(CellStatus.EMPTY)){
                    System.out.print(" | "+"  | ");
                }
                else  System.out.print(" | "+cell.getSymbol()+" | ");
            }
            System.out.println();
        }
    }

    public void setMove(Move move) {
       Cell cell =  grid.get(move.getCell().getRow()).get(move.getCell().getCol());
       cell.setStatus(CellStatus.FILLED);
       cell.setPlayer(move.getMovedBy());
    }

    public boolean isBoardFilled(int x, int y) {
        if(grid.get(x).get(y).getStatus() == CellStatus.FILLED){
            return true;
        }
        return false;
    }
}
