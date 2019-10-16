package evenoddnumbers;

/**
 * Show a list between 0 and 10 with even and odd numbers identified.
 * 
 * @author Rafael da Silva Ferreira <rafael@swift-yah.io>
 */
public class EvenOddNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            String type = "ímpar";
            
            if (i % 2 == 0) {
                type = "par";
            }
            
            System.out.println(i + " é " + type);
        }
    }
    
}
