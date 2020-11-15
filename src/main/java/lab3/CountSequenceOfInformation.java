package lab3;

import java.util.*;

public class CountSequenceOfInformation {
    public void execute(String pathToFile) {
        MyReader reader = new MyReader();

        Graph graph = reader.readFrom(pathToFile);

        Set<String> strings = graph.modifiedBreadthFirstTraversal(reader.getStartingVertex());

        List<String> reversedList = new ArrayList<>();
        for (String s : strings) {
            reversedList.add(0, s);
        }
        MyWriter writer = new MyWriter();
        writer.writeToFile(reversedList);

    }
}
