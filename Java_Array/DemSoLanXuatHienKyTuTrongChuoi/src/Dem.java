import java.util.Scanner;

public class Dem {
    public static void main(String[] args) {
        String chuoi = "xin chao ban";
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ký tự cần đếm");
        char kyTu = sc.next().charAt(0);
        int count=0;
        for (int i = 0 ; i<chuoi.length();i++){
            char ch = chuoi.charAt(i);
            if (kyTu==ch){
                count++;
            }
        }
        if (count==0){
            System.out.println("Ký tự "+kyTu+" không xuất hiện lần nào");
        }else{
            System.out.println("Ký tự "+kyTu+" xuất hiện "+count+" lần");
        }
    }
}
