import java.util.Arrays;

public class GopMang {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9, 10};
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
       // System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        int j =0;
        for (int i = arr1.length;i<arr3.length;i++){
            arr3[i]=arr2[j];
            j++;
        }
        //System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
        System.out.println("Mảng arr3 sau khi ghép: " + Arrays.toString(arr3));
    }
}
