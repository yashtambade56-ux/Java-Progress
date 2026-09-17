# Assignment 14: Student Marks Viewer using JTable and MVC Architecture

## Overview
The **Student Marks Viewer** is a Java application developed for **Unit 8: GUI Programming with Swing & JavaFX**. It demonstrates the **Model-View-Controller (MVC)** architectural pattern using Swing's `JTable` component with `DefaultTableModel` for displaying and manipulating tabular student records, combined with a minimal JavaFX window previewing the class average.

---

## Architectural Breakdown (MVC)

1. **Model (`StudentMarks`)**:
   - Plain Java class with `rollNo`, `name`, and `marks`.
   - Free from GUI dependencies, encapsulating data and accessors.
   - A single shared collection (`List<StudentMarks>`) maintains state for both the table view and class average calculations.

2. **View (`JFrame`, `JTable`, `DefaultTableModel`)**:
   - `JTable` backed by `DefaultTableModel` with columns: `Roll No`, `Name`, `Marks`.
   - Text fields (`rollField`, `nameField`, `marksField`) for data input.
   - Action buttons (`Add`, `Update`, `Delete`, `Show Average`).
   - `JLabel` displaying the calculated class average.

3. **Controller (`ActionListener` & Event Routing)**:
   - **Add**: Reads inputs, creates a `StudentMarks` object, adds to the list, and appends a row via `DefaultTableModel.addRow()`.
   - **Update**: Obtains selected row index with `getSelectedRow()` and updates values using `setValueAt()`.
   - **Delete**: Removes row with `removeRow()` and removes the entity from the model list.
   - **Show Average**: Recalculates average of marks, updates `JLabel`, and launches a JavaFX window previewing the class average.

4. **JavaFX Introduction**:
   - Minimal JavaFX window using `Stage`, `Scene`, `Label`, and `Button` previewing class average.

---

## Exception Handling
- **`ArrayIndexOutOfBoundsException`**: Guarded using `try-catch` when **Update** or **Delete** is clicked without selecting a row (`table.getSelectedRow() < 0`).
- **`NumberFormatException`**: Handles non-integer Roll No and non-numeric Marks inputs safely with descriptive error dialogs.

---

## File Structure

```
Assignment14/
├── assignment14.java  # Core MVC implementation (Model, View, Controller)
├── Main.java          # Driver entry point delegating to assignment14.main
└── README.md          # Documentation and execution instructions
```

---

## How to Compile and Run

From the root repository directory (`/Users/ankitrajjha/java-Assign`):

### 1. Compile
```bash
javac Assignment14/assignment14.java Assignment14/Main.java
```

### 2. Run
```bash
java Assignment14.assignment14
```
*(or alternatively)*
```bash
java Assignment14.Main
```
