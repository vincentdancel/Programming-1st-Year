package progact;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        //2D array ; get sum

        Scanner sc = new Scanner(System.in);

        int matrix[][] = new int[3][3];

        System.out.println("Print 2D array Contents..");
        for (int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("Input 2D array contents..");
        for (int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                System.out.println("input for row " + (row + 1) + ", column " + (col + 1) + ";");
                matrix[row][col] = sc.nextInt();
            }
        }
        System.out.println("Print 2D array Contents..");
        for (int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        for (int col =0; col < matrix[0].length; col++){
            int sum = 0;
            for (int row = 0; row < matrix.length; row++){
                sum = sum + matrix[row][col];
            }
            System.out.println("Sum of column " + (col + 1) + " = " + sum);
        }
        for (int row =0; row < matrix[0].length; row++){
            int sum = 0;
            for (int col = 0; col < matrix.length; col++){
                sum = sum + matrix[row][col];
            }
            System.out.println("Sum of row " + (row + 1) + " = " + sum);
        }
    }
}
    

