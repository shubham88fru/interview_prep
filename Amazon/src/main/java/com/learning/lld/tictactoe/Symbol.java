package com.learning.lld.tictactoe;

public enum Symbol {
    X("X"), O("O"), DASH("-");

    public final String symbol;
    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

}
