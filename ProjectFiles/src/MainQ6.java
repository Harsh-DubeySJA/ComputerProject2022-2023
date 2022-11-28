import java.util.Scanner;

class LargeNumberSum {

    private String firstNumber, secondNumber;

    public LargeNumberSum(String firstNumber, String secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public String sum() {

        if (secondNumber.length() > firstNumber.length()) {
            String temp = firstNumber;
            firstNumber = secondNumber;
            secondNumber = temp;
        }

        if (firstNumber.charAt(0) == '-' && secondNumber.charAt(0) != '-') {
            String temp = firstNumber;
            firstNumber = secondNumber;
            secondNumber = temp;
        }
        String output = subtract();
        return output;
    }

    private String subtract() {
        String largeSum = "";
        int i, j;
        boolean hasBorrowed = false;
        for (i = firstNumber.length() - 1, j = secondNumber.length() - 1; i >= 0; i--, j--) {
            char first = firstNumber.charAt(i);
            char second = secondNumber.charAt(j);
            if (first >= second) {
                if (hasBorrowed) {
                    int ans = (first - second) - 1;
                    if (ans < 0)
                        largeSum = (ans + 10) + largeSum;
                    else {
                        largeSum = ans + largeSum;
                        hasBorrowed = false;
                    }
                }
                else
                    largeSum = (first - second) + largeSum;
            } else {
                hasBorrowed = true;
                largeSum = (10 + (first - second)) + largeSum;
            }
        }
        return largeSum;
    }

    private String add() {
        String largeSum = "";
        int i = firstNumber.length() - 1, j = secondNumber.length() - 1;
        int digitSum = 0;
        while (j > 0) {
            digitSum += ((firstNumber.charAt(i--) - 48) + (secondNumber.charAt(j--) - 48));
            largeSum = (digitSum % 10) + largeSum;
            digitSum /= 10;
        }
        if (digitSum > 0) {
            if (i >= 0)
                largeSum = (digitSum + (firstNumber.charAt(i--) - 48)) + largeSum;
            else
                largeSum = digitSum + largeSum;
        }
        if (i >= 0)
            return firstNumber.substring(0, i+1) + largeSum;
        return largeSum;
    }
}

public class MainQ6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("A = ");
        String firstNumber = sc.next();
        System.out.print("B = ");
        String secondNumber = sc.next();
        LargeNumberSum largeNumber = new LargeNumberSum(firstNumber, secondNumber);
        System.out.println("Sum = " + largeNumber.sum());
        sc.close();
    }
}
