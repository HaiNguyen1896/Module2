import java.util.Scanner;

public class find_max_Element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputTotalAsset;
        double[] totalAsset;
        do {
            System.out.println("Enter the number Billionare's total asset");
            inputTotalAsset = sc.nextInt();
            if (inputTotalAsset < 0 || inputTotalAsset > 20) {
                System.out.println("Please re-enter");
            }
        } while (inputTotalAsset < 0 || inputTotalAsset > 20);
        int i = 0;
        totalAsset = new double[inputTotalAsset];
        while (i < inputTotalAsset) {
            System.out.println("Enter the total asset of Billionare " + (i + 1));
            totalAsset[i] = sc.nextDouble();
            i++;
        }
        double Max = totalAsset[0];
        int index = 1;
        for (int j = 0; j < totalAsset.length; j++) {
            if (Max < totalAsset[j]) {
                Max = totalAsset[j];
                index = j;
            }
        }
        System.out.println("The largest Total asset is " + Max + " ,at position " + (index + 1));
    }
}
