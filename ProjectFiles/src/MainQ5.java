import java.util.Scanner;

class SmithNumber {
    private int input;
    public SmithNumber(int input) {
        this.input = input;
    }

    public boolean isSmith() {
        return !isPrime() && (digitSum(input) == primeFactorsSum());
    }

    private int digitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private boolean isPrime() {
        if (input == 0 || input == 1) return false;
        if (input == 2) return true;
        if (input % 2 == 0) return false;
        for (int i = 3, sqrt = (int) Math.sqrt(input); i < sqrt; i+=2) {
            if (input % i == 0)
                return false;
        }
        return true;
    }

    private int primeFactorsSum() {
        int sum = 0;
        while (input % 2 == 0) {
            sum += 2;
            input /= 2;
        }
        for (int divisor = 3, sqrt = (int) Math.sqrt(input); divisor < sqrt; divisor+=2) {
            if (isPrime())break;
            while (input % divisor == 0) {
                sum += digitSum(divisor);
                input /= divisor;
            }
        }

        if (input > 0 && isPrime())
            sum = sum + digitSum(input);
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
