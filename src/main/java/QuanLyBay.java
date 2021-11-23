import java.io.*;
import java.util.*;

public class QuanLyBay {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        List<VeMayBay> list = new ArrayList<>();


        int choose;
        do {
            showMenu();
            choose = input.nextInt();
                switch (choose){
                    case 1:
                            input(list);
                        break;
                    case 2:
                            save(list , "DuLieuBay.dat");
                        break;
                    case 3:
                            sort(list);
                        break;
                    case 4:
                            saveByAirLine(list);
                        break;
                    case 5:
                        System.out.println("Thoát !!");
                        break;

                    default:
                        System.out.println("Input failed !!");
                        break;
                }
        } while (choose != 5);
    }
    static void input(List<VeMayBay> list){
        System.out.println("Nhập số vé máy bay : ");
        int n = input.nextInt();

            for (int i = 0 ; i < n ; i++){
                VeMayBay veMayBay = new VeMayBay();
                veMayBay.input();

                list.add(veMayBay);
            }
    }

    static void save(List<VeMayBay> list,  String filename) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void sort(List<VeMayBay> list) {
        // sap xep
        Collections.sort(list, (o1, o2) ->{
            if (o1.getPrice() < o2.getPrice()){
                return -1;
            }
            return 1;
        });
        for (int i = 0 ; i < list.size(); i++){
            list.get(i).display();
        }
    }
    static void saveByAirLine(List<VeMayBay> list){
        List<VeMayBay> vietjetAirList = getAirLine(list,"VJ");
        save(vietjetAirList, "VietjetAir.dat");

        List<VeMayBay> vietnamAirLineList = getAirLine(list,"VN");
        save(vietnamAirLineList, "VietNamAirLineList.dat");

        List<VeMayBay> jetstarList = getAirLine(list,"JET");
        save(jetstarList, "JetStarList.dat");

    }

    static List<VeMayBay> getAirLine(List<VeMayBay> list , String prex){
        List<VeMayBay> airLineList = new ArrayList<>();
            for (VeMayBay veMayBay : airLineList){
                if(veMayBay.getId().startsWith(prex)){
                    airLineList.add(veMayBay);
                }
            }
            return  airLineList;
    }

    static  void showMenu() {
        System.out.println("1. Nhập thông tin cho N chuyến bay");
        System.out.println("2. Đọc thông tin");
        System.out.println("3. Đọc thông tin từ file và hiển thị");
        System.out.println("4. Sắp xếp theo giá ");
        System.out.println("5. In thông tin mỗi hãng bay ra 1 file");
        System.out.println("Choose: ");
    }
}
