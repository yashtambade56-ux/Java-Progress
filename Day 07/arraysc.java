import java.util.Scanner;

public class arraysc {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        int n = sc.nextInt();

        int[] number = new int[n];

        System.out.println("Enter elements");

        for (int i = 0; i < n; i++) {
            number[i] = sc.nextInt();
        }

        System.out.println("Array elements");

        for (int i = 0; i < n; i++) {
            System.out.println(number[i]);
        }
    }
}