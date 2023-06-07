import java.util.Scanner;

public class ConvertTemperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double farrenheit;
        double celcious;
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1.Farrenheit to Celcious");
            System.out.println("2.Celcious to Farrenheit");
            System.out.println("0.Exit");
            System.out.println("enter your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Farrenheit");
                    farrenheit = sc.nextDouble();
                    System.out.println("Farrenheit to Celcious: " + fahrenheitToCelsius(farrenheit));
                    break;
                case 2:
                    System.out.println("Enter the Celcious");
                    celcious = sc.nextDouble();
                    System.out.println("Farrenheit to Celcious: " + celsiusToFahrenheit(celcious));
                    break;
            }
        } while (choice != 0);
    }

    public static double celsiusToFahrenheit(double celsius) {
        double farenheit;
        farenheit = celsius / (5.0 / 9) + 32;
        return farenheit;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        double celcious;
        celcious = (5.0 / 9) * (fahrenheit - 32);
        return celcious;
    }
}
