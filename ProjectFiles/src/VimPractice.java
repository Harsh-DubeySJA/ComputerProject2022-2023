import java.util.Scanner;

public class VimPractice {
    public static int checkMatch(String word, String guess) {
        int count = 0;
        for (int i = 0, maxLength = word.length() - guess.length(), guessLength = guess.length(); i < maxLength; i++) {
            if (word.substring(i, i + guessLength).equals(guess))
                count++;
        }
        return count;
    }

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word and Guess Word");
        System.out.println(checkMatch(sc.next(), sc.next()));
        sc.close();
    }
}
