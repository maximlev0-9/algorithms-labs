package lab1;

public class Utils {

    private static int swapCounterInsertion;
    private static int compareCounterInsertion;
    private static long timeInMillisInsertion;

    private static int swapCounterQuick;
    private static int compareCounterQuick;
    private static long timeInMillisQuick;

    private Utils() {
    }

    public static long getTimeInMillisInsertion() {
        return timeInMillisInsertion;
    }

    public static long getTimeInMillisQuick() {
        return timeInMillisQuick;
    }

    public static int getCompareCounterInsertion() {
        return compareCounterInsertion;
    }

    public static int getSwapCounterInsertion() {
        return swapCounterInsertion;
    }

    public static int getSwapCounterQuick() {
        return swapCounterQuick;
    }

    public static int getCompareCounterQuick() {
        return compareCounterQuick;
    }


    public static void insertionSortInsectsByVelocityDesc(Insect[] insects) {
        long startTime = System.nanoTime();
        for (int i = 1; i < insects.length; i++) {

            int index = i;

            while (index != 0
                    && compareVelocities(insects, index)) {

                swapCounterInsertion++;
                Insect insect = insects[index];
                insects[index] = insects[index - 1];
                insects[index - 1] = insect;
                index--;
            }
        }

        timeInMillisInsertion = startTime - System.nanoTime();
    }

    private static boolean compareVelocities(Insect[] insects, int index) {

        ++compareCounterInsertion;

        return insects[index].getVelocityInMeters() > insects[index - 1].getVelocityInMeters();
    }

    private static int partition(Insect[] arr, int low, int high) {
        Insect pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (compareWeights(arr[j].getWeightInGrams(), pivot.getWeightInGrams())) {
                i++;


                swapCounterQuick++;


                Insect temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        swapCounterQuick++;

        Insect temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    private static boolean compareWeights(double weightInGrams, double weightInGrams2) {
        compareCounterQuick++;
        return weightInGrams > weightInGrams2;
    }


    private static void quickSort(Insect[] arr, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void quickSortInsectsByWeightDesc(Insect[] insects) {
        long startTime = System.nanoTime();
        quickSort(insects, 0, insects.length - 1);
        timeInMillisQuick = startTime - System.nanoTime();
    }

}
