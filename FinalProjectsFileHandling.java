package finalprojects;

import java.io.*;
import java.util.*;

public class FinalProjects {

    private static final String FILENAME = "inventory.txt";

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Display the menu
        while (true) {
            System.out.println("\n1. Add an item\n2. Display all items\n3. Search Item\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    displayAllItems();
                    break;
                case 3:
                    searchItem();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    // Method to add an item to the inventory
    private static void addItem() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME, true))) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter item name: ");
            String name = scanner.nextLine();
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            // Write the item details to the file
            writer.println("Item Name:" + name + '\n' + "Quantity:" + quantity + '\n' + "Price:" + price + '\n');

            System.out.println("Item added successfully.\n");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Method to display all items
    private static void displayAllItems() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    //Method to search an item to the inventory
    private static void searchItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the item name to search: ");
        String searchItemName = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Item Name:") && line.contains(searchItemName)) {
                    System.out.println("Item found:");
                    System.out.println(line); // Print item name
                    for (int i = 0; i < 2; i++) {
                        line = reader.readLine();
                        if (line != null) {
                            System.out.println(line);
                        }
                    }
                    return;
                }
            }
            System.out.println("Item not found.\n");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
