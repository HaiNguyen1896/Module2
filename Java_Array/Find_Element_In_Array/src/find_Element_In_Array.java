import java.util.Scanner;

public class find_Element_In_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] students = {"Christian", "Michael", "Camilla", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.println("Enter the name you need to check");
        String studentName = sc.nextLine();
        boolean isExit= false;
        for (int i = 0;i<students.length;i++){
            if(students[i].equals(studentName)){
                System.out.println("Position of the student is in the list "+studentName+" is "+i);
                isExit=true;
                break;
            }
        }
        if(!isExit){
            System.out.println("Not found "+studentName+" in the list.");
        }

    }
}
