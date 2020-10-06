package lab1;

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

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                insectsList.add(new Insect(values[0], Double.parseDouble(values[1]), Integer.parseInt(values[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        Insect[] insects = (Insect[]) insectsList.toArray();
        Stream.of(insects).forEach(System.out::println);

        System.out.println();
        System.out.println("Insertion sort by velocity:");
        Utils.insertionSortInsectsByVelocityDesc(insects);
        Stream.of(insects).forEach(System.out::println);

        System.out.println();
        System.out.println("Quick sort by weight:");
        Utils.quickSortInsectsByWeightDesc(insects);
        Stream.of(insects).forEach(System.out::println);
    }
}
