# Assignment 8: Smart Cab Booking System

## Overview

The **Smart Cab Booking System** is a Java console application developed to demonstrate **Packages and Advanced OOP Concepts**.

The application accepts passenger details such as name, cab type, base fare, and pickup location. It calculates the final fare by adding a fixed booking fee and displays a formatted booking summary.

The project demonstrates concepts such as **user-defined packages, enums, wrapper classes, autoboxing, unboxing, final variables, StringBuilder, member inner classes, and anonymous classes**.

---

## Concepts Covered

### User-Defined Packages

The project uses a user-defined package:

```text
Assignment8.cab.booking
```

The `CabBooking` class is imported into the main driver class.

---

### Enums

The `CabType` enum represents different types of cabs:

* `MINI`
* `SEDAN`
* `SUV`

```java
public enum CabType {
    MINI, SEDAN, SUV
}
```

---

### Wrapper Classes

The program uses wrapper classes instead of primitive data types.

* `Integer` → Passenger ID
* `Double` → Base Fare
* `Double` → Booking Fee
* `Double` → Final Fare

---

### Autoboxing & Unboxing

**Autoboxing** converts primitive values into wrapper objects.

```java
int rawId = 101;
Integer passengerId = rawId;
```

```java
double rawFare = 500;
Double baseFare = rawFare;
```

**Unboxing** converts wrapper objects into primitive values.

```java
double unboxedFare = baseFare;
```

---

### Final Variable

The booking fee is declared as `final`, which means it cannot be changed after initialization.

```java
private final Double bookingFee;
```

The fixed booking fee is:

```text
₹50
```

---

### StringBuilder

The application uses `StringBuilder` to create the booking summary.

```java
StringBuilder sb = new StringBuilder();
```

The `append()` method is used to add booking details efficiently.

---

### Member Inner Class

The `PickupLocation` class is a member inner class inside `CabBooking`.

It stores the passenger's pickup location.

```java
CabBooking.PickupLocation pickup =
        booking.new PickupLocation(location);
```

---

### Anonymous Class

The application uses an anonymous class to implement the `BookingConfirmation` interface.

```java
BookingConfirmation confirmation = new BookingConfirmation() {
    @Override
    public void confirm() {
        System.out.println("Booking confirmed successfully.");
    }
};
```

---

## Code Structure

```text
Assignment8/
│
├── cab/
│   └── booking/
│       └── CabBooking.java
│
├── Main.java
│
└── README.md
```

### Files

* **`Main.java`**

  * Driver class.
  * Accepts user input.
  * Demonstrates autoboxing and unboxing.
  * Creates the `CabBooking` object.
  * Instantiates the inner class.
  * Uses an anonymous class for booking confirmation.

* **`CabBooking.java`**

  * Contains the main booking logic.
  * Contains the `CabType` enum.
  * Contains the `BookingConfirmation` interface.
  * Contains the `PickupLocation` member inner class.
  * Uses wrapper classes and a final variable.
  * Builds the booking summary using `StringBuilder`.

---

## Cab Types

| Cab Type  | Description                            |
| :-------- | :------------------------------------- |
| **MINI**  | Small and economical cab               |
| **SEDAN** | Comfortable standard cab               |
| **SUV**   | Large cab suitable for more passengers |

---

## Fare Calculation

The final fare is calculated using:

```text
Final Fare = Base Fare + Booking Fee
```

### Example

```text
Base Fare: ₹500
Booking Fee: ₹50

Final Fare: ₹550
```

---

## Sample Console Interaction

```text
Enter Passenger Name: Apeksha
Enter Cab Type (MINI, SEDAN, SUV): SEDAN
Enter Base Fare: 500
Enter Pickup Location: Mumbai

===== Smart Cab Booking System =====
Passenger Name: Apeksha
Cab Type: SEDAN
Base Fare: ₹500
Booking Fee: ₹50
Final Fare: ₹550
Pickup Location: Mumbai
Booking confirmed successfully.
```

---

## Program Flow

1. The user enters the passenger name.
2. The user selects a cab type.
3. The user enters the base fare.
4. The user enters the pickup location.
5. The program demonstrates autoboxing using `Integer` and `Double`.
6. The program validates that the fare is not negative.
7. A `CabBooking` object is created.
8. The `PickupLocation` inner class is instantiated.
9. The booking summary is created using `StringBuilder`.
10. The final fare is displayed.
11. An anonymous class confirms the booking.

---

## How to Compile & Run

### From the Root Workspace Directory

```bash
# Compile
javac Assignment8/cab/booking/CabBooking.java Assignment8/Main.java

# Run
java Assignment8.Main
```

---

## Learning Outcomes

After completing this assignment, you will understand:

* How to create and use user-defined packages.
* How to import classes from another package.
* How to use enums in Java.
* How wrapper classes work.
* The difference between autoboxing and unboxing.
* How to use `final` variables.
* How to use `StringBuilder`.
* How to create member inner classes.
* How to create and use anonymous classes.
* How to organize a Java project using multiple files and packages.
