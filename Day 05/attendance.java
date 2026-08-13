import java.util.Scanner;

public class attendance {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your attendenc % : ");
        int a = sc.nextInt();

        if (a <= 75) {
            System.out.println("you are not able to sit the exam");
        }
}
}
