public class EventEntry {
    public static void main(String[] args) {

        boolean registered = true;
        int age = 20;

        if (registered) {
            if (age >= 18) {
                System.out.println("Entry allowed");
            } else {
                System.out.println("Age requirement not satisfied");
            }
        } else {
            System.out.println("Please complete registration");
        }
    }
}