import java.util.Scanner;

public class ChangeToRomanAndInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Roman Number ");
        Roman decimal = new Roman(sc.next());
        System.out.println("Decimal Number " + decimal.romanToDecimal());
        System.out.println("Enter Decimal Number");
        Roman roman = new Roman(sc.nextInt());
        System.out.println("Roman Number " + roman.decimalToRoman());
        System.out.println(roman.getRoman());
        System.out.println(roman.getDecimal());
        System.out.println(decimal.getDecimal());
        System.out.println(decimal.getRoman());
        System.out.println(roman);
        System.out.println(decimal);
        sc.close();
    }
}
