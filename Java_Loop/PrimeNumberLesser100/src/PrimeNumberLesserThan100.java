public class PrimeNumberLesserThan100 {
    public static void main(String[] args) {
        int N = 2;
        while (N < 100) {
            if (checkPrime(N)) {
                System.out.print(N + " ");
            }
            N++;
        }
    }

    public static boolean checkPrime(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            return true;
        } else {
            return false;
        }
    }
}
