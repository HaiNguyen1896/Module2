import java.util.Scanner;

public class leap_year_calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year = sc.nextInt();
        boolean isLeapYear = false;
        boolean isDivisedBy4 = year % 4 == 0;
        if (isDivisedBy4) {
            boolean isDivisedBy100 = year % 100 == 0;
            if (isDivisedBy100) {
                boolean isDivisedBy400 = year % 400 == 0;
                if (isDivisedBy400) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
        if (isLeapYear) {
            System.out.printf("%d is a leap year", year);
        } else {
            System.out.printf("%d is not a leap year", year);
        }
    }
}
