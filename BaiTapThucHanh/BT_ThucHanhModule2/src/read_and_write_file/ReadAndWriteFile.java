package read_and_write_file;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    File file = new File("src/data/product.csv");

    public void writeFile(List<Product> productList) {
        try {
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Product product : productList) {
                line += product.getId() + "," + product.getProductName() + "," + product.getProductPrice() + "," + product.getProductCapacity() + "," + product.getProductDescribe() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> readFile() {
        List<Product> tempProduct = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                tempProduct.add(new Product(data[0], data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3]), data[4]));
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tempProduct;
    }
}
