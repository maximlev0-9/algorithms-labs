package lab3;


import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Getter
public class MyReader {

    public Map<String, List<String>> readFrom(String pathToFile) {
        Map<String, List<String>> elements = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(pathToFile))) {
            while (true) {
                String input = null;
                try {
                    input = scanner.nextLine();

                } catch (NoSuchElementException ignored) {
                }
                if (input == null) break;

                String[] pairs = input.split(" ");

                String key = pairs[0].trim();
                String value = pairs[1].trim();

                List<String> listOfValues = elements.getOrDefault(key, new ArrayList<>());
                listOfValues.add(value);
                elements.put(key, listOfValues);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return elements;
    }
}
