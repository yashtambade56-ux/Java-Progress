// Student Academic Profile System

// Develop a Java application that stores student information and calculates:
// Total Marks
// Percentage
// Grade
// Pass/Fail Status

import java.util.Scanner;

public class Assignment1 {

    public static void main(String[] args) {

        Scanner a1 = new Scanner(System.in);

        // Student Details
        System.out.print("Enter Student Name: ");
        String student = a1.nextLine();

        System.out.print("Enter Student Roll no: ");
        String roll = a1.nextLine();

        // Marks of all subjects
        System.out.print("Enter Marks of Subject 1: ");
        int s1 = a1.nextInt();

        System.out.print("Enter Marks of Subject 2: ");
        int s2 = a1.nextInt();

        System.out.print("Enter Marks of Subject 3: ");
        int s3 = a1.nextInt();

        System.out.print("Enter Marks of Subject 4: ");
        int s4 = a1.nextInt();

        System.out.print("Enter Marks of Subject 5: ");
        int s5 = a1.nextInt();

        // Calculate total marks
        int total = s1 + s2 + s3 + s4 + s5;

        // Calculate percentage
        double percentage = total / 5.0;

        // Calculate grade
        char grade;

        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else if (percentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // Pass / Fail
        String status;

        if (percentage >= 40) {
            status = "PASS";
        } else {
            status = "FAIL";
        }

        // Display student profile
        System.out.println("\n----- Student Academic Profile -----");
        System.out.println("Student Name: " + student);
        System.out.println("Roll No: " + roll);
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Status: " + status);

        a1.close();
    }
}