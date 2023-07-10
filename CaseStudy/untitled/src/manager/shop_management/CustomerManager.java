package manager.shop_management;

import login.Customer;
import manager.i_manager.IManagement;
import read_and_write.ReadAndWriteCustomerFile;
import regex.Invalid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CustomerManager implements IManagement<Customer> {
    Invalid invalid = new Invalid();
    Scanner sc = new Scanner(System.in);
    List<Customer> customersList;
    ReadAndWriteCustomerFile readAndWriteCustomerFile = new ReadAndWriteCustomerFile();

    public CustomerManager() {
        customersList = readAndWriteCustomerFile.readCustomerFile();
    }

    @Override
    public void add(Customer customer) {
        boolean check = true;
        for (int i = 0; i < customersList.size(); i++) {
            if (customersList.get(i).getCustomerUsername().equals(customer.getCustomerUsername()) && customersList.get(i).getCustomerPassword().equals(customer.getCustomerPassword())) {
                check = false;
                System.out.println("Khách hàng đã có trong danh sách, không thể tạo mới");
                Customer.count = Customer.count - 1;
                break;
            }
        }
        if (check) {
            customersList.add(customer);
            readAndWriteCustomerFile.writeCustomerFile(customersList);
            System.out.println("Thêm Khách hàng thành công");
        }
    }

    @Override
    public void remove(int id) {
        int index = findIndexByID(id);
        if (index == -1) {
            System.out.println("ID không tồn tại");
        } else {
            customersList.remove(index);
            System.out.println("===Xóa thành công===");
        }
    }

    @Override
    public int findIndexByID(int id) {
        for (int i = 0; i < customersList.size(); i++) {
            if (customersList.get(i).getIdCustomer() == id) {
                return i;
            }
        }
        return -1;
    }

    public void edit(int id) {
        int index = findIndexByID(id);
        if (index == -1) {
            System.out.println("ID không tồn tại");
        } else {
            System.out.println("Hãy nhập thông tài khoản Khách hàng");
            String customerUsername = sc.nextLine();
            System.out.println("Hãy nhập mật khẩu tài khoản Khách hàng");
            String customerPassword = sc.nextLine();
            System.out.println("Hãy nhập tên của Khách hàng");
            String customerName = invalid.checkNameString();
            System.out.println("Hãy nhập tuổi của Khách hàng");
            int customerAge = invalid.checkNumber();
            System.out.println("Hãy nhập địa chỉ thường trú của Khách hàng");
            String customerAdress = invalid.checkAdress();
            System.out.println("Hãy nhập Email của Khách hàng");
            String customerEmail = invalid.checkGmail();
            customersList.get(index).setCustomerUsername(customerUsername);
            customersList.get(index).setCustomerPassword(customerPassword);
            customersList.get(index).setCustomerName(customerName);
            customersList.get(index).setCustomerAge(customerAge);
            customersList.get(index).setCustomerAddress(customerAdress);
            customersList.get(index).setCustomerEmail(customerEmail);
        }
    }

    public void editSpecificCustomer(int id, String username, String password) {
        int index = findIndexByID(id);
        if (index == -1) {
            System.out.println("ID không tồn tại");
        } else {
            System.out.println("Hãy nhập tên của Khách hàng");
            String customerName = invalid.checkNameString();
            System.out.println("Hãy nhập tuổi của Khách hàng");
            int customerAge = invalid.checkNumber();
            System.out.println("Hãy nhập địa chỉ thường trú của Khách hàng");
            String customerAdress = invalid.checkAdress();
            System.out.println("Hãy nhập Email của Khách hàng");
            String customerEmail = invalid.checkGmail();
            customersList.get(index).setCustomerName(customerName);
            customersList.get(index).setCustomerAge(customerAge);
            customersList.get(index).setCustomerAddress(customerAdress);
            customersList.get(index).setCustomerEmail(customerEmail);
            readAndWriteCustomerFile.writeCustomerFile(customersList);
        }
    }

    public boolean checkIdentifyUser(String username, String password) {
        for (int i = 0; i < customersList.size(); i++) {
            if (customersList.get(i).getCustomerUsername().equals(username) && customersList.get(i).getCustomerPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public List<Customer> findCustomerByName(String name) {
        List<Customer> tempList = new ArrayList<>();
        for (int i = 0; i < customersList.size(); i++) {
            if (customersList.get(i).getCustomerName().contains(name)) {
                tempList.add(customersList.get(i));
            }
        }
        return tempList;
    }

    @Override
    public List<Customer> getAll() {
        return customersList;
    }
}
