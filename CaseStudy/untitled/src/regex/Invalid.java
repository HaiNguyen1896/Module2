package regex;

import java.util.Scanner;

public class Invalid {
    Scanner sc = new Scanner(System.in);
    public static final String NAME_REGEX = "^[\\p{L}\\p{M}']+([\\s-][\\p{L}\\p{M}']+)*$";
    public static final String ADMIN_CUSTOMER_REGEX = "^(admin|customer)$";
    public static final String GMAIL_REGEX = "\\w+@\\w+(\\.\\w+)+";
    public static final String ADRESS_REGEX = "(?:[\\p{L}a-zA-Z0-9\\s]+-){2}[\\p{L}a-zA-Z0-9\\s]+";
    public static final String VEHICLE_TYPE_REGEX = "^(xe số|xe ga)$";
    public static final String DATE_REGEX = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public String checkNameString() {
        boolean check = false;
        String checkName;
        do {
            checkName = sc.nextLine();
            if (checkName.matches(NAME_REGEX)) {
                check = true;
            } else {
                System.out.println("Định dạng cần nhập là chữ, hãy nhập lại");
            }
        } while (!check);
        return checkName;
    }

    public String checkAdminOrCustomer() {
        String checkAdminOrCustomer;
        boolean check = false;
        do {
            checkAdminOrCustomer = sc.nextLine();
            if (checkAdminOrCustomer.matches(ADMIN_CUSTOMER_REGEX)) {
                return checkAdminOrCustomer;
            } else {
                System.out.println("Vai trò chỉ có thể là admin hoặc customer");
            }
        } while (!check);
        return null;
    }

    public String checkGmail() {
        String checkGmail;
        boolean check = false;
        do {
            checkGmail = sc.nextLine();
            if (checkGmail.matches(GMAIL_REGEX)) {
                return checkGmail;
            } else {
                System.out.println("Email cần nhập đúng định dạng(example@gmail.com...)");
            }
        } while (!check);
        return null;
    }

    public String checkDate() {
        String checkDate;
        boolean check = false;
        do {
            checkDate = sc.nextLine();
            if (checkDate.matches(DATE_REGEX)) {
                return checkDate;
            } else {
                System.out.println("Cần nhập đúng định dạng ngày");
            }
        } while (!check);
        return null;
    }

    public String checkAdress() {
        String checkAdress;
        boolean check = false;
        do {
            checkAdress = sc.nextLine();
            if (checkAdress.matches(ADRESS_REGEX)) {
                return checkAdress;
            } else {
                System.out.println("Địa chỉ cần nhập đúng định dạng (example-abc-xyz)");
            }
        } while (!check);
        return null;
    }

    public String checkVehicleType() {
        String checkType;
        boolean check = false;
        do {
            checkType = sc.nextLine();
            if (checkType.matches(VEHICLE_TYPE_REGEX)) {
                return checkType;
            } else {
                System.out.println("Loại xe chỉ có thể là 'xe số' hoặc 'xe ga'");
            }
        } while (!check);
        return null;
    }

    public int check1or2Number() {
        int checkNumber;
        do {
            try {
                checkNumber = Integer.parseInt(sc.nextLine());
                if (checkNumber == 1 || checkNumber == 2) {
                    break;
                } else {
                    System.out.println("Nhập 1 để đăng nhập lại hoặc 2 để quay trở lại bước trước");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Cần nhập 1 hoặc 2 để lựa chọn");
            }
        } while (true);
        return checkNumber;
    }

    public int checkNumber() {
        int checkNumber;
        boolean check = false;
        do {
            try {
                checkNumber = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Định dạng cần nhập là số, hãy nhập lại");
            }
        } while (true);
        return checkNumber;
    }
}