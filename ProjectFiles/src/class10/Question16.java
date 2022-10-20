package class10;

import java.util.Scanner;

public class Question16 {
    public static void series(int input) {
        System.out.print(1);
        int sum = 1;
        int h = 0;
        for (int i = 2; sum < input; i++) {
            if (i % 2 == 0) {
                h += 8;
            }
            sum += h;
            System.out.print(" " + sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int input = sc.nextInt();
        series(input);
        sc.close();
    }
}
