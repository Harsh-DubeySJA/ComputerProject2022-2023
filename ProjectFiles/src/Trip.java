import java.util.Scanner;

public class Trip {

    public static float output(float[] expenditure) {
        float average;
        float sum = 0;
        for (float individualMoney : expenditure)
            sum += individualMoney;

//        Calculating average on float variable upto two decimal places
        average = (int)(((sum / expenditure.length) + 0.005f) * 100.0f) / 100.0f;

//        Money to be exchanged to equalize students' cost
        float moneyExchange = 0;
        for (float money : expenditure)
            if (money > average)
                moneyExchange += money - average;
        return moneyExchange;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of Students N in trip");
        float[] expenditure = new float[sc.nextInt()];

        System.out.println("Student's individual Expenditure");
        for (int i = 0; i < expenditure.length; i++)
            expenditure [i] = sc.nextFloat();

        System.out.println("Money to be exchanged $" + output(expenditure));
        sc.close();
    }
}
