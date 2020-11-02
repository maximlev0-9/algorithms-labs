package lab2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MyReader {

    private int dailyAmountOfFood;
    private int numberOfHamstersUpperBound;

    public Hamster[] readFrom(String pathToFile) {
        Hamster[] hamsters;
        try (Scanner scanner = new Scanner(new File(pathToFile))) {
            int numberOfHamstersInShop = 0;
            dailyAmountOfFood = Integer.parseInt(scanner.nextLine());
            numberOfHamstersInShop = Integer.parseInt(scanner.nextLine());
            hamsters = new Hamster[numberOfHamstersInShop];
            numberOfHamstersUpperBound = numberOfHamstersInShop;
            for (int i = 0; i < numberOfHamstersInShop; i++) {
                String s = scanner.nextLine();
                String[] a = s.split(" ");
                int dailySth = Integer.parseInt(a[0]);
                int greediness = Integer.parseInt(a[1]);
                hamsters[i] = new Hamster(i + 1, dailySth, greediness);

            }

        } catch (IOException e) {
            e.printStackTrace();
            hamsters = new Hamster[]{new Hamster(1, 1, 2), new Hamster(2, 2, 2)};
        }
        return hamsters;
    }

    public int getDailyAmountOfFood() {
        return dailyAmountOfFood;
    }

    public int getNumberOfHamstersUpperBound() {
        return numberOfHamstersUpperBound;
    }
}
