package lab2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Visualisation of algorithm
// This is like a binary search


//  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
//  1 2 3 4 5 6 7 8 9 {10} 11 12 13 14 15 16 17 18
// no, too many food is needed
// resorting for another number of hamsters
//  1 2 3 4 {5} 6 7 8 9 10
// ok, I have such amount of food
//  1 2 3 4 5 6 {7} 8 9 10
// Ok, I have such amount of food
//  1 2 3 4 5 6 7 {8} 9 10
// Great! Amount of food needed is just slightly less than I have for each day


public class Main {
    private static Hamster[] hamsters;
    private static int numberOfHamstersUpperBound = 0;
    private static int numberOfHamstersLowerBound = 0;

    private static int dailyAmountOfFood = 0;
    private static int maxNumberOfHamsters = 0;

    public static void main(String[] args) throws IOException {

        hamsters = new Hamster[0];
        try (Scanner scanner = new Scanner(new File("src/main/java/lab2/hamstr.in"))) {
            int numberOfHamstersInShop = 0;
            dailyAmountOfFood = Integer.parseInt(scanner.nextLine());
            numberOfHamstersInShop = Integer.parseInt(scanner.nextLine());
            hamsters = new Hamster[numberOfHamstersInShop];
            numberOfHamstersUpperBound = numberOfHamstersInShop;
            for (int i = 0; i < numberOfHamstersInShop; i++) {
                String s = scanner.nextLine();
                String[] a = s.split(" ");
                int dailySth = Integer.parseInt(a[0]);
                int greediness = Integer.parseInt(a[1]);
                hamsters[i] = new Hamster(i + 1, dailySth, greediness);

            }

        } catch (IOException e) {
            e.printStackTrace();
            hamsters = new Hamster[]{new Hamster(1, 1, 2), new Hamster(2, 2, 2)};
        }

        // I have list of all existing hamsters and amount of food

        // pre-algorithm:
        // 1) Take any hamsters till it's full (n) UPD: and reevaluate cost for all previously chosen (n*n)
        // 2) Evaluate amount for each currently chosen hamster
        // 3) Evaluate amount for all hamsters that weren't chosen
        // 4) replace those who need more food with those who need less
        // 5) Repeat in cycle 2 & 3
        // Also do check if I can add (not replace) hamsters (that's after 3) (quite hard operation compared to replacing, but I need it)

        // Ok, let's go
        // I gave up before even starting writing code(

        // v2
        // 1) search for smallest values and add to array (use chosenHamsterGreediness for evaluating cost)
        // 2) quick sort hamsters that weren't chosen until now


        // v3
        // i really don't know about it, but idea is to sort them anyhow and then choose appropriate

        // maybe, посортувати для, наприклад, половини або sqrt(число хом'яків) і глянути, чи можу я вибрати саме таку кількість хом'яків.
        // Якщо можу, запам'ятовую хом'яків і їх кількість і рухаюсь далі. (на скільки, хз, треба якось оптимізувати, наприклад, дивитись
        // на кількість їжі, яка ще лишилась, або на те, наскільки це число менше від числа всіх хом'яків).
        // ok, let's go

        // once more, in
        evaluateAll();
        System.out.println("Max number of hamsters I can buy in shop: " + maxNumberOfHamsters);
        try (FileWriter fileWriter = new FileWriter(new File("src/main/java/lab2/hamstr.out"))) {
            fileWriter.write("" + maxNumberOfHamsters);
            fileWriter.flush();
        } catch (Exception ignored) {
        }
        // 1
//        for (int i = 0; i < numberOfHamstersInShop; i++) {      // n
//            int overallAmountOfFood = hamsters[i].getOverallAmountOfFood(getIndexOfLastElementInArray(chosenHamsters)) + chosenHamstersGreediness; // n*n
//            if (overallAmountOfFood < dailyAmountOfFood) {
//                dailyAmountOfFood -= overallAmountOfFood;
//                chosenHamstersGreediness += hamsters[i].getGreediness();
//                chosenHamsters[getIndexOfLastElementInArray(chosenHamsters) + 1] = hamsters[i]; // n*n
//            }
//        }
//
//        for (int j = 0; j < numberOfHamstersInShop; j++) {
//
//
//            // 2
//            int currentSizeOfChosenHamsters = getIndexOfLastElementInArray(chosenHamsters); // n
//            int[] foodForEachChosenHamster = new int[currentSizeOfChosenHamsters];
//            for (int i = 0; i < currentSizeOfChosenHamsters; i++) { // n
//                foodForEachChosenHamster[i] = chosenHamsters[i].getOverallAmountOfFood(currentSizeOfChosenHamsters); // n
//            }
//            // 3
//            int[] foodForEachHamster = new int[currentSizeOfChosenHamsters];
//            for (int i = 0; i < numberOfHamstersInShop; i++) {
//                foodForEachHamster[i] = hamsters[i].getOverallAmountOfFood(currentSizeOfChosenHamsters);
//            }
//        }


    }

    private static void evaluateAll() {    // once more, in
        while (true) { // cycle
            //sort all hamsters
            quickSort(hamsters, 0, hamsters.length - 1);
            // and
            // compare sum of all hamsters from start to {} with daily amount of food
            int currentLastElementIndex = (numberOfHamstersLowerBound + numberOfHamstersUpperBound) / 2;
            double sumOfElementsOfArray = sumOfElementsOfArray(hamsters, currentLastElementIndex);

            // if difference between dailyAmountOfFood and current споживанням is less than dailyAmountOfFood for last chosen hamster, then it's
            // already max number of hamsters
            if (sumOfElementsOfArray - dailyAmountOfFood > hamsters[currentLastElementIndex].getOverallAmountOfFood(currentLastElementIndex)
                    || numberOfHamstersLowerBound == currentLastElementIndex) {
                maxNumberOfHamsters = currentLastElementIndex;
                break;
            }
            if (sumOfElementsOfArray > dailyAmountOfFood) {
                numberOfHamstersUpperBound = currentLastElementIndex;
            } else {
                numberOfHamstersLowerBound = currentLastElementIndex;
            }

        }
    }

    private static int sumOfElementsOfArray(Hamster[] hamsters, int end) {
        int sum = 0;
        for (int i = 0; i < end; i++) {
            sum += hamsters[i].getOverallAmountOfFood((numberOfHamstersLowerBound + numberOfHamstersUpperBound) / 2);
        }
        return sum;
    }

    private static int getIndexOfLastElementInArray(Hamster[] hamsters) {
        for (int i = 0; i < hamsters.length; i++) {
            if (hamsters[i] == null) {
                return i - 1;
            }
        }
        return hamsters.length - 1;
    }


    private static int partition(Hamster[] arr, int low, int high) {
        Hamster pivot = arr[high];
        int i = (low - 1);
        int currentLastElementIndex = (numberOfHamstersLowerBound + numberOfHamstersUpperBound) / 2;
        for (int j = low; j < high; j++) {
            if (arr[j].getOverallAmountOfFood(currentLastElementIndex) < pivot.getOverallAmountOfFood(currentLastElementIndex)) {
                i++;
                Hamster temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Hamster temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    private static void quickSort(Hamster[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
