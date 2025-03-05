package com.learning.lld.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    int size;
    private Cell[][] board;
    private Player[] players;
    int totalMoves = 0;

    public TicTacToe(int size) {
        this.size = size;
        board = new Cell[size][size];
        players = new Player[2];
        players[0] = new Player(Symbol.X);
        players[1] = new Player(Symbol.O);
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public void startGame() {
        int player = 0;
        Scanner scanner = new Scanner(System.in);
        while (!isFull()) {
            System.out.println("Player " + player + " choose row: ");
            int i = scanner.nextInt();

            System.out.println("Player " + player + " choose column: ");
            int j = scanner.nextInt();

            if (!makeMove(i, j, players[player])) {
                System.out.println("Invalid move, please try again");
                continue;
            }

            printBoard();
            if (winner(i, j, players[player])) {
                break;
            }

            player = 1 - player;
        }

        if (isFull()) {
            System.out.println("Draw");
            return;
        }

        System.out.println("Player " + player + " won");
    }

    public synchronized boolean makeMove(int row, int col, Player player) {
        if (row < 0 || row >= size || col < 0 || col >= size || board[row][col].symbol != Symbol.DASH) {
            return false;
        }

        board[row][col].symbol = player.getSymbol();
        totalMoves += 1;
        return true;
    }

    private boolean isFull() {
        return totalMoves == size * size;
    }

    private boolean winner(int row, int col, Player player) {
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


    public void printBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col].symbol.getSymbol() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
