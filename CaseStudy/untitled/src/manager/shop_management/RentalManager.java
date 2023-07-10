package manager.shop_management;
import model.Rental;
import read_and_write.ReadAndWriteRental;

import java.util.ArrayList;
import java.util.List;


public class RentalManager {
    ReadAndWriteRental readAndWriteRental = new ReadAndWriteRental();
    List<Rental> rentalList;
    public RentalManager(){
        try{
        rentalList= readAndWriteRental.readFile();
        }catch (Exception e){
            rentalList=new ArrayList<>();
        }
    }
    public void addRentVehicle(Rental rental){
       rentalList.add(rental);
       readAndWriteRental.writeFile(rentalList);
    }
    public List<Rental> showRental(){
        return rentalList;
    }
    public int findIndexByID(int id) {
        for (int i = 0; i < rentalList.size(); i++) {
            if (rentalList.get(i).getRentalID() == id) {
                return i;
            }
        }
        return -1;
    }
    public void removeRental(int id){
        int index = findIndexByID(id);
        if (index == -1) {
            System.out.println("ID không tồn tại");
        } else {
            rentalList.remove(index);
        }
    }

}
