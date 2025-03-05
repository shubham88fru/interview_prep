package com.learning.lld.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    private Player[] players;
    Board board;

    public TicTacToe(int size) {
        board = new Board(size);
        players = new Player[2];
        players[0] = new Player(Symbol.X);
        players[1] = new Player(Symbol.O);
    }

    public void startGame() {
        int player = 0;
        Scanner scanner = new Scanner(System.in);
        while (!board.isFull()) {
            System.out.println("Player " + player + " choose row: ");
            int i = scanner.nextInt();

            System.out.println("Player " + player + " choose column: ");
            int j = scanner.nextInt();

            if (!board.makeMove(i, j, players[player])) {
                System.out.println("Invalid move, please try again");
                continue;
            }

            board.print();
            if (board.winner(i, j, players[player])) {
                break;
            }

            player = 1 - player;
        }

        if (board.isFull()) {
            System.out.println("Draw");
            return;
        }

        System.out.println("Player " + player + " won");
    }




}
