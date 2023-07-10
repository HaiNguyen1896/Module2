package manager.account_management;

import login.Admin;
import manager.i_manager.IManagement;
import read_and_write.ReadAndWriteAdminFile;
import regex.Invalid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminManager implements IManagement<Admin> {
    Invalid invalid = new Invalid();
    Scanner sc = new Scanner(System.in);
    List<Admin> adminList;
    ReadAndWriteAdminFile readAndWriteFile = new ReadAndWriteAdminFile();

    public AdminManager() {
        adminList = readAndWriteFile.readAdminFile();
    }

    @Override
    public void add(Admin admin) {
        boolean check = true;
        for (int i = 0; i < adminList.size(); i++) {
            if (adminList.get(i).getAdmUsername().equals(admin.getAdmUsername()) && adminList.get(i).getAdmPassword().equals(admin.getAdmPassword())) {
                System.out.println("Tài khoản admin đã bị trùng, bạn hãy tạo lại tài khoản khác");
                check = false;
                break;
            }
        }
        if (check) {
            adminList.add(admin);
            readAndWriteFile.writeAdminFile(adminList);
            System.out.println("Thêm admin thành công");
        }
    }

    @Override
    public void remove(int id) {
        int index = findIndexByID(id);
        if (index == -1) {
            System.out.println("ID không tồn tại");
        } else {
            adminList.remove(index);
            readAndWriteFile.writeAdminFile(adminList);
            System.out.println("Bạn đã xóa thành công Admin");
        }
    }

    @Override
    public int findIndexByID(int id) {
        for (int i = 0; i < adminList.size(); i++) {
            if (adminList.get(i).getIdAdm() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Admin> getAll() {
        return adminList;
    }

    public boolean checkIdentifyUser(String username, String password) {
        for (int i = 0; i < adminList.size(); i++) {
            if (adminList.get(i).getAdmUsername().equals(username) && adminList.get(i).getAdmPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void editCurrentAdmin(int id) {
        int index = findIndexByID(id);
        if (index == -1) {
            System.out.println("ID không tồn tại");
        } else {
            System.out.println("Nhập tên đăng nhập của tài khoản");
            String adminCurrentUsername = sc.nextLine();
            System.out.println("Nhập mật khẩu của tài khoản");
            String adminCurrentPassword = sc.nextLine();
            System.out.println("Nhập tên");
            String adminCurrentName = invalid.checkNameString();
            System.out.println("Nhập tuổi");
            int adminCurrentAge = invalid.checkNumber();
            System.out.println("Nhập địa chỉ thường trú");
            String adminCurrentAdress = invalid.checkAdress();
            System.out.println("Nhập email admin");
            String adminCurrentGmail = invalid.checkGmail();
            adminList.get(index).setAdmUsername(adminCurrentUsername);
            adminList.get(index).setAdmPassword(adminCurrentPassword);
            adminList.get(index).setAdmName(adminCurrentName);
            adminList.get(index).setAdmAge(adminCurrentAge);
            adminList.get(index).setAdmAdress(adminCurrentAdress);
            adminList.get(index).setAdmEmail(adminCurrentGmail);
            readAndWriteFile.writeAdminFile(adminList);
        }
    }

    public List<Admin> findAdminByName(String name) {
        List<Admin> tempList = new ArrayList<>();
        for (int i = 0; i < adminList.size(); i++) {
            if (adminList.get(i).getAdmName().contains(name)) {
                tempList.add(adminList.get(i));
            }
        }
        return tempList;
    }

    public void createNewAdmAccount(Admin e) {
        add(e);
    }
}
