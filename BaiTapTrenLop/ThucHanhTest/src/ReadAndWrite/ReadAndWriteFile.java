package ReadAndWrite;

import model.Product;

import java.io.*;
import java.util.List;

public class ReadAndWriteFile {
    File file = new File("src/data/product.csv");

    public void writeFile(List<Product> productList){

        try {
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
            String line = "";
            for(Product product : productList){
                
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
