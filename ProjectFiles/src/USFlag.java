public class USFlag {
    public static void main(String[] args) {
        for (int j = 0; j < 9; j++) {
            if (j % 2 == 0) {
                System.out.print("☆ ☆ ☆ ☆ ☆ ☆");
                System.out.println("__________________________");
            } else {
                System.out.print(" ☆ ☆ ☆ ☆ ☆ ");
                System.out.println("__________________________");
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("_______________________________________");
        }
    }
}
