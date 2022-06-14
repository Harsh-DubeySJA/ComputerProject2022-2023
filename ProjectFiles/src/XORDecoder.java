import java.util.Scanner;

public class XORDecoder {

    public static String encipher(String plainText, String password) {
        int codeLength = plainText.length();

//        If Length of Password is less than codeLength
        if (password.length() < codeLength)
            password = correctPassword(plainText, password);

//        When Length of Password is not less than codeLength
        else if (codeLength < password.length())
            password = password.substring(0, codeLength);

        int[] secret = new int[codeLength];
        for (int i = 0; i < codeLength; i++) {
            secret[i] = ( (int)plainText.charAt(i) ^ (int)password.charAt(i) );
        }

        String message = "";
        for (int decode : secret)
            message += (char)decode;

        return message;
    }

    private static String correctPassword(String plainText, String password) {
        String copy = password;
        for (int i = password.length(), j = 0; i < plainText.length(); i++)
            if (plainText.charAt(i) == ' ')
                password += " ";
            else {
                password += copy.charAt(j);
                j = j+1 < copy.length() ? j+1 : 0;
            }

        return password;
    }

    public static String dicipher (String cipherText, String password) {
        return encipher(cipherText, password);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Plain Text and Password");
        String cipherText = encipher(sc.nextLine(), sc.nextLine());
        System.out.println("Cipher Text is " + cipherText);
        System.out.println("Enter Cipher Text and Password");
        String plainText = dicipher(sc.nextLine(), sc.nextLine());
        System.out.println("Plain Text is " + plainText);
        sc.close();
    }
}
