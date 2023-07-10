package read_and_write;

import login.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCustomerFile {
    File file = new File("D:/Work/Codegym/Module2/CaseStudy/untitled/src/ReadAndWrite/TxtFile/Customer.csv");

    public List<Customer> readCustomerFile() {
        List<Customer> customerList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                customerList.add(new Customer(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), data[5], data[6]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
        }
        return customerList;
    }

    public void writeCustomerFile(List<Customer> customerList) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Customer customer : customerList) {
                line += customer.getRole() + "," + customer.getCustomerUsername() + "," + customer.getCustomerPassword() + "," + customer.getCustomerName() + "," + customer.getCustomerAge() + "," + customer.getCustomerAddress() + "," + customer.getCustomerEmail() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
