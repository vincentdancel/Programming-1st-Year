package grades;

import java.util.Scanner;

public class Grades {

    public static void main(String[] args) {

        //to enter input
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of grades: ");
        int numgrade = sc.nextInt();
        int[] grade = new int[numgrade];

        System.out.println("Enter the grade");
        for (int times = 0; times < numgrade; times++) {
            System.out.println("Enter grade: ");
            grade[times] = sc.nextInt();

        }
        //max grade
        int max = grade[0];
        for (int i = 0; i < grade.length; i++) {
            if (max < grade[i]) {
                max = grade[i];
            }
        }

        //min grade
        int min = grade[0];
        for (int i = 0; i < grade.length; i++) {
            if (min > grade[i]) {
                min = grade[i];
            }
        }

        //output min, max, & average grade
        System.out.println("Minimum Grade: " + min);
        System.out.println("Maximum Grade: " + max);
        float sum = 0;
        for (int a = 0; a < grade.length; a++) {
            sum += grade[a];
        }
        float average = sum / grade.length;

        //average grade output
        System.out.printf("Average Grade: %.2f ", average);
    }
}
