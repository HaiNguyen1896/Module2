package menu.menu_customer;

import login.Customer;
import login.UserManagement.UserManagement;
import manager.account_management.AdminManager;
import manager.shop_management.CustomerManager;
import manager.shop_management.MotorbikeManager;
import manager.shop_management.RentalManager;
import manager.shop_management.VehicleManager;
import model.Motorbike;
import model.Rental;
import model.Vehicle;
import read_and_write.ReadAndWriteMotorbike;
import read_and_write.ReadAndWriteRental;
import regex.Invalid;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class ShowCustomerMenu {
    ReadAndWriteMotorbike readAndWriteMotorbike = new ReadAndWriteMotorbike();
    ReadAndWriteRental rentalRead = new ReadAndWriteRental();
    Scanner sc = new Scanner(System.in);
    AdminManager adminManager;
    CustomerManager customerManager;
    VehicleManager vehicleManager;
    UserManagement userManagement;
    RentalManager rentalManager;
    Invalid invalid = new Invalid();
    MotorbikeManager motorbikeManager;

    public ShowCustomerMenu(AdminManager adminManager, CustomerManager customerManager, VehicleManager vehicleManager, RentalManager rentalManager, UserManagement userManagement, MotorbikeManager motorbikeManager) {
        this.adminManager = adminManager;
        this.customerManager = customerManager;
        this.vehicleManager = vehicleManager;
        this.rentalManager = rentalManager;
        this.userManagement = userManagement;
        this.motorbikeManager = motorbikeManager;
    }

    //================Show customer information Menu===================
    public void showCustomerInformationMenu() {
        int choice = -1;
        do {
            System.out.println("1. Xem thông tin cá nhân\n" +
                    "2. Cập nhập thông tin cá nhân\n" +
                    "3. Đi đến danh mục sản phẩm của cửa hàng\n" +
                    "4. Xem lịch sử thuê xe\n" +
                    "0. Thoát");
            System.out.println("Nhập lựa chọn của Quý khách");
            choice = invalid.checkNumber();
            switch (choice) {
                case 1:
                    showCustomerInformation();
                    break;
                case 2:
                    editCustomerInformation();
                    break;
                case 3:
                    shopProductForCustomer();
                    break;
                case 4:
                    getRental();
                    break;
                default:
                    System.out.println("Nhập sai lựa chọn");
            }
        } while (choice != 0);
    }

    public void shopProductForCustomer() {

        int choice = -1;
        do {
            System.out.println("1. Xem danh sách dòng xe số");
            System.out.println("2. Xem danh sách dòng xe ga");
            System.out.println("0. Thoát");
            System.out.println("Nhập loại xe Quý khách muốn thuê");
            choice = invalid.checkNumber();
            switch (choice) {
                case 1:
                    manualTransmissionMotorcycle();
                    break;
                case 2:
                    automaticTranmissionMotorcycle();
                    break;
                default:
                    System.out.println("Quý khách nhập sai lựa chọn");
            }
        } while (choice != 0);
    }

    public void showCustomerInformation() {
        for (int i = 0; i < customerManager.getAll().size(); i++) {
            if (customerManager.getAll().get(i).getCustomerUsername().equals(userManagement.getUserName()) && customerManager.getAll().get(i).getCustomerPassword().equals(userManagement.getUserPassword())) {
                System.out.println(customerManager.getAll().get(i).toString());
            }
        }
    }

    public Customer getCustomer() {
        for (int i = 0; i < customerManager.getAll().size(); i++) {
            if (customerManager.getAll().get(i).getCustomerUsername().equals(userManagement.getUserName()) && customerManager.getAll().get(i).getCustomerPassword().equals(userManagement.getUserPassword())) {
                return customerManager.getAll().get(i);
            }
        }
        return null;
    }

    public void editCustomerInformation() {
        Customer tempCustomer = getCustomer();
        customerManager.editSpecificCustomer(tempCustomer.getIdCustomer(), tempCustomer.getCustomerUsername(), tempCustomer.getCustomerPassword());
    }

    public void rentalVehicle(int id, int id2) {
        Vehicle vehicle = vehicleManager.getAll().get(id);
        Motorbike motorbike = motorbikeManager.getAll().get(id2);
        String motorbikeLisencePlate = motorbike.getMotorbikeLisencePlate();
        System.out.println("Hãy nhập thời điểm Quý khách muốn thuê xe");
        String beginDay = invalid.checkDate();
        String[] dataBeginDay = beginDay.split("/");
        LocalDate startDate = LocalDate.of(Integer.parseInt(dataBeginDay[2]), Integer.parseInt(dataBeginDay[1]), Integer.parseInt(dataBeginDay[0]));
        System.out.println("Hãy nhập thời điểm Quý khách muốn trả xe");
        String returnDay = invalid.checkDate();
        String[] dataReturnDay = returnDay.split("/");
        LocalDate endDate = LocalDate.of(Integer.parseInt(dataReturnDay[2]), Integer.parseInt(dataReturnDay[1]), Integer.parseInt(dataReturnDay[0]));
        Period period = Period.between(startDate, endDate);
        int dayBettwen = period.getDays();
        double amountPaid = dayBettwen * 80000;
        Rental rental = new Rental(getCustomer().getCustomerName(), vehicle.getModel(), motorbikeLisencePlate, beginDay, returnDay, amountPaid);
        rentalManager.addRentVehicle(rental);
        getCustomer().setMyRental(rental);
        rentalRead.writeFile(rentalManager.showRental());
    }

    public void getNewestRental() {
        int newestIndex = getCustomer().getMyRental().size();
        System.out.println(getCustomer().getMyRental().get(newestIndex - 1));
    }

    public void getRental() {
        for (Rental rental : rentalManager.showRental()) {
            if (rental.getCustomerName().equals(getCustomer().getCustomerName()))
                System.out.println(rental.toString());
        }
    }

    public void manualTransmissionMotorcycle() {
        int choiceMotorbike = -1;
        int choice;
        do {
            for (int i = 0; i < vehicleManager.getAll().size(); i++) {
                if (vehicleManager.getAll().get(i).getType().equals("xe số")) {
                    System.out.println((i + 1) + ": " + vehicleManager.getAll().get(i).getModel());
                }
            }
            System.out.println("0. Thoát");
            System.out.println("Xin hãy nhập dòng xe Quý khách muốn thuê!");
            choiceMotorbike = invalid.checkNumber();
            if (choiceMotorbike == 0) break;
            do {
                int countMotorbike = 0;
                System.out.println(vehicleManager.getAll().get(choiceMotorbike - 1));
                System.out.println("Các xe thuộc dòng xe " + vehicleManager.getAll().get(choiceMotorbike - 1).getModel() + " bao gồm: ");
                for (int i = 0; i < motorbikeManager.getAll().size(); i++) {
                    if (motorbikeManager.getAll().get(i).getModel().equalsIgnoreCase(vehicleManager.getAll().get(choiceMotorbike - 1).getModel())) {
                        System.out.println(motorbikeManager.getAll().get(i));
                        countMotorbike++;
                    }
                }
                if (countMotorbike == 0) {
                    System.out.println("Xe Quý khách chọn đang tạm thời hết hàng, xin Quý khách thông cảm, Quý khách hãy lựa chọn xe khác\n" +
                            "=============KÍNH MONG QUÝ KHÁCH THÔNG CẢM!=============");
                    break;
                }
                System.out.println("1.Thuê xe\n" +
                        "2.Trả xe\n" +
                        "0.Thoát");
                System.out.println("Nhập lựa chọn của Quý khách");
                choice = invalid.checkNumber();
                if (choice == 1) {
                    int quantity = vehicleManager.getAll().get(choiceMotorbike - 1).getQuantity();
                    if (quantity <= 0) {
                        System.out.println("Xe Quý khách chọn đang tạm thời hết hàng, xin Quý khách thông cảm, Quý khách hãy lựa chọn xe khác\n" +
                                "=============KÍNH MONG QUÝ KHÁCH THÔNG CẢM!=============");
                    } else {
                        System.out.println("Nhập ID xe Quý khách muốn thuê:");
                        choice = invalid.checkNumber();
                        if (motorbikeManager.getAll().get(choice - 1).isHired()) {
                            System.out.println("Xe đã được thuê, mời Quý khách chọn xe khác\n" +
                                    "=============KÍNH MONG QUÝ KHÁCH THÔNG CẢM!=============");
                        } else {
                            rentalVehicle(choiceMotorbike - 1, choice - 1);
                            System.out.println("Hợp đồng của Quý khách: ");
                            vehicleManager.getAll().get(choiceMotorbike - 1).setQuantity(quantity - 1);
                            for (int i = 0; i < motorbikeManager.getAll().size(); i++) {
                                if (motorbikeManager.getAll().get(i).getId() == (choice - 1)) {
                                    motorbikeManager.getAll().get(i).setHired(true);
                                    readAndWriteMotorbike.writeFile(motorbikeManager.getAll());
                                    break;
                                }
                            }
                            getNewestRental();
                            System.out.println("===========CẢM ƠN QUÝ KHÁCH ĐÃ ỦNG HỘ===========");
                        }
                    }
                } else if (choice == 2) {
                   if(returnMotorbike()==1) {
                       int quantity = vehicleManager.getAll().get(choiceMotorbike - 1).getQuantity();
                       vehicleManager.getAll().get(choiceMotorbike - 1).setQuantity(quantity + 1);
                   }
                }
            } while (choice != 0);
        } while (choiceMotorbike != 0);
    }

    public void automaticTranmissionMotorcycle() {
        int choiceMotorbike = -1;
        int choice;
        do {
            for (int i = 0; i < vehicleManager.getAll().size(); i++) {
                if (vehicleManager.getAll().get(i).getType().equals("xe ga")) {
                    System.out.println((i + 1) + ": " + vehicleManager.getAll().get(i).getModel());
                }
            }
            System.out.println("0. Thoát");
            System.out.println("Xin hãy nhập dòng xe Quý khách muốn thuê!");
            choiceMotorbike = invalid.checkNumber();
            if (choiceMotorbike == 0) break;
            do {
                int countMotorbike = 0;
                System.out.println(vehicleManager.getAll().get(choiceMotorbike - 1));
                System.out.println("Các xe thuộc dòng xe " + vehicleManager.getAll().get(choiceMotorbike - 1).getModel() + " bao gồm: ");
                for (int i = 0; i < motorbikeManager.getAll().size(); i++) {
                    if (motorbikeManager.getAll().get(i).getModel().equalsIgnoreCase(vehicleManager.getAll().get(choiceMotorbike - 1).getModel())) {
                        System.out.println(motorbikeManager.getAll().get(i));
                        countMotorbike++;
                    }
                }
                if (countMotorbike == 0) {
                    System.out.println("Xe Quý khách chọn đang tạm thời hết hàng, xin Quý khách thông cảm, Quý khách hãy lựa chọn xe khác\n" +
                            "=============KÍNH MONG QUÝ KHÁCH THÔNG CẢM!=============");
                    break;
                }
                System.out.println("1.Thuê xe\n" +
                        "2.Trả xe\n" +
                        "0.Thoát");
                System.out.println("Nhập tùy chọn của Quý khách");
                choice = invalid.checkNumber();
                if (choice == 1) {
                    int quantity = vehicleManager.getAll().get(choiceMotorbike - 1).getQuantity();
                    if (quantity <= 0) {
                        System.out.println("Xe Quý khách chọn đang tạm thời hết hàng, xin Quý khách thông cảm, Quý khách hãy lựa chọn xe khác\n" +
                                "=============KÍNH MONG QUÝ KHÁCH THÔNG CẢM!=============");
                    } else {
                        System.out.println("Nhập id xe mà Quý khách muốn thuê");
                        choice = invalid.checkNumber();
                        if (motorbikeManager.getAll().get(choice - 1).isHired()) {
                            System.out.println("Xe đã được thuê, mời bạn chọn xe khác\n" +
                                    "=============KÍNH MONG QUÝ KHÁCH THÔNG CẢM!=============");
                        } else {
                            rentalVehicle(choiceMotorbike - 1, choice - 1);
                            System.out.println("Hợp đồng của Quý khách: ");
                            vehicleManager.getAll().get(choiceMotorbike - 1).setQuantity(quantity - 1);
                            for (int i = 0; i < motorbikeManager.getAll().size(); i++) {
                                if (motorbikeManager.getAll().get(i).getId() == (choice - 1)) {
                                    motorbikeManager.getAll().get(i).setHired(true);
                                    readAndWriteMotorbike.writeFile(motorbikeManager.getAll());
                                    break;
                                }
                            }
                            getNewestRental();
                            System.out.println("===========CẢM ƠN QUÝ KHÁCH ĐÃ ỦNG HỘ===========");
                        }
                    }
                } else if (choice == 2) {
                    if(returnMotorbike()==1) {
                        int quantity = vehicleManager.getAll().get(choiceMotorbike - 1).getQuantity();
                        vehicleManager.getAll().get(choiceMotorbike - 1).setQuantity(quantity + 1);
                    }
                }
            } while (choice != 0);
        } while (choiceMotorbike != 0);
    }

    public int returnMotorbike() {
        boolean check = false;
        System.out.println("Nhập mã hợp đồng của bạn");
        int id = invalid.checkNumber();
        String returnFalseMotorbikeLisence = "";
        for (int i = 0; i < rentalManager.showRental().size(); i++) {
            if (rentalManager.showRental().get(i).getRentalID() == (id - 1)) {
                returnFalseMotorbikeLisence = rentalManager.showRental().get(i).getMotorbikeLisence();
                check = true;
                break;
            }
        }
        for (int i = 0; i < motorbikeManager.getAll().size(); i++) {
            if (motorbikeManager.getAll().get(i).getMotorbikeLisencePlate().equals(returnFalseMotorbikeLisence)) {
                motorbikeManager.getAll().get(i).setHired(false);
                readAndWriteMotorbike.writeFile(motorbikeManager.getAll());
                break;
            }
        }
        rentalManager.removeRental(id - 1);
        rentalRead.writeFile(rentalManager.showRental());
        if (check) {
            System.out.println("=====Quý khách đã trả xe thành công, cảm ơn Quý khách đã sử dụng dịch vụ của chúng tôi!======");
            return 1;
        }
        return -1;
    }
}
