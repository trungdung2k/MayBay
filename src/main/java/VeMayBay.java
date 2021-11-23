import lombok.Data;

import java.io.Serializable;
import java.util.Scanner;

@Data
public class VeMayBay implements Serializable {
    String id;
    String name;
    String date;
    String baggage;
    int price;

    public VeMayBay (){
    }

    public VeMayBay(String id, String name, String date, String baggage, int price) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.baggage = baggage;
        this.price = price;
    }

    public void  input() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã vé: ");
        id = input.nextLine();

        System.out.println("Nhập tên chuyến bay: ");
        name = input.nextLine();

        System.out.println("Nhập ngày bay: ");
        date = input.nextLine();

        System.out.println("Nhập hành lí kí gửi: ");
        baggage = input.nextLine();

        System.out.println("Nhập giá vé máy bay : ");
        price = Integer.parseInt(input.nextLine());
    }

    @Override
    public String toString() {
        return "VeMayBay{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", baggage='" + baggage + '\'' +
                ", price=" + price +
                '}';
    }

    public  void display (){
        System.out.println(toString());
    }
}
