import java.util.Scanner;

public class Soundex {
    public String getSoundex (String word) {
        String drop = "";
        return drop;
    }

    public String drop (String word) {
        String drop = "" + word.charAt(0);
//        String
        return drop;
    }
    public static String soundexOut(String word) {
        word = word.toLowerCase();
        String drop = dropedWord(word);
        String soundex = "" + drop.charAt(0);
        int i;
        if (soundexCode(word.charAt(0)) == soundexCode(drop.charAt(1)))
            i = 2;
        else
            i = 1;
        for (; i < drop.length() && soundex.length() < 5; i++) {
            if (i < drop.length()-1 && soundexCode(drop.charAt(i-1)) == soundexCode(drop.charAt(i+1)) ) {
                if (drop.charAt(i) == 'y' || drop.charAt(i) == 'h' || drop.charAt(i) == 'w')
                    i++;
            }
            else {
                int code = soundexCode(drop.charAt(i));
                soundex += code!=0 ? code : "";
            }
        }
        if (soundex.length() < 4)
            for (i = soundex.length(); i < 4; i++) {
                soundex += "0";
            }
        return soundex;
    }
    public static int soundexCode(char c) {
        String [] code = {"bfpv", "cgjkqsxz" , "dt" , "l" , "mn" , "r"} ;
//        int codeNumber = 0;
        for (int i = 0 ; i < code.length ; i++) {
            if (code[i].indexOf(c) != -1) {
                return i+1;
            }
        }
        return 0;

    }
    public static String dropedWord(String word) {
        String drop = "";
        drop += word.toUpperCase().charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' ||
                    word.charAt(i) == 'o' || word.charAt(i) == 'u' )
                continue;
            drop += word.charAt(i);
        }
        return drop;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter word to be converted into soundex: ");
        System.out.println(soundexOut(sc.next()));
        sc.close();
    }
}
