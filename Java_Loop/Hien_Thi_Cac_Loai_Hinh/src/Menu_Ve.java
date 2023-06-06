import java.util.Scanner;

public class Menu_Ve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choosenCase = -1;
        while (choosenCase != 0) {
            System.out.println("Choose the case");
            System.out.println("1. Draw the Rectangle");
            System.out.println("2. Draw the Triangle 1");
            System.out.println("3. Draw the Triangle 2");
            System.out.println("4. Draw the Triangle 3");
            System.out.println("0.exit");
            System.out.println("Enter your choice");
            choosenCase = sc.nextInt();
            switch (choosenCase) {
                case 1:
                    drawRectangle();
                    break;
                case 2:
                    drawTriangle1();
                    break;
                case 3:
                    drawTriangle2();
                    break;
                case 4:
                    drawTriangle3();
                    break;
            }
        }
    }

    public static void drawRectangle() {
        String draw = "";
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 8; j++) {
                draw += "*";
            }
            System.out.println(draw);
            draw = "";
        }
    }

    //Vẽ tam giác góc vuông ở bottom-left
    public static void drawTriangle1() {
        String draw = "";
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                draw += "*";
            }
            System.out.println(draw);
            draw = "";
        }
    }

    //Vẽ tam giác góc vuông ở top-left
    public static void drawTriangle2() {
        String draw = "";
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                draw += "*";
            }
            System.out.println(draw);
            draw = "";
        }
    }

    // vẽ tam giác cân
    public static void drawTriangle3() {
        for (int i = 1; i <= 5; i++) {
            for (int j = i; j <= 5; j++) {
                System.out.print(" ");
            }
            for (int j = 5 - i; j < 5; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }
}
