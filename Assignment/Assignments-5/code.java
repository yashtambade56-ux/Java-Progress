import java.util.Scanner;

class Room {
    private int roomNumber;
    private String roomType;
    private String customerName;
    private int numberOfDays;
    private double pricePerDay;
    private boolean isBooked;

    private static int totalBookings = 0;

    public Room(int roomNumber, String roomType, double pricePerDay) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerDay = pricePerDay;
        this.customerName = "None";
        this.numberOfDays = 0;
        this.isBooked = false;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumberOfDays() {
        return this.numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getPricePerDay() {
        return this.pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isBooked() {
        return this.isBooked;
    }

    public void setBooked(boolean booked) {
        this.isBooked = booked;
    }

    public static int getTotalBookings() {
        return totalBookings;
    }

    public boolean bookRoom(String customerName, int numberOfDays) {
        if (this.isBooked) {
            System.out.println("Room " + this.roomNumber + " is already booked!");
            return false;
        }
        this.customerName = customerName;
        this.numberOfDays = numberOfDays;
        this.isBooked = true;
        totalBookings++;

        System.out.println("\n===== Booking Confirmation =====");
        System.out.println("Room Number   : " + this.roomNumber);
        System.out.println("Room Type     : " + this.roomType);
        System.out.println("Customer Name : " + this.customerName);
        System.out.println("Number of Days: " + this.numberOfDays);
        System.out.println("Price Per Day : ₹" + (int) this.pricePerDay);
        System.out.println();
        System.out.println("Total Bill    : ₹" + (int) calculateBill());
        System.out.println("Room booked successfully.");
        return true;
    }

    public double calculateBill() {
        return this.numberOfDays * this.pricePerDay;
    }

    public void displayRoomDetails() {
        System.out.println("\n--- Room Details ---");
        System.out.println("Room Number   : " + this.roomNumber);
        System.out.println("Room Type     : " + this.roomType);
        System.out.println("Price Per Day : ₹" + (int) this.pricePerDay);
        System.out.println("Status        : " + (this.isBooked ? "Booked" : "Available"));
        if (this.isBooked) {
            System.out.println("Customer Name : " + this.customerName);
            System.out.println("Days Booked   : " + this.numberOfDays);
            System.out.println("Total Bill    : ₹" + (int) calculateBill());
        }
    }

    public void checkStatus() {
        if (this.isBooked) {
            System.out.println("Room " + this.roomNumber + " (" + this.roomType + ") is currently BOOKED by " + this.customerName + ".");
        } else {
            System.out.println("Room " + this.roomNumber + " (" + this.roomType + ") is AVAILABLE for booking (₹" + (int) this.pricePerDay + "/day).");
        }
    }

    public boolean cancelBooking() {
        if (!this.isBooked) {
            System.out.println("Room " + this.roomNumber + " is not currently booked.");
            return false;
        }
        System.out.println("Booking for Room " + this.roomNumber + " (Customer: " + this.customerName + ") has been successfully CANCELLED.");
        this.customerName = "None";
        this.numberOfDays = 0;
        this.isBooked = false;
        if (totalBookings > 0) {
            totalBookings--;
        }
        return true;
    }
}

public class Assignments5 {

    // Helper method to find room by room number
    private static Room findRoom(Room[] rooms, int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Room[] rooms = {
            new Room(101, "Standard", 2000),
            new Room(102, "Standard", 2000),
            new Room(201, "Deluxe", 3500),
            new Room(205, "Deluxe", 3500),
            new Room(301, "Premium", 5000)
        };

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n===== Hotel Room Booking System =====");
            System.out.println("1. Book Room");
            System.out.println("2. Display Room Details");
            System.out.println("3. Calculate Bill");
            System.out.println("4. Check Room Status");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Display Total Bookings");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 7.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Book Room
                    System.out.println("\nAvailable Room Types:");
                    System.out.println("- Standard (₹2000/day): Rooms 101, 102");
                    System.out.println("- Deluxe   (₹3500/day): Rooms 201, 205");
                    System.out.println("- Premium  (₹5000/day): Room 301");
                    System.out.print("Enter Room Number to book: ");
                    int bookRoomNum = scanner.nextInt();
                    Room bookRoom = findRoom(rooms, bookRoomNum);

                    if (bookRoom == null) {
                        System.out.println("Error: Room " + bookRoomNum + " does not exist.");
                        break;
                    }

                    if (bookRoom.isBooked()) {
                        System.out.println("Sorry, Room " + bookRoomNum + " is already booked.");
                        break;
                    }

                    System.out.print("Enter Customer Name: ");
                    scanner.nextLine(); // Clear newline
                    String name = scanner.nextLine().trim();

                    System.out.print("Enter Number of Days: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid number of days.");
                        scanner.next();
                        break;
                    }
                    int days = scanner.nextInt();

                    if (days <= 0) {
                        System.out.println("Error: Number of days must be at least 1.");
                        break;
                    }

                    bookRoom.bookRoom(name, days);
                    break;

                case 2: // Display Room Details
                    System.out.print("Enter Room Number (or 0 for all rooms): ");
                    int viewRoomNum = scanner.nextInt();
                    if (viewRoomNum == 0) {
                        for (Room r : rooms) {
                            r.displayRoomDetails();
                        }
                    } else {
                        Room r = findRoom(rooms, viewRoomNum);
                        if (r != null) {
                            r.displayRoomDetails();
                        } else {
                            System.out.println("Error: Room " + viewRoomNum + " does not exist.");
                        }
                    }
                    break;

                case 3: // Calculate Bill
                    System.out.print("Enter Room Number to calculate bill: ");
                    int billRoomNum = scanner.nextInt();
                    Room billRoom = findRoom(rooms, billRoomNum);
                    if (billRoom == null) {
                        System.out.println("Error: Room " + billRoomNum + " does not exist.");
                    } else if (!billRoom.isBooked()) {
                        System.out.println("Room " + billRoomNum + " is not currently booked. Bill is ₹0.");
                    } else {
                        System.out.println("Room " + billRoomNum + " (" + billRoom.getCustomerName() + ") Total Bill: ₹" + (int) billRoom.calculateBill());
                    }
                    break;

                case 4: // Check Room Status
                    System.out.println("\n--- Current Rooms Status ---");
                    for (Room r : rooms) {
                        r.checkStatus();
                    }
                    break;

                case 5: // Cancel Booking
                    System.out.print("Enter Room Number to cancel booking: ");
                    int cancelRoomNum = scanner.nextInt();
                    Room cancelRoom = findRoom(rooms, cancelRoomNum);
                    if (cancelRoom != null) {
                        cancelRoom.cancelBooking();
                    } else {
                        System.out.println("Error: Room " + cancelRoomNum + " does not exist.");
                    }
                    break;

                case 6: // Display Total Bookings (Static variable)
                    System.out.println("\nTotal active bookings across all rooms: " + Room.getTotalBookings());
                    break;

                case 7: // Exit
                    System.out.println("Thank you for using Hotel Room Booking System. Goodbye!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please choose an option between 1 and 7.");
                    continue;
            }
        }

        scanner.close();
    }
}
