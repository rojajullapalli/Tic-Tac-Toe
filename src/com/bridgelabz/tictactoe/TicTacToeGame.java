package com.bridgelabz.tictactoe;

public class TicTacToeGame {

    public static char[] createBoard() {
        char[] board = new char[10];
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
        return board;
    }

    public static void main(String[] args) {
        System.out.println("welcome to tic tac toe problem");
        createBoard();
    }
}
