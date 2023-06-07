import java.util.Arrays;
import java.util.Scanner;

public class count_passed_exam_student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int students;
        do{
            System.out.println("Hãy nhập số lượng sinh viên cần nhập điểm");
            students= sc.nextInt();
            if(students>30){
                System.out.println("Bạn nhập quá giới hạn, hãy nhập lại");
            }
        }while(students>30||students<0);
        int []arrPoints=new int[students];
        int count=0;
        for(int i =0;i<arrPoints.length;i++){
            System.out.println("Nhập điểm cho sinh viên thứ ["+(i+1)+"]");
            arrPoints[i]= sc.nextInt();
            if(arrPoints[i]>=5 && arrPoints[i]<=10) count++;
        }
        System.out.println("Điểm bạn vừa nhập của các sinh viên là: "+ Arrays.toString(arrPoints)+" số lượng sinh viên qua bài kiểm tra là "+count);
    }
}
