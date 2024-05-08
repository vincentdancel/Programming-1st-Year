package thirdexams;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        int[] arr = {33, 10, 11, 40, 77, 91, 5, 8, 20, 18, 22, 21};

        String fileName = "mytextfile.txt";

        try {
            FileWriter writer = new FileWriter(fileName);

            int evenSum = 0;
            int oddSum = 0;
            int evenCount = 0;
            int oddCount = 0;
            int evenLessThan20 = 0;                
            int oddLessThan10 = 0;

            writer.write("Even numbers:\n");
            for (int num : arr) {
                if (num % 2 == 0) {
                    evenSum += num;
                    evenCount++;
                    if (num < 20) {
                        evenLessThan20++;
                    }
                    writer.write(num + "\n");
                } else {
                    oddSum += num;
                    oddCount++;
                    if (num < 10) {
                        oddLessThan10++;
                    }
                }
            }

            writer.write("\nOdd numbers:\n");
            for (int num : arr) {
                if (num % 2 != 0) {
                    writer.write(num + "\n");
                }
            }

            writer.write("\nSum of even numbers: " + evenSum + "\n");
            writer.write("Sum of odd numbers: " + oddSum + "\n");

            writer.write("\nEven numbers less than 20: " + evenLessThan20 + "\n");
            writer.write("Odd numbers less than 10: " + oddLessThan10 + "\n");

            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Input has been written to the file.");
    }
}
