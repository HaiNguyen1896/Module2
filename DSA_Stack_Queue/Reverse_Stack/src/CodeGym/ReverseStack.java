package CodeGym;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReverseStack {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("The array number before reverse");
        System.out.println(Arrays.toString(array));
        LinkedList<Integer> stack = new LinkedList<>();
        for (int ar : array) {
            stack.push(ar);
        }
        for (int i = 0; i < stack.size(); i++) {
            array[i] = stack.pop();
        }
        System.out.println("The array number after reverse");
        System.out.println(Arrays.toString(array));

    String str = "Xin chào bạn";
        System.out.println("String before reverse");
        System.out.println(str);
        String[]mWord = str.split(" ");
        LinkedList<String>wStack=new LinkedList<>();
        for(String str1 : mWord){
            wStack.push(str1);
        }
        String out = "";
        for (int i =0;i<mWord.length;i++){
          out+=wStack.pop()+" ";
        }
        System.out.println("String after reverse");
        System.out.println(out);



    }


}
