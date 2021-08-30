package com.bridgelabz.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
    static Scanner userInput = new Scanner(System.in);
    public static char[] createBoard() {
        char[] board = new char[10];
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
        return board;
    }

    public static char chooseUserLetter(Scanner userInput) {
        System.out.println("Choose Your Letter X or O: ");
        return userInput.next().toUpperCase().charAt(0);
    }



    public static void showBoard(char[] board) {
        System.out.println("|-----------|");
        System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");
        System.out.println("|-----------|");
    }


    public static void makeMove(char board[],char userLetter) {
        System.out.print("Select location between 1-9 : ");
        int location = userInput.nextInt();
        if (board[location] != ' ') {
            System.out.println("Position Already Occupied");
        }
        else {
            board[location] = userLetter;
            showBoard(board);
        }
    }

    public static void main(String[] args) {
        System.out.println("welcome to tic tac toe problem");
        Scanner userInput = new Scanner(System.in);
        char[] board = createBoard();
        char userLetter = chooseUserLetter(userInput);
        char computerLetter = (userLetter == 'X') ? 'O' : 'X';
        showBoard(board);
        makeMove(board,userLetter);
    }
}
