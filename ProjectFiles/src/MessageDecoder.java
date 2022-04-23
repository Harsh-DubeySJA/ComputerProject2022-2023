import java.util.Scanner;

public class MessageDecoder {

    public static String decoder(String code, String password) {
        int codeLength = code.length();

//        If Length of Password is less than codeLength
        if (password.length() < codeLength)
            return "Password cannot be smaller than the code";

//        When Length of Password is not less than codeLength
        if (codeLength < password.length())
            password = password.substring(0, codeLength);

        int[] secret = new int[codeLength];
        for (int i = 0; i < codeLength; i++) {
            secret[i] = ( (int)code.charAt(i) ^ (int)password.charAt(i) );
        }

        String message = "";
        for (int decode : secret)
            message += (char)decode;

        return message;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Code and Password");
        String message = decoder(sc.nextLine(), sc.nextLine());
        System.out.println("The Encoded message is " + message);
        sc.close();
    }
}
