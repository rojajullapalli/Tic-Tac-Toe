package com.bridgelabz.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
    static Scanner userInput = new Scanner(System.in);
    static char userLetter;
    static char computerLetter;
    static char playerChoice;
    static char[] board = new char[10];
    static int count;
    static int chance;

    static ArrayList<int[]> checkCondition = new ArrayList<>();

    public static void conditionsForWin() {
        int[] row1 = {1, 2, 3};
        int[] row2 = {4, 5, 6};
        int[] row3 = {7, 8, 9};
        int[] col1 = {1, 4, 7};
        int[] col2 = {2, 5, 8};
        int[] col3 = {3, 6, 9};
        int[] diag1 = {1, 5, 9};
        int[] diag2 = {3, 5, 7};

        checkCondition.add(row1);
        checkCondition.add(row2);
        checkCondition.add(row3);
        checkCondition.add(col1);
        checkCondition.add(col2);
        checkCondition.add(col3);
        checkCondition.add(diag1);
        checkCondition.add(diag2);
    }

    public static char[] createBoard() {
        for (int i = 1; i < 10; i++) {
            board[i] = ' ';
        }
        return board;
    }

    public static void chooseLetter() {
        System.out.print("Choose your Letter X or O : ");
        userLetter = userInput.next().toUpperCase().charAt(0);
        if (userLetter == 'X' || userLetter == 'O') {
            playerChoice = userLetter;
            computerLetter = (userLetter == 'X') ? 'O' : 'X';
        } else {
            System.out.println("Invalid INPUT");
            chooseLetter();
        }
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
        } else {
            board[location] = userLetter;
        }
    }

    public static void computerBlock(char computerChoice){
        if(board[1]==userLetter && board[2]==userLetter || board[5]==userLetter && board[7]==userLetter || board[9]==userLetter && board[6]==userLetter)
            board[3]=computerChoice;
        else if(board[2]==userLetter && board[3]==userLetter || board[4]==userLetter && board[7]==userLetter || board[5]==userLetter && board[9]==userLetter)
            board[1]=computerChoice;
        else if(board[1]==userLetter && board[3]==userLetter || board[5]==userLetter && board[8]==userLetter)
            board[2]=computerChoice;
        else if(board[1]==userLetter && board[7]==userLetter || board[5]==userLetter && board[6]==userLetter)
            board[4]=computerChoice;
        else if(board[1]==userLetter && board[9]==userLetter || board[3]==userLetter && board[7]==userLetter || board[4]==userLetter && board[6]==userLetter || board[2]==userLetter && board[8]==userLetter)
            board[5]=computerChoice;
        else if(board[3]==userLetter && board[9]==userLetter || board[4]==userLetter && board[5]==userLetter)
            board[6]=computerChoice;
        else if(board[1]==userLetter && board[4]==userLetter || board[8]==userLetter && board[9]==userLetter || board[3]==userLetter && board[5]==userLetter )
            board[7]=computerChoice;
        else if(board[2]==userLetter && board[5]==userLetter || board[7]==userLetter && board[9]==userLetter)
            board[8]=computerChoice;
        else if(board[1]==userLetter && board[5]==userLetter || board[3]==userLetter && board[6]==userLetter || board[7]==userLetter && board[8]==userLetter )
            board[9]=computerChoice;
        else{
            int location = (int) (Math.random() * 10);
            if (board[location] != ' ') {
                System.out.println("Position Already Occupied");
                computerBlock(computerChoice);
            } else {
                board[location] = computerChoice;
            }
        }
    }



    public static void toss() {
        System.out.println("Toss Time - Press 0 for Head And 1 for Tail: ");
        int check = userInput.nextInt();
        int chance = (int) (Math.random() * 2);
        if (chance == check) {
            System.out.println("You Won the Toss");
            count = 0;
        } else {
            System.out.println("You Lose the Toss");
            count = 1;
        }
    }

    public static char winCheck() {
        final int WIN_CONDITION = 3;
        for (int index = 0; index < checkCondition.size(); index++) {
            int addX = 0;
            int addO = 0;
            for (int i = 0; i < checkCondition.get(index).length; i++) {
                if (board[checkCondition.get(index)[i]] == 'X') {
                    addX += 1;
                    if (addX == WIN_CONDITION) {
                        return 'X';
                    }
                } else if (board[checkCondition.get(index)[i]] == 'O') {
                    addO += 1;
                    if (addO == WIN_CONDITION) {
                        return 'O';
                    }
                }
            }
        }
        return ' ';
    }

    public static boolean tie() {
        for (int k = 1; k < 10; k++) {
            if (board[k] == ' ') {
                return false;
            }
        }
        return true;
    }

    public static void turn() {
        while (true) {
            if (winCheck() == 'X' || winCheck() == 'O') {
                System.out.println((userLetter == winCheck()) ? "You Win" : "Computer Wins");
                break;
            } else if (tie()) {
                System.out.println("It's a tie");
                break;
            } else {
                if (count % 2 == chance) {
                    System.out.println("Your Turn");
                    makeMove();
                    showBoard();
                } else {
                    System.out.println("Computer Turn");
                    computerBlock(computerLetter);
                    showBoard();
                }
                count++;
            }
        }
    }
    public static void iscontinue(){
        conditionsForWin();
        createBoard();
        chooseLetter();
        System.out.println("Computer Letter: " + computerLetter);
        showBoard();
        toss();
        turn();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToeGame");
        while(true) {
            System.out.println("enter you want to play \n1.Yes 2.No");
            int play=userInput.nextInt();
            if(play==1)
                iscontinue();
            else
                break;
        }
    }
}