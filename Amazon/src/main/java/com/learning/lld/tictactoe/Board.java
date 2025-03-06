package com.learning.lld.tictactoe;

public class Board {
    private int size;
    private Cell[][] board;
    private int totalMoves = 0;
    private int[] rowSum;
    private int[] colSum;
    private int fDiag;
    private int bDiag;

    public Board(int size) {
        this.size = size;
        this.board = new Cell[size][size];
        this.rowSum = new int[size];
        this.colSum = new int[size];
        this.fDiag = 0;
        this.bDiag = 0;
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

        if (row == col) { //optimization - only makes sense to check the diagonal if row == col.
            for (int i = 0, j = 0; i < size; i++, j++) {
                if (board[i][j].symbol == Symbol.DASH || board[i][j].symbol != player.getSymbol()) {
                    diagonalMatch = false;
                    break;
                }
            }
        }

        if (row + col == size-1)
        for (int i = 0, j = size - 1; i < size; i++, j--) {
            if (board[i][j].symbol == Symbol.DASH || board[i][j].symbol != player.getSymbol()) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

    public boolean winnerOptimal(int row, int col, Player player) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for (int i = 0; i < size; i++) {
            if (board[row][i].symbol == Symbol.DASH || board[row][i].symbol != player.getSymbol()) {
                rowMatch = false;
            }

            if (board[i][col].symbol == Symbol.DASH || board[i][col].symbol != player.getSymbol()) {
                columnMatch = false;
            }

            if (board[i][i].symbol == Symbol.DASH || board[i][i].symbol != player.getSymbol()) {
                diagonalMatch = false;
            }

            if (board[i][size-i-1].symbol == Symbol.DASH || board[i][size-i-1].symbol != player.getSymbol()) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

    public boolean winnerO1(int row, int col, Player player) {
        if (player.getSymbol() == Symbol.X) {
            rowSum[row] += 1;
            colSum[col] += 1;
            if (row == col) fDiag += 1;
            if (row == size - col - 1) bDiag += 1;
        } else if (player.getSymbol() == Symbol.O) {
            rowSum[row] -= 1;
            colSum[col] -= 1;
            if (row == col) fDiag -= 1;
            if (row == size - col - 1) bDiag -= 1;
        }

        if (size == Math.abs(rowSum[row]) || size == Math.abs(colSum[col]) || size == Math.abs(fDiag) || size == Math.abs(bDiag)) {
            return true;
        }

        return false;
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
