package com.learning.lld.tictactoe;

public class Board {
    private int size;
    private Cell[][] board;
    int totalMoves = 0;

    public Board(int size) {
        this.size = size;
        this.board = new Cell[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public synchronized boolean makeMove(int row, int col, Player player) {
        if (row < 0 || row >= this.size || col < 0 || col >= this.size || board[row][col].symbol != Symbol.DASH) {
            return false;
        }

        board[row][col].symbol = player.getSymbol();
        totalMoves += 1;
        return true;
    }


    public boolean isFull() {
        return totalMoves == size * size;
    }

    public boolean winner(int row, int col, Player player) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for (int i = 0; i < size; i++) {
            if (board[row][i].symbol == Symbol.DASH || board[row][i].symbol != player.getSymbol()) {
                rowMatch = false;
                break;
            }
        }

        for (int i = 0; i < size; i++) {
            if (board[i][col].symbol == Symbol.DASH || board[i][col].symbol != player.getSymbol()) {
                columnMatch = false;
                break;
            }
        }

        for (int i = 0, j = 0; i < size; i++, j++) {
            if (board[i][j].symbol == Symbol.DASH || board[i][j].symbol != player.getSymbol()) {
                diagonalMatch = false;
                break;
            }
        }

        for (int i = 0, j = size - 1; i < size; i++, j--) {
            if (board[i][j].symbol == Symbol.DASH || board[i][j].symbol != player.getSymbol()) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }


    public void print() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col].symbol.getSymbol() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
