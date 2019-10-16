public class PrimeNumbers {
    public static void main(String[] args) {
        int lower = 3;
        int upper = 499;

        System.out.println(2);

        for (int i = lower; i <= upper; i += 2) {
            boolean isPrime = true;

            for (int j = 3; j < i; j += 2) {
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