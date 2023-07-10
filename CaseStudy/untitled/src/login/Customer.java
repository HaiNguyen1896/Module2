package login;

import model.Rental;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private int idCustomer;
    private String customerUsername;
    private String customerPassword;
    private String customerName;
    private int customerAge;
    private String customerAddress;
    private String customerEmail;
    public static int count;
    List<Rental> myRental = new ArrayList<>();

    public Customer(String role, String customerUsername, String customerPassword, String name, int age, String address, String email) {
        super(role);
        this.idCustomer = count++;
        this.customerUsername = customerUsername;
        this.customerPassword = customerPassword;
        this.customerName = name;
        this.customerAge = age;
        this.customerAddress = address;
        this.customerEmail = email;
    }

    public List<Rental> getMyRental() {
        return myRental;
    }

    public void setMyRental(Rental myRental) {
        this.myRental.add(myRental);
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "Thông tin khách hàng:" + "\n" +
                "\tID khách hàng: " + idCustomer + "\n" +
                "\tTài khoản đăng nhập: " + customerUsername + "\n" +
                "\tHọ và tên: " + customerName + "\n" +
                "\tTuổi: " + customerAge + "\n" +
                "\tĐịa chỉ: " + customerAddress + "\n" +
                "\tEmail: " + customerEmail + "\n" +
                "-----------------------------------";

    }
}
