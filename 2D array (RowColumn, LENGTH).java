package javaapplication6;

import java.util.Scanner;

public class JavaApplication6 {

    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);

        int matrix[][] = new int[3][3];

        System.out.println("Input 2D array contents...");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.println("Input from row " + row + ", colum" + col + ":");
                matrix[row][col] = sr.nextInt();
            }
        }
        System.out.println("Print 2d array contents...");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();

        }

    }
}
