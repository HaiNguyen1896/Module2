import java.util.Scanner;

public class checkPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = sc.nextInt();
        if (number < 2) {
            System.out.println(number + " is not a Prime number");
        } else {
            if (isPrime(number)) {
                System.out.println(number + " is a Prime number");
            } else {
                System.out.println(number + " is not a Prime number");
            }
        }
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
