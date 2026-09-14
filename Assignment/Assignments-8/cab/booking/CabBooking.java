package Assignment8.cab.booking;

public class CabBooking {

    // Enum
    public enum CabType {
        MINI,
        SEDAN,
        SUV
    }


    // Interface for Anonymous Class
    public interface BookingConfirmation {
        void confirm();
    }


    // Member Inner Class
    public class PickupLocation {

        private String location;

        public PickupLocation(String location) {
            this.location = location;
        }

        public String getLocation() {
            return location;
        }
    }


    // Wrapper Classes
    private Integer passengerId;
    private String passengerName;
    private CabType cabType;
    private Double baseFare;

    // Final Variable
    private final Double bookingFee;

    private Double finalFare;

    private PickupLocation pickupLocation;


    // Constructor
    public CabBooking(
            Integer passengerId,
            String passengerName,
            CabType cabType,
            Double baseFare
    ) {

        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.cabType = cabType;
        this.baseFare = baseFare;

        // Fixed booking fee
        this.bookingFee = 50.0;

        // Unboxing + Autoboxing
        this.finalFare =
                this.baseFare + this.bookingFee;
    }


    // Set Pickup Location
    public void setPickupLocation(
            PickupLocation pickupLocation
    ) {
        this.pickupLocation = pickupLocation;
    }


    // StringBuilder Summary
    public String buildSummary() {

        StringBuilder sb = new StringBuilder();

        sb.append("===== Smart Cab Booking System =====\n");

        sb.append("Passenger Name: ")
                .append(passengerName)
                .append("\n");

        sb.append("Cab Type: ")
                .append(cabType)
                .append("\n");

        sb.append("Base Fare: ₹")
                .append(formatFare(baseFare))
                .append("\n");

        sb.append("Booking Fee: ₹")
                .append(formatFare(bookingFee))
                .append("\n");

        sb.append("Final Fare: ₹")
                .append(formatFare(finalFare))
                .append("\n");

        if (pickupLocation != null) {

            sb.append("Pickup Location: ")
                    .append(pickupLocation.getLocation());

        }

        return sb.toString();
    }


    // Format Fare
    private String formatFare(Double fare) {

        double value = fare;

        if (value == Math.floor(value)) {
            return String.valueOf((long) value);
        }

        return String.format("%.2f", value);
    }
}