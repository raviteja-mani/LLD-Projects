package com.tic_tac_toe.v2;

import java.util.List;

public class RowWinningStrategy implements WinningStrategy{
    private List<PlayerCount> playerRowCounts;
    public RowWinningStrategy() {
        playerRowCounts = List.of(new PlayerCount(),new PlayerCount(),new PlayerCount());
    }
    @Override
    public boolean checkWinner(int playerNo,Cell cell) {
        int x = cell.getRow();
        if(playerNo ==1) {
            playerRowCounts.get(x).incrementPlayer1Count();
            return playerRowCounts.get(x).getPlayer1Count() == 3;
        }
        else if(playerNo ==2) {
            playerRowCounts.get(x).incrementPlayer2Count();
            return playerRowCounts.get(x).getPlayer2Count() == 3;
        }
        return false;
    }
//    public void updatePlayerCount(int playerNo,int x){
//        if(playerNo == 1) playerRowCounts.get(x).incrementPlayer1Count();
//        else if(playerNo == 2) playerRowCounts.get(x).incrementPlayer2Count();
//    }
}
