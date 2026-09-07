import java.util.Scanner;

public class Assignment3 {

    static int total(int[] ratings) {
        int sum = 0;

        for (int r : ratings) {
            sum += r;
        }

        return sum;
    }

    static double average(int[] ratings) {
        return (double) total(ratings) / ratings.length;
    }

    static void search(int[][] ratings, String[] partners, int key) {
        boolean found = false;

        for (int i = 0; i < ratings.length; i++) {
            for (int j = 0; j < ratings[i].length; j++) {

                if (ratings[i][j] == key) {
                    System.out.println("Rating " + key + " found for " + partners[i]);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Rating not found.");
        }
    }

    public static void main(String[] args) {

        String[] partners = {
            "Partner 1", "Partner 2", "Partner 3",
            "Partner 4", "Partner 5"
        };

        int[][] ratings = {
            {5, 4, 5, 4},
            {4, 5, 4, 5},
            {3, 4, 3, 4},
            {5, 5, 5, 5},
            {4, 3, 4, 3}
        };

        // Display total and average rating
        for (int i = 0; i < ratings.length; i++) {

            int total = total(ratings[i]);
            double avg = average(ratings[i]);

            System.out.printf(
                "%s: Total Rating = %d, Average = %.2f%n",
                partners[i], total, avg
            );
        }

        // Search rating
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter rating to search: ");
        int key = sc.nextInt();

        search(ratings, partners, key);

        sc.close();
    }
}
