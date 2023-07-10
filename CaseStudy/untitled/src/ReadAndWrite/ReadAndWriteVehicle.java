package read_and_write;

import model.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteVehicle {
    File file = new File("D:/Work/Codegym/Module2/CaseStudy/untitled/src/ReadAndWrite/TxtFile/Vehicle.csv");

    public void writeFile(List<Vehicle> vehicles) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Vehicle vehicle : vehicles) {
                line += vehicle.getModel() + "," + vehicle.getProductManufactoringYear() + "," + vehicle.getType() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Vehicle> readFile() {
        Vehicle.count = 0;
        List<Vehicle> tempVehicle = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                tempVehicle.add(new Vehicle(data[0], Integer.parseInt(data[1]), data[2]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
        }
        return tempVehicle;
    }
}