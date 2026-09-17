# Assignment 10: Student Course Enrollment Manager

## Overview
The **Student Course Enrollment Manager** is a Java application developed for **Unit 6: Collections Framework in Java**. It demonstrates practical usage of `ArrayList` and `LinkedList` implementing the `List` and `Deque` interfaces to handle course admissions and a waiting queue.

---

## Key Java Collections & Methods Demonstrated

| Menu Option | Collection & Method | Description |
|---|---|---|
| **1. Add Student to Enrollment List** | `ArrayList.add()` | Directly enrolls a student into the confirmed list. |
| **2. Display Enrolled Students** | `ArrayList` (for-each) | Iterates over confirmed enrollments. |
| **3. Add Student to Waiting Queue** | `LinkedList.addLast()` | Adds student to the end of the waiting queue. |
| **4. Promote Student from Queue** | `LinkedList.removeFirst()` & `ArrayList.add()` | Moves the first student in line into the enrollment list. |
| **5. Search Student in Enrollment List** | `ArrayList.contains()`, `indexOf()` | Searches for a student name and reports their 0-based index. |
| **6. Remove Student from Enrollment List** | `ArrayList.remove()` | Removes a student from confirmed enrollment. |
| **7. Display Waiting Queue** | `LinkedList` & `Iterator` | Traverses waiting students in order using an `Iterator`. |
| **8. Exit** | Loop control | Terminates the application. |

---

## File Structure

```
Assignment10/
├── Assignment10.java  # Core Collections Framework implementation
├── Main.java          # Driver entry point delegating to Assignment10.main
└── README.md          # Documentation and execution guide
```

---

## How to Compile & Run

```bash
# Compile
javac Assignment10/Assignment10.java Assignment10/Main.java

# Run
java Assignment10.Assignment10
```
