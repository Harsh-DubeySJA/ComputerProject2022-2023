package class10;

import java.util.Scanner;

public class Atransport {
    private String name;
    private int w, charge;

    public void accept() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name of the Customer: ");
        name = sc.next();
        System.out.print("Weight of the parcel: ");
        w = sc.nextInt();
        sc.close();
    }

    public void calculate() {
        if (w <= 10) {
            charge = 25 * w;
        } else if (w <= 30) {
            charge = 250 + (20 * (w-10));
        } else {
            charge = 650 + (10 * (w-30));
        }
    }

    public void print() {
        System.out.println("Name\tWeight\tBill\tAmount");
        System.out.println(name + "\t" + w + "\t" + charge + "\t" + (charge + ((charge * 5) / 100)));
    }

    public static void main(String[] args) {
        Atransport atransport = new Atransport();
        atransport.accept();
        atransport.calculate();
        atransport.print();
    }
}
