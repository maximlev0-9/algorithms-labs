package lab4;

import java.util.ArrayList;
import java.util.Arrays;
<<<<<<< HEAD
import java.util.Collections;
=======
>>>>>>> 47290a5... wrote new algorithm
import java.util.List;
import java.util.stream.Stream;

public class CountMinNumberOfParts {
    private List<String> listOfPossibleSubstrings;

    public void evaluate(String pathToFile) {
<<<<<<< HEAD



        // new algorithm
        //
        // for each element
        // check if I can get here with any value from list of possible strings. (additional check of length from start to current index, whether...
        // ...it's too small or not)
        // if I can, check whether there is value with any number of paths to get there
        // if there is, add to current element's paths that element paths. Continue checking with other elements from list of...)
        // ok, when I get to the end, last element in array would show how many ways to it exists.




=======
        // binary_str
        // number
        // list_of_lengths_to_each_element = [Integer.MAX_VALUE for i in range(len(binary_str))]
        // генеримо ліст кусків
        // цикл
        //  for i in range(n):
        //      for substr in list:
        //          чЕкаємо, чи індекс початку стрінги з ліста не менший 0
        //          if i - len(substr) < 0:
        //              break
        //
        //          if binary_str[i-len(substr), i] is substr:
        //              list_of_lengths_to_each_element[i] = min(this, list_of_lengths_to_each_element[i-len(substr)])
        //
>>>>>>> 47290a5... wrote new algorithm
        MyReader reader = new MyReader();
        String[] values = reader.readFrom(pathToFile);
        String binaryNumber = values[0];
        int number = Integer.parseInt(values[1]);
        int[] pathsToThisElements = new int[binaryNumber.length()];
        Arrays.fill(pathsToThisElements, 0);
        listOfPossibleSubstrings = generateSubstringsFromNumber(number, binaryNumber.length());
<<<<<<< HEAD
//        Collections.reverse(listOfPossibleSubstrings);



        for (int i = 0; i < binaryNumber.length(); i++) {

        }


=======
>>>>>>> 47290a5... wrote new algorithm

        int result = doAllEvaluations(binaryNumber);

        MyWriter writer = new MyWriter();
        writer.writeToFile(result);
    }

    private int doAllEvaluations(String binaryNumber) {
        int length = binaryNumber.length()+1;
        Integer[] lol = new Integer[length];
        Arrays.fill(lol, Integer.MAX_VALUE);
        lol[0] = 0;
        List<Integer> listOfLengthsToEachElement = Arrays.asList(lol);
        for (int i = 0; i < length; i++) {
            for (String substring : listOfPossibleSubstrings) {
                int lengthOfSubstring = substring.length();
                if (i - lengthOfSubstring < 0) {
                    break;
                }
                if (listOfLengthsToEachElement.get(i - lengthOfSubstring) == Integer.MAX_VALUE){
                    continue;
                }
                if (binaryNumber.startsWith(substring, i - lengthOfSubstring)) {
                    listOfLengthsToEachElement.set(i,
                            Integer.min(listOfLengthsToEachElement.get(i),
                                    listOfLengthsToEachElement.get(i - lengthOfSubstring) + 1));
                }
            }
        }
        return listOfLengthsToEachElement.get(length-1);
    }

    private List<String> generateSubstringsFromNumber(int number, int length) {
        List<String> result = new ArrayList<>();
        int curr = 1;
        while (true) {
            String binaryRepr = convertToBinary(curr);
            if (binaryRepr.length() > length) {
                break;
            }
            result.add(binaryRepr);
            curr *= number;
        }
        return result;
    }

    public String convertToBinary(int number) {
        return Integer.toBinaryString(number);
    }
}
