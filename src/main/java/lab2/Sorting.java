package lab2;


// я пробував зробити сортування загальним, але проблема в тому, що воно не підійде для мого алгоритму.
// Мені для порівняння треба передавати якусь змінну, кількість хом'яків, по якій і будуть рахуватись "витрати" на хом'яків, по яким
// ті будуть порівнюватись. А в джавівському методі compare(object o) *з інтерфейсу Comparable* передається тільки сам інший об'єкт, а мені це не підходить.
// Тому я для свого коду не переробляв сортування
public class Sorting {
    private Sorting() {
    }

    private static int partition(Hamster[] arr, int low, int high, int numberOfHamstersToMakeCompareBetween) {
        Hamster pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].getOverallAmountOfFood(numberOfHamstersToMakeCompareBetween) <
                    pivot.getOverallAmountOfFood(numberOfHamstersToMakeCompareBetween)) {
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

    public static void quickSort(Hamster[] arr, int low, int high, int numberOfHamstersToMakeCompareBetween) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, numberOfHamstersToMakeCompareBetween);

            quickSort(arr, low, pivotIndex - 1, numberOfHamstersToMakeCompareBetween);
            quickSort(arr, pivotIndex + 1, high, numberOfHamstersToMakeCompareBetween);
        }
    }
}
