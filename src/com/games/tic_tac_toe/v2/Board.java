package com.games.tic_tac_toe.v2;

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
    public  void displayBoard(){
        for(int i = 0 ;i<grid.size();i++){
            for(Cell cell: grid.get(i)){
                System.out.print(" | "+cell.getSymbol()+" | ");
            }
            System.out.println();
        }
    }
}
