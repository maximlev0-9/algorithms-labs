package lab4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountMinNumberOfParts {
    private List<String> listOfPossibleSubstrings;
    private int minNumberOfIterations = Integer.MAX_VALUE;

//    public static void main(String[] args) {
//        String binaryReal = "100111011110100100111110110011100101000111100101110010001100111011110100100111110110011100101000110010110000111100101110010001";
//        String binary = "1001110111101001001111101100111001010001111001011100100011001110111101001001111101100111001010001100";
//        int len = binary.length();
//        System.out.println(len);
//        BigInteger decimal = BigInteger.ZERO;
//        BigInteger multiplier = BigInteger.ONE;
//        for (int pow = (binary.length() - 1); pow > -1; pow--) {
//
//            if (binary.charAt(pow) == '1') {
//                decimal = decimal.add(BigInteger.valueOf(1L << (pow)));
//
//            }
//        }
//        System.out.println(decimal.toString());
//        System.out.println(decimal.toString().length());
//    }

    public void evaluate(String pathToFile) {
        MyReader reader = new MyReader();
        String[] values = reader.readFrom(pathToFile);
        String binaryNumber = values[0];
        int number = Integer.parseInt(values[1]);

        listOfPossibleSubstrings = generateSubstringsFromNumber(number, binaryNumber.length());
        Collections.reverse(listOfPossibleSubstrings);

        checkAllPossibleVariationsForThis(binaryNumber, 0);

        MyWriter writer = new MyWriter();
        writer.writeToFile(minNumberOfIterations);
    }

    private void checkAllPossibleVariationsForThis(String binaryNumber, int currentNumberOfIterations) {
        if (binaryNumber.isEmpty()) {
            minNumberOfIterations = Math.min(currentNumberOfIterations, minNumberOfIterations);
            return;
        }
        if (currentNumberOfIterations >= minNumberOfIterations - 1) {
            return;
        }
        for (String prefix : listOfPossibleSubstrings) {
            if (binaryNumber.startsWith(prefix)) {
                checkAllPossibleVariationsForThis(binaryNumber.substring(prefix.length()), ++currentNumberOfIterations);
            }
        }
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
