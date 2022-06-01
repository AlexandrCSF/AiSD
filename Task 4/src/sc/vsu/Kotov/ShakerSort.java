package sc.vsu.Kotov;
// Код шейкерной сортировки был взят со стороннего сайта
public class ShakerSort {
    public static String shakerSort(int[] arr) {
        int amountCompare = 0;
        int amountSwap = 0;
        int tmp;
        int left = 0;
        int right = arr.length - 1;
        do {
            for (int i = left; i < right; i++) {
                amountCompare++;
                if (arr[i] > arr[i + 1]) {

                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    amountSwap++;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                amountCompare++;
                if (arr[i] < arr[i - 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tmp;
                    amountSwap++;
                }
            }
            left++;
        } while (left < right);
        return (amountCompare)+ ", " + (amountSwap);
    }
}
