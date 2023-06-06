import java.util.Scanner;

public class Twenty_Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên tố cần in ra");
        int number = sc.nextInt();
        int count = 0;
        int N = 2;
        while (count < number) {
            if (checkPrime(N)) {
                count++;
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
