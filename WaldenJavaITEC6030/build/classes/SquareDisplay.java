/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

public class SquareDisplay {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String promptResponse;
        int squareSize;
        
        System.out.print("Enter an integer in the range of 1-15: ");
        promptResponse = kb.next();
        squareSize = Integer.parseInt(promptResponse);
        if (squareSize > 0 && squareSize <=15) {
            for (int i=1; i <= squareSize; i++) {
                for (int j=1; j <= squareSize; j++) {
                    System.out.print("X");       
                } 
                if (i < squareSize) System.out.print("\n");
            }
        } else {
            System.exit(0);
        }
        
        
    }
    
}
