package lab2;

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


public class HamsterCounter {
    private Hamster[] hamsters;
    private int numberOfHamstersUpperBound = 0;
    private int numberOfHamstersLowerBound = 0;

    private int dailyAmountOfFood = 0;
    private int maxNumberOfHamsters = 0;

    public void countMaxPossibleHamsters(String pathToFile) {
        hamsters = new Hamster[0];
        MyReader reader = new MyReader();
        reader.readFrom(pathToFile);
        dailyAmountOfFood = reader.getDailyAmountOfFood();
        numberOfHamstersUpperBound = reader.getNumberOfHamstersUpperBound();

        evaluateAll();

        MyWriter writer = new MyWriter();
        writer.writeToFile(maxNumberOfHamsters);
    }


    private void evaluateAll() {    // once more, in
        while (true) { // cycle
            //sort all hamsters
            int currentLastElementIndex = (numberOfHamstersLowerBound + numberOfHamstersUpperBound) / 2;
            Sorting.quickSort(hamsters, 0, hamsters.length - 1, currentLastElementIndex);
            // and
            // compare sum of all hamsters from start to {} with daily amount of food
            double sumOfElementsOfArray = sumOfElementsOfArray(hamsters, currentLastElementIndex);

            // if difference between dailyAmountOfFood and current consumption is less than dailyAmountOfFood for last chosen hamster, then it's
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
}
