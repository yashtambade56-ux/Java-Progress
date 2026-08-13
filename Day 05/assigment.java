import java.util.Scanner;

public class assigment {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Are you submitting your assignment (true/false): ");
        boolean a = sc.nextBoolean();

        if (a == true) {
            System.out.println("Damn bro, you completed your assignment!");
        } else {
            System.out.println("Oops, you lost your free marks!");
        }

        sc.close();
    }
}