package sc.vsu.Kotov;
// Код сортировки пузырьком был взят со стороннего сайта
public class BubbleSort {
    public static String bubbleSort(int[] arr) {
        int amountCompare = 0;
        int amountSwap = 0;
        int n = arr.length;
        int tmp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                amountCompare++;
                if (arr[j - 1] > arr[j]) {
                    tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                    amountSwap++;
                }
            }
        }
        return (amountCompare)+ ", " + (amountSwap);
    }
}
