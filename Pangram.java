import java.util.Scanner;

class PangramCheck {
    private String input;
    private boolean isPan = true;

    public PangramCheck(String input) {
        this.input = input;
        checkPangaram();
    }

    private void checkPangaram() {
        boolean[] counter = new boolean[26];
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            int pointer =  input.charAt(i) - 'a';
            if (pointer >= 0 && pointer < 26)
                counter[pointer] = true;
        }
        for (boolean check : counter) {
            if (!check) {
                isPan = false;
                break;
            }
        }
    }

    public String toString() {
        if (isPan) {
            return "\"" + input + "\"" + " is a Pangram.";
        } else {
            return "\"" + input + "\"" + " is not a Pangram.";
        }
    }
}

public class Pangram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence : ");
        String input = sc.nextLine();
        PangramCheck checker = new PangramCheck(input);
        System.out.println(checker);
        sc.close();
    }
}
