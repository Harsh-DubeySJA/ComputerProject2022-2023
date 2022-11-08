import java.util.Scanner;

class InnerAnagram {
    private String input;
    private String output;
    private int count;
    public InnerAnagram(String input) {
        this.input = input;
        output = "";
        count = 0;
    }

    public void getCombinations() {
        char[] chars = splitCharacters();
        permute(chars, 0);
        System.out.println("OUTPUT: \n" + output);
        System.out.println("TOTAL NO. OF ANAGRAMS: " + count);
    }

    private void permute(char[] chars, int position) {
        if (position == input.length() - 1) {
            output += joinString(chars) + "\n";
            count++;
        } else {
            for (int i = position; i < input.length(); i++) {
                if (chars[i] == chars[position] && i != position)
                    continue;
                char temp = chars[i];
                chars[i] = chars[position];
                chars[position] = temp;
                permute(chars, position+1);
                // maintains the original array
                temp = chars[i];
                chars[i] = chars[position];
                chars[position] = temp;
            }
        }
    }

    private String joinString(char[] chars) {
        StringBuilder newStr = new StringBuilder();
        for (char ch: chars) {
            newStr.append(ch);
        }
        return newStr.toString();
    }

    private char[] splitCharacters() {
        int length = input.length();
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = input.charAt(i);
        }
        return chars;
    }
}

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("INPUT: ");
        String word = sc.next();
        InnerAnagram inner = new InnerAnagram(word);
        inner.getCombinations();
        sc.close();
    }
}
