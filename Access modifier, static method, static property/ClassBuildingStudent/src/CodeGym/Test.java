package CodeGym;

public class Test {
    public static void main(String[] args) {
        Student st1 = new Student();
        Student st2 = new Student();
        st1.setName("Kenny");
        st1.setClasses("C04H1");
        st2.setName("Bryan");
        st2.setClasses("C03H1");
        System.out.println(st1.getName() + " " + st1.getClasses());
        System.out.println(st2.getName() + " " + st2.getClasses());
    }
}
