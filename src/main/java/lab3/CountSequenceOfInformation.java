package lab3;

import java.util.*;

public class CountSequenceOfInformation {
    public void execute(String pathToFile) {
        MyReader reader = new MyReader();
        // map of elements and lists of elements that point on element
        Map<String, List<String>> elements = reader.readFrom(pathToFile);

        Set<String> independentValues = getSetOfIndependentValues(elements);

        List<String> finalOutput = new ArrayList<>();
        finalOutput.addAll(independentValues);

        for (int i = 0; i < elements.size(); i++) {
            for (Map.Entry<String, List<String>> entry :
                    elements.entrySet()) {
                if (!independentValues.contains(entry.getKey()) && independentValues.containsAll(entry.getValue())) {
                    independentValues.add(entry.getKey());
                    finalOutput.add(entry.getKey());
                }
            }
        }
        MyWriter writer = new MyWriter();
        writer.writeToFile(finalOutput);
    }

    private static Set<String> getSetOfIndependentValues(Map<String, List<String>> elements) {
        Set<String> independentValues = new HashSet<>();
        elements.values().forEach(independentValues::addAll);
        independentValues.removeAll(elements.keySet());
        return independentValues;
    }
}
