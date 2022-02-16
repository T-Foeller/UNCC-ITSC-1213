/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package magicsquare;

import java.util.Scanner;

/**
 *
 * @author Tyler Foeller
 */
public class MagicSquare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Add this code inside the main method
        Scanner scan = new Scanner(System.in);
        int count = 1; //count which square we're on

        System.out.println("Enter an integer number for the size of the square");
        int size = scan.nextInt(); //size of next square
        System.out.println("Enter an integer number for the max of the square");
        int max = scan.nextInt();//max int value in square
        System.out.println("Enter an integer number for the min of the square");
        int min = scan.nextInt();//min int value in square

        //create a new Square of the given size
        Square sq = new Square(size,min,max);

        System.out.println("******** Square ********");

        //print the square
        sq.printSquare();

        //Part B -
        System.out.println("******** Square details ********");

        //print the sums of its rows
        for (int i = 0; i < size; i++) {
            System.out.println("Row " + i + " sum: " + sq.sumRow(i));
        }

        //print the sums of its columns
        for (int i = 0; i < size; i++) {
            System.out.println("Column " + i + " sum: " + sq.sumColumn(i));
        }

        //Part C -
        //print the sum of the main diagonal
        System.out.println("Main diagonal sum: " + sq.sumMainDiag());

        //print the sum of the other diagonal
        System.out.println("Other diagonal sum: " + sq.sumOtherDiag());

        //Part D -
        //determine and print whether it is a magic square  
        if (sq.isMagic()) {
            System.out.println("This 2D array is a magic square");
        } else {
            System.out.println("This 2D array is not a magic square");
        }
    }
    
}
