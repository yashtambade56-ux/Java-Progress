public class FindStudent {

    public static void main(String[] args) {

        int targetRollNo = 104;

        for (int rollNo = 101; rollNo <= 110; rollNo++) {

            System.out.println("Checking Roll No " + rollNo);

            if (rollNo == targetRollNo) {
                System.out.println("Student Found");
                break;
            }
        }
    }
}