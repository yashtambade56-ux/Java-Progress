import java.util.Scanner;

public class Assignment1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll No: ");
        String rollNo = sc.nextLine();

        System.out.print("Enter Year: ");
        String year = sc.nextLine();

        System.out.print("\nEnter First Number: ");
        double firstNumber = sc.nextDouble();

        System.out.print("Enter Second Number: ");
        double secondNumber = sc.nextDouble();


        double addition = firstNumber + secondNumber;
        double subtraction = firstNumber - secondNumber;
        double multiplication = firstNumber * secondNumber;
        double division = firstNumber / secondNumber;


        System.out.println("\n----- Student Profile -----");

        System.out.println("Name    : " + name);
        System.out.println("Roll No : " + rollNo);
        System.out.println("Year    : " + year);


        System.out.println("\n----- Basic Calculator -----");

        System.out.println("First Number  : " + firstNumber);
        System.out.println("Second Number : " + secondNumber);

        System.out.println("\nAddition       : " + addition);
        System.out.println("Subtraction    : " + subtraction);
        System.out.println("Multiplication : " + multiplication);

        if (secondNumber != 0) {
            System.out.println("Division       : " + division);
        } else {
            System.out.println("Division       : Cannot divide by zero");
        }

        sc.close();
    }
}
