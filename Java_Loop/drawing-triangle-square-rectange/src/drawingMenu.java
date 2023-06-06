import java.util.Scanner;

public class drawingMenu {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int choosenCase = 1;
        while (choosenCase != 0) {
            System.out.println("Choose the case");
            System.out.println("1. Draw the Triangle");
            System.out.println("2. Draw the Square");
            System.out.println("3. Draw the Rectangle");
            System.out.println("0.exit");
            System.out.println("Enter your choice");
            choosenCase = sc.nextInt();
            switch (choosenCase) {
                case 1:
                    System.out.println("Draw the triangle");
                    System.out.println("******");
                    System.out.println("*****");
                    System.out.println("****");
                    System.out.println("***");
                    System.out.println("**");
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println("Draw the square");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 3:
                    System.out.println("Draw the rectangle");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }

    }
}
