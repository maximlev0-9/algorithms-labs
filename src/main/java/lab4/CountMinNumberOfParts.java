package lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountMinNumberOfParts {
    private List<String> listOfPossibleSubstrings;

    public void evaluate(String pathToFile) {

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

        MyReader reader = new MyReader();
        String[] values = reader.readFrom(pathToFile);
        String binaryStr = values[0];
        int number = Integer.parseInt(values[1]);

        listOfPossibleSubstrings = generateSubstringsFromNumber(number, binaryStr.length());


        int result = doAllEvaluations(binaryStr);

        MyWriter writer = new MyWriter();
        writer.writeToFile(result);
    }

    private int doAllEvaluations(String binaryNumber) {
        int length = binaryNumber.length() + 1;
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

                if (listOfLengthsToEachElement.get(i - lengthOfSubstring) == Integer.MAX_VALUE) {
                    continue;
                }

                if (binaryNumber.startsWith(substring, i - lengthOfSubstring)) {
                    listOfLengthsToEachElement.set(i,
                            Integer.min(listOfLengthsToEachElement.get(i), listOfLengthsToEachElement.get(i - lengthOfSubstring) + 1));
                }
            }
        }
        return listOfLengthsToEachElement.get(length - 1);
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
