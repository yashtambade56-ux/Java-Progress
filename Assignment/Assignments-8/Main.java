package Assignment8;

import Assignment8.cab.booking.CabBooking;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Cab Type (MINI, SEDAN, SUV): ");
        String cabInput = sc.next().trim().toUpperCase();

        CabBooking.CabType cabType;

        try {
            cabType = CabBooking.CabType.valueOf(cabInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Cab Type!");
            sc.close();
            return;
        }

        System.out.print("Enter Base Fare: ");
        double rawFare = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Pickup Location: ");
        String location = sc.nextLine().trim();


        // Autoboxing
        int rawId = 101;
        Integer passengerId = rawId;

        Double baseFare = rawFare;


        // Unboxing
        double unboxedFare = baseFare;

        if (unboxedFare < 0) {
            System.out.println("Fare cannot be negative.");
            sc.close();
            return;
        }


        // Create Cab Booking
        CabBooking booking = new CabBooking(
                passengerId,
                name,
                cabType,
                baseFare
        );


        // Member Inner Class
        CabBooking.PickupLocation pickup =
                booking.new PickupLocation(location);

        booking.setPickupLocation(pickup);


        // Display Summary
        System.out.println();
        System.out.println(booking.buildSummary());


        // Anonymous Class
        CabBooking.BookingConfirmation confirmation =
                new CabBooking.BookingConfirmation() {

                    @Override
                    public void confirm() {
                        System.out.println(
                                "Booking confirmed successfully."
                        );
                    }
                };

        confirmation.confirm();

        sc.close();
    }
}