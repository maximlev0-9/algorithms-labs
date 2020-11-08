package lab3;


import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Getter
public class MyReader {
    private Set<String> values;

//    public List<Record> readFrom(String pathToFile) {
//        List<Record> records = new ArrayList<>();
//        try (Scanner scanner = new Scanner(new File(pathToFile))) {
//            while (true) {
//                String s = scanner.nextLine();
//                if (s == null) break;
//
//                String[] values = s.split(" ");
//                records.add(new Record(values[0], values[1]));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return records;
//    }

    public Map<String, List<String>> readFrom(String pathToFile) {
        values = new HashSet<>();
        Map<String, List<String>> elements = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(pathToFile))) {
            while (true) {
                String s = null;
                try {
                    s = scanner.nextLine();

                } catch (NoSuchElementException e) {

                }
                if (s == null) break;

                String[] pairs = s.split(" ");

                String key = pairs[0].trim();
                String value = pairs[1].trim();

                List<String> orDefault = elements.getOrDefault(key, new ArrayList<>());// 1 ( not log(n))
                orDefault.add(value);
                elements.put(key, orDefault);

                values.add(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        values.removeAll(elements.keySet());


        return elements;
    }
}
