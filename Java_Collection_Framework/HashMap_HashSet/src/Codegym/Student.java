package Codegym;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Student {
    private String name;
    private int age;
    private String adress;
    public Student(){}
    public Student(String name,int age,String adress){
        super();
        this.name= name;
        this.age=age;
        this.adress=adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Student@Name="+this.name+",Age="+this.age+",adress="+this.adress;
    }

    public static void main(String[] args) {
        Student student1 = new Student("Nam",20,"HN");
        Student student2 = new Student("Hung",21,"HN");
        Student student3 = new Student("Ha",22,"HN");
        Map<Integer,Student> studentMap = new HashMap<Integer,Student>();
        studentMap.put(1,student1);
        studentMap.put(2,student2);
        studentMap.put(3,student3);
        for(Map.Entry<Integer, Student> student : studentMap.entrySet()){
            System.out.println(student.toString());
        }
        System.out.println("...........Set");
        Set<Student>students=new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student1);
        for(Student student : students){
            System.out.println(student.toString());
        }

    }
}
