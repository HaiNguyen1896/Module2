import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ALo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>arr = new ArrayList<>();
        for(int i = 0;i<n;i++){
            arr.add(sc.nextInt());
        }
        int k = sc.nextInt();
        int x = sc.nextInt();
        arr.add(k,x);
        for(int i =0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }

}
