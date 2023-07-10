package Codegym.Manager;

import Codegym.Compare.PriceCompare;
import Codegym.Product.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProductManager {

    List<Product> arrayList = new ArrayList<>();

    public void addProduct(Product product) {
        boolean check = false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getId() == product.getId()) {
                System.out.println("Đã tồn tại id");
                check = true;
                break;
            }
        }
        if (!check) {
            arrayList.add(product);
            System.out.println("-------------Thêm thành công-----------");
        }
    }

    public void editProduct(int id, String name) {
        boolean check = false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getId() == id) {
                arrayList.get(i).setProductName(name);
                System.out.println("----------Sửa thành công------------");
                check = true;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy sản phẩm");
        }
    }

    public void deleteProduct(int id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getId() == id) {
                arrayList.remove(i);
                System.out.println("--------------Xoá thành công------------");
            }
        }
    }

    public void findProductByName(String name) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getProductName().equals(name)) {
                System.out.println(arrayList.get(i));
                System.out.println("---------Tìm thành công---------------");
            }
        }
    }

    public void showProduct() {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    public void comparePriceUp() {
        Collections.sort(arrayList);
        System.out.println("So sánh giá lên");
        for (Product list : arrayList) {
            System.out.println(list.toString());
        }
    }

    public void comparePriceDown() {
        PriceCompare priceCompare = new PriceCompare();
        Collections.sort(arrayList, priceCompare);
        System.out.println("So sánh giá xuống");
        for (Product list : arrayList) {
            System.out.println(list.toString());
        }
    }
}
