
package com.mycompany.minesweepergame;

import java.util.Random;
import java.util.Scanner;


public class MineSweeper {
    int rowNumber;
    int columnNumber;
    int size;
    int[][] map;
    int[][] board;
    boolean game = true;
    Random rand = new Random();
    Scanner scan=new Scanner(System.in);
        
                

    MineSweeper(int rowNumber,int columnNumber){
        this.rowNumber=rowNumber;
        this.columnNumber=columnNumber;
        this.map=new int[rowNumber][columnNumber];
        this.board=new int[rowNumber][columnNumber];
        this.size=rowNumber*columnNumber;
    }
    
    public void run(){
        int row,col,success=0;
        prepareGame();
        System.out.println("The game has started. ");
        while(game){
            print(board);
            System.out.print("Row : ");
            row=scan.nextInt();
            System.out.print("Column : ");
            col=scan.nextInt();
            
            if(row<0 || row>rowNumber){
                System.out.println("your coordinate is faulty");
                continue;
            }
            if(col<0 || col>columnNumber){
                System.out.println("your coordinate is faulty");
                continue;
            }
            if(map[row][col]!= -1){
                check(row,col);
                success++;
                if(success==(size-(size/4))){
                    System.out.println("You won. congratulations !!");
                    print(map);
                    break;
                }
            }
            else{
                game=false;
                System.out.println("you click on the mine! Game over...");
                print(map);
            }
            
            
        }
        
        
        
        
    }
    
    
    
    public void check(int r, int c)    {
        if(board[r][c]==0){
            
            if((c < columnNumber -1 ) && (map[r][c+1] == -1)) {
                board[r][c]++;
            }
            if((r<rowNumber-1) && (map[r+1][c] == -1)) {
                board[r][c]++;
            }
            if((r>0) && (map[r-1][c] == -1)) {
                board[r][c]++;
            }
            if((c>0) && (map[r][c-1] == -1)) {
                board[r][c]++;
            }
        
        
            if((c<columnNumber-1) && (r<rowNumber-1) && map[r+1][c+1] == -1) {
                board[r][c]++;
            }
            if((c>0) && (r>0) && (map[r-1][c-1]) == -1) {
                board[r][c]++;
            }
            if((c>0) && (r<rowNumber-1) && (map[r+1][c-1]) == -1) {
                board[r][c]++;
            }
            if( (r>0) && (c<columnNumber-1) && (map[r-1][c+1]) == -1) {
                board[r][c]++;
            }
            if(board[r][c] == 0){
                board[r][c]=-2;
            }
            
        }
        
        
        
    }
    
    
    public void prepareGame(){
        int randRow, randCol, count=0;
        while(count!=(size/4)){
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(columnNumber);
            if(map[randRow][randCol]!= -1){
                map[randRow][randCol]= -1;
                count++;
            }
        }
        
    }
    public void print(int[][] arr) {
        for(int i=0; i< arr.length; i++) {
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]>=0)
                    System.out.print(" ");
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
}
