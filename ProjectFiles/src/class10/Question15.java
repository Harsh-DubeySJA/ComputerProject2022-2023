package class10;

import java.util.Scanner;

public class Question15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int n = sc.nextInt();
        System.out.println(seriesSum(n));
        sc.close();
    }

    public static double seriesSum(int n) {
        double fact = 1;
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            sum += 1.0d / fact;
        }
        return sum;
    }
}
