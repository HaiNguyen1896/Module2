import java.util.Scanner;

public class NumberToString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số");
        int number = -1;
        while (number < 0 || number > 999) {
            number = sc.nextInt();
            if (number < 0 || number > 999) {
                System.out.println("Nhập lại");
            }
        }
        int donvi = number % 10;
        int chuc = (number / 10) % 10;
        int tram = (number / 100);
        String chuoiTram = "";
        String chuoiChuc = "";
        String chuoiDonVi = "";
        if (tram > 0 && tram < 10) {
            chuoiTram = laychuoi(tram) + " trăm ";
        } else {
            chuoiTram = "";
        }
        if (chuc == 0 && tram > 0) {
            chuoiChuc = "linh ";
        } else if (chuc == 0) {
            chuoiChuc = "";
        } else if (chuc >= 2 && chuc < 10) {
            chuoiChuc = laychuoi(chuc) + " mươi ";
        } else {
            chuoiChuc = " mười ";
        }
        if (donvi == 0) {
            chuoiDonVi = "";
        } else if (donvi == 1) {
            chuoiDonVi = " mốt ";
        } else {
            chuoiDonVi = laychuoi(donvi);
        }
        System.out.println(chuoiTram + chuoiChuc + chuoiDonVi);
    }

    public static String laychuoi(int numb) {
        String chuoi = "";
        switch (numb) {
            case 0:
                chuoi = "không";
            case 1:
                chuoi = "một";
                break;
            case 2:
                chuoi = "hai";
                break;
            case 3:
                chuoi = "ba";
                break;
            case 4:
                chuoi = "bốn";
                break;
            case 5:
                chuoi = "năm";
                break;
            case 6:
                chuoi = "sáu";
                break;
            case 7:
                chuoi = "bảy";
                break;
            case 8:
                chuoi = "tám";
                break;
            case 9:
                chuoi = "chín";
        }
        return chuoi;
    }
}
