package manager.shop_management;

import manager.i_manager.IManagement;
import model.Motorbike;
import read_and_write.ReadAndWriteMotorbike;
import regex.Invalid;

import java.util.List;
import java.util.Scanner;

public class MotorbikeManager implements IManagement<Motorbike> {
    Invalid invalid = new Invalid();
    Scanner sc = new Scanner(System.in);
    private List<Motorbike> motorbikeDetailList;
    ReadAndWriteMotorbike readAndWriteMotorbike = new ReadAndWriteMotorbike();

    public MotorbikeManager() {
        this.motorbikeDetailList = readAndWriteMotorbike.readFile();
    }

    @Override
    public void add(Motorbike motorbike) {
        motorbikeDetailList.add(motorbike);
        readAndWriteMotorbike.writeFile(motorbikeDetailList);
        System.out.println("Thêm xe thành công");
    }

    @Override
    public void remove(int id) {
        int index = findIndexByID(id);
        if (index == -1) {
            System.out.println("ID không tồn tại");
        } else {
            motorbikeDetailList.remove(index);
            readAndWriteMotorbike.writeFile(motorbikeDetailList);
            System.out.println("===Xóa thành công===");
        }
    }

    public void removeByIndex(int index) {
        motorbikeDetailList.remove(index);
        readAndWriteMotorbike.writeFile(motorbikeDetailList);
    }

    @Override
    public int findIndexByID(int id) {
        for (int i = 0; i < motorbikeDetailList.size(); i++) {
            if (motorbikeDetailList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Motorbike> getAll() {
        return motorbikeDetailList;
    }

    public void editDetailMotorbike(int id) {
        int index = findIndexByID(id);
        if (index == -1) {
            System.out.println("ID không tồn tại");
        } else {
            System.out.println("Hãy nhập dòng xe: ");
            String model = sc.nextLine();
            System.out.println("Nhập năm sản xuất xe");
            int productManufactoringYear = invalid.checkNumber();
            System.out.println("Nhập loại xe: ");
            String type = sc.nextLine();
            System.out.println("Nhập biển kiểm soát: ");
            String motorbikeLisencePlate = sc.nextLine();
            System.out.println("Nhập màu xe: ");
            String motorbikeColor = sc.nextLine();
            Boolean isHired = false;
            motorbikeDetailList.get(index).setProductManufactoringYear(productManufactoringYear);
            motorbikeDetailList.get(index).setModel(model);
            motorbikeDetailList.get(index).setType(type);
            motorbikeDetailList.get(index).setMotorbikeLisencePlate(motorbikeLisencePlate);
            motorbikeDetailList.get(index).setColor(motorbikeColor);
            motorbikeDetailList.get(index).setHired(isHired);
            readAndWriteMotorbike.writeFile(motorbikeDetailList);
            System.out.println("============Sửa thành công============");
        }
    }
}
