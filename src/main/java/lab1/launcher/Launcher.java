package lab1.launcher;

import lab1.utilities.Utils;
import lab1.model.Insect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Launcher {
    public static void main(String[] args) {

        String fileName = args[0];
        List<Insect> insectsList = new ArrayList<>();

//        try {
//            BufferedReader br = new BufferedReader(new FileReader(new File("src/main/java/lab1/example.csv")));
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }

        String filePrefix = "D:/IdeaProjects/algorithms_and_programming/src/main/resources/";
        try (BufferedReader br = new BufferedReader(new FileReader(filePrefix + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                insectsList.add(new Insect(values[0], Double.parseDouble(values[1]), Integer.parseInt(values[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int number = 100000;
        Insect[] insects = insectsList.toArray(new Insect[0]);
//        Insect[] insects = InsectGenerator.createRandomInsects(number);
        Stream.of(insects).forEach(System.out::println);
        System.out.println("Number of objects: " + number);
        System.out.println();
        System.out.println("Insertion sort by velocity: ");

        Utils.insertionSortInsectsByVelocityDesc(insects);

        System.out.println("Time in milliseconds: " + Utils.getTimeInMillisInsertion());
        System.out.println("Number of swaps: " + Utils.getSwapCounterInsertion());
        System.out.println("Number of compares: " + Utils.getCompareCounterInsertion());
        Stream.of(insects).forEach(System.out::println);

        System.out.println();
        System.out.println("Quick sort by weight: ");

        Utils.quickSortInsectsByWeightDesc(insects);

        System.out.println("Time in milliseconds: " + Utils.getTimeInMillisQuick());
        System.out.println("Number of swaps: " + Utils.getSwapCounterQuick());
        System.out.println("Number of compares: " + Utils.getCompareCounterQuick());
        Stream.of(insects).forEach(System.out::println);
    }
}
