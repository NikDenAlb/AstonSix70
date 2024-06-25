package stage1.four;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] a = {1, 22, 33, 44, 45, 16, 71, 81, 91, 1};
        Integer[] b = {1, 22, 33, 44, 45, 16, 71, 81, 91, 1};
        String[] c = {"Первый", "Второй", "Третий", "Четвёртый", "Пятый", "Шестой", "Седьмой", "Восьмой"};
        Shellsort<Integer> s = new Shellsort<>(a);
        s.sort();
        System.out.println(Arrays.toString(a));

        ServiceSort.sort(b);
        System.out.println(Arrays.toString(b));

        new Shellsort<>(c).sort();
        System.out.println(Arrays.toString(c));
    }
}