import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Raffle {
    private String[] individuals;
    private int noOfWinners;

    Raffle(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            Scanner sc = new Scanner(new FileReader(fileName));
            BufferedReader br = new BufferedReader(reader);
            int length = 0;
            while (sc.nextLine() != null)
                length++;
            individuals = new String[length];
            for (int i = 0; i < length; i++) {
                individuals[i] = br.readLine();
            }
        } catch (IOException e) {
            System.out.println();
        }
    }

    private void draw (int prizeCount) {
        noOfWinners = prizeCount;
        for (int i = 0; i < prizeCount;) {
            int index = (int) (Math.random() * prizeCount) + prizeCount;
            if (index < i)
                continue;
            String temp = individuals[i];
            individuals[i] = individuals[index];
            individuals[index] = temp;
            i++;
        }
    }

    private void showWinners() {
        for (int i = 0; i < noOfWinners; i++) {
            System.out.println(individuals[i]);
        }
    }

    public static void main(String[] args) {
        Raffle obj = new Raffle("ProjectFiles/src/participants.csv");
        obj.draw(20);
        obj.showWinners();;
    }
}
