package lab2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Complexity = log(n) <<binary search>> * (   n*log(n) <<quicksort>>  +   ~n <<sum of all elements to current>>    )
// n*(log(n)^2) + ~n*log(n)

// Visualisation of algorithm
// This is like a binary search + quicksort


//  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
//  1 2 3 4 5 6 7 8 9 {10} 11 12 13 14 15 16 17 18
// no, too many food is needed
// resorting for another number of hamsters (5)
//  1 2 3 4 {5} 6 7 8 9 10
// ok, I have enough food
//  1 2 3 4 5 6 {7} 8 9 10
// Ok, I have enough food
//  1 2 3 4 5 6 7 {8} 9 10
// Great! Amount of food needed is just slightly less than I have for each day


public class Main {
    private Hamster[] hamsters;
    private int numberOfHamstersUpperBound = 0;
    private int numberOfHamstersLowerBound = 0;

    private int dailyAmountOfFood = 0;
    private int maxNumberOfHamsters = 0;

    public static void main(String[] args) {

//        countAllPossibleHamsters();

    }

    public void countMaxPossibleHamsters(String pathToFile) {
        hamsters = new Hamster[0];
        try (Scanner scanner = new Scanner(new File(pathToFile))) {
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

        // maybe, посортувати для, наприклад, половини або sqrt(число хом'яків) і глянути, чи можу я вибрати саме таку кількість хом'яків.
        // Якщо можу, запам'ятовую хом'яків і їх кількість і рухаюсь далі. (на скільки, хз, треба якось оптимізувати, наприклад, дивитись
        // на кількість їжі, яка ще лишилась, або на те, наскільки це число менше від числа всіх хом'яків).
        // ok, let's go

        // once more, in
        evaluateAll();
        try (FileWriter fileWriter = new FileWriter(new File("src/main/java/lab2/hamstr.out"))) {
            fileWriter.write("" + maxNumberOfHamsters);
            fileWriter.flush();
        } catch (Exception ignored) {
        }
    }

    private void evaluateAll() {    // once more, in
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

    private int sumOfElementsOfArray(Hamster[] hamsters, int end) {
        int sum = 0;
        for (int i = 0; i < end; i++) {
            sum += hamsters[i].getOverallAmountOfFood((numberOfHamstersLowerBound + numberOfHamstersUpperBound) / 2);
        }
        return sum;
    }


    private int partition(Hamster[] arr, int low, int high) {
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

    private void quickSort(Hamster[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
