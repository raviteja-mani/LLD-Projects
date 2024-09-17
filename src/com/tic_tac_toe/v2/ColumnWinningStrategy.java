package com.tic_tac_toe.v2;

import java.util.List;

public class ColumnWinningStrategy implements WinningStrategy{

    private List<PlayerCount> playerColCounts;
    public ColumnWinningStrategy() {
        playerColCounts = List.of(new PlayerCount(),new PlayerCount(),new PlayerCount());
    }
    @Override
    public boolean checkWinner(int playerNo,Cell cell) {
        int x = cell.getCol();
        if(playerNo ==1){
            playerColCounts.get(x).incrementPlayer1Count();
            return playerColCounts.get(x).getPlayer1Count() == 3;
        }
        else if(playerNo ==2){
            playerColCounts.get(x).incrementPlayer2Count();
            return playerColCounts.get(x).getPlayer2Count() == 3;
        }
        return false;
    }
//    public void updatePlayerCount(int playerNo,int x){
//        if(playerNo == 1) playerColCounts.get(x).incrementPlayer1Count();
//        else if(playerNo == 2) playerColCounts.get(x).incrementPlayer2Count();
//    }
}
