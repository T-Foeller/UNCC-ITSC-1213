package magicsquare;

import java.util.Scanner;
import java.lang.Math;

public class Square {

    private int[][] square;

    //--------------------------------------
    //create new square of given size
    //--------------------------------------
    public Square(int size) {
        square = new int[size][size];

    }
    
    //--------------------------------------
    //create new square using given 2D array
    //--------------------------------------
    public Square(int[][] matrix) {
        square = matrix;

    }
    
    //Bonus
    //--------------------------------------
    //create new square using given a size, min integer and max integer inclusive
    //--------------------------------------
    public Square(int size, int min,int max) {
        square = new int[size][size];
        
        for (int r = 0 ; r < square.length; r++) {
            for (int c = 0; c < square[0].length; c++) {
                int randomInt = (int)(Math.random() * (max - min + 1)) + min;
                
                square[r][c] += randomInt;
            }
        }
    }

    //--------------------------------------
    //return the square 2D array
    //--------------------------------------
    public int[][] getSquare() {
        return square;
    }

    //--------------------------------------
    //return the sum of the values in the given row
    //--------------------------------------
    public int sumRow(int row) {
        int total = 0;
        
        if (row < square.length) {
            for (int c = 0; c < square[row].length; c++) {
                total += square[row][c];
            }
        }
        else {
            System.out.println("Error: row number " + row + " does not exist");
            return -1;
        }

        return total;
    }

    //--------------------------------------
    //return the sum of the values in the given column
    //--------------------------------------
    public int sumColumn(int col) {
        int total = 0;
        
        if (col < square[0].length) {
            for (int r = 0; r < square.length; r++) {
                total += square[r][col];
            }
        }
        else {
            System.out.println("Error: column number " + col + " does not exist");
            return -1;
        }

        return total;
    }

    //--------------------------------------
    //return the sum of the values in the main diagonal
    //--------------------------------------
    public int sumMainDiag() {
        int total = 0;
        
        for (int s = 0; s < square.length; s++) {
            total += square[s][s];
        }

        return total;
    }

    //--------------------------------------
    //return the sum of the values in the other ("reverse") diagonal
    //--------------------------------------
    public int sumOtherDiag() {
        int total = 0;
        
        int c = square[0].length - 1;
        
        for (int r = 0; r < square.length; r++) {
            if (c >= 0) {
               total += square[r][c];
               c--;
            }
        }

        return total;

    }

    //--------------------------------------
    //return true if the square is magic (all rows, cols, and diags have
    //same sum), false otherwise
    //--------------------------------------
    public boolean isMagic() {
        //Creating a array to iterate through
        int[] allSums = new int[square.length * 2 + 2];
        int index = 0;
        
        for (int r = 0; r < square.length; r++) {
            allSums[index] += this.sumRow(r);
            index++;
        }
        
        for (int c = 0; c < square[0].length; c++) {
            allSums[index] += this.sumColumn(c);
            index++;
        }
        
        allSums[index] += this.sumMainDiag();
        index++;
        allSums[index] += this.sumOtherDiag();
        
        //Iterate through allSums to see if all values are equal to each other
        int testSum = allSums[0];
        
        for (int i = 1; i < allSums.length; i++) {
            if (allSums[i] != testSum) {
                return false;
            }
        }

        return true;
    }

    //--------------------------------------
    //read info into the square from the standard input.
    //--------------------------------------
    public void readSquare(Scanner scan) {
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square.length; col++) {
                System.out.println("Enter an integer number");
                square[row][col] = scan.nextInt();
            }
        }
    }

    //--------------------------------------
    //print the contents of the square, neatly formatted
    //--------------------------------------
    public void printSquare() {
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square.length; col++) {
                System.out.print(square[row][col] + "  ");
            }
            System.out.println("");
        }

    }
}

