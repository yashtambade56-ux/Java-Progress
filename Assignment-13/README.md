# Assignment 13: Swing-Based Student Feedback Form

## Overview
The **Student Feedback Form** is a Java Swing GUI application developed for **Unit 8: GUI Programming with Swing**. It demonstrates core Swing concepts including frame layout managers (`BorderLayout`, `GridLayout`, and `FlowLayout`), event-driven architecture using `ActionListener`, hierarchical application menus (`JMenuBar`, `JMenu`, `JMenuItem`), and modal dialog boxes (`JOptionPane`) for confirmations, notifications, and error reporting.

---

## Key GUI Components & Swing Concepts Demonstrated

| Feature | Component / Class | Method / Pattern Demonstrated |
|---|---|---|
| **Window Structure** | `JFrame` | `BorderLayout` positioning form, feedback list, and buttons into distinct regions. |
| **Form Fields Arrangement** | `JPanel` | `GridLayout(4, 2)` arranging labels and text fields into neat rows and columns. |
| **Application Menu** | `JMenuBar`, `JMenu`, `JMenuItem` | Hierarchical menu bar with **File** (`Save Feedback`, `Clear Form`, `Exit`) and **Help** (`About`). |
| **Event Handling** | `ActionListener` | Shared listeners handling form submission from both the Submit button and the File menu. |
| **Clear Form Action** | `ActionListener` | Resets input text fields (`nameField`, `courseField`, `ratingField`, `commentsField`). |
| **Exit Confirmation** | `JOptionPane` | `showConfirmDialog()` displaying a modal Yes/No question before termination. |
| **About Information** | `JOptionPane` | `showMessageDialog()` displaying version, author, and purpose details. |
| **Input Validation** | `JOptionPane` & `try-catch` | Checks for empty required fields and handles `NumberFormatException` for non-numeric ratings. |
| **Feedback Display** | `JTextArea` + `JScrollPane` | Non-editable multi-line text area displaying submitted records. |

---

## File Structure

```
Assignment13/
├── assignment13.java  # Core Swing GUI form, layout, and event handlers
├── Main.java          # Driver entry point delegating to assignment13.main
└── README.md          # Documentation and execution instructions
```

---

## How to Compile & Run

From the root repository directory (`/Users/ankitrajjha/java-Assign`):

### 1. Compile
```bash
javac Assignment13/assignment13.java Assignment13/Main.java
```

### 2. Run
```bash
java Assignment13.assignment13
```
*(or alternatively)*
```bash
java Assignment13.Main
```

---

## Form Validation & Behavior

1. **Empty Name or Course Check**:
   - Displays an error dialog: `"Name field cannot be empty!"` / `"Course field cannot be empty!"`.
2. **Numeric Rating Validation**:
   - Enforces integer values between `1` and `5` using a `try-catch` block capturing `NumberFormatException`.
3. **Exit Confirmation**:
   - Intercepts exit requests with a confirmation dialog (`JOptionPane.YES_NO_OPTION`).
