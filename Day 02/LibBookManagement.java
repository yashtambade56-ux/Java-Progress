import java.util.Scanner;

public class LibBookManagement {

    public static void main(String[] args) {

        Scanner lib = new Scanner(System.in);

        System.out.print("Enter Book Name: ");
        String book = lib.nextLine();

        System.out.print("Enter Author Name: ");
        String author = lib.nextLine();

        System.out.print("Enter Date: ");
        String date = lib.nextLine();

        System.out.println("\n--- Book Details ---");
        System.out.println("Book Name: " + book);
        System.out.println("Author Name: " + author);
        System.out.println("Date: " + date);

        lib.close();
    }
}