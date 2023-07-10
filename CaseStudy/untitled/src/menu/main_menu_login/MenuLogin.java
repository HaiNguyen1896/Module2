package menu.main_menu_login;
import login.UserManagement.UserManagement;
import manager.account_management.AdminManager;
import manager.shop_management.CustomerManager;
import manager.shop_management.MotorbikeManager;
import manager.shop_management.RentalManager;
import manager.shop_management.VehicleManager;
import menu.menu_admin.ShowAdminMainMenu;
import menu.menu_customer.ShowCustomerMenu;
import regex.Invalid;
import java.util.Scanner;

public class MenuLogin {

    Scanner sc = new Scanner(System.in);
    AdminManager adminManager = new AdminManager();
    CustomerManager customerManager = new CustomerManager();
    UserManagement userManagement = new UserManagement(adminManager, customerManager);
    RentalManager rentalManager = new RentalManager();
    VehicleManager vehicleManager = new VehicleManager();
    MotorbikeManager motorbikeManager = new MotorbikeManager();
    ShowCustomerMenu customerMenu = new ShowCustomerMenu(adminManager, customerManager, vehicleManager, rentalManager, userManagement,motorbikeManager);
    ShowAdminMainMenu showMainMenu = new ShowAdminMainMenu(adminManager, customerManager, vehicleManager, rentalManager,motorbikeManager);
    Invalid invalid = new Invalid();



    public void showMenuLogin() {
        int choice = -1;
        vehicleManager.getAndSetSizeOfMotorbike();
        do {
            System.out.println("=====QUẢN LÝ CỬA HÀNG CHO THUÊ XE MÁY HỢP NHẤT=====\n" +
                    "**************** Quản lý tài khoản ****************\n" +
                    "1. Đăng nhập tài khoản\n" +
                    "2. Tạo tài khoản mới\n" +
                    "0. Thoát");
            System.out.println("Nhập lựa chọn của bạn");
            choice = invalid.checkNumber();
            switch (choice) {
                case 1:
                    if (userManagement.login() == 1) {
                        showMainMenu.showAdminLoginMenu();
                    } else {
                        customerMenu.showCustomerInformationMenu();
                    }
                    break;
                case 2:
                    userManagement.registerNewAccount();
                    break;
                default:
                    System.out.println("Nhập sai lựa chọn");
            }
        } while (choice != 0);
    }
}

