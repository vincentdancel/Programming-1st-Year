package registersystem;

import java.util.Scanner;

public class RegisterSystem {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        // Declaring 2D Array
        String[][] data = new String[3][4];  

        //Inputing the data of the student
        System.out.println("Input your: ID Number, First Name, Last Name, and Course");
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                data[row][col] = read.next();
            }
        }
       
        System.out.println('\n');
        
        //Dispalying the data of the student
        System.out.println("Stored Data:");
        
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                System.out.print(data[row][col] + " ");
            }
            
            //Displayed
            System.out.println();
        }
    }
}
