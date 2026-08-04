import java.util.Scanner;
public class StudentPercentage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Html: ");
        int Html = sc.nextInt();

        System.out.print("Css: ");
        int Css = sc.nextInt();

        System.out.print("JavaScript: ");
        int JavaScript = sc.nextInt();

        System.out.print("Reactjs: ");
        int Reactjs = sc.nextInt();
        
        int total = Html + Css + JavaScript + Reactjs;
        double percentage = total / 5.0;

        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage + "%");

        sc.close();
    }
    
}
