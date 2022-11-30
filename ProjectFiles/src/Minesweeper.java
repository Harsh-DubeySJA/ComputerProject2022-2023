//import java.util.Arrays;
//import java.util.Scanner;
//
//class Mines {
//
//    public Mines() {
//        available();
//    }
//    private char[][] mine;
//    private char [][] temp1 = {
//                    {' ' , '*' , ' ' , ' ' , ' ' , ' '},
//                    {' ' , ' ' , '*' , ' ' , ' ' , ' '},
//                    {' ' , ' ' , ' ' , '*' , ' ' , ' '},
//                    {' ' , ' ' , ' ' , ' ' , '*' , ' '},
//                    {' ' , ' ' , ' ' , ' ' , ' ' , ' '}
//            },
//            temp2 = {
//                    {' ' , ' ' , '*' , ' ' , ' ' , ' ' , ' ' , ' '},
//                    {' ' , ' ' , ' ' , '*' , ' ' , ' ' , ' ' , ' '},
//                    {' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' '},
//                    {' ' , ' ' , ' ' , ' ' , '*' , ' ' , ' ' , ' '},
//                    {' ' , ' ' , ' ' , ' ' , ' ' , '*' , ' ' , ' '},
//                    {' ' , ' ' , ' ' , ' ' , ' ' , '*' , ' ' , ' '},
//                    {' ' , ' ' , ' ' , ' ' , '*' , ' ' , ' ' , ' '},
//                    {' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' '},
//                    {' ' , ' ' , ' ' , ' ' , ' ' , ' ' , '*' , ' '},
//                    {' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' '},
//                    {' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' '}
//            },
//            temp3 = {
//                    {' ' , ' ' , ' ' , ' ' , ' ' , '*'},
//                    {' ' , ' ' , ' ' , ' ' , ' ' , '*'},
//                    {' ' , ' ' , '*' , ' ' , ' ' , ' '},
//                    {' ' , ' ' , ' ' , ' ' , '*' , '*'},
//                    {' ' , ' ' , ' ' , ' ' , '*' , '*'},
//                    {' ' , ' ' , ' ' , '*' , '*' , ' '},
//                    {' ' , ' ' , '*' , '*' , ' ' , ' '},
//                    {' ' , ' ' , '*' , ' ' , ' ' , ' '},
//                    {' ' , '*' , ' ' , ' ' , ' ' , ' '},
//                    {'*' , ' ' , ' ' , ' ' , ' ' , ' '}
//            },
//            temp4 = {
//                    {' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
//            };
//
//    private void available() {
//        System.out.println("Available Maze :\n");
//        System.out.println("Maze 1:");
//        display(temp1);
//
//        System.out.println("\nMaze 2:");
//        display(temp2);
//
//        System.out.println("\nMaze 3:");
//        display(temp3);
//
//        System.out.println("\nMaze 4:");
//        display(temp4);
//    }
//
//    private void display(char[][] mine) {
//        for (char[] row : mine) {
//            for (char col : row) {
//                System.out.print(col);
//            }
//            System.out.println();
//        }
//    }
//
//    private void populate(){
//        int sum=0;
//        for( int x=0; x<mine.length; x++ ){
//            for( int y=0; y<mine[x].length; y++ ){
//                sum=getValue(x-1,y-1)+
//                        getValue(x-1,y)+
//                        getValue(x-1,y+1)+
//                        getValue(x,y-1)+
//                        getValue(x,y+1)+
//                        getValue(x+1,y-1)+
//                        getValue(x+1,y)+
//                        getValue(x+1,y+1);
//                if (mine[x][y]!='*' && sum!=0) {
//                    mine[x][y]=(char)(sum+48);
//                } else {
//                    mine[x][y]=mine[x][y]=='*'?'*':'.';
//                }
//            }
//        }
//    }
//
//    private int getValue( int x, int y){
//        if (x>=0 && x<mine.length && y>=0 && y<mine[x].length) {
//            if(mine[x][y]=='*') return 1;
//        }
//        return 0;
//    }
//}
//
//public class Minesweeper {
//    public static void main( String args[] ){
//        Scanner sc = new Scanner(System.in);
//        System.out.println(
//                "Choose your grid\n1.[6x5] [Default]\n2.[8x11]\n3.[6x10]\n4.[10x10]"
//        );
//        Mines m = new Mines();
//        m.mineSize(sc.nextInt());
//        sc.close();
//    }
//}


class Minesweeper{
    char[][] mine;
    public Minesweeper(char[][] mine) {
        this.mine=mine;
    }

    public static void main(String[] args){
        char[][] mine = {
                {' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', '*', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        Minesweeper m = new Minesweeper(mine);
        m.populate();
        m.display();
    }

    public void populate( ){
        int sum;
        for( int x=0; x<mine.length; x++ ){
            for( int y=0; y<mine[x].length; y++ ){
                sum=getValue(x-1,y-1)+
                        getValue(x-1,y)+
                        getValue(x-1,y+1)+
                        getValue(x,y-1)+
                        getValue(x,y+1)+
                        getValue(x+1,y-1)+
                        getValue(x+1,y)+
                        getValue(x+1,y+1);
                System.err.println(x+" "+y+" "+sum);
                if( mine[x][y]!='*' && sum!=0 ){
                    mine[x][y]=(char)(sum+48);
                }else{
                    mine[x][y]=mine[x][y]=='*'?'*':'.';
                }
            }
        }
    }

    public  int getValue( int x, int y){
        if (x>=0 && x<mine.length && y>=0 && y<mine[x].length){
            if(mine[x][y]=='*') return 1;
        }
        return 0;
    }

    public void display() {
        for (char[] row : mine) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}