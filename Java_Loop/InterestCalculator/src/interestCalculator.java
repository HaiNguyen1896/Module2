import java.util.Scanner;

public class interestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bank deposit money");
        double bankDeposit = sc.nextDouble();
        System.out.println("Enter interest rate in percentage");
        double interest = sc.nextDouble();
        System.out.println("Enter the number of Month");
        int month = sc.nextInt();
        double totalMoney = 0;
        for (int i = 0 ; i<month;i++){
            totalMoney += bankDeposit*(interest/100)/12;
        }
        System.out.println("Total of Interest= "+totalMoney);
    }
}
