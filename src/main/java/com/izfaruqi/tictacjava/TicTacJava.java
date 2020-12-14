package com.izfaruqi.tictacjava;

import java.util.Scanner;

public class TicTacJava {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to TicTacJava!");
        while(true){
            Board board = new Board();
            boolean hasWin = false;
            System.out.println(board.printBoard());

            while(!hasWin){
                System.out.println("You are " + board.getCurrentPlayer().getName());
                System.out.print("Enter row and column: ");
                int row = s.nextInt();
                int col = s.nextInt();

                int moveResult = board.move(row, col);
                if(moveResult == 1){
                    System.out.println("Illegal move!");
                } else if(moveResult == 2){
                    System.out.println(board.printBoard());
                    System.out.println("Congratulations " + board.getCurrentPlayer().getName() + ", you have won!");
                    hasWin = true;
                } else {
                    System.out.println(board.printBoard());
                }
            }

            System.out.print("Do you want to play again (y/n)?");
            String opt = s.next();
            if(!opt.equals("y")){
                break;
            }
        }

    }
}
