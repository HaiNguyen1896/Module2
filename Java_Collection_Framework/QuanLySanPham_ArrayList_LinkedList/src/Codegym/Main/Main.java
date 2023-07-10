package Codegym.Main;

import Codegym.Manager.ProductManager;
import Codegym.Product.Product;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    ProductManager productManager = new ProductManager();
    public void showMenu() {

        int choice;
        do {
            System.out.println("1. Thêm sản phẩm\n" +
                    "2. Sửa thông tin sản phẩm theo id\n" +
                    "3.Xoá sản phẩm theo id \n" +
                    "4.Hiển thị theo danh sách sản phẩm\n" +
                    "5.Tìm kiếm sản phẩm theo tên\n" +
                    "6.Sắp xếp sản phẩm tăng dần, giảm dần theo giá\n");
            System.out.println("Nhập lựa chọn của bạn");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    productManager.showProduct();
                    break;
                case 5:
                    findAProductbyName();
                    break;
                case 6:
                    System.out.println("Bấm 1 so sánh giá lên và 2 để so sánh giá xuống");
                    int choice2 = Integer.parseInt(sc.nextLine());
                    if(choice2==1) {
                        productManager.comparePriceUp();
                    }else{
                        productManager.comparePriceDown();
                    }
                    break;
            }
        } while (choice!=0);
    }


    public void addProduct(){
        System.out.println("Nhập id sản phẩm");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên sản phẩm");
        String name = sc.nextLine();
        System.out.println("Nhập giá sản phẩm");
        int price = Integer.parseInt(sc.nextLine());
        Product product = new Product(id,name,price);
        productManager.addProduct(product);
    }

    public void editProduct(){
        System.out.println("Nhập id bạn muốn sửa");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên sản phẩm bạn muốn sửa thành");
        String name = sc.nextLine();
        productManager.editProduct(id,name);
    }
    public void deleteProduct(){
        System.out.println("Nhập id sản phẩm bạn muốn xoá");
        int id = Integer.parseInt(sc.nextLine());
        productManager.deleteProduct(id);
    }

    public void findAProductbyName(){
        System.out.println("Nhập tên sản phẩm bạn muốn tìm kiếm");
        String nameProduct = sc.nextLine();
        productManager.findProductByName(nameProduct);
    }



    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }
}
