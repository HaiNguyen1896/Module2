package product_manager;

import model.Product;
import read_and_write_file.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
    PriceComparator priceComparator;
    Scanner sc = new Scanner(System.in);
    List<Product> productsList;

    public ProductManager() {
        productsList = readAndWriteFile.readFile();
    }

    public void addProduct(Product product) {
        productsList.add(product);
        readAndWriteFile.writeFile(productsList);
    }

    public void updateProduct(Product product, int index) {
        productsList.set(index, product);
        readAndWriteFile.writeFile(productsList);
    }

    public int findIndexByID(String id) {
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public List<Product> getAllProduct() {
        return productsList;
    }

    public void removeProduct(int index) {
        productsList.remove(index);
        readAndWriteFile.writeFile(productsList);
    }

    public void sortProductByAscendingPrice() {
        List<Product> tempList = new ArrayList<>(productsList);
        Collections.sort(tempList, new PriceComparator());
        for (Product product : tempList) {
            System.out.println(product.toString());
        }
    }

    public void sortProductByDecendingPrice() {
        List<Product> tempList = new ArrayList<>(productsList);
        Collections.sort(tempList, Collections.reverseOrder(new PriceComparator()));
        for (Product product : tempList) {
            System.out.println(product.toString());
        }
    }

    public void findHighesPriceProduct() {
        productsList = readAndWriteFile.readFile();
        double maxPrice = productsList.get(0).getProductPrice();
        int index = 0;
        for (int i = 1; i < productsList.size(); i++) {
            if (maxPrice < productsList.get(i).getProductPrice()) {
                maxPrice = productsList.get(i).getProductPrice();
                index = i;
            }
        }
        System.out.println(productsList.get(index).toString());
    }
}
