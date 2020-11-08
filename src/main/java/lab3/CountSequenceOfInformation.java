package lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountSequenceOfInformation {
    public static void main(String[] args) {
        //create new MyReader class
        MyReader reader = new MyReader();
        Map<String, List<String>> elements = reader.readFrom("src\\main\\java\\lab3\\govern.in");
        Set<String> independentValues = reader.getValues();
        List<String> finalOutput = new ArrayList<>();
        finalOutput.addAll(independentValues);
        for (int i = 0; i < elements.size(); i++) {
            for (String key :
                    elements.keySet()) {
                if (independentValues.containsAll(elements.get(key))) {
                    independentValues.add(key);
                    finalOutput.add(key);
                    elements.remove(key);
                }
            }
        }
        System.out.println(finalOutput);

    }


//        List<Record> recordsSortedByKeys = new ArrayList<>(records);
//        recordsSortedByKeys.sort(Comparator.comparing(Record::getInfo));
//        List<Record> recordsSortedByValues = new ArrayList<>(records);
//        recordsSortedByValues.sort(Comparator.comparing(Record::getInfoNeeded));
//
//        for (int i = 0; i < recordsSortedByKeys.size(); i++) {
//            if (!recordsSortedByKeys.contains(recordsSortedByKeys.get(i).getInfoNeeded())) {
//
//            }
//        }
//        // sort keys and values
//
//        // search for information that don't point to any other
//        // goto mark make_action:
//        // add it to final list
//        // look for infos dependent on this
//        // if it hasn't any other dependencies, go to make_action
//        // if has any, forget about it.
//        //
//    }
}
