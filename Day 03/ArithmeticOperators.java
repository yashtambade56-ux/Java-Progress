public class ArithmeticOperators {
    public static void main(String[] args) {

        int pizza = 480;
        int pasta = 290;

        int total = pizza + pasta;
        int difference = pizza - pasta;
        int multiply = pizza * pasta;
        int average = total / 2;
        int remainder = total % 100;

        System.out.println("Total: " + total);
        System.out.println("Difference: " + difference);
        System.out.println("Multiply: " + multiply);
        System.out.println("Average: " + average);
        System.out.println("Remaining after 100: " + remainder);
    }
}