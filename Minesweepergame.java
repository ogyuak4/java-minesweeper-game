
package com.mycompany.minesweepergame;

import java.util.Scanner;


public class Minesweepergame {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int row,column;
        System.out.println("Welcome to minesweepergame !!! ");
        System.out.println("Please enter the board sizes ! ");
        System.out.println("row size: ");
        row=scan.nextInt();
        System.out.println("column size: ");
        column=scan.nextInt();
        MineSweeper minesweeper=new MineSweeper(row,column);
        minesweeper.run();
        
        
    }
}
