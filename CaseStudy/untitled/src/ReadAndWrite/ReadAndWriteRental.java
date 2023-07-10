package read_and_write;
import model.Rental;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteRental {
    File file = new File("D:/Work/Codegym/Module2/CaseStudy/untitled/src/ReadAndWrite/TxtFile/Rental.csv");

    public void writeFile(List<Rental> rentalList)  {
        try {
            FileWriter fileReader = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader);
            String line = "";
            for (Rental rental : rentalList) {
                line +=  rental.getCustomerName()+ "," + rental.getMotorbikeType() + "," + rental.getMotorbikeLisence() + "," + rental.getStartDay() + "," + rental.getReturnDay()+","+rental.getAmountPaid()+"\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public List<Rental> readFile(){
        List<Rental> tempRental = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line=bufferedReader.readLine())!=null){
                String[] data = line.split(",");
                tempRental.add(new Rental(data[0], data[1],data[2],data[3],data[4],Double.parseDouble(data[5])));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            System.out.println(e);
        }
    return tempRental;
    }
}
