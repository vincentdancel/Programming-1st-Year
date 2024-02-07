package replacezero;

import java.util.Scanner;

public class ReplaceZero {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // inputting an array
        System.out.println("Enter the size of the array:");
        int size = input.nextInt();

        System.out.println("Enter the elements of the array:" + size);

        System.out.println("Elements");

        //setting a value
        int[] array = new int[size];

        //checking if there is a negative array
        for (int j = 0; j < size; j++) {
            array[j] = input.nextInt();
            if (array[j] < 0) {
                array[j] = 0;

            }
        }

        //Displaying the input
        System.out.println("Array after replacing negative elements with zero:");

        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }

    }

}
