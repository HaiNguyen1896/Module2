import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight, height, bmi;
        System.out.println("Your weight (in kilogram)");
        weight = sc.nextDouble();
        System.out.println("Your height(in meter)");
        height = sc.nextDouble();
        bmi = weight / Math.pow(height, 2);
        System.out.printf("%-20s%s", "bmi", "Interpretation\n");
        if (bmi < 18.5) {
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        } else if (bmi >= 18.5 && bmi < 25.0) {
            System.out.printf("%-20.2f%s", bmi, "normal");
        } else if (bmi >= 25.0 && bmi < 30.0) {
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        } else {
            System.out.println("You are Obese");
        }
    }
}
