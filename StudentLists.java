package studentlists;

import java.util.Scanner;

public class StudentLists {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[][] studentInformation = new String[100][5];
        int count = 0;

        while (true) {

            System.out.println("Choose an option:\n"
                    + "1. Add Student\n"
                    + "2. Edit/Update Information\n"
                    + "3. Delete Student Information\n"
                    + "4. Display\n"
                    + "5. Exit");

            int option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter ID Number: ");
                    String IdNumber = input.next();
                    System.out.print("Enter First Name: ");
                    String FirstName = input.next();
                    System.out.print("Enter Last Name: ");
                    String LastName = input.next();
                    System.out.print("Enter Course: ");
                    String Course = input.next();
                    System.out.print("Enter Year Level: ");
                    String YearLevel = input.next();

                    studentInformation[count][0] = IdNumber;
                    studentInformation[count][1] = FirstName;
                    studentInformation[count][2] = LastName;
                    studentInformation[count][3] = Course;
                    studentInformation[count][4] = YearLevel;
                    count++;

                    break;

                case 2:
                    System.out.print("Enter ID Number to Edit: ");
                    String idToEdit = input.next();

                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (studentInformation[i][0].equals(idToEdit)) {
                            System.out.print("Enter new ID Number: ");
                            String newIdNumber = input.next();
                            studentInformation[i][0] = newIdNumber;
                            System.out.println("ID Number updated successfully.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("ID Number not found.");
                    }

                    break;

                case 3:
                    System.out.print("Enter ID Number to Delete: ");
                    String idToDelete = input.next();

                    found = false;
                    for (int i = 0; i < count; i++) {
                        if (studentInformation[i][0].equals(idToDelete)) {         // Delete the student information by shifting remaining elements                  
                            for (int j = i; j < count - 1; j++) {
                                studentInformation[j] = studentInformation[j + 1];
                            }
                            count--;
                            System.out.println("Student with ID Number " + idToDelete + " deleted successfully.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("ID Number not found.");
                    }

                    break;

                case 4:
                    System.out.println("Student Information:"); // DISPLAYING ALL THE DATA OF STUDENTS
                    for (int i = 0; i < count; i++) {
                        System.out.println("ID Number: " + studentInformation[i][0]);
                        System.out.println("Name: " + studentInformation[i][1] + " " + studentInformation[i][2]);
                        System.out.println("Course: " + studentInformation[i][3] + "-" + studentInformation[i][4] + "\n");
                    }
                    break;

                case 5:
                    System.out.println("Exiting");
                    System.exit(0);

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
