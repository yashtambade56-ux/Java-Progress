import java.util.Scanner;

class Vehicle {
    String vehicleNumber;
    String model;
    String customerName;
    int rentDays;

    Vehicle(String vehicleNumber, String model, String customerName, int rentDays) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.customerName = customerName;
        this.rentDays = rentDays;
    }

    void displayDetails() {
        System.out.println("Vehicle No: " + vehicleNumber);
        System.out.println("Model: " + model);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Rent Days: " + rentDays);
    }
}

class Car extends Vehicle {
    Car(String vehicleNumber, String model, String customerName, int rentDays) {
        super(vehicleNumber, model, customerName, rentDays);
    }

    int calculateRent() {
        return rentDays * 1500;
    }
}

class Bike extends Vehicle {
    Bike(String vehicleNumber, String model, String customerName, int rentDays) {
        super(vehicleNumber, model, customerName, rentDays);
    }

    int calculateRent() {
        return rentDays * 700;
    }
}

class Scooter extends Vehicle {
    Scooter(String vehicleNumber, String model, String customerName, int rentDays) {
        super(vehicleNumber, model, customerName, rentDays);
    }

    int calculateRent() {
        return rentDays * 500;
    }
}

class ElectricCar extends Vehicle {
    int batteryCapacity;

    ElectricCar(String vehicleNumber, String model, String customerName, int rentDays, int batteryCapacity) {
        super(vehicleNumber, model, customerName, rentDays);
        this.batteryCapacity = batteryCapacity;
    }

    int calculateRent() {
        return rentDays * 2000;
    }

    void displayElectricCarDetails() {
        displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

public class Assignment6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Vehicle vehicle = null;
        int choice;

        while (true) {

            System.out.println("\n===== Vehicle Rental System =====");
            System.out.println("1. Rent Car");
            System.out.println("2. Rent Bike");
            System.out.println("3. Rent Scooter");
            System.out.println("4. Rent Electric Car");
            System.out.println("5. Display Vehicle Details");
            System.out.println("6. Calculate Rental Charges");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice >= 1 && choice <= 4) {

                System.out.print("Enter Vehicle Number: ");
                String number = sc.nextLine();

                System.out.print("Enter Model: ");
                String model = sc.nextLine();

                System.out.print("Enter Customer Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Rent Days: ");
                int days = sc.nextInt();

                if (choice == 1) {
                    vehicle = new Car(number, model, name, days);
                } 
                else if (choice == 2) {
                    vehicle = new Bike(number, model, name, days);
                } 
                else if (choice == 3) {
                    vehicle = new Scooter(number, model, name, days);
                } 
                else {
                    System.out.print("Enter Battery Capacity: ");
                    int battery = sc.nextInt();
                    vehicle = new ElectricCar(number, model, name, days, battery);
                }

                System.out.println("Vehicle rented successfully!");
            }

            else if (choice == 5) {

                if (vehicle == null) {
                    System.out.println("No vehicle rented.");
                } 
                else if (vehicle instanceof ElectricCar) {
                    ((ElectricCar) vehicle).displayElectricCarDetails();
                } 
                else {
                    vehicle.displayDetails();
                }
            }

            else if (choice == 6) {

                if (vehicle == null) {
                    System.out.println("No vehicle rented.");
                } 
                else if (vehicle instanceof Car) {
                    System.out.println("Total Rent: ₹" + ((Car) vehicle).calculateRent());
                } 
                else if (vehicle instanceof Bike) {
                    System.out.println("Total Rent: ₹" + ((Bike) vehicle).calculateRent());
                } 
                else if (vehicle instanceof Scooter) {
                    System.out.println("Total Rent: ₹" + ((Scooter) vehicle).calculateRent());
                } 
                else if (vehicle instanceof ElectricCar) {
                    System.out.println("Total Rent: ₹" + ((ElectricCar) vehicle).calculateRent());
                }
            }

            else if (choice == 7) {
                System.out.println("Exiting...");
                break;
            }

            else {
                System.out.println("Invalid Choice");
            }
        }

        sc.close();
    }
}
