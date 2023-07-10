package login.UserManagement;

import login.Admin;
import login.Customer;
import manager.account_management.AdminManager;
import manager.shop_management.CustomerManager;
import regex.Invalid;

import java.util.Scanner;

public class UserManagement {
    Scanner sc = new Scanner(System.in);
    AdminManager adminManager;
    CustomerManager customerManager;
    private String userName;
    private String userPassword;
    Invalid invalid = new Invalid();

    public UserManagement(AdminManager adminManager, CustomerManager customerManager) {
        this.adminManager = adminManager;
        this.customerManager = customerManager;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int login() {
        boolean isValidAdmin, isValidCustomer;
        outer:
        do {
            System.out.println("Nhập username");
            this.userName = sc.nextLine();
            System.out.println("Nhập password");
            this.userPassword = sc.nextLine();
            isValidAdmin = adminManager.checkIdentifyUser(this.userName, this.userPassword);
            isValidCustomer = customerManager.checkIdentifyUser(this.userName, this.userPassword);
            if (!isValidAdmin && !isValidCustomer) {
                System.out.println("Đăng nhập thất bại, bạn muốn nhập lại hay thoát\n" +
                        "1. Nhấn 1 để nhập lại\n" +
                        "2. Nhấn 2 để thoát");
                int choice = invalid.check1or2Number();
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        break outer;
                }
            }
        } while (!isValidAdmin && !isValidCustomer);
        if (isValidAdmin) {
            String currentAdmName = "";
            for (int i = 0; i < adminManager.getAll().size(); i++) {
                if (adminManager.getAll().get(i).getAdmUsername().equals(userName)) {
                    currentAdmName = adminManager.getAll().get(i).getAdmName();
                    break;
                }
            }
            System.out.println("Chào mừng Admin " + currentAdmName + ", Chúc bạn một ngày làm việc hiệu quả!");
            return 1;
        } else if (isValidCustomer) {
//            String currentCustomerName = "";
//            for (int i = 0; i < customerManager.getAll().size(); i++) {
//                if (customerManager.getAll().get(i).getCustomerUsername().equals(userName)) {
//                    currentCustomerName = customerManager.getAll().get(i).getCustomerName();
//                    break;
//                }
//            }
            System.out.println("Chào mừng Quý khách hàng, Chúc quý khách một ngày mới vui vẻ!");
            return 2;
        }
        return -1;
    }

    public void registerNewAccount() {
        String role;
        System.out.println("Tạo tài khoản mới");
        System.out.println("Nhập vai trò");
        role = invalid.checkAdminOrCustomer();
        if (role.equals("admin")) {
            System.out.println("===========Tạo tài khoản Admin==========");
            String admUserName;
            String admPassword;
            do {
                boolean check = false;
                System.out.println("Nhập tài khoản Admin");
                admUserName = sc.nextLine();
                System.out.println("Nhập mật khẩu Admin");
                admPassword = sc.nextLine();
                for (int i = 0; i < adminManager.getAll().size(); i++) {
                    if (adminManager.getAll().get(i).getAdmUsername().equals(admUserName) && adminManager.getAll().get(i).getAdmPassword().equals(admPassword)) {
                        System.out.println("Tài khoản và mật khẩu vừa nhập đã tồn tại, hãy nhập lại");
                        check = true;
                    }
                }
                if (!check) break;
            } while (true);
            System.out.println("Nhập tên Admin");
            String admName = invalid.checkNameString();
            System.out.println("Nhập tuổi Admin");
            int admAge = invalid.checkNumber();
            System.out.println("Nhập địa chỉ của Admin");
            String admAdress = invalid.checkAdress();
            System.out.println("Nhập gmail của Admin");
            String admGmail = invalid.checkGmail();
            Admin admin = new Admin(role, admUserName, admPassword, admName, admAge, admAdress, admGmail);
            adminManager.createNewAdmAccount(admin);
            System.out.println("============Tạo tài khoản thành công===========");
        } else {
            System.out.println("===========Tạo tài khoản Khách hàng==========");
            String customerUsername, customerPassword;
            do {
                boolean check = false;
                System.out.println("Nhập tài khoản cho khách hàng");
                customerUsername = sc.nextLine();
                System.out.println("Nhập mật khẩu cho khách hàng");
                customerPassword = sc.nextLine();
                for (int i = 0; i < customerManager.getAll().size(); i++) {
                    if (customerManager.getAll().get(i).getCustomerUsername().equals(customerUsername) && customerManager.getAll().get(i).getCustomerPassword().equals(customerPassword)) {
                        System.out.println("Tài khoản và mật khẩu khách hàng đã tồn tại, xin quý khách vui lòng nhập lại");
                        check = true;
                    }
                }
                if (!check) break;
            } while (true);
            System.out.println("Nhập tên khách hàng");
            String customerName = invalid.checkNameString();
            System.out.println("Nhập tuổi khách hàng");
            int customerAge = invalid.checkNumber();
            System.out.println("Nhập địa chỉ khách hàng");
            String customerAdress = invalid.checkAdress();
            System.out.println("Nhập email khách hàng");
            String customerEmail = invalid.checkGmail();
            Customer customer = new Customer(role, customerUsername, customerPassword, customerName, customerAge, customerAdress, customerEmail);
            customerManager.add(customer);
            System.out.println("============Tạo tài khoản thành công===========");
        }
    }
}
