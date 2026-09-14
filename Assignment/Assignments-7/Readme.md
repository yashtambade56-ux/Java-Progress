# Assignment 7: E-commerce Coupon Validator

## Overview

The **E-commerce Coupon Validator** is a Java application designed to demonstrate **custom exception handling** and **conditional business logic**. It validates discount coupons, checks minimum order requirements, calculates discounts, and displays the final payable amount.

If the coupon is invalid or the minimum order amount is not met, the program throws a custom checked exception called **`InvalidCouponException`**.

---

## Concepts Covered

- Custom Exception Handling
- Creating Custom Exceptions using `Exception`
- Throwing Exceptions using `throw`
- Exception Propagation using `throws`
- Error Handling using `try-catch-finally`
- Conditional Statements
- User Input using `Scanner`
- Loops for multiple transactions

---

## Coupon Rules & Discounts

| Coupon Code | Minimum Order Amount | Discount Rate | Description |
| :--- | :---: | :---: | :--- |
| **`SAVE10`** | ₹1,000 | 10% | 10% discount on orders of ₹1,000 or more |
| **`SAVE20`** | ₹2,000 | 20% | 20% discount on orders of ₹2,000 or more |
| **`SAVE30`** | ₹3,000 | 30% | 30% discount on orders of ₹3,000 or more |
| **Invalid / Below Minimum** | — | 0% | Throws `InvalidCouponException` |

---

## Code Structure

- **Package:** `Assignment7`
- **Class:** `Ecommerce_coupon_validator`
- **Custom Exception:** `InvalidCouponException extends Exception`

---

Valid output :-

<img width="288" height="140" alt="Image" src="https://github.com/user-attachments/assets/9c40cd7f-5b10-4cd2-8317-01366fa76611" />

--

Invalid output :-

<img width="337" height="120" alt="Image" src="https://github.com/user-attachments/assets/bfa7c916-f844-4f47-b02e-5315f6d21a8e" />

---

## Sample Console Interaction

### Valid Coupon

```text
Enter order amount: 1500
Enter coupon code: SAVE10
Discount: ₹150.0
Final amount: ₹1350.0
Coupon validation completed.
Continue? (yes/no): yes
