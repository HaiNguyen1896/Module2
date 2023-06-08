package codegym;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();
        Student std1 = new Student(1, "Dao Quang Hieu");
        Student std2 = new Student(2, "Do Ba Anh");
        Student std3 = new Student(3, "Tran My Anh");
        std1.display();
        std2.display();
        std3.display();

    }
}
