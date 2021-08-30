package com.bridgelabz.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
    static Scanner userInput = new Scanner(System.in);
    static char userLetter;
    static char computerLetter;
    static char[] board = new char[10];

    public static char[] createBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
        return board;
    }

    public static char chooseUserLetter(Scanner userInput) {
        System.out.println("Choose Your Letter X or O: ");
        return userInput.next().toUpperCase().charAt(0);
    }



    public static void showBoard() {
        System.out.println("|-----------|");
        System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");
        System.out.println("|-----------|");
    }


    public static void makeMove() {
        System.out.print("Select location between 1-9 : ");
        int location = userInput.nextInt();
        if (board[location] != ' ') {
            System.out.println("Position Already Occupied");
            makeMove();
        }
        else {
            board[location] = userLetter;
        }
    }

    public static void toss() {
        System.out.println("Toss Time - Press 0 for Head And 1 for Tail: ");
        int check = userInput.nextInt();
        int chance =(int) (Math.random() * 2);
        if (chance == check) {
            System.out.println("You Won the Toss");
            System.out.println("Your Turn");
            makeMove();
            showBoard();
        }
        else {
            System.out.println("You Lose the Toss");
            System.out.println("Computer Turn");
        }
    }

    public static void main(String[] args) {
        System.out.println("welcome to tic tac toe problem");
        char[] board = createBoard();
        userLetter = chooseUserLetter(userInput);
        char computerLetter = (userLetter == 'X') ? 'O' : 'X';
        showBoard();
        toss();
    }
}
