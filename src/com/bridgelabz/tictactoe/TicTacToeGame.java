package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

    public static char[] createBoard() {
        char[] board = new char[10];
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
        return board;
    }

    public static char chooseLetter() {
        char user;
        char computer =0 ;
        Scanner sc = new Scanner(System.in);
        System.out.println("1. X");
        System.out.println("2. O");
        System.out.println("Enter case number to choose letter:- ");
        int result = sc.nextInt();
        if (result == 1) {
            user = 'X';
            System.out.println("user selects " +user);
        }
         else {
            user = 'O';
            System.out.println("user selects " +user);
        }
        return computer;

}


    public static void main(String[] args) {
        System.out.println("welcome to tic tac toe problem");
        createBoard();
        chooseLetter();

    }


}
