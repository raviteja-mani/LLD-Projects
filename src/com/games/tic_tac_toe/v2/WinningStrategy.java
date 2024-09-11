package com.games.tic_tac_toe.v2;

public interface WinningStrategy {
    public boolean checkWinner(int playerNo,Cell cell);
//    public void updatePlayerCount(int playerNo,int x);
}
