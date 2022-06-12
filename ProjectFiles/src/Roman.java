public class Roman {

    private int value;
    private String roman;

    Roman(int value) {
        this.value = value;
        roman = "";
    }

    Roman(String roman) {
        this.roman = roman;
    }

    public int romanToDecimal() {
        if (roman == null || roman.isEmpty())
            return 0;

        roman = roman.toUpperCase();
        final String romanCharacters = "IVXLCDM";
        final int[] decimalValues = {1, 5, 10, 50, 100, 500, 1000};
        for (int i = 0, previous = romanCharacters.indexOf(roman.charAt(0)), current; i < roman.length(); i++) {
            current = romanCharacters.indexOf(roman.charAt(i));
            if (previous < current)
                value += decimalValues[current] - 2 * decimalValues[previous];
            else
                value += decimalValues[current];
            previous = current;
        }
        return value;
    }

    public String decimalToRoman(){
        int repeat, copy = value;
        final int[] magnitude ={1000,900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol ={"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for(int x=0; x<magnitude.length; x++){
            repeat=copy/magnitude[x];
            for(int i=1; i<=repeat; i++){
                roman+=symbol[x];
            }
            copy%=magnitude[x];
        }
        return roman;
    }

    public String getRoman() {
        return roman;
    }

    public int getDecimal() {
        return value;
    }

    @Override
    public String toString() {
        return  "value=" + value +
                ",\nroman=" + roman;
    }
}
