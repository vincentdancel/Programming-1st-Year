package javaapplication26;
import java.io.*;
import java.util.*;

public class JavaApplication26 {

    private static final String FILENAME = "inventory.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the menu
        while (true) {
            System.out.println("1. Add an item\n2. Display all items\n3. Remove an item\n4. Calculate inventory value\n5. Exit");
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
                    removeItem();
                    break;
                case 4:
                    calculateInventoryValue();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

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

            writer.println("Item Name:" + name);
            writer.println("Quantity:" + quantity);
            writer.println("Price:" + price);
            writer.println();

            System.out.println("Item added successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void displayAllItems() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // skip empty lines
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void removeItem() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter item name to remove: ");
            String nameToRemove = scanner.nextLine();
            StringBuilder fileContent = new StringBuilder();
            boolean found = false;

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Item Name:" + nameToRemove)) {
                    found = true;
                    // Skip the next two lines (Quantity and Price)
                    reader.readLine();
                    reader.readLine();
                    reader.readLine(); // skip the blank line
                } else {
                    fileContent.append(line).append(System.lineSeparator());
                }
            }

            if (!found) {
                System.out.println("Item not found.");
                return;
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
                writer.print(fileContent.toString());
            }

            System.out.println("Item removed successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void calculateInventoryValue() {
        double totalValue = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Quantity:")) {
                    int quantity = Integer.parseInt(line.substring(9).trim());
                    line = reader.readLine(); // Move to next line which should contain price
                    double price = Double.parseDouble(line.substring(6).trim());
                    totalValue += quantity * price;
                }
            }
            System.out.println("Total Inventory Value: $" + totalValue);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
