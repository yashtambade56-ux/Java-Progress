public class OperatorAssociativity {
    public static void main(String[] args){
        int hours = 5;
        int rate = 40;

        int amount = hours * rate;

        boolean electricVehical = true;
        boolean member = false;

        boolean discount = electricVehical || member;

        System.out.println("Parking Amount = " + amount);
        System.out.println("Discount Available= " + discount);

        amount += 50;
        System.out.println("Total Amount = " + amount);
    }
}
