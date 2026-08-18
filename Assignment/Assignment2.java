import java.util.Scanner;

public class Assignment2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter attendance: ");
        int attendance = sc.nextInt();

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        while (true) {

            System.out.println("\n1. Eligibility");
            System.out.println("2. Performance");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice");
                continue;
            }

            switch (choice) {

                case 1:
                    if (attendance >= 75) {
                        if (marks >= 40)
                            System.out.println("Eligible");
                        else
                            System.out.println("Not Eligible");
                    } else {
                        System.out.println("Not Eligible");
                    }
                    break;

                case 2:
                    if (marks >= 75)
                        System.out.println("Good");
                    else if (marks >= 60)
                        System.out.println("Average");
                    else
                        System.out.println("poor");
                    break;

                case 3:
                    System.out.println("Exit");
                    break;
            }

            if (choice == 3)
                break;
        }
    }
}