import java.util.Scanner;

class SmithNumber {
    private int n;
    public SmithNumber(int n) {
        this.n = n;
    }

    public boolean isSmith() {
        return !isPrime() && (digitSum(n) == primeFactorsSum());
    }

    private int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    private boolean isPrime() {
        if (n == 0 || n == 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3, sqrt = (int) Math.sqrt(n); i < sqrt; i+=2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private int primeFactorsSum() {
        int sum = 0;
        while (n % 2 == 0) {
            sum += 2;
            n /= 2;
        }
        for (int divisor = 3, sqrt = (int) Math.sqrt(n); divisor < sqrt; divisor+=2) {
            if (isPrime())break;
            while (n % divisor == 0) {
                sum += digitSum(divisor);
                n /= divisor;
            }
        }

        if (n > 0 && isPrime())
            sum = sum + digitSum(n);
        return sum;
    }
}

public class MainQ5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int n = sc.nextInt();
        SmithNumber smithNumber = new SmithNumber(n);
        if (smithNumber.isSmith())
            System.out.println(n + " is a Smith Number.");
        else
            System.out.println(n + " is not a Smith Number.");
        sc.close();
    }
}
