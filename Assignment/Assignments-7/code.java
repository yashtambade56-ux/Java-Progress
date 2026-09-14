package Assignment7;

import java.util.Scanner;

public class Ecommerce_coupon_validator {

    static class InvalidCouponException extends Exception {
        InvalidCouponException(String message) {
            super(message);
        }
    }

    static void validate(double amount, String code)
            throws InvalidCouponException {

        double discount;

        if (code.equals("SAVE10") && amount >= 1000)
            discount = amount * 0.10;
        else if (code.equals("SAVE20") && amount >= 2000)
            discount = amount * 0.20;
        else if (code.equals("SAVE30") && amount >= 3000)
            discount = amount * 0.30;
        else
            throw new InvalidCouponException("Invalid coupon or minimum order not met.");

        System.out.println("Discount: ₹" + discount);
        System.out.println("Final amount: ₹" + (amount - discount));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter order amount: ");
            double amount = sc.nextDouble();

            System.out.print("Enter coupon code: ");
            String code = sc.next();

            try {
                validate(amount, code);
            } catch (InvalidCouponException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Coupon validation completed.");
            }

            System.out.print("Continue? (yes/no): ");
            if (sc.next().equalsIgnoreCase("no"))
                break;
        }

        sc.close();
    }
}
