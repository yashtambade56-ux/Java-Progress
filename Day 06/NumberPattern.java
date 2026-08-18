public class NumberPattern {
    
    public static void main(String[] args) {
        
        for (int row = 1; row <= 5; row++) {
            for(int number = 1; number <= row; number++) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
