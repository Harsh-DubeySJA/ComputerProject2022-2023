import java.util.Scanner;

public class HammingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("INPUT:\tEnter any number: ");
        int input = sc.nextInt();
        isHamming(input);
        sc.close();
    }

    public static void isHamming(int input) {
        if (input < 0) {
            System.out.println("OUTPUT:\tNEGATIVE NUMBER ENTERED. INVALID INPUT");
            return;
        }
        PrimeSequence prime = new PrimeSequence();
        int divisor = prime.nextPrime();
        int temp = input;
        StringBuilder result = new StringBuilder();
        boolean status = true;
        while (temp != 1) {
            while (temp % divisor == 0) {
                temp /= divisor;
                result.append(divisor);
                if (temp != 1) result.append(" x ");
                if (divisor > 5) status = false;
            }
//            if (temp == 1) break;
            divisor = prime.nextPrime();
        }
        System.out.println("OUTPUT:\t" + input + " = " + result);
        if (status) System.out.println("\t\t" + input + " IS A HAMMING NUMBER");
        else System.out.println("\t\t" + input + " IS NOT A HAMMING NUMBER");
    }
}

class PrimeSequence {
    private int number;

    public PrimeSequence() {
        number = 1;
    }

    public int nextPrime() {
        while (!isPrime(++number));
        return number;
    }

    public boolean isPrime(int number) {
        if (number == 2) return true;
        if ((number&1) == 0) return false;
        for (int i = 3, limit = (int) Math.sqrt(number); i <= limit; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
