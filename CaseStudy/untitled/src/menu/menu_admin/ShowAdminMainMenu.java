package menu.menu_admin;

import login.Admin;
import login.Customer;
import manager.account_management.AdminManager;
import manager.shop_management.CustomerManager;
import manager.shop_management.MotorbikeManager;
import manager.shop_management.RentalManager;
import manager.shop_management.VehicleManager;
import model.Motorbike;
import model.Vehicle;
import read_and_write.ReadAndWriteMotorbike;
import read_and_write.ReadAndWriteVehicle;
import regex.Invalid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowAdminMainMenu {
    Scanner sc = new Scanner(System.in);
    AdminManager adminManager;
    VehicleManager motorbikeManager;
    CustomerManager customerManager;
    RentalManager rentalManager;
    Invalid invalid = new Invalid();
    MotorbikeManager motorbikeDetailManager;
    ReadAndWriteMotorbike readAndWriteMotorbike = new ReadAndWriteMotorbike();

    public ShowAdminMainMenu(AdminManager adminManager, CustomerManager customerManager, VehicleManager vehicleManager, RentalManager rentalManager, MotorbikeManager motorbikeDetailManager) {
        this.adminManager = adminManager;
        this.customerManager = customerManager;
        this.motorbikeManager = vehicleManager;
        this.rentalManager = rentalManager;
        this.motorbikeDetailManager = motorbikeDetailManager;
    }

    //=======================MENU QUẢN LÝ THÔNG TIN ADMIN====================
    public void showAdminLoginMenu() {
        int choice;
        do {
            System.out.println("1. Thêm Admin\n" +
                    "2. Xóa Admin\n" +
                    "3. Cập nhập thông tin Admin\n" +
                    "4. Tìm thông tin Admin theo tên\n" +
                    "5. Hiển thị thông tin các admin đang quản lý\n" +
                    "6. Vào trang quản lý\n" +
                    "0. Thoát");
            choice = invalid.checkNumber();
            switch (choice) {
                case 1:
                    addAdmin();
                    break;
                case 2:
                    removeAdmin();
                    break;
                case 3:
                    editCurrentAdmin();
                    break;
                case 4:
                    findAdminByName();
                    break;
                case 5:
                    showAllAdmin();
                    break;
                case 6:
                    showAdminMainMenu();
                    break;
                default:
                    System.out.println("Nhập sai lựa chọn");
            }
        } while (choice != 0);
    }

    public void addAdmin() {
        String admUserName, admPassword;
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
        System.out.println("Nhập tên của Admin");
        String admName = invalid.checkNameString();
        System.out.println("Nhập tuổi của Admin");
        int admAge = invalid.checkNumber();
        System.out.println("Nhập địa chỉ của Admin");
        String admAdress = invalid.checkAdress();
        System.out.println("Nhập gmail của Admin");
        String admGmail = invalid.checkGmail();
        Admin admin = new Admin("admin", admUserName, admPassword, admName, admAge, admAdress, admGmail);
        adminManager.add(admin);
    }

    public void removeAdmin() {
        System.out.println("Nhập ID Admin cần xóa");
        int id = invalid.checkNumber();
        this.adminManager.remove(id);
    }

    public void findAdminByName() {
        System.out.println("Nhập tên Admin bạn muốn tìm");
        String name = invalid.checkNameString();
        for (int i = 0; i < adminManager.findAdminByName(name).size(); i++) {
            System.out.println(adminManager.findAdminByName(name).get(i).toString());
        }
    }
    public void editCurrentAdmin(){
        System.out.println("Nhập ID admin cần sửa thông tin");
        int id = invalid.checkNumber();
        adminManager.editCurrentAdmin(id);
    }

    public void showAllAdmin() {
        for (int i = 0; i < adminManager.getAll().size(); i++) {
            System.out.println(adminManager.getAll().get(i).toString());
        }
    }

    //========================MENU QUẢN LÝ THÔNG TIN CỬA HÀNG CỦA ADMIN=======================
    public void showAdminMainMenu() {
        int choice;
        do {
            System.out.println("1. Quản lý nhóm xe\n" +
                    "2. Quản lý nhóm khách hàng\n" +
                    "0. Thoát");
            choice = invalid.checkNumber();
            switch (choice) {
                case 1:
                    showVehicleGroupManagement();
                    break;
                case 2:
                    showCustomerGroupManagement();
                    break;
                default:
                    System.out.println("Nhập sai lựa chọn");
            }
        } while (choice != 0);
    }

    public void showVehicleGroupManagement() {
        int choice;
        do {
            System.out.println("1. Thêm dòng xe mới\n" +
                    "2. Thêm xe mới\n" +
                    "3. Sửa thông tin xe\n" +
                    "4. Xóa xe khỏi danh sách\n" +
                    "5. Hiển thị danh sách xe\n" +
                    "0. Thoát");
            System.out.println("Nhập tùy chọn của bạn");
            choice = invalid.checkNumber();
            switch (choice) {
                case 1:
                    addNewModelMotorbike();
                    break;
                case 2:
                    addNewMotorbike();
                    break;
                case 3:
                    editMotorbike();
                    break;
                case 4:
                    removeChoice();
                    break;
                case 5:
                    showMotorbike();
                    break;
                default:
                    System.out.println("Nhập sai lựa chọn");
            }
        } while (choice != 0);
    }

    //========================Chức năng cho các dòng xe========================
    public void addNewModelMotorbike() {
        System.out.println("Hãy nhập dòng xe mới: ");
        String model = sc.nextLine();
        System.out.println("Nhập năm sản xuất dòng xe");
        int manufactoringYear = invalid.checkNumber();
        boolean check = true;
        for (int i = 0; i < motorbikeManager.getAll().size(); i++) {
            if (model.equals(motorbikeManager.getAll().get(i).getModel()) && manufactoringYear == motorbikeManager.getAll().get(i).getProductManufactoringYear()) {
                System.out.println("Mẫu xe này đã được cập nhập trước đây, hãy kiểm tra lại");
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("Nhập loại xe");
            String type = invalid.checkVehicleType();
            Vehicle vehicle = new Vehicle(model, manufactoringYear, type);
            motorbikeManager.add(vehicle);
        }
    }

    public void addNewMotorbike() {
        System.out.println("Nhập dòng xe");
        String model = sc.nextLine();
        System.out.println("Nhập năm sản xuất");
        int productYear = invalid.checkNumber();
        System.out.println("Nhập loại xe");
        String type = invalid.checkVehicleType();
        String motorbikeLisencePlate="";
        do {
            boolean check = false;
            System.out.println("Nhập biển kiểm soát");
            motorbikeLisencePlate = sc.nextLine();
            for(int i =0;i<motorbikeDetailManager.getAll().size();i++){
                if(motorbikeLisencePlate.equals(motorbikeDetailManager.getAll().get(i).getMotorbikeLisencePlate())){
                    System.out.println("Biển đăng ký đã tồn tại, hãy kiểm tra lại");
                    check = true;
                }
            }
            if(!check) break;
        }while(true);
        System.out.println("Nhập màu xe");
        String motorbikeColor = invalid.checkNameString();
        Motorbike motorbike = new Motorbike(model, productYear, type, motorbikeLisencePlate, motorbikeColor, false);
        for (int i = 0; i < motorbikeManager.getAll().size(); i++) {
            if (motorbikeManager.getAll().get(i).getModel().equals(model)) {
                motorbikeManager.getAll().get(i).setQuantity(motorbikeManager.getAll().get(i).getQuantity() + 1);
            }
        }
        motorbikeDetailManager.add(motorbike);
    }

    public void removeMotorbike() {
        System.out.println("Nhập ID xe cần xóa");
        int id = invalid.checkNumber();
        String type = "";
        for (int i = 0; i < motorbikeManager.getAll().size(); i++) {
            if (motorbikeManager.getAll().get(i).getId() == (id-1)) {
                type = motorbikeManager.getAll().get(i).getModel();
            }
        }
        List<Motorbike> list = new ArrayList<>();
        for (int i = 0; i < motorbikeDetailManager.getAll().size(); i++) {
            if (motorbikeDetailManager.getAll().get(i).getModel().equals(type)) {
            } else {
                list.add(motorbikeDetailManager.getAll().get(i));
            }
        }
        readAndWriteMotorbike.writeFile(list);
        motorbikeManager.remove((id-1));
    }

    public void removeDetailMotorbike() {
        System.out.println("Nhập ID xe cần xóa");
        int id = invalid.checkNumber();
        motorbikeDetailManager.remove(id - 1);
    }

    public void editMotorbike() {
        System.out.println("Nhập ID xe cần sửa thông tin");
        int id = invalid.checkNumber();
        motorbikeDetailManager.editDetailMotorbike(id - 1);
    }

    public void showMotorbike() {
        motorbikeManager.getAndSetSizeOfMotorbike();
        if (motorbikeManager.getAll().size() == 0) {
            System.out.println("Chưa có xe nào trong danh sách, hãy nhập thêm xe");
        } else {
            ReadAndWriteVehicle readAndWriteVehicle = new ReadAndWriteVehicle();
            readAndWriteVehicle.readFile();
            for (int i = 0; i < motorbikeManager.getAll().size(); i++) {
                System.out.println(motorbikeManager.getAll().get(i).toString());
                for (int j = 0; j < motorbikeDetailManager.getAll().size(); j++) {
                    if (motorbikeDetailManager.getAll().get(j).getModel().equals(motorbikeManager.getAll().get(i).getModel())) {
                        System.out.println(motorbikeDetailManager.getAll().get(j));
                    }
                }
                System.out.println("--------------------------------------------------------------------------------");
            }
        }

    }

    public void removeChoice() {
        int choice;
        do {
            System.out.println("1. Xóa tất cả xe trong 1 dòng xe\n" +
                    "2. Xóa xe cụ thể\n" +
                    "0. Thoát");
            System.out.println("Nhập tùy chọn của bạn");
            choice = invalid.checkNumber();
            switch (choice) {
                case 1:
                    removeMotorbike();
                    break;
                case 2:
                    removeDetailMotorbike();
                    break;
            }
        } while (choice != 0);
    }


    //========================Quản lý nhóm khách hàng=================
    public void showCustomerGroupManagement() {
        int choice = -1;
        do {
            System.out.println("1. Thêm khách hàng\n" +
                    "2. Sửa thông tin khách hàng\n" +
                    "3. Xóa thông tin khách hàng\n" +
                    "4. Tìm thông tin khách hàng theo tên\n" +
                    "5. Hiển thị thông tin khách hàng\n" +
                    "6. Hiển thị danh sách xe đang được thuê\n" +
                    "0. Thoát");
            System.out.println("Hãy nhập lựa chọn của bạn");
            choice = invalid.checkNumber();
            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    editCustomer();
                    break;
                case 3:
                    removeCustomer();
                    break;
                case 4:
                    findCustomerByName();
                    break;
                case 5:
                    showCustomer();
                    break;
                case 6:
                    showRentalVehicle();
                    break;
                default:
                    System.out.println("Nhập sai lựa chọn");
            }
        } while (choice != 0);
    }

    public void addCustomer() {
        String customerUsername, customerPassword;
        do {
            boolean check = false;
            System.out.println("Nhập tài khoản cho Khách hàng");
            customerUsername = sc.nextLine();
            System.out.println("Nhập mật khẩu cho Khách hàng");
            customerPassword = sc.nextLine();
            for (int i = 0; i < customerManager.getAll().size(); i++) {
                if (customerManager.getAll().get(i).getCustomerUsername().equals(customerUsername) && customerManager.getAll().get(i).getCustomerPassword().equals(customerPassword)) {
                    System.out.println("Tài khoản và mật khẩu của Khách hàng đã tồn tại, vui lòng nhập lại");
                    check = true;
                }
            }
            if (!check) break;
        } while (true);
        System.out.println("Nhập tên của Khách hàng");
        String customerName = invalid.checkNameString();
        System.out.println("Nhập tuổi của Khách hàng");
        int customerAge = invalid.checkNumber();
        System.out.println("Nhập địa chỉ thường trú của Khách hàng");
        String customerAdress = invalid.checkAdress();
        System.out.println("Nhập Email của Khách hàng");
        String customerEmail = invalid.checkGmail();
        Customer customer = new Customer("customer", customerUsername, customerPassword, customerName, customerAge, customerAdress, customerEmail);
        customerManager.add(customer);
    }

    public void showCustomer() {
        List<Customer> customers = customerManager.getAll();
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).toString());
        }
    }

    public void editCustomer() {
        System.out.println("Nhập ID của Khách hàng cần sửa");
        int id = invalid.checkNumber();
        customerManager.edit(id);
    }

    public void removeCustomer() {
        System.out.println("Nhập ID của Khách hàng cần xóa:");
        int id = invalid.checkNumber();
        customerManager.remove(id);
    }

    public void showRentalVehicle() {
        for (int i = 0; i < rentalManager.showRental().size(); i++) {
            System.out.println(rentalManager.showRental().get(i).toString());
        }
    }
    public void findCustomerByName() {
        System.out.println("Nhập tên Khách hàng bạn muốn tìm");
        String name = invalid.checkNameString();
        for (int i = 0; i < customerManager.findCustomerByName(name).size(); i++) {
            System.out.println(customerManager.findCustomerByName(name).get(i).toString());
        }
    }
}
