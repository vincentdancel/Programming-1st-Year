package addletter1;

import java.util.Scanner;

public class AddLetter1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Input a word:");
        String word = input.nextLine();

        String output = "";

        for (int v = 0; v < word.length(); v++) {
            char x = word.charAt(v);

            output = output + x;

            if (x == 'A' || x == 'a' || x == 'E' || x == 'e' || x == 'I' || x == 'i' || x == 'O' || x == 'o' || x == 'U' || x == 'u') {
                output = output + 'p' + x;
            }

            System.out.println(output);

        }

    }

}
