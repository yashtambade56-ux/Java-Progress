import java.util.Scanner;

public class Employee {

    public static void main(String[] args) {

        Scanner emp = new Scanner(System.in);

        // Employee Details
        System.out.print("Enter Employee ID: ");
        int id = emp.nextInt();

        emp.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = emp.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = emp.nextDouble();

        System.out.print("Enter Employee Experience (in years): ");
        double experience = emp.nextDouble();

        emp.nextLine();

        System.out.print("Enter Date of Joining: ");
        String joiningDate = emp.nextLine();

        // Display Employee Details
        System.out.println("\n----- Employee Details -----");
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: $" + salary);
        System.out.println("Employee Experience: " + experience + " years");
        System.out.println("Date of Joining: " + joiningDate);

        emp.close();
    }
}