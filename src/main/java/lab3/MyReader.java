package lab3;


import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Getter
public class MyReader {
    private String startingVertex;

    public Graph readFrom(String pathToFile) {
        Graph newGraph = new Graph();

        Set<String> keys = new HashSet<>();
        Set<String> values = new HashSet<>();
        try (Scanner scanner = new Scanner(new File(pathToFile))) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] pairs = input.split(" ");

                String key = pairs[0].trim();
                String value = pairs[1].trim();

                keys.add(key);
                values.add(value);

                newGraph.addVertex(key);
                newGraph.addVertex(value);
                newGraph.addEdge(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        keys.removeAll(values);

        startingVertex = keys.stream().reduce((v, v2) -> v).get();


        return newGraph;
    }
}
