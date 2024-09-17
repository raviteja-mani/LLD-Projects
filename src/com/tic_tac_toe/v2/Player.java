package com.tic_tac_toe.v2;

public class Player {
       private  Symbol symbol;
//        String name;
        public Player(Symbol symbol) {
            this.symbol = symbol;
        }
        public Character getSymbol() {
            return symbol.getSymbol();
        }
        public void setSymbol(Symbol symbol) {
            this.symbol = symbol;
        }
}
