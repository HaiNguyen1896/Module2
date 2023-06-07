import java.util.Scanner;

public class Reverse_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrLength;
        do {
            System.out.println("Nhập chiều dài mảng");
            arrLength = sc.nextInt();
            if (arrLength > 20) System.out.println("Bạn nhập quá giới hạn");
        } while (arrLength < 0 || arrLength > 20);
        int[] myArr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            System.out.println("Nhập giá trị myArr[" + i + "]");
            myArr[i] = sc.nextInt();
        }
        System.out.printf("%-20s%s","Mảng trước khi đảo ngược: ","");
        for (int i = 0;i<myArr.length;i++){
            System.out.print(myArr[i]+" ");
        }
        for (int i = 0; i < myArr.length / 2; i++) {
            int temp = myArr[i];
            myArr[i] = myArr[arrLength-1-i];
            myArr[arrLength-i-1] = temp;
        }
        System.out.print("\nMảng sau khi đảo ngược: ");
        for (int i = 0;i<myArr.length;i++){
            System.out.print(myArr[i]+" ");
        }
    }
}
