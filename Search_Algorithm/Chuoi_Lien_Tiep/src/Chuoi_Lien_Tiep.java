import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Chuoi_Lien_Tiep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi cần tìm");
        String string = sc.nextLine();
        LinkedList<Character> maxString = new LinkedList<>();
        for (int i=0;i<string.length();i++){
            LinkedList<Character>temp = new LinkedList<>();
            temp.add(string.charAt(i));
            for(int j = i+1;j<string.length();j++){
                if(string.charAt(j)>temp.getLast()){
                    temp.add(string.charAt(j));
                }else {
                    break;
                }
            }
            if(maxString.size()<temp.size()){
                maxString.clear();
                maxString.addAll(temp);
            }
            temp.clear();
        }
        for(Character char1 : maxString){
            System.out.print(char1);
        }

    }
}
