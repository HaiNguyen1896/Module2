package main_menu;

import model.Product;
import product_manager.ProductManager;
import regex.Regex;

import java.util.Scanner;

public class MainMenu {
    Scanner sc = new Scanner(System.in);
    ProductManager productManager = new ProductManager();
    Regex regex = new Regex();
//    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();

    public void showMenu() {
        int choice = -1;
        do {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM----\n" +
                    "Chọn chức năng theo số (để tiếp tục)\n" +
                    "1. Xem danh sách\n" +
                    "2. Thêm mới\n" +
                    "3. Cập nhập\n" +
                    "4. Xóa\n" +
                    "5. Sắp xếp\n" +
                    "6. Tìm sản phẩm có giá đắt nhất\n" +
                    "7. Thoát");
            System.out.println("Chọn chức năng:");
            choice = regex.checkInvalidNumber();
            switch (choice) {
                case 1:
                    showProductList();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    removeProduct();
                    break;
                case 5:
                    ascendingAndDecendingPrice();
                    break;
                case 6:
                    productManager.findHighesPriceProduct();
                    break;
                default:
                    System.out.println("Nhập sai tùy chọn");
            }
        } while (choice != 7);

    }

    public void addProduct() {
        System.out.println("Nhập mã sản phẩm");
        String id = checkProductID();
        System.out.println("Nhập tên sản phẩm");
        String productName = regex.checkInvalidString();
        System.out.println("Nhập giá sản phẩm");
        int productPrice = regex.checkInvalidNumber();
        System.out.println("Nhập số lượng sản phẩm");
        int productCapacity = regex.checkInvalidNumber();
        System.out.println("Nhập mô tả sản phẩm");
        String productDescrible = sc.nextLine();
        Product product = new Product(id, productName, productPrice, productCapacity, productDescrible);
        productManager.addProduct(product);
    }

    public void updateProduct() {
        String id;
        boolean check = false;
        int index;
        do {
            System.out.println("Nhập mã sản phẩm");
            id = sc.nextLine();
            index = productManager.findIndexByID(id);
            if (id.equals("")) {
                check = true;
                break;
            }
            if (index == -1) {
                System.out.println("Không tìm được sản phẩm trên, hãy nhập lại");
            } else {
                break;
            }
        } while (true);
        if (check) {
            return;
        }
        System.out.println("Nhập tên sản phẩm");
        String productName = regex.checkInvalidString();
        System.out.println("Nhập giá sản phẩm");
        int productPrice = regex.checkInvalidNumber();
        System.out.println("Nhập số lượng sản phẩm");
        int productCapacity = regex.checkInvalidNumber();
        System.out.println("Nhập mô tả sản phẩm");
        String productDescrible = sc.nextLine();
        Product product = new Product(id, productName, productPrice, productCapacity, productDescrible);
        productManager.updateProduct(product, index);
    }

    public void removeProduct() {
        String id;
        boolean check = false;
        int index;
        do {
            System.out.println("Nhập mã sản phẩm");
            id = sc.nextLine();
            index = productManager.findIndexByID(id);
            if (id.equals("")) {
                check = true;
                break;
            }
            if (index == -1) {
                System.out.println("Không tìm được sản phẩm trên, hãy nhập lại");
            } else {
                break;
            }
        } while (true);
        if (check) return;
        System.out.println("Bạn có chắc chắc muốn xóa không, nhập Y nếu muốn xóa, nhập ký tự khác để thoát khỏi chương trình");
        String choice = regex.checkInvalidString();
        if (choice.equals("Y")) {
            productManager.removeProduct(index);
        } else {
            return;
        }
    }

    public void showProductList() {
        int pageSize = 5;
        int pageIndex = 0;
        boolean shouldContinue = true;
        if(productManager.getAllProduct().size()==0){
            System.out.println("Chưa có sản phẩm trong danh sách");
            return;
        }
        while (shouldContinue) {
            for (int i = pageIndex; i < pageSize + pageIndex && i < productManager.getAllProduct().size(); i++) {
                System.out.println(productManager.getAllProduct().get(i).toString());
            }

            pageIndex += pageSize;
            if (pageIndex >= productManager.getAllProduct().size()) {
                System.out.println("Đã hiển thị hết sản phẩm");
                break;
            }
            System.out.println("Nhấn enter để tiếp tục hoặc exit để thoát");
            String choice = sc.nextLine();
            if (choice.equals("exit")) {
                shouldContinue = false;
            }
        }

//        for (int i = 0; i < productManager.getAllProduct().size(); i++) {
//            int count = 0;
//            System.out.println(productManager.getAllProduct().get(i).toString());
//            if(count==4){
//
//            }
//        }
    }

    public void ascendingAndDecendingPrice() {
        int choice;
        do {
            System.out.println("1. Sắp xếp theo giá tăng dần\n" +
                    "2. Sắp xếp theo giá giảm dần\n" +
                    "3. Thoát");
            System.out.println("Nhập tùy chọn của bạn");
            choice = regex.checkInvalidNumber();
            switch (choice) {
                case 1:
                    productManager.sortProductByAscendingPrice();
                    break;
                case 2:
                    productManager.sortProductByDecendingPrice();
                    break;
                default:
                    if (choice != 3) System.out.println("Nhập lại tùy chọn");
            }
        } while (choice != 3);
    }

    public String checkProductID() {
        boolean check = true;
        String id;
        do {
            id = sc.nextLine();
            for (int i = 0; i < productManager.getAllProduct().size(); i++) {
                if (id.equals(productManager.getAllProduct().get(i).getId())) {
                    System.out.println("Id đã trùng");
                    check = false;
                }else{
                    check=true;
                }
            }
        }while(!check);
        return id;
    }
//        String id="";
//        if(productManager.getAllProduct().size()==0){
//            return id;
//        }
//        while(check) {
//            id = sc.nextLine();
//            for (int i = 0; i < productManager.getAllProduct().size(); i++) {
//                if (id.equals(productManager.getAllProduct().get(i).getId())) {
//                    System.out.println("ID bị trùng");
//                    break;
//                }
//            }
//            if(check)
//
//        }
//        return id;
//    }
}
