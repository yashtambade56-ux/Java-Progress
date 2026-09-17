package Assignment11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Assignment11 {
    // 1. Set Up the Collections
    private static final HashSet<String> categories = new HashSet<>();
    private static final TreeSet<Integer> productIds = new TreeSet<>();
    private static final TreeMap<Integer, String> productCatalog = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        // 2. Menu Loop & Switch Statement
        while (choice != 8) {
            System.out.println("\n===== Product Inventory Management System =====");
            System.out.println("1. Add Product Category");
            System.out.println("2. Add Product ID");
            System.out.println("3. Add Product to Catalog");
            System.out.println("4. Display All Products");
            System.out.println("5. Find Nearest Product ID");
            System.out.println("6. Display Products in ID Range");
            System.out.println("7. Remove Product");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) continue;
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        // HashSet: add() silently ignores duplicates
                        System.out.print("Enter category name: ");
                        String category = scanner.nextLine().trim();
                        categories.add(category);
                        System.out.println("Category added: " + category);
                        break;

                    case 2:
                        // TreeSet: add() and iterator traversal in ascending order
                        System.out.print("Enter product ID: ");
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        productIds.add(id);
                        System.out.println("Product ID added: " + id);
                        System.out.print("Sorted Product IDs: ");
                        Iterator<Integer> it = productIds.iterator();
                        while (it.hasNext()) {
                            System.out.print(it.next() + (it.hasNext() ? ", " : ""));
                        }
                        System.out.println();
                        break;

                    case 3:
                        // TreeMap: put() associates ID with description
                        System.out.print("Enter product ID: ");
                        int prodId = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter product name and price: ");
                        String details = scanner.nextLine().trim();
                        productCatalog.put(prodId, details);
                        productIds.add(prodId);
                        System.out.println("Product added to catalog.");
                        break;

                    case 4:
                        // firstKey() throws NoSuchElementException if TreeMap is empty
                        productCatalog.firstKey();
                        System.out.println("\n===== All Products (Sorted by ID) =====");
                        for (Map.Entry<Integer, String> entry : productCatalog.entrySet()) {
                            System.out.println(entry.getKey() + " -> " + entry.getValue());
                        }
                        break;

                    case 5:
                        // NavigableMap: floorKey() and ceilingKey()
                        productCatalog.firstKey();
                        System.out.print("Enter ID to search nearest: ");
                        int searchId = Integer.parseInt(scanner.nextLine().trim());
                        System.out.println("Floor ID  : " + productCatalog.floorKey(searchId));
                        System.out.println("Ceiling ID: " + productCatalog.ceilingKey(searchId));
                        break;

                    case 6:
                        // NavigableMap: subMap() (or headMap() & tailMap())
                        productCatalog.firstKey();
                        System.out.print("Enter range (from - to): ");
                        String[] range = scanner.nextLine().trim().split("\\s*-\\s*|\\s+");
                        int from = Integer.parseInt(range[0]);
                        int to = Integer.parseInt(range[1]);
                        NavigableMap<Integer, String> inRange = productCatalog.subMap(from, true, to, true);
                        System.out.println("===== Products in Range =====");
                        for (Map.Entry<Integer, String> entry : inRange.entrySet()) {
                            System.out.println(entry.getKey() + " -> " + entry.getValue());
                        }
                        break;

                    case 7:
                        // TreeMap and TreeSet remove()
                        productCatalog.firstKey();
                        System.out.print("Enter product ID to remove: ");
                        int removeId = Integer.parseInt(scanner.nextLine().trim());
                        if (!productCatalog.containsKey(removeId)) {
                            throw new NoSuchElementException("Product ID " + removeId + " not found.");
                        }
                        productCatalog.remove(removeId);
                        productIds.remove(removeId);
                        System.out.println("Product removed successfully.");
                        break;

                    case 8:
                        System.out.println("Exiting Product Inventory Management System. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please select an option between 1 and 8.");
                }
            } catch (NoSuchElementException e) {
                System.out.println(productCatalog.isEmpty()
                        ? "Catalog is empty. Please add products first."
                        : "Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid numeric input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Error: Operation failed (" + e.getMessage() + ").");
            }
        }
        scanner.close();
    }
}
