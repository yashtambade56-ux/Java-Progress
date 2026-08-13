public class download {
    
    public static void main(String[] args) {
        
        int progress = 20;
        while (progress <= 100) {

            System.out.println("Download:" + progress + "%");

            progress = progress + 20;
        }
    }
}
