package com.games.tic_tac_toe.v2;

public class Player {
       private  Symbol symbol;
//        String name;
        public Player(Symbol symbol) {
            this.symbol = symbol;
        }
        public Symbol getSymbol() {
            return symbol;
        }
        public void setSymbol(Symbol symbol) {
            this.symbol = symbol;
        }
}
