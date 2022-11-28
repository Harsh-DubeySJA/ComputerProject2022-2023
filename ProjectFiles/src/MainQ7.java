class Anagrams {
    private String input;
    private String output;

    public Anagrams(String input) {
        this.input = input;
    }

    public String combinations() {
        char[] ch = uniqueCharacters();
        swap(ch, 0);
        return output;
    }

    private char[] uniqueCharacters() {
        int size = input.length();
        char[] ch = new char[size];
        for (int i = 0; i < input.length(); i++) ch[i] = input.charAt(i);
        return ch;
    }

    private String charToString(char[] ch) {
        String word = "";
        for (int i = 0; i < ch.length; i++) {
            word += ch[i];
        }
        return word;
    }

    private void swap(char[] ch, int start) {
        if (start == ch.length) {
            output += charToString(ch) + ", ";
        } else {
            for (int i = start; ; i++) {

            }
        }
    }
}

public class MainQ7 {
    public static void main(String[] args) {
    }
}
