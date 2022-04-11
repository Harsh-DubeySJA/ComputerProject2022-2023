import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RaffleWithArrayList {
    private final List<String> individuals = new ArrayList<>();
    private List<String> winners;

    RaffleWithArrayList(String fileName) {
        try {
        FileReader participants = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(participants);
        String line;
        while ((line = reader.readLine()) != null)
            individuals.add(line);
        reader.close();
        participants.close();
        } catch (FileNotFoundException e) {
            System.out.println("File with " + fileName + " was not found");
        }
        catch (IOException e) {
            System.out.println("NullPointerException");
        }
    }

    private void draw(int prizeCount) {
        winners = new ArrayList<>(prizeCount);
        for (int i = 0; i < prizeCount; i++) {
            String winner = individuals.get((int)(Math.random() * prizeCount) + prizeCount);
            if (!winners.contains(winner))
                winners.add(winner);
        }
    }

    private void showWinners() {
        System.out.println("Winners are \n------- ---\n");
        for (String winner : winners)
            System.out.println(winner);
    }

    public static void main(String[] args) {
        RaffleWithArrayList obj = new RaffleWithArrayList("ProjectFiles/src/participants.csv");
        obj.draw(5);
        obj.showWinners();
    }
}
