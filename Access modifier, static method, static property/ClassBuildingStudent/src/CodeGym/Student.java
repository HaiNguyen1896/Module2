package CodeGym;

public class Student {
    private String name = "John";
    private String classes = "C02";

    public Student() {
    }

    // Chuyển các accessModifier khac nhau thì chỉ private là không truy cập được
    protected void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getClasses() {
        return this.classes;
    }

    // Chuyển các accessModifier khac nhau thì chỉ private là không truy cập được
    protected void setClasses(String classes) {
        this.classes = classes;
    }
}
