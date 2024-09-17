package com.tic_tac_toe.v1;

public interface WinningStrategy {
   public boolean validate(Board board, Move currentMove);
}
