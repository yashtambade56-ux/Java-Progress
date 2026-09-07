import java.util.Scanner;

public class Assignment4 {

    public static void displayAllMarks(int[][] marks, String[] students, String[] subjects) {
        System.out.println("\n--- All Student Marks ---");
        System.out.printf("%-12s", "Student");
        for (String subject : subjects) {
            System.out.printf("%-10s", subject);
        }
        System.out.println();
        System.out.println("----------------------------------------");

        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%-12s", students[i]);
            for (int j = 0; j < marks[i].length; j++) {
                System.out.printf("%-10d", marks[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] calculateTotals(int[][] marks) {
        int[] totals = new int[marks.length];
        for (int i = 0; i < marks.length; i++) {
            int sum = 0;
            for (int j = 0; j < marks[i].length; j++) {
                sum += marks[i][j];
            }
            totals[i] = sum;
        }
        return totals;
    }

    public static void displayStudentTotals(int[] totals, String[] students) {
        System.out.println("\n--- Student Total Marks ---");
        for (int i = 0; i < totals.length; i++) {
            System.out.printf("%-12s Total   : %d%n", students[i], totals[i]);
        }
    }

    public static void displayStudentAverages(int[] totals, int numSubjects, String[] students) {
        System.out.println("\n--- Student Average Marks ---");
        for (int i = 0; i < totals.length; i++) {
            double average = (double) totals[i] / numSubjects;
            System.out.printf("%-12s Average : %.2f%n", students[i], average);
        }
    }
    public static void displayHighestScores(int[][] marks, int[] totals, String[] students, String[] subjects) {
        System.out.println("\n--- Highest Marks Analysis ---");

        for (int j = 0; j < subjects.length; j++) {
            int highestSubjectMark = marks[0][j];
            int topStudentIndex = 0;
            for (int i = 1; i < marks.length; i++) {
                if (marks[i][j] > highestSubjectMark) {
                    highestSubjectMark = marks[i][j];
                    topStudentIndex = i;
                }
            }
            System.out.printf("Highest %-7s Marks : %d (%s)%n", subjects[j], highestSubjectMark, students[topStudentIndex]);
        }

        int maxTotal = totals[0];
        int topStudentIdx = 0;
        for (int i = 1; i < totals.length; i++) {
            if (totals[i] > maxTotal) {
                maxTotal = totals[i];
                topStudentIdx = i;
            }
        }
        System.out.println();
        System.out.println("Highest Scorer: " + students[topStudentIdx] + " (Total: " + maxTotal + ")");
    }

    public static void searchMark(int[][] marks, int target, String[] students, String[] subjects) {
        boolean found = false;
        System.out.println("\n--- Linear Search Results for Mark: " + target + " ---");
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                if (marks[i][j] == target) {
                    System.out.println("Found " + target + " scored by " + students[i] + " in " + subjects[j]);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Mark " + target + " was not found in any student's records.");
        }
    }

    public static void bubbleSortTotals(int[] totals, String[] students) {
        int n = totals.length;
        int[] sortedTotals = totals.clone();
        String[] sortedStudents = students.clone();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedTotals[j] < sortedTotals[j + 1]) {
                    int tempTotal = sortedTotals[j];
                    sortedTotals[j] = sortedTotals[j + 1];
                    sortedTotals[j + 1] = tempTotal;
                    String tempStudent = sortedStudents[j];
                    sortedStudents[j] = sortedStudents[j + 1];
                    sortedStudents[j + 1] = tempStudent;
                }
            }
        }

        System.out.println("\n--- Sorted Student Totals (Highest to Lowest) ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("Rank %d: %-12s | Total: %d%n", (i + 1), sortedStudents[i], sortedTotals[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] students = {"Student 1", "Student 2", "Student 3", "Student 4", "Student 5"};
        String[] subjects = {"Java", "Python", "DBMS"};

        int[][] marks = {
            {78, 82, 75}, // Student 1
            {90, 85, 88}, // Student 2
            {65, 72, 70}, // Student 3
            {88, 91, 85}, // Student 4
            {55, 60, 58}  // Student 5
        };

        int[] totals = calculateTotals(marks);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n===== Student Marks Management System =====");
            System.out.println("1. Display All Marks");
            System.out.println("2. Calculate Student Total");
            System.out.println("3. Calculate Student Average");
            System.out.println("4. Find Highest Scorer & Subject-Wise Highest");
            System.out.println("5. Search Marks (Linear Search)");
            System.out.println("6. Sort Student Totals (Bubble Sort)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 7.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAllMarks(marks, students, subjects);
                    break;

                case 2:
                    displayStudentTotals(totals, students);
                    break;

                case 3:
                    displayStudentAverages(totals, subjects.length, students);
                    break;

                case 4:
                    displayHighestScores(marks, totals, students, subjects);
                    break;

                case 5:
                    System.out.print("Enter marks to search: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid marks input! Please enter an integer.");
                        scanner.next();
                        continue;
                    }
                    int searchTarget = scanner.nextInt();
                    searchMark(marks, searchTarget, students, subjects);
                    break;

                case 6:
                    bubbleSortTotals(totals, students);
                    break;

                case 7:
                    System.out.println("Exiting Student Marks Management System. Goodbye!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select an option between 1 and 7.");
                    continue;
            }
        }

        scanner.close();
    }
}
