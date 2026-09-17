# Assignment 11: Product Inventory Management System

## Overview
The **Product Inventory Management System** is a Java console application developed for **Unit 6: Collections Framework in Java**. It showcases the practical application of Set and Map interfaces by storing unique product categories, maintaining sorted unique product IDs, and mapping each product ID to its details with rich search and range-query capabilities.

---

## Key Java Collections & Methods Demonstrated

| Menu Option | Collection & Method | Description |
|---|---|---|
| **1. Add Product Category** | `HashSet.add()` | Stores unique category names; duplicates are ignored. |
| **2. Add Product ID** | `TreeSet.add()` & `Iterator` | Stores unique IDs in auto-sorted order and traverses using an `Iterator`. |
| **3. Add Product to Catalog** | `TreeMap.put()` | Associates a product ID (key) with its name and price (value). |
| **4. Display All Products** | `TreeMap.entrySet()`, `firstKey()`, `lastKey()` | Iterates through entry sets in ascending key order; demonstrates `firstKey()` and `lastKey()`. |
| **5. Find Nearest Product ID** | `NavigableMap.floorKey()`, `ceilingKey()` | Finds the closest IDs at-or-below and at-or-above a specified target ID. |
| **6. Display Products in ID Range** | `NavigableMap.subMap()` | Performs range queries between two ID boundaries (inclusive). |
| **7. Remove Product** | `TreeMap.remove()`, `TreeSet.remove()` | Removes product entry from both catalog and ID set. |
| **8. Exit** | Loop termination | Gracefully terminates the application. |

---

## Exception Handling
- **`NoSuchElementException`**: Wrapped around operations attempting to query or remove from empty collections, or looking up non-existent keys.
- **`NumberFormatException`**: Handles non-integer numeric input safely so the program does not crash.
- **`IllegalArgumentException`**: Guards against invalid key ranges during submap extraction.

---

## File Structure

```
Assignment11/
├── Assignment11.java  # Core implementation with collections, menu, and handlers
├── Main.java          # Driver entrypoint delegating to Assignment11.main
└── README.md          # Documentation and execution instructions
```

---

## How to Compile and Run

From the root repository directory (`/Users/ankitrajjha/java-Assign`):

### 1. Compile
```bash
javac Assignment11/Assignment11.java Assignment11/Main.java
```

### 2. Run
```bash
java Assignment11.Assignment11
```
*(or alternatively)*
```bash
java Assignment11.Main
```

---

## Sample Console Output

```text
===== Product Inventory Management System =====
1. Add Product Category
2. Add Product ID
3. Add Product to Catalog
4. Display All Products
5. Find Nearest Product ID
6. Display Products in ID Range
7. Remove Product
8. Exit
Enter your choice: 1
Enter category name: Electronics
Category added: Electronics

===== Product Inventory Management System =====
1. Add Product Category
2. Add Product ID
3. Add Product to Catalog
4. Display All Products
5. Find Nearest Product ID
6. Display Products in ID Range
7. Remove Product
8. Exit
Enter your choice: 3
Enter product ID: 105
Enter product name and price: Wireless Mouse, 799
Product added to catalog.

Enter product ID: 102
Enter product name and price: USB Cable, 199
Product added to catalog.

===== All Products (Sorted by ID) =====
102 -> USB Cable, 199
105 -> Wireless Mouse, 799
Lowest Product ID  : 102
Highest Product ID : 105

Enter ID to search nearest: 103
Floor ID  : 102
Ceiling ID: 105

Enter range (from - to): 100 - 104
===== Products in Range =====
102 -> USB Cable, 199
```
