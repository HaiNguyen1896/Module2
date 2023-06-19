package Codegym;

public class Run {
    public static void main(String[] args) {
        CheckSymbol main = new CheckSymbol();
        String string = "(–b+(b^2–4*a*c)^(0.5/ 2*a))";
        if (main.checkSymbol(string)) {
            System.out.println("Khớp");
        } else {
            System.out.println("Không khớp");
        }
    }
}
