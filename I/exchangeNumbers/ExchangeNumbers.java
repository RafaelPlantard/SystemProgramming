public class ExchangeNumbers {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int c;

        System.out.println("A is: " + a);
        System.out.println("B is: " + b);

        System.out.println("Exchanging A to B...");

        c = a;
        a = b;
        b = c;

        System.out.println("A is: " + a);
        System.out.println("B is: " + b);
    }
}