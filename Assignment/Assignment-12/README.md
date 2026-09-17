# Assignment 12: Multi-Counter Ticket Booking Simulator

## Overview
The **Multi-Counter Ticket Booking Simulator** is a Java console application developed for **Unit 7: Multithreading in Java**. It simulates multiple ticket counters concurrently selling tickets from a shared ticket pool, demonstrating thread creation via `Thread` and `Runnable`, thread synchronization using `synchronized`, thread priority control (`setPriority`), lifecycle inspection (`isAlive`), and coordination using `join()`.

---

## Key Multithreading Concepts Demonstrated

| Menu Option | Multithreading Concept | Description |
|---|---|---|
| **1. Start Counter (Thread Class)** | `Thread` (`extends Thread`) | Creates a counter thread by subclassing `Thread` and overriding `run()`. |
| **2. Start Counter (Runnable Interface)** | `Runnable` interface | Creates a counter thread by implementing `Runnable` and passing to `Thread`. |
| **3. Set Thread Priority** | `Thread.setPriority()` | Adjusts thread scheduling priority between `Thread.MIN_PRIORITY` (1) and `Thread.MAX_PRIORITY` (10). |
| **4. Display Thread Status** | `getName()`, `getPriority()`, `isAlive()` | Inspects runtime state and attributes of counter threads. |
| **5. Display Available Tickets** | `synchronized` method | Reads ticket count safely from shared pool. |
| **6. Wait for All Counters to Finish** | `Thread.join()` | Blocks the main thread until background counters complete execution. |
| **7. Reset Ticket Pool** | State reset | Restores available tickets and resets thread references safely. |
| **8. Exit** | Program termination | Terminates the application. |

---

## File Structure

```
Assignment12/
├── Assignment12.java  # Core Multithreading simulation implementation
├── Main.java          # Driver entry point delegating to Assignment12.main
└── README.md          # Documentation and execution guide
```

---

## How to Compile & Run

```bash
# Compile
javac Assignment12/Assignment12.java Assignment12/Main.java

# Run
java Assignment12.Assignment12
```
