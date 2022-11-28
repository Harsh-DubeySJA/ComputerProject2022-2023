import java.util.Scanner;

class Sum {
    private String first;
    private String second;
    private String output = "";

    public Sum(String first, String second) {
        this.first = first;
        this.second = second;
        sum();
    }

    private void sum() {
        boolean firstNegative = false;
        boolean secondNegative = false;
        if (first.charAt(0) == '-') {
            first = first.substring(1);
            firstNegative = true;
        }
        if (second.charAt(0) == '-') {
            second = second.substring(1);
            secondNegative = true;
        }
        if (firstNegative == secondNegative) {
            addition();
            if (firstNegative) {
                output = "-" + output;
            }
        } else if (first.length() <= second.length()) {
            outer:
            if (first.length() == second.length()) {
                for (int i = 0; i < first.length(); i++) {
                    if (first.charAt(i) > second.charAt(i)) {
                        break;
                    }
                    if (first.charAt(i) < second.charAt(i)) {
                        break outer;
                    }
                }
                subtraction();
                return;
            }
            String temp = first;
            first = second;
            second = temp;
            subtraction();
            if (secondNegative) {
                output = "-" + output;
            }
        } else {
            subtraction();
        }
    }

    private void addition() {
        int data = 0;
        int i = first.length() - 1, j = second.length() - 1;
        while (j >= 0) {
            data += first.charAt(i) - '0' + second.charAt(j) - '0';
            output = data % 10 + output;
            data /= 10;
            i--;
            j--;
        }
        if(data > 0) {
            if (i == j) {
                output = data + output;
            }
            else {
                output = first.charAt(i) - '0' + data + output;
            }
            i--;
        }
        while (i >= 0) {
            output = first.charAt(i) - '0' + output;
            i--;
        }
    }

    private void subtraction() {
        int data;
        boolean carry = false;
        int i = first.length() - 1;
        int j = second.length() - 1;
        while (j >= 0) {
            char one = first.charAt(i);
            char two = second.charAt(j);
            if (one < two) {
                data = (10 + (one - '0')) - (two - '0');
                if (carry) {
                    data--;
                }
                carry = true;
            }
            else {
                data = (one - '0' - (two - '0'));
                if (carry) {
                    data--;
                    carry = false;
                }
            }
            output = data + output;
            i--;
            j--;
        }
        if (i >= 0 && carry) {
            output = first.charAt(i) - '0' - 1 + output;
            i--;
        }
        while (i >= 0) {
            output = first.charAt(i) - '0' + output;
            i--;
        }
        if (output.charAt(0) == '0') {
            for (int counter = 1; counter < output.length()-1; counter++) {
                if (output.charAt(counter) != '0') {
                    output = output.substring(counter);
                    break;
                }
            }
        }
    }

    public String toString() {
        return "Sum = " + output;
    }
}

public class LongNumberSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers to be added");
        System.out.print("A = ");
        String first = sc.next();
        System.out.print("B = ");
        String second = sc.next();
        Sum sum = new Sum(first, second);
        System.out.println(sum);
        sc.close();
    }
}
