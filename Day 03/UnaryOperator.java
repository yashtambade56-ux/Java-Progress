public class UnaryOperator {
    public static void main(String args[])
    {
        int visitors = 250;

        visitors++;  // post increments

        System.out.println("After New Entry =" +visitors);

        visitors--; // post decrement

        System.out.println("After Exit =" +visitors);
}
}