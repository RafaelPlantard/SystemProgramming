public class PrimeNumbers {
    public static void main(String[] args) {
        int lower = 2;
        int upper = 500;

        for (int i = lower; i < upper; i++) {
            int multiples = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    multiples++;
                }
            }

            if (multiples == 2) {
                System.out.println(i);
            }
        }
    }
}