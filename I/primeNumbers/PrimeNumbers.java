public class PrimeNumbers {
    public static void main(String[] args) {
        int lower = 2;
        int upper = 500;

        for (int i = lower; i < upper; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(i);
            }
        }
    }
}