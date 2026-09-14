import java.util.Scanner;

class InvalidCouponException extends Exception {
    public InvalidCouponException(String message) {
        super(message);
    }
}

public class CouponValidator {


    public static void validateCoupon(String code, double amount) throws InvalidCouponException {
        switch (code) {
            case "SAVE10":
                if (amount < 1000) {
                    throw new InvalidCouponException("Order amount does not meet the minimum requirement for SAVE10.");
                }
                break;
            case "SAVE20":
                if (amount < 2000) {
                    throw new InvalidCouponException("Order amount does not meet the minimum requirement for SAVE20.");
                }
                break;
            case "SAVE30":
                if (amount < 3000) {
                    throw new InvalidCouponException("Order amount does not meet the minimum requirement for SAVE30.");
                }
                break;
            default:
                throw new InvalidCouponException("Invalid coupon code entered.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== E-Commerce Coupon Validator =====");
        System.out.print("Order Amount : ₹");
        double orderAmount = scanner.nextDouble();

        System.out.print("Coupon Code  : ");
        String couponCode = scanner.next();

        try {
            validateCoupon(couponCode, orderAmount);

     
            double discountPercentage = 0;
            if (couponCode.equals("SAVE10"))
                discountPercentage = 0.10;
            else if (couponCode.equals("SAVE20"))
                discountPercentage = 0.20;
            else if (couponCode.equals("SAVE30"))
                discountPercentage = 0.30;

            double discountAmount = orderAmount * discountPercentage;
            double finalAmount = orderAmount - discountAmount;

            System.out.println("\nCoupon applied successfully.");
            System.out.printf("\nDiscount Amount      : ₹%.2f", discountAmount);
            System.out.printf("\nFinal Payable Amount : ₹%.2f\n", finalAmount);

        } catch (InvalidCouponException e) {
            System.out.println("\nError: " + e.getMessage());
        } finally {
            System.out.println("\nCoupon validation completed.");
        }

        scanner.close();
    }
}
