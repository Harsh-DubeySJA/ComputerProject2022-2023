import java.util.Scanner;

class TSoundex {
    private static int getConsonantCode( char ch ){
        String[] codeList = { "BFPV", "CGJKQSXZ","DT","L","MN","R" };
        int code = 0;
        for( int i = 0 ; i < codeList.length ; i++ ){
            if( codeList[i].indexOf(ch) >= 0 ) {
                code = i+1;
            }
        }
        return code;
    }
    private static boolean isVowel( char ch ){
        return "AEIOUaeiou".indexOf(ch) >= 0 ;
    }
    public static String getSoundexCode( String str ){
        str=str.toUpperCase();
        String soundexCode = "" + str.charAt(0), temp="";
        int length = str.length();
        char curr, prev, next;
        String dropList = "AEIOUYHW";
        for( int i=1 ; i< length ; i++ ){
            curr = str.charAt(i);
            prev = str.charAt( i-1 );
            if( ( curr=='H' || curr == 'W') && i != length-1 ){
                if( temp.length() >= 2) temp=temp.substring(1);
                next=str.charAt( i+1 );
                if( isVowel(curr) && getConsonantCode( prev ) == getConsonantCode( next ) ){
                    temp += prev+prev;
                    i=i+1;
                }else if( getConsonantCode( prev ) == getConsonantCode( next ) ){
                    temp += prev;
                    i=i+1;
                }
            }else if( getConsonantCode( curr ) != getConsonantCode( prev ) ){
                if( dropList.indexOf( curr ) == -1 ){
                    temp += curr;
                }
            }
        }
        temp = ( temp + "0000" ).substring( 0, 3 );
        for( int i = 0; i<=2 ; i++ ){
            soundexCode += getConsonantCode( temp.charAt( i ) );
        }
        return soundexCode;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter word to be converted into soundex: ");
        System.out.println(getSoundexCode(sc.next()));
        sc.close();
    }
}