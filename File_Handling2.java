package finalprojects;

import java.io.*;
import java.util.*;

public class FinalProjects {

    /*A small inventory management system. 
       Have it save items with name, quantity, and price to a file.
       Enable to add items.
     */
    
    private static final String FILENAME = "inventory.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the menu
        while (true) {
            System.out.println("1. Add an item\n2. Display all items\n3. Exit");
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
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
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

            System.out.println("Item added successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Method to display all items
    private static void displayAllItems() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine())!= null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


    // Method to calculate and display the inventory value
    private static void calculateInventoryValue() {
        double totalValue = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine())!= null) {
                if (line.startsWith("Quantity:")) {
                    int quantity = Integer.parseInt(line.substring(9));
                    line = reader.readLine(); // Move to next line which should contain price
                    double price = Double.parseDouble(line.substring(6));
                    totalValue += quantity * price;
                }
            }
            System.out.println("Total Inventory Value: $" + totalValue);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
