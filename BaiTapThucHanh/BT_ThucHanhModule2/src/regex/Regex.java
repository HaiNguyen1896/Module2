package regex;

import java.util.Scanner;

public class Regex {
    Scanner sc = new Scanner(System.in);
    public static final String NAME_REGEX = "^[\\p{L}\\p{M}']+([\\s-][\\p{L}\\p{M}']+)*$";
    public static final String ADMIN_CUSTOMER_REGEX = "^(admin|customer)$";
    public static final String GMAIL_REGEX = "\\w+@\\w+(\\.\\w+)+";
    public static final String ADRESS_REGEX = "(?:[\\p{L}a-zA-Z0-9\\s]+-){2}[\\p{L}a-zA-Z0-9\\s]+";
    public static final String VEHICLE_TYPE_REGEX = "^(xe số|xe ga)$";
    public static final String DATE_REGEX = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public int checkInvalidNumber() {
        int Number;
        do {
            try {
                Number = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Định dạng cần nhập là số");
            }
        } while (true);
        return Number;
    }
    public String checkInvalidString() {
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

}
