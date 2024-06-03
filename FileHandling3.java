
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

            writer.println("Item Name:" + name + '\n' + "Quantity:" + quantity + '\n' + "Price:" + price + '\n');

            System.out.println("Item added successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

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

    private static void removeItem() {
        try {
            Scanner scanner = new Scanner(new File(FILENAME));
            StringBuilder fileContent = new StringBuilder();
            System.out.print("Enter item name to remove: ");
            String nameToRemove = scanner.nextLine();
            boolean found = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Item Name:" + nameToRemove)) {
                    found = true;
                    // Skipping item details
                    for (int i = 0; i < 2; i++) {
                        scanner.nextLine();
                    }
                } else {
                    fileContent.append(line).append('\n');
                }
            }

            scanner.close();

            if (!found) {
                System.out.println("Item not found.");
                return;
            }

            PrintWriter writer = new PrintWriter(new FileWriter(FILENAME));
            writer.print(fileContent);
            writer.close();
            
            System.out.println("Item removed successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

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
    
    
