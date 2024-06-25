package stage1.four;

public class Shellsort<T extends Comparable<T>> {
    private final T[] arr;

    public Shellsort(T[] arr) {
        this.arr = arr;
    }

    public void sort() {
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