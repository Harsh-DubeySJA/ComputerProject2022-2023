package class10;

import java.util.Scanner;

public class Question18SpyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        if (isSpyNumber(n)) {
            System.out.println(n + " is a Spy Number.");
        } else {
            System.out.println(n + " is not a Spy Number.");
        }
        sc.close();
    }

    public static boolean isSpyNumber(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {
            sum += n % 10;
            product *= n % 10;
            n /= 10;
        }
        return (product == sum);
    }
}
