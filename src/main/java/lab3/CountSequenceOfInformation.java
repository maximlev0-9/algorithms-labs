package lab3;

import java.util.*;

public class CountSequenceOfInformation {
    public void execute(String pathToFile) {
        MyReader reader = new MyReader();
        // map of elements and lists of elements that point on element
        Graph graph = reader.readFrom(pathToFile);

        Set<String> strings = graph.modifiedBreadthFirstTraversal(reader.getStartingVertex());

        List<String> reversedList = new ArrayList<>();
        for (String s : strings) {
            reversedList.add(0, s);
        }
        MyWriter writer = new MyWriter();
        writer.writeToFile(reversedList);

        // new algorithm:
        // build graph.
        // search for first element
        //
        // make BFS for this graph...
        //no, not just a BFS, i need sth more
        // reverse it
        // Stonks!


    }
}
