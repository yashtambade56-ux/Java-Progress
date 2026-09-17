package Assignment10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Assignment10 {
    private static final ArrayList<String> enrolledStudents = new ArrayList<>();
    private static final LinkedList<String> waitingQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 8) {
            System.out.println("\n===== Student Course Enrollment Manager =====");
            System.out.println("1. Add Student to Enrollment List");
            System.out.println("2. Display Enrolled Students");
            System.out.println("3. Add Student to Waiting Queue");
            System.out.println("4. Promote Student from Queue");
            System.out.println("5. Search Student in Enrollment List");
            System.out.println("6. Remove Student from Enrollment List");
            System.out.println("7. Display Waiting Queue");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) continue;
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name to enroll: ");
                        String enrollName = scanner.nextLine().trim();
                        if (enrollName.isEmpty()) {
                            System.out.println("Error: Student name cannot be empty.");
                        } else {
                            enrolledStudents.add(enrollName);
                            System.out.println("Student enrolled successfully.");
                        }
                        break;

                    case 2:
                        if (enrolledStudents.isEmpty()) {
                            throw new NoSuchElementException("Enrollment list is empty.");
                        }
                        System.out.println("\n===== Enrolled Students (" + enrolledStudents.size() + ") =====");
                        int eIdx = 1;
                        for (String student : enrolledStudents) {
                            System.out.println(eIdx++ + ". " + student);
                        }
                        break;

                    case 3:
                        System.out.print("Enter student name for waiting queue: ");
                        String waitName = scanner.nextLine().trim();
                        if (waitName.isEmpty()) {
                            System.out.println("Error: Student name cannot be empty.");
                        } else {
                            waitingQueue.addLast(waitName);
                            System.out.println("Student added to waiting queue.");
                        }
                        break;

                    case 4:
                        if (waitingQueue.isEmpty()) {
                            throw new NoSuchElementException("Waiting queue is empty. No students to promote.");
                        }
                        System.out.println("Promoting first student from waiting queue...");
                        String promoted = waitingQueue.removeFirst();
                        enrolledStudents.add(promoted);
                        System.out.println(promoted + " moved to Enrollment List.");
                        break;

                    case 5:
                        if (enrolledStudents.isEmpty()) {
                            throw new NoSuchElementException("Enrollment list is empty.");
                        }
                        System.out.print("Enter student name to search: ");
                        String searchName = scanner.nextLine().trim();
                        if (enrolledStudents.contains(searchName)) {
                            int index = enrolledStudents.indexOf(searchName);
                            System.out.println("Student found at index: " + index);
                        } else {
                            System.out.println("Student '" + searchName + "' not found in enrollment list.");
                        }
                        break;

                    case 6:
                        if (enrolledStudents.isEmpty()) {
                            throw new NoSuchElementException("Enrollment list is empty. No students to remove.");
                        }
                        System.out.print("Enter student name to remove: ");
                        String removeName = scanner.nextLine().trim();
                        if (!enrolledStudents.contains(removeName)) {
                            throw new NoSuchElementException("Student '" + removeName + "' not found in enrollment list.");
                        }
                        enrolledStudents.remove(removeName);
                        System.out.println("Student '" + removeName + "' removed from enrollment list.");
                        break;

                    case 7:
                        if (waitingQueue.isEmpty()) {
                            throw new NoSuchElementException("Waiting queue is empty.");
                        }
                        System.out.println("\n===== Waiting Queue (" + waitingQueue.size() + ") =====");
                        int wIdx = 1;
                        Iterator<String> it = waitingQueue.iterator();
                        while (it.hasNext()) {
                            System.out.println(wIdx++ + ". " + it.next());
                        }
                        break;

                    case 8:
                        System.out.println("Exiting Student Course Enrollment Manager. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please select an option between 1 and 8.");
                }
            } catch (NoSuchElementException | IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid choice. Please enter a valid number.");
            }
        }
        scanner.close();
    }
}
