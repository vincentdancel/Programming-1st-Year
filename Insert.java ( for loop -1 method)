package insert;

import java.util.Scanner;

public class Insert {

    public static void main(String[] args) {

        int array[] = new int[6];
        int location = 0;
        int value = 0;
        int max = 5;

        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter 5 integer values in the array :");
        int values = input.nextInt();

        for (int i = 0; i < max - 1; i++) {
            array[i] = input.nextInt();
        }
        System.out.println("\nEnter the location where you want to insert a new value (index begins with 0) :");
        location = input.nextInt();

        System.out.println("\nEnter the new value that you want to insert in array :");
        value = input.nextInt();

        for (int i = max; i > location; i--) {
            array[i] = array[i - 1];

        }
        array[location] = value;

        System.out.println("\nValues in array after inserting new value: " + value + " at the location " + location);
        for (int i = 0; i <= max; i++) {
            System.out.println(array[i]);
        }

    }
}
