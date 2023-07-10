package read_and_write;

import login.Admin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteAdminFile {
    File file = new File("D:/Work/Codegym/Module2/CaseStudy/untitled/src/ReadAndWrite/TxtFile/Admin.csv");

    public List<Admin> readAdminFile() {
        List<Admin> adminList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                adminList.add(new Admin(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), data[5], data[6]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
        }
        return adminList;
    }

    public void writeAdminFile(List<Admin> adminList) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Admin admin : adminList) {
                line += admin.getRole() + "," + admin.getAdmUsername() + "," + admin.getAdmPassword() + "," + admin.getAdmName() + "," + admin.getAdmAge() + "," + admin.getAdmAdress() + "," + admin.getAdmEmail()+"\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
