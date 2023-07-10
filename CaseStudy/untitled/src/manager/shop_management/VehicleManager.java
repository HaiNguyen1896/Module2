package manager.shop_management;

import manager.i_manager.IManagement;
import model.Motorbike;
import model.Vehicle;
import read_and_write.ReadAndWriteMotorbike;
import read_and_write.ReadAndWriteVehicle;

import java.util.List;
import java.util.Scanner;

public class VehicleManager implements IManagement<Vehicle> {
    Scanner sc = new Scanner(System.in);
    private List<Vehicle> motorbikeList;
    ReadAndWriteVehicle readAndWriteVehicle = new ReadAndWriteVehicle();

    ReadAndWriteMotorbike readAndWriteMotorbike = new ReadAndWriteMotorbike();

    public VehicleManager() {
        this.motorbikeList = readAndWriteVehicle.readFile();
    }

    @Override
    public void add(Vehicle vehicle) {
        boolean check = true;
        for (int i = 0; i < motorbikeList.size(); i++) {
            if (motorbikeList.get(i).getModel().equalsIgnoreCase(vehicle.getModel()) && motorbikeList.get(i).getProductManufactoringYear() == vehicle.getProductManufactoringYear()) {
                check = false;
                System.out.println("Dòng xe đã có trong danh sách, không thể tạo mới");
                break;
            }
        }
        if (check) {
            motorbikeList.add(vehicle);
            readAndWriteVehicle.writeFile(motorbikeList);
            System.out.println("Thêm xe thành công");
        }
    }

    @Override
    public void remove(int id) {
        int index = findIndexByID(id);
        if (index == -1) {
            System.out.println("ID không tồn tại");
        } else {
            motorbikeList.remove(index);
            readAndWriteVehicle.writeFile(motorbikeList);
            System.out.println("===Xóa thành công===");
        }
    }

    public void edit(int id) {
        int index = findIndexByID(id);
        if (index == -1) {
            System.out.println("ID không tồn tại");
        } else {
            System.out.println("Hãy nhập dòng xe mới: ");
            String model = sc.nextLine();
            System.out.println("Nhập năm sản xuất dòng xe");
            System.out.println("Nhập loại xe: ");
            String type = sc.nextLine();
            int manufactoringYear = Integer.parseInt(sc.nextLine());
            motorbikeList.get(index).setModel(model);
            motorbikeList.get(index).setProductManufactoringYear(manufactoringYear);
            motorbikeList.get(index).setType(type);
        }
    }

    @Override
    public int findIndexByID(int id) {
        for (int i = 0; i < motorbikeList.size(); i++) {
            if (motorbikeList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Vehicle> getAll() {
        return motorbikeList;
    }

    public void getAndSetSizeOfMotorbike() {
        List<Motorbike> tempMotorbikeModel = readAndWriteMotorbike.readFile();
        for (int i = 0; i < motorbikeList.size(); i++) {
            int count = 0;
            for (int j = 0; j < tempMotorbikeModel.size(); j++) {
                if (tempMotorbikeModel.get(j).getModel().equals(motorbikeList.get(i).getModel())) {
                    if(tempMotorbikeModel.get(j).isHired()==true){
                    }else {
                        count++;
                    }
                }
            }
            motorbikeList.get(i).setQuantity(count);
        }
    }
}