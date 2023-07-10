package read_and_write;
import model.Motorbike;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteMotorbike {
    File file = new File("D:/Work/Codegym/Module2/CaseStudy/untitled/src/ReadAndWrite/TxtFile/Motorbike.csv");

    public void writeFile(List<Motorbike> motorbikes) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Motorbike motorbike : motorbikes) {
                line += motorbike.getModel() + "," + motorbike.getProductManufactoringYear() + "," + motorbike.getType() + "," + motorbike.getMotorbikeLisencePlate() + "," + motorbike.getColor() + "," + motorbike.isHired()+"\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Motorbike> readFile() {
        Motorbike.countID = 0;
        List<Motorbike> tempMotorbike = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                tempMotorbike.add(new Motorbike(data[0], Integer.parseInt(data[1]), data[2], data[3], data[4], Boolean.parseBoolean(data[5])));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
        }
        return tempMotorbike;
    }
}
