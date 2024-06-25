package stage1.four;

import org.jetbrains.annotations.NotNull;

public class ServiceSort {
    public static <T extends Comparable<T>> void sort(T @NotNull [] arr) {
        for (int gap = arr.length >> 1; gap > 0; gap >>= 1) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j >= gap && arr[j].compareTo(arr[j - gap]) < 0) {
                    T temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;
                    j -= gap;
                }
            }
        }
    }
}