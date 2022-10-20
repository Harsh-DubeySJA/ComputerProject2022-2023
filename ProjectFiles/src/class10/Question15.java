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

    public static float seriesSum(int n) {
        int fact = 1;
        float sum = 0;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            sum += 1.0f / fact;
        }
        return sum;
    }
}
