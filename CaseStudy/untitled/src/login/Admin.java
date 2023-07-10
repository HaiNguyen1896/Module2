package login;

public class Admin extends User {
    private int idAdm;
    private String admUsername;
    private String admPassword;
    private String admName;
    private int admAge;
    private String admAdress;
    private String admEmail;
    private static int count;
    public static int idAdmCount;

    public Admin(String role, String admUsername, String admPassword, String admName, int admAge, String admAdress, String admEmail) {
        super(role);
        this.idAdm = idAdmCount++;
        this.admUsername = admUsername;
        this.admPassword = admPassword;
        this.admName = admName;
        this.admAge = admAge;
        this.admAdress = admAdress;
        this.admEmail = admEmail;
    }

    public int getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
    }

    public String getAdmUsername() {
        return admUsername;
    }

    public void setAdmUsername(String admUsername) {
        this.admUsername = admUsername;
    }

    public String getAdmPassword() {
        return admPassword;
    }

    public void setAdmPassword(String admPassword) {
        this.admPassword = admPassword;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public int getAdmAge() {
        return admAge;
    }

    public void setAdmAge(int admAge) {
        this.admAge = admAge;
    }

    public String getAdmAdress() {
        return admAdress;
    }

    public void setAdmAdress(String admAdress) {
        this.admAdress = admAdress;
    }

    public String getAdmEmail() {
        return admEmail;
    }

    public void setAdmEmail(String admEmail) {
        this.admEmail = admEmail;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Admin.count = count;
    }

    public static int getIdAdmCount() {
        return idAdmCount;
    }

    public static void setIdAdmCount(int idAdmCount) {
        Admin.idAdmCount = idAdmCount;
    }

    @Override
    public String toString() {
        return "Thông tin Admin: \n" +
                "\tTài khoản admin: "+this.getAdmUsername()+"\n"+
                "\tMật khẩu admin: "+admPassword+"\n"+
                "\tID admin: " + this.idAdm + "\n" +
                "\tHọ tên: " + this.admName+"\n"+
                "\tTuổi: " + this.admAge +"\n"+
                "\tĐịa chỉ nhà: " + this.admAdress +"\n"+
                "\tEmail: " + this.admEmail +"\n"+
                "------------------------------------------";
    }
}
